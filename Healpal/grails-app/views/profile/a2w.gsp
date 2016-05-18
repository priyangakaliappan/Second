<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: a2w
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
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
								<h3>Do you have a Patient Portal account?</h3>
								<div class="btn-group">
									<a href="#" class="blue-btn">Yes</a>
									<g:link controller="profile" action="a5" class="blue-btn" params="[fromatwoW:'@t%r@ue@']">No</g:link>
									<a href="#" class="blue-btn">Not sure</a>
									<g:link controller="profile" action="a2w" class="blue-btn">what's that?</g:link>
								</div>
								<div class="clearfix mar-bot-30"></div>
								<p class="text-left"><strong>Patient portal</strong> - a website and/or app that allows you to electronically  access your medical records. If you have one of these portals, you’ll enter your username and password in Healpal’s secure signup process. Our clinical data aggregation tools then automatically pulls records from your Patient Portal, using your username and password to secure access.</p>
								<p class="text-left"><strong>Please note:</strong> You may have more than 1 Patient Portal account if you visited multiple healthcare systems. In that case, you may have to provide us with usernames and passwords of each patient portal account for us automatically create your profile.</p>
								<p class="text-left"><strong>Why is it preferable to use Patient Portal account to create your profile on healpal?</strong></p>
								<p class="text-left"><strong>The most important reasons are:</strong></p>
								<ol>
									<li><strong>It’s automated:</strong>  Our clinical data aggregation tool automatically pulls records from your Patient Portal. You sit back as we do all the work for you to create your profile.</li>
									<li><strong>It’s quick:</strong> Since we build your profile, it should take less than a minute for you. You may choose to create a profile using our questionnaire, but this will need 15-20 minutes of your time.</li>
									<li><strong>It’s accurate:</strong> Since your profile is generated automatically from your Patient Portal account, there are less chances of errors.</li>
									<li><strong>Security and privacy:</strong> Using your Patient portal account is the best guarantee of your identity- that you truly are a patient. You do not have to provide additional authentication. We have a huge emphasis on security and integrity, not only for you but also for other patients</li>
								</ol>
								<g:link controller="profile" action="a2" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
						</div>
					</div>
</body>
</html>