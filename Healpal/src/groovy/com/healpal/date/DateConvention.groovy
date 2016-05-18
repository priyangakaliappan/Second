package com.healpal.date



import java.text.DateFormat;
import java.text.SimpleDateFormat

import javassist.bytecode.stackmap.BasicBlock.Catch;


public class DateConvention {


	/*
	 * Description  : Used for get the Date Object format of string date 
	 * 
	 */
	Date getDate(String datestr){
		
		Date dateTo = null
		try{
			if(datestr != null && !datestr.trim().equals("")){
				String str=datestr
				SimpleDateFormat sd1=new SimpleDateFormat("dd-MM-yyyy")
				Date dateFrom=sd1.parse(str)
				SimpleDateFormat sd2=new SimpleDateFormat("yyyy/MM/dd")
				dateTo=sd2.parse(sd2.format(dateFrom))
			}else{
				println "DateConvertion - getDate() datestring is null or empty!!!!!"
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dateTo
	}
	
	
	/* 
	 * Description  : Used for get the DateTime Object format of string date
	 *
	 */
	def getDateTime(String datestr){
		try{
			if(datestr != null && !datestr.trim().equals("")){
				String str=datestr
				String str2=str+" "+new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds()
				SimpleDateFormat sd1=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				Date dateFrom=sd1.parse(str2)
				SimpleDateFormat sd2=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				Date dateTo=sd2.parse(sd2.format(dateFrom))
				return dateTo
			}else{
				return null
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	String convertUtilDateToString(Date date){
		String sDate = null;
		try{
			if(date != null){
				SimpleDateFormat sd1=new SimpleDateFormat("dd-MM-yyyy")
				return sd1.format(date);
			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sDate;
	}
	String convertUtilDateToString(Date date,String format){
		String sDate = null;
		try{
			if(date != null && format != null){
				SimpleDateFormat sd1=new SimpleDateFormat(format)
				return sd1.format(date);
			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sDate;
	}
	
	def getTimeForm(String timestr){
		try{
			if(timestr != null && !timestr.trim().equals("")){
				SimpleDateFormat sd1=new SimpleDateFormat("HH:mm:ss")
				Date time1 = sd1.parse(timestr+":00");
				return time1
			}else{
				//do nothing
			}
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}
	
	//v1.1 starts
	/*
	 * Description  : Used for get the Date Object format of string date
	 *
	 */
	def Date getDateFromStringDate(String dateString){
		
		Date dateTo = null
		try{
			if(dateString != null && !dateString.trim().equals("")){
				String string=dateString
				SimpleDateFormat sd1=new SimpleDateFormat("MM/dd/yyyy")
				Date dateFrom=sd1.parse(string)
				SimpleDateFormat sd2=new SimpleDateFormat("yyyy/MM/dd")
				dateTo=sd2.parse(sd2.format(dateFrom))
			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dateTo
	}
	
	/**
	 * Change the date format MM/dd/YYYY
	 * @param date
	 * @return
	 */
	def static String getDateMMddYYYY(def date){

		try{
			if(date != null){
				SimpleDateFormat sd2=new SimpleDateFormat("MM/dd/yyyy")
				return sd2.format(date)
			}else{
				return null
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//v1.1 ends

	
	
	/*
	 *  get given date and current date is Equal
	 * */
	def getTodayDateIsEqual(Date date){
		String dateStr;
		try{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			SimpleDateFormat time = new SimpleDateFormat("hh:mm a");
			SimpleDateFormat time3 = new SimpleDateFormat("h:mm a");
			
			SimpleDateFormat time2 = new SimpleDateFormat("MMM d,yyyy");
        	Date date1 = sdf.parse(sdf1.format(date));
        	Date date2 = sdf.parse(sdf1.format(new Date()));
 
        	if(date1.compareTo(date2)==0){
				//if equal only print time ex : 2:30 PM
				if(date.getHours()>12){
					dateStr = date.getHours().minus(12)>10?time.format(date):time3.format(date)
				}else{
					dateStr = date.getHours()<10?time3.format(date):time.format(date)
				}
        	}else{
				//if not equal only print date in the format of Dec 23,2014
				dateStr = time2.format(date)
        	}
			
			return dateStr
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	
	
	
}
