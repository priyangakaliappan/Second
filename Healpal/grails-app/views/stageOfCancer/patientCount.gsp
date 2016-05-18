<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  <g:link controller="StageOfCancer" action="cancerTypeCount" >Total Number Of Patient  Count <span style="color:red;"> ${patientCountVal}</span></g:link>   
  <br>
  <br>
  <br>
  Last Month Count <span style="color:red;">  ${lastMonth} </span>
  <br>
  <br>
  <br>
 Jan-June Month Count <span style="color:red;">  ${janToJunMonthCount} </span> 
  
   <br>
  <br>
  <br>
  July-Dec Month Count  <span style="color:red;">  ${julToDecMonthCount} </span> 
  </div>
</body>
</html>