<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Healpal</title>
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.10.2.js')}"></script>
	<script src="${resource(dir:'js/user',file:'signup.js')}"></script>
</head>
<body>
  <div class="body">
  	Create A New Account.
  	
  	
				  	<g:form method="post" controller="profile" action="signup">
				  			<input type="email" name="email" placeholder="email" required maxlength="128"/>
				  			<input type="password" name="password" placeholder="password" id="pwd" required maxlength="100"/>
				  			<input type="password" name="confirmPassword" placeholder="confirmPassword" id="cpwd" required maxlength="100"/>
				  			<input type="text" name="firstName" placeholder="firstName" required maxlength="60"/>
				  			<input type="text" name="lastName" placeholder="lastName" required maxlength="60"/>
				  			<g:submitButton name="signup" value="Signup" onclick="return validate();"/>
				  	</g:form>
  	
  					<span id="userErr" style="color: red"><br>
  						${flash.msg} <g:link controller="home" action="index">login</g:link>
						<g:hasErrors bean="${user}">
								<span style="color: red"><g:renderErrors
										bean="${user}" as="list" /></span>
							</g:hasErrors>
					</span>
  	
  	
  </div>
</body>
</html>