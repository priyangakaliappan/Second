<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: a2
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/02/2015      Initial Creation
 * 
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="createProfile" />
<title>Insert title here</title>
</head>
<body>
		<div class="col-sm-12 pad-lr-0">
						<div class="profile-box-bg">
							<div class="pad-top">
								<h1>Do you have a Patient Portal account?</h1>
								<div class="btn-group">
									<a href="#" class="blue-btn">Yes</a>
									<g:link controller="profile" action="a5" class="blue-btn">No</g:link>
									<a href="#" class="blue-btn">Not sure</a>
									<g:link controller="profile" action="a2w" class="blue-btn active">what's that?</g:link>
								</div>
							</div>
							<g:link controller="profile" action="a1" class="back-link"><i class="back-arrow"></i>Back</g:link>
						</div>
					</div>
</body>
</html>