<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: a3
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/02/2015      Initial Creation
 * 
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="createProfile"/>
<title>Insert title here</title>
</head>
<body>
  <div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<h2> If you provide us access ( enter your username  and password below ) to your  Health Portal account we can automatically generate your Healpal Profile using our proprietary and secure clinical data aggregation tool.  </h2>
								<div class="clearfix"></div>
								<div class="col-sm-2"></div>
								<div class="col-sm-8 m-pad-lr">
									<select class="profile-select" name="condition" id="healthcareSystem" onChange="condition(this.value)">
										<option value="">Please select your Healthcare System</option>
										<option value="introduction">Healthcare System 1</option>
										<option value="introduction">Healthcare System 2</option>
										<option value="introduction">Healthcare System 3</option>
									</select>
									<div class="clearfix"></div>
									<div class="col-sm-6 pad-lt-0 m-pad-rt">
										<input type="email" class="text-box text-box-r" type="email" class="textbox"  id="username" placeholder="Username" required/>
									</div>
									<div class="col-sm-6 pad-rt-0 m-pad-lt">
										<input type="password" class="text-box text-box-r" type="password" class="textbox" id="password" placeholder="Password" required/>
									</div>
								</div>
								<div class="col-sm-2"></div>
								<div class="clearfix mar-bot-5"></div>
								<g:link controller="profile" action="a4" class="blue-btn m-btn" onclick="return addAccount()">Add Account</g:link>
								<div class="clearfix"></div>
								<a href="#" class="add-acc">+Add another account</a>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
							</div>
							<g:link controller="profile" action="a2" class="back-link"><i class="back-arrow"></i>Back</g:link>
						</div>
					</div>
</body>
</html>