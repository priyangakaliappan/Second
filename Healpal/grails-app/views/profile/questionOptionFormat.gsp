<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="profile"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  <div class="col-sm-12">
	<div class="profile-box-bg">
	<div class="text-center">			
	<h2>Please choose Question Format <br>Which you want to answer</h2>
	<g:if test="${flash.msg}">
	<h6 class="red-text">
		${flash.msg}
	</h6>	
	</g:if>
	<div class="list-content">
	  <g:select id="question" class="" from="${OptionsFormat}"
				optionKey="id" name="questionOptionsFormat" optionValue="questionOptionsFormat"
				noSelection="['': 'Select']"/>
	  </div>
	  
	  <div id="option1">
	  <g:render template="textBox"></g:render>	 
	  </div>
	  <div id="option2">
	   <g:render template="selectBox"></g:render>
	  </div>
	  <div id="option3">
	   <g:render template="multiSelectBox"></g:render>
	  </div>
	  <div id="option4">
	    <g:render template="checkBox"></g:render>
	 
	  </div>
	</div>
	</div>
	</div>
  </div>
<script type="text/javascript">
$("document").ready(function(){
	$("#option1").hide();
	$("#option2").hide();
	$("#option3").hide();
	$("#option4").hide();
	$("#question").change(function(){
	if($("#question").val()!=""&&$("#question").val()==1){
	$("#option1").show();
	$("#option2").hide();
	$("#option3").hide();
	$("#option4").hide();
	}
	else if($("#question").val()!=""&&$("#question").val()==2){
	$("#option2").show()
	$("#option1").hide();
	$("#option3").hide();
	$("#option4").hide();
	}
	else if($("#question").val()!=""&&$("#question").val()==3){
	$("#option3").show();
	$("#option1").hide();
	$("#option2").hide();
	$("#option4").hide();
	}
	else if($("#question").val()!=""&&$("#question").val()==4){
	$("#option4").show();
	$("#option1").hide();
	$("#option2").hide();
	$("#option3").hide();
	}
else{
	$("#option1").hide();
	$("#option2").hide();
	$("#option3").hide();
	$("#option4").hide();
	}
	});
$("#but").click(function(){
	alert($("#hai").val())
	});
});
</script> 
</body>
</html>