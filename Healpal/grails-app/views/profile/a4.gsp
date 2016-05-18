<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: a4
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
<meta name="layout" content="profile"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  <div class="col-sm-12">
						<div class="profile-box-bg">
						<div class="icon-box-top text-center">
						<img src="${resource(dir:'assets/images',file:'blue-button.jpg')}" alt="image">
						</div>
						
							<div class="text-center pad-top">
								<h1>Do you have a Blue Button enabled account?</h1>
								<div class="profile-divider account"></div>
								<div class="btn-group">
								    <%--<g:link controller="profile" action="a6" class="btn pink-btn active">Yes</g:link>
									--%>
									<%--<g:link controller="profile" action="a5" class="pink-btn">Yes</g:link>
									--%>
									<a href="#" class="pink-btn">Yes</a>
									<g:link controller="profile" action="a5" class="pink-btn">No</g:link>
									<g:link controller="profile" action="a5" class="pink-btn">Not sure</g:link>
									<g:link controller="profile" action="a5" class="pink-btn">what&#146s it?</g:link>
								</div>
							</div>
							<g:link controller="profile" action="a2" class="back-link"><i class="back-arrow"></i>Back</g:link>
						</div>
					</div>
  </div>
</body>
</html>