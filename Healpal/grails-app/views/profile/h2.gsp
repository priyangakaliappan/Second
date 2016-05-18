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
 <g:form controller="profile" action="h2">
						<div class="profile-box-bg">
							<div class="icon-box-top text-center"><img src="${resource(dir:'assets/icon',file:'h2-icon.jpg')}" /></div>
							<div class="text-center">
								<h1>Please choose the targeted therapy or therapies given to you</h1>
									<div class="list-content">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li><input type="checkbox" value="Trastuzumab or Herceptin" name="answer1" class="checkboxSelect" id="answer1"/>
											<label for="answer1"  class="selectedLabels">Trastuzumab or Herceptin</label></li>
											
											<li><input type="checkbox" value="Trastuzumab emtansine or T-DM1, Kadcyla" name="answer2" class="checkboxSelect" id="answer2"/>
											<label for="answer2"  class="selectedLabels">Trastuzumab emtansine or T-DM1, Kadcyla</label></li>
										</ul>
									</div>
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li><input type="checkbox" value="Pertuzumab or Perjeta" name="answer3" class="checkboxSelect" id="answer3"/>
										<label for="answer3"  class="selectedLabels">Pertuzumab or Perjeta</label></li>
								        <li><input type="checkbox" value="Lapatinib or Tykerb" name="answer4" class="checkboxSelect" id="answer4"/>
								        <label for="answer4"  class="selectedLabels">Lapatinib or Tykerb</label></li>
										</ul>
									</div>
									
								</div>
								<div class="clearfix mar-bot-30"></div>
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="Profile" action="h1" class="back-link"><i class="back-arrow"></i>Back</g:link>
							<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
						</div>
						</g:form>
						<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">4/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>0 more questions for 70% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div></div></div></section>
						<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">4/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>0 more questions for 70% profile completion</p>				
				
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