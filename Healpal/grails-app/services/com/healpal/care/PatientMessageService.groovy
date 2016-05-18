package com.healpal.care
 
import grails.orm.HibernateCriteriaBuilder
import java.text.SimpleDateFormat

import javax.servlet.http.HttpSession
import com.sun.java.util.jar.pack.Package;




import sun.text.normalizer.UBiDiProps.IsAcceptable;
import groovy.sql.Sql
import grails.transaction.Transactional

@Transactional
class PatientMessageService {



	
	public String checkNull(String data) throws Exception {
		try{
			if(data!= null){
				return data;
			}else{
				return "";
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
}
