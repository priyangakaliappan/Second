<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: c1
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
<link href="${resource(dir:'assets/css',file:'colorbox.css')}"
	rel="stylesheet" type="text/css">
</head>
<body>
<section>
			<div class="container container-950">
				<div class="row">
  			<div class="col-sm-12">
						<div class="profile-box-bg">
							
								<div class="col-md-12 col-xs-12  m-pad-lr pad-lr-0">
								<h1>I am a</h1>
								<g:if test="${iamList}">
								<g:each status="i" in="${iamList}" var="iam" >
								<div class="box-content2">
									<g:link  action="c1" params="${[iAm:iam.id]}"><div class="box-content2-bg"><h3><span>${iam.aboutYouName}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
							</div>
							
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="d2" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="prograss-bar pull-left">
								<div class="bar-text">2/12</div>
									<ul>
										<div class="per-text pull-left">0%</div>
										<li class="active"></li>
										<li class="active"></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<div class="per-text pull-right">20%</div>
									</ul>
									<p>10 more questions for 20% profile completion</p>				
								</div>
							</div>
						</div></div>
		</section>
		<%--<section>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">2/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>10 more questions for 20% profile completion</p>				
				
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