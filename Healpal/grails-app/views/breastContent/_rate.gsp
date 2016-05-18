<%@ page import="com.healpal.care.CancerContentRate" %>

 
<input type="button" value="Satisfactory" id="satis" onClick="rateMe('${section}' ,'${page}' ,'${CancerContentRate.satisfactory}');"/>
<input type="button" value="Perfect" id="perfect" onClick="rateMe('${section}' ,'${page}' ,'${CancerContentRate.perfect}');"/>
<input type="button" value="Not Clear" id="clear" onClick="rateMe('${section}' ,'${page}' ,'${CancerContentRate.notClear}');"/>
<input type="button" value="Not what I wanted" id="wanted" onClick="rateMe('${section}' ,'${page}' ,'${CancerContentRate.wanted}');"/>

 <%--
 

<input type="button" value="Satisfactory" id="satis" onClick="rateMe();"/>
<input type="button" value="Perfect" id="perfect" onClick="rateMe();"/>
<input type="button" value="Not Clear" id="clear" onClick="rateMe();"/>
<input type="button" value="Now what i wanted" id="wanted" onClick="rateMe();"/>
--%>