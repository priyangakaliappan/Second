<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="mailLayout" />
<title>Healpal</title>
</head>
<body>

<div class="fixed-header"></div>

<%--<g:hiddenField name="hiddenUserId" value="${accountActiveId}" id="hiddenUserIdd" />
	--%><div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0">
		<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Account Activity</label>
		<div class="login-bss-cont register-bss" style="text-align: center; font-size: medium; margin-left: 33px; width: 90%;">
           <br>
			<%--<div class="col-sm-8 pad-lt-0 login-right-cont">

				--%><div class="right">
				<div class="form-group">
					
								
					<g:if test="${ignoreExpired}">
					<g:if test="${flash.msg}">
				 <div class="alert alert-danger" id="account" 
				 style="text-align: center;font-size: medium;margin-left:33px; width: 90%;">${flash.msg}</div>
			                 </g:if>	
							</g:if>		
							<g:else>
							<div class="alert alert-error"
									style="display: block; font-size: 12px;">link got expired</div>
							</g:else>	
					
					</div>
					
				</div>
				<!--right-->
			</div>
		</div>
		</div>
		</div>
		</div>
	
	<%--</div>
	--%><div class="fixed-header"></div>

</body>
</html>

