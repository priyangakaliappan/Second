package com.healpal.encryptdecrypt;


import java.io.DataInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.regex.*;

 

import javax.swing.JOptionPane;
 
public class ageCaluculate 
{
    public static void main(String args[])
    {
        try
        {
        DataInputStream in=new DataInputStream(System.in);
         
                //7.calculate age SMK
                String date=null,fullyear=null;
                int month=0,day=0,year=0,month2=0,day2=0,year2=0,confirm=1;
                Date d=new Date();
                SimpleDateFormat sf=new SimpleDateFormat("MM/dd/yyyy");
                SimpleDateFormat sf3=new SimpleDateFormat("yyyy");
                do{
                        JOptionPane.showMessageDialog(null,"!!!!!!!!!    Welcome by SMK        !!!!!!!");
                        date=JOptionPane.showInputDialog("Enter Your Date of Birth(MM/dd/yyyy)");
                        Pattern pat=Pattern.compile("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)");
                        Matcher mat=pat.matcher(date);
                        boolean b=mat.matches();
                        if(b==true)
                        {   
                        //user Date
                                d=sf.parse(date);
                                
                                
                                month=d.getMonth();day=d.getDate();
                                
                                
                                fullyear=sf3.format(d);
                                year=Integer.parseInt(fullyear);
                                month++;
                        //current date
                                 
                                Calendar cal=new GregorianCalendar();
                                day2=cal.get(Calendar.DATE);month2=cal.get(Calendar.MONTH);year2=cal.get(Calendar.YEAR);
                                 
                                int age=year2-year;
                                month2++;
                                if(month>11)
                                {--age;}
                                if(month2>=month && day2>=day)
                                {++age;}
                                JOptionPane.showMessageDialog(null,"Your Age Is :"+age);
                        }
                        else
                        {
                            confirm=JOptionPane.showConfirmDialog(null,"Enter Correct Format & if U Want To Continue Press Yes");
                        }
                }while(confirm==0);     
        }
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
    }
}