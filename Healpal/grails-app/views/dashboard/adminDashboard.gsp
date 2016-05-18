<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.healpal.care.Diagnosis"%>
<%@page import="com.healpal.care.GroupMail"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="admin">
<title>Insert title here</title>
</head>
<body>
  <div id="tables_page" class="main_container glass admin-content">
		<div class="row-fluid title orange-topstripe">
			<h1>
				Dashboard 
			</h1>
			<%--<div class="pull-right"><small><g:link controller="dashboard" action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Dashboard</small></div>
		--%></div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body" style="height: auto;">
					<h1>User Details</h1>
					<div class="control-group">
						<div class="controls">
							<g:link controller="user" action="view" > 
								<div class="col-sm-3">
									<div class="user-box">
										<div class="pull-left"><p class="box-content"> ${patientCountVal} <br/><small>User  Count</small> </p></div>
										<div class="pull-right"><i class="user-icon"></i></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</g:link>
							<g:link controller="UserMonth" action="view" > 
								<div class="col-sm-3">
									<div class="user-box">
										<div class="pull-left"><p class="box-content">${lastMonth} <br/> <small>Last Month</small></p></div>
										<div class="pull-right"><i class="user-icon"></i></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</g:link>
							<g:link controller="JanToJunMonth" action="view" > 
								<div class="col-sm-3">
									<div class="user-box">
										<div class="pull-left"><p class="box-content">${janToJunMonthCount} <br/> <small>JAN-JUN</small></p></div>
										<div class="pull-right"><i class="user-icon"></i></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</g:link>
							<g:link controller="JulToDecMonth" action="view" > 
								<div class="col-sm-3">
								<div class="user-box">
									<div class="pull-left"><p class="box-content">${julToDecMonthCount} <br/> <small>JUL-DEC</small></p></div>
									<div class="pull-right"><i class="user-icon"></i></div>
									<div class="clearfix"></div>
									</div>
								</div>
							</g:link>
							<div class="clearfix mar-bot-45"></div>
							<br/>
							<br/>
							<h1>Site Details</h1>
							<g:link controller="GroupMail" action="view">
								<div class="col-sm-3">
									<div class="user-box-o">
										<div class="pull-left"><p class="box-content"> ${GroupMail.count}<small>Subscription Mail</small></p></div>
										<div class="pull-right"><i class="note-icon"></i></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</g:link>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="col-sm-3">
									<div class="user-box-o">
										<div class="pull-left"><p class="box-content">${Diagnosis.count}<small>Cancer Type</small></p></div>
										<div class="pull-right"><i class="note-icon"></i></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</g:link>
							<div class="clearfix mar-bot-30"></div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
							<%--<a href="#">
								<div class="yellow-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="red-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<div class="clearfix mar-bot-15"></div>
							<a href="#">
								<div class="blue-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="green-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="yellow-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="red-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<div class="clearfix mar-bot-15"></div>
							<a href="#">
								<div class="blue-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="green-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="yellow-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="red-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
						--%></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>