<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="admin"/>
<title>::.. Healpal | User ..::</title>
<style type="text/css">
.dashboard-sidebar-right {
    display: table-cell;
    float: right;
    border-right: 1px solid #e0e0e0;
    padding-right: 33px;
    vertical-align: top;
}
.profile-img img { float:right;}


</style>
</head>
<body>
 
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Edit User
				<small><g:link controller="dashboard" action="adminDashboard" class="blue-text">
					Home
					</g:link> <i class="icon-angle-double-right"></i> Edit User</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						<span>${flash.msg}</span>
							<%--<g:formRemote name="signupForm" url="[controller: 'Race', action: 'update']" update="updateResult" class="form-horizontal" id="patient_login_form">
								--%>
								<g:render template="form"></g:render>
									    </div>
									   </div>
									  </div>
									 </div>
									</div>
		
		
		
		</div>
</body>



<script type="text/javascript">
function refresh()
{
	alert("hai");
	
	}

</script>


</body>
</html>