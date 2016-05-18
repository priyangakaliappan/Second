/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/01/2015
 * Description : Service for the User Controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0     10/02/2015        Initial Creation
 *
 */

package com.healpal.care


import grails.transaction.Transactional

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date;

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import com.healpal.date.DateConvention
import com.healpal.encryptdecrypt.BCrypt;
import com.healpal.encryptdecrypt.CryptographyUtil;

@Transactional
class UserService implements org.springframework.context.ResourceLoaderAware{
	def ResourceLoader resourceLoader
    def serviceMethod() {

    }
	
	HealpalUser doSave(params ,HealpalUser user ,Person person ,String action,request){ 
			if(params != null){
				println"user:::::::::::::::::::::::::::::::::"+user
				user.withTransaction {status->
					try{
						// user first name , last name , ph no etc.. details are save into Person table
						person = savePerson(person ,params ,action) 
						if(!person.validate()){
//							person.errors.each{
//								println it
//							}
						}
						else{
						
									user = save(user, params, person ,action)
						
							if(!user.validate()){
								
								// if user credentials not saved the saved person details will be deleted
								status.setRollbackOnly()
								user.errors.each{
									println it
								}
								return user
							}
						}
						
					}
					catch(Exception e){
						status.setRollbackOnly()
						user = null
					}
				}
			}else{//do nothing
			}
			return user
	}
	
	
	
	def photoSave(params,HealpalUser user,Person person,request,String action){
		try{
			println"inside photo save"+user
			println"inside photo save"+person
			println "request;;;;;;;;;;;;;;;;;;;;;;;;"+request
				CommonsMultipartFile f = request.getFile('uploadPhoto')
				String name =f.getOriginalFilename()
				println "name:::::::::::::::::::::::::::::::::::::::::::::::::"+name
				if(name){
					String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
					String fileName = name.substring(0,name.lastIndexOf('.'));
					name =  user?.person.id+"." + extension
					println "name:::::::::::::::::::::::::::::::::::::::::::::::::"+name
				}
				println "********extension name **************"+name
				def serveletContext = ServletContextHolder.servletContext
				def storagePath =resourceLoader.getResource("/assets/patient-photo/").getFile() //serveletContext.getRealPath("assets/patient-photo/")
				if( !storagePath.exists() ){
					if(storagePath.mkdirs()){
					}else{
					}
				}
		
				// Store file
		
				if(!f.isEmpty()){
					f.transferTo( new File("${storagePath}/${name}") )
				}else{
				}
				
				
				ProfilePhoto photo = ProfilePhoto.findByPatient(Patient.findByPerson(user?.person));
				if(photo !=null){
					photo.profilePhotoPath = name
					photo.patient = Patient.findByPerson(user?.person)
					photo.rowAltered = new Date()
					photo.isActive = (short)1
				}else{
					photo = new ProfilePhoto()
					photo.profilePhotoPath = name
					photo.patient = Patient.findByPerson(user?.person)
					photo.rowCreated = new Date()
					photo.isActive = (short)1
				}
				def profile = photo.save(flush:true)
				if (!photo.validate()){
					photo.errors.each {println it }
				}else{
					// do nothing
				}
			
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	HealpalUser save(HealpalUser user , params ,Person person ,String action){
		try{
			user . userName = params.email
			if(params.password != null && !params.password.isEmpty()){
				byte[] password = params.password?.trim().getBytes()
				String encryptPassword = BCrypt.encode_base64(password, params.password?.length())
				user . password = encryptPassword//params.password
			}
			//user . enabled = params.enabled?(params.enabled?.toString()?.toInteger()==1)?true:false:(session.authority.equalsIgnoreCase(Role.patient)?false:true)//true
			user . enabled = params.enabled?(params.enabled?.toString()?.toInteger()==1)?true:false:false//true
			user . accountLocked = params.accountLocked?(params.accountLocked?.toString()?.toInteger()==1)?true:false:false   
			user . accountExpired = false
			user . passwordExpired = false
			user . isActive =  params.enabled?(params.enabled?.toString()?.toInteger()==1)?1:0:1  
			if(action.equalsIgnoreCase("create")){
				user . rowCreated = new Date() }else{
				user . rowAltered = new Date()
			}
			user . person = person
			user.save(flush:true)
			return user	
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	Person savePerson(Person person ,params ,String action){
		try{
			person . firstName = params.firstName?params.firstName.capitalize():''
			person . lastName = params.lastName?params.lastName.capitalize():''
			if(params.username && params.username!=null){
			person . fullName = params.username
			}
			else{
				person . fullName = params.firstName?params.firstName.capitalize():''+" "+params.lastName?params.lastName.capitalize():''
			}
			person . emailAddress = params.email
			person . isActive = 1
			if(action.equalsIgnoreCase("create")){
				person . rowCreated = new Date() }else{
				person . rowAltered = new Date()
			}
			person . save(flush:true)
			return person
		}catch(Exception exception){
			throw exception
		}
	}
	
	Patient savePatient(Patient patient ,Person person ,params){
		try{
			println"savePatient"
			patient . person = person
			patient . isActive = 1
			patient . rowCreated = new Date()
			patient . save(flush:true)
			return patient
		}catch(Exception exception){
			throw exception
		}
	}
	
	int disableAccount(params){
		try{
			return HealpalUser.executeUpdate("update HealpalUser h set h.enabled=? , h.isActive=0 ,h.rowAltered=? where h.id=?",[false ,new Date() ,params.userId.toLong()])
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getList(params){
		try{
			return HealpalUser.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ ilike('userName',"%"+params.searchValue+"%")}
						and{ person{ ilike('fullName',"%"+params.searchValue+"%") }
						}
					}
				}
			} 
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getUserList(String action){
		return HealpalUser.createCriteria().list{
			eq('isActive',(short)1)
			if(action.equalsIgnoreCase("create")){
				not {
					'in'('id',UserRole.list()?.healpalUser?.id)
				}
			}
		}
	}
	/**
	 *  Sending an email to registered user to verify document
	 * @param sendToMail
	 * send to single mail
	 * @return
	 */
	def sendMail(String sendToMail, String personName){
		try{
			if(sendToMail && sendToMail!=null && !sendToMail.isEmpty()){
				def toMail=sendToMail.toString();
				sendMail {
					to toMail
					subject "Hello "+personName
					body 'Document has been verified successfully'
				}
			}
		}catch(Exception exception){
			throw exception
		}
	}
	def getCount(params){
		try{
			return HealpalUser.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ ilike('userName',"%"+params.searchValue+"%")}
						and{ person{like('fullName',"%"+params.searchValue+"%")}
						}
					}
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
