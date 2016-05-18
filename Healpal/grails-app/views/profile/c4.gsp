<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: c4
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
<section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="">
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
								<h1 class="pad-bot-0">Gender identity (optional)</h1>
								<h2 class="pad-top-0">If you choose to add gender identity, we will display that
									in place of sex on your profile.</h2>
								<div class="text-left">
									<div class="box-content2">
										<g:link controller="profile" action="c4" params="[ans:'Female']"><div class="box-content2-bg"><h3><span>Female</span></h3></div></g:link>
									</div>
									<div class="box-content2">
										<g:link controller="profile" action="c4" params="[ans:'Male']"><div class="box-content2-bg"><h3><span>Male</span></h3></div></g:link>
									</div>
									<div class="box-content2">
										<g:link controller="profile" action="c4" params="[ans:'TransFemaleOrTranswoman']"><div class="box-content2-bg"><h3><span>TransFemale/ Transwoman</span></h3></div></g:link>
									</div>
									<div class="box-content2">
										<g:link controller="profile" action="c4" params="[ans:'TransMaleOrTransman']"><div class="box-content2-bg"><h3><span>TransMale/ Transman</span></h3></div></g:link>
									</div>
									<div class="box-content2">
										<g:link controller="profile" action="c4" params="[ans:'Genderqueer']"><div class="box-content2-bg"><h3><span>Genderqueer</span></h3></div></g:link>
									</div>
									<div class="box-content2">
										<g:link controller="profile" action="c4" params="[ans:'Something else']"><div class="box-content2-bg"><h3><span>Something else</span></h3></div></g:link>
									</div>
									<div class="clearfix">&nbsp;</div>
									<div class="clearfix">&nbsp;</div>
								</div>
							</div>
							</div>
								<g:link action="c3" class="back-link"><i class="back-arrow"></i>Back</g:link>
								<g:link class="skip-text" controller="profile" action="c5">Skip</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">5/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>7 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
						</div></div></section>
						<%--<section>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">5/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>7 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
--%></body>
</html>