/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/06/2015
 * Description : service for the userrole controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/09/2015         Initial Creation
 *
 */
package com.healpal.care

import grails.transaction.Transactional

@Transactional
class UserRoleService {

    def serviceMethod() {

    }
	
	UserRole save(params ,UserRole urole ,String action){
		try{
			urole . role = Role.get(params.role?.toLong())
			urole . isActive = params.isActive?(params.isActive?.toString()?.toInteger()==1)?1:0:1
			if(action.equalsIgnoreCase("create")){
				urole . healpalUser = HealpalUser.get(params.healpalUser?.toLong())
				urole . rowCreated = new Date() }else{
				urole . rowAltered = new Date()
			}
			urole . save(flush : true)
			return urole
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	int delete(params){
		try{
			return UserRole.executeUpdate("update UserRole ur set ur.isActive=0 where ur.id=?",[params.id.toLong()])
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getList(params){
		try{
			return UserRole.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{
							healpalUser{ ilike("userName","%"+params.searchValue+"%")}
						}
						and{
							role{ilike("authority","%"+params.searchValue+"%")}
						}
					}
				}
				
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	def update(Role role ,params){
		try{ 
			return role != null?UserRole.executeUpdate("update UserRole ur set ur.isActive=? where ur.role=?" ,[params.isActive?(params.isActive?.toString()?.toInteger()==(short)1)?(short)1:(short)0:(short)1 ,role]):0
		}catch(Exception exception){
				throw exception
		}
	}
	def getCount(params){
		try{
			return UserRole.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{
							healpalUser{ ilike("userName","%"+params.searchValue+"%")}
						}
						and{
							role{ilike("authority","%"+params.searchValue+"%")}
						}
					}
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
