<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="profile" />
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-12">
		<div class="profile-box-bg">
		<g:form controller="ProfileQuestionAndAnswer" action="add">
			<div class="col-md-10 col-xs-12 center-align text-center">
			<g:if test="${question}">			
			<div class="text-center">
			<input type="hidden" name="profileQuestion" value="${question?.id}">			
				<h1>${question?.questionLabel?.questionLabel}</h1>
				<h2>${question?.questionText?.questionText}</h2>				
				<g:if test="${question?.questionOptionsFormat?.id == 1}">
				<g:render template="textBox"></g:render>
				</g:if>
				<g:elseif test="${question?.questionOptionsFormat?.id == 2}">
				<g:render template="dropDown"></g:render>
				</g:elseif>
				<g:elseif test="${question?.questionOptionsFormat?.id == 3}">
				<g:render template="multipleDropDown"></g:render>	
				</g:elseif>
				<g:elseif test="${question?.questionOptionsFormat?.id == 4}">
				<g:render template="checkBox"></g:render>
				</g:elseif>
				
				<g:submitButton name="Save" class="pink-btn"/>
				</div>
					</g:if>
			</div><br>
			
			
			</g:form>
			<g:link controller="ProfileQuestionAndAnswer" action="nextQuestion">Next</g:link>
			<g:link controller="ProfileQuestionAndAnswer" action="back">Back</g:link>
		</div>
	</div>
</body>
</html>