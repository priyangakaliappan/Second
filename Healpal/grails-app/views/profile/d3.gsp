<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="createProfile"/>
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
  <div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
								<div class="col-md-12 col-xs-12  m-pad-lr box-cont-width pad-lr-0">
								<h1>Stage of cancer</h1>
								<div class="text-left">
								<g:if test="${cancerStage}">
								<g:each in="${cancerStage}" var="record">
								<div class="box-content2">
									<g:link controller="profile" action="d3" params="${[ans:record?.cancerStageLevel]}"><div class="box-content2-bg" id="${record?.id}"><h3><span>${record?.cancerStageLevel}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
								</div>
							</div>
							</div>
							<br/>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="d2"  class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">2/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>17 more questions for 50% profile completion</p>				
				
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
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">2/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>17 more questions for 50% profile completion</p>				
				
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