<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="mailLayout" />
<title>Healpal</title>
</head>
<body><section class="inner-white-bg reset-page">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0">
						<h1>Reset Your Password</h1>
						<div id="err" class="alert alert-danger"
						style="text-align: center; font-size: medium; margin-left: 33px; width: 90%;">
					</div>
					
					<g:if test="${flash.reset}">
					<div id="err" class="alert alert-danger"
						style="text-align: center; font-size: medium; margin-left: 33px; width: 90%;">
						${flash.reset}
					</div>
				</g:if>
				<g:form controller="forgotPassword" action="reset" name="resetForm">
					<g:if test="${canReset}">
						<g:hiddenField name="hiddenUserId" value="${resetUserId}"
							id="hiddenUserIdd" />
				
						<h6>Please enter a password in both fields :</h6>
						<input type="password" id="newPassword" name="newPassword"
									placeholder="Your new password" class="form-control"
									maxlength="100" required
									oninvalid="this.setCustomValidity('Please enter password')"
									onchange="this.setCustomValidity('')"
									style="height:35px; line-height:35px; border:1px solid #d5d5d5; border-radius:5px; padding:0px 0px 0px 8px; font-size:15px; color:#5a5a5a; width:265px;">
									
									
						<div class="clearfix mar-bot-10"></div>
						<input type="password" id="confirmPassword"
									name="confirmPassword" class="form-control"
									placeholder="Confirm password" required
									oninvalid="this.setCustomValidity('Confirm your Password')"
									onchange="this.setCustomValidity('')"
									style="height:35px; line-height:35px; border:1px solid #d5d5d5; border-radius:5px; padding:0px 0px 0px 8px; font-size:15px; color:#5a5a5a; width:265px;">
									
									
									
						<div class="clearfix"></div>
						<g:submitButton name="save"
								class="btn btn-default btn-lg orange-btn submit-btn" value="Save" />
								</g:if>
					<g:else>
						<g:if test="${ignoreExpired}">
						</g:if>
						<g:else>
							<div class="alert alert-error"
								style="display: block; font-size: 12px;">Password reset
								link got expired</div>
						</g:else>
					</g:else>
				</g:form>
				
				
				
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	
	
	
	
	
	<%--<section class="inner-white-bg">
		<div class="container">
			<div class="row">
				<h2 class="mar-top-70">Reset Your Password</h2>
				<div class="form-group">
					<div id="err" class="alert alert-danger"
						style="text-align: center; font-size: medium; margin-left: 33px; width: 90%;">
					</div>
				</div>
				<g:if test="${flash.reset}">
					<div id="err" class="alert alert-danger"
						style="text-align: center; font-size: medium; margin-left: 33px; width: 90%;">
						${flash.reset}
					</div>
				</g:if>
				<g:form controller="forgotPassword" action="reset" name="resetForm">
					<g:if test="${canReset}">
						<g:hiddenField name="hiddenUserId" value="${resetUserId}"
							id="hiddenUserIdd" />
						<br>
						<h6>Please enter a password in both fields:</h6>

						<div>
							<div class="col-sm-8 col-xs-12">
								<input type="password" id="newPassword" name="newPassword"
									placeholder="Your new password" class="form-control"
									maxlength="100" required
									oninvalid="this.setCustomValidity('Please enter password')"
									onchange="this.setCustomValidity('')"
									style="margin-left: -40px; width: 235px">
							</div>
						</div>
						<br>
						<br>
						<div class="form-group">
							<div class="col-sm-8">
								<input type="password" id="confirmPassword"
									name="confirmPassword" class="form-control"
									placeholder="Confirm password" required
									oninvalid="this.setCustomValidity('Confirm your Password')"
									onchange="this.setCustomValidity('')"
									style="margin-left: -40px; width: 235px;">

							</div>
						</div>
						<br>
						<br>
						<div>
							<g:submitButton name="save"
								class="btn btn-default btn-lg header-orange-btn" value="save" />
							<g:link controller="home" action="index"
								class="btn btn-brand-f btn-orange">Cancel</g:link>
						</div>

					</g:if>
					<g:else>
						<g:if test="${ignoreExpired}">
						</g:if>
						<g:else>
							<div class="alert alert-error"
								style="display: block; font-size: 12px;">Password reset
								link got expired</div>
						</g:else>
					</g:else>
				</g:form>

			</div>
		</div>
	</section>
	--%><div class="fixed-header"></div>
	<script type="text/javascript"
		src="../assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="../assets/new-design/js/bootstrap.min.js"></script>
		
		

</body>
</html>

