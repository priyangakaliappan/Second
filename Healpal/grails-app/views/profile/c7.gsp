<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: c7
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
						<div class="icon-box-top text-center"><img src="../assets/icon/c7-icon.jpg" /></div>
							<div class="">
								<div class="col-md-12 col-xs-12 pad-lr-0  m-pad-lr">
								<h1>Select your Race</h1>
								<div class="text-left">
								<g:if test="${race}">
								<g:each in="${race}" var="record">
								<div class="box-content2">
									<g:link controller="profile" action="c7"
								params="${[ans:record?.raceName]}"><div class="box-content2-bg" id="${record?.id}"><h3><span>${record?.raceName}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
								</div>
							</div>
							</div>
							<br/>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link action="c6" class="back-link"><i class="back-arrow"></i>Back</g:link>
								<g:link class="skip-text" controller="profile" action="c8">Skip</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">8/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>4 more questions for 20% profile completion</p>				
				
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
				<div class="bar-text">8/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>4 more questions for 20% profile completion</p>				
				
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