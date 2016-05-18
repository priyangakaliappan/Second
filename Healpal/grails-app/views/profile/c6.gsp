<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: c6
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
	<g:form controller="profile" action="c6" method="post">
		  <div class="col-sm-12">
						<div class="profile-box-bg">
						<div class="icon-box-top text-center"><img src="../assets/icon/c6-icon.jpg" /></div>
							<div class="text-center">
								<div class="col-md-10 col-xs-12 center-align text-center m-pad-lr">
								<h1>Select your Ethnicity</h1>
								<g:if test="${ethnicityView}">
								<g:each status="i" in="${ethnicityView}" var="ethnicity">
								<div class="box-content2">
									<g:link controller="profile" action="c6"
								params="${[ethnicityId:ethnicity.id]}"><div class="box-content2-bg" id="${ethnicity?.id}"><h3><span>${ethnicity.ethnicityName}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
							</div>
							</div>
							<br/>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="c5" class="back-link"><i class="back-arrow"></i>Back</g:link>
								<g:link class="skip-text" controller="profile" action="c7">Skip</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">7/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>5 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
	</g:form>
	</div></div></section>
	<%--<section>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">7/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>5 more questions for 20% profile completion</p>				
				
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