/*
 * Author    : Karthigeyan
 * Project   : Healpal
 * Date      :
 * Description : getAboutYouList  ,doSave ,doUpdate ,doDelete of About  You
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0               Initial Creation
 *
 */

package com.healpal.care

import com.sun.org.apache.bcel.internal.generic.RETURN;

import grails.transaction.Transactional

@Transactional
class AboutYouService {

	def serviceMethod() {
	}


	def getAboutYouList(params){
		try{
			return AboutYou.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("aboutYouName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}


	AboutYou doSave(AboutYou aboutYouSave,params){
		try{
			AboutYou aboutYou= new AboutYou();
			aboutYou.aboutYouName=params.aboutyou;
			aboutYou.rowCreated=new Date();
			aboutYou.isActive=(short)1;
			aboutYouSave=aboutYou.save(flush:true);
			return aboutYouSave
		}catch(Exception e){
		throw e
		}
	}


	AboutYou doUpdate(AboutYou aboutYouUpdate ,params){
		try{
			AboutYou updateYou=AboutYou.get(params.aboutId.toLong());
			updateYou.aboutYouName = params.aboutyou
			updateYou.isActive = params.status.equals("active")?(short)1:(short)0;
			updateYou.rowAltered = new Date();
			aboutYouUpdate = updateYou.save();
			return aboutYouUpdate
		}catch(Exception exception){
			throw exception
		}
	}

	AboutYou doDelete(AboutYou aboutYouDelete,params){
		AboutYou deleteStatus = new AboutYou()
		deleteStatus.withTransaction {status->
			try{
				if(params.aboutId !=null && !params.aboutId.isEmpty()){
					def delete = AboutYou.executeUpdate("UPDATE AboutYou p SET p.isActive=? WHERE p.id=?",[
						(short)0,
						params.aboutId.toLong()
					])
					if(delete){
						return deleteStatus
					}
				}
			}catch(Exception e){
				throw e
			}
		}
	}
	def getCount(params){
		try{
			return AboutYou.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != "") ilike("aboutYouName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception e){
		throw e
	}
		
	}
}
