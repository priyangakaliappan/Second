
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="mailLayout"/>
<title>Healpal</title>
</head>
<body>
<div class="fixed-header"></div>
	<div class="modal-body">
		<label style="position: relative;left: 293px; margin-bottom: 10px; ">Forgot Password</label>	
		<g:form controller="forgotPassword"  class="form-horizontal"  name="password"  action="forgot">
		<div class="col-sm login-right-cont">
			<div><label style="font-size: 15px; font-weight: normal; margin-left: 50px;">Email</label>
			<input type="text" id="form_email" name="email" placeholder="Please enter your email"  maxlength="60" class="textbox" autocomplete="off"
										required oninvalid="this.setCustomValidity('Please enter your email')"
										onchange="this.setCustomValidity('')" style="margin-left: 100px; width: 387px; margin-right: 20px;  height: 36px; font-size: 13px;">	
			
			</div>
			
<div style="text-align: center;">
					<g:submitButton value="Send Request"  class="btn btn-brand-f forgot-btn" name="send"></g:submitButton>
			        <g:link  controller="home" action="index" class="btn btn-brand-f forgot-btn">Cancel</g:link>
			        
				<g:if test="${flash.msg}">
								<div id="err" class="alert alert-danger" style="text-align: center;font-size: medium;width: 90%; margin-left:33px; margin-bottom: 0px; margin-bottom: 0px;">${flash.msg}</div>
								</g:if>	
								</div>					
		</div>		
		</g:form>
		<g:if test="${flash.msg}">
								<div id="err" class="alert alert-danger" style="text-align: center;font-size: medium;font-size: medium; margin-left: 408px; margin-top: 23px; width: 30%; margin-bottom: 0px;">${flash.msg}</div>
								</g:if>
		
</div>
<div class="fixed-header"></div>

</body>
</html>

