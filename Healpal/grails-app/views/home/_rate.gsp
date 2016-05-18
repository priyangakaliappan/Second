<%@ page import="com.healpal.care.CancerTreatmentRate" %>

 
<input type="button" value="Satisfactory" id="satis" onClick="rateMe('${title}' ,'${CancerTreatmentRate.satisfactory}');"/>
<input type="button" value="Perfect" id="perfect" onClick="rateMe('${title}' ,'${CancerTreatmentRate.perfect}');"/>
<input type="button" value="Not Clear" id="clear" onClick="rateMe('${title}' ,'${CancerTreatmentRate.notClear}');"/>
<input type="button" value="Not what I wanted" id="wanted" onClick="rateMe('${title}' ,'${CancerTreatmentRate.wanted}');"/>

