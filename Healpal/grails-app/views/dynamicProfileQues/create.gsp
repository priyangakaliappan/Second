<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="admin"/>
<title>Insert title here</title>
</head>
<body>
  	<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Profile Question
				<small><g:link controller="dashboard" action="adminDashboard">Home </g:link>
					<i class="icon-angle-double-right"></i> Add Profile Question</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<g:render template="form"></g:render>
									</div>
							</div>
						</div>
					</div>
				</div>
		    </div>	
</body>
</html>


