<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: c5
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
						<div class="icon-box-top text-center"><img src="../assets/profile/img/c5-icon.jpg" /></div>
							<div class="text-center">
								<h1>Where do you live ?</h1>
								<g:form controller="profile" action="c5" name="address" autocomplete="off">
								<div class="col-md-12 col-xs-12 m-pad-lr">
									<div class="col-sm-6 m-pad-lr">
									<input type="text" class="textbox text-box1" id="zip" name="zip" placeholder="Zip/ Postal code" maxlength="5" onKeyPress="return checkOnlyNumber(event);"/>
									</div>
									<div class="col-sm-6 m-pad-lr">
										<input type="text" id="city" class="textbox text-box1" placeholder="City"  name="city" readonly="readonly"/>
									</div>
									</div>
									<div class="col-md-12 m-pad-lr">
									<div class="col-sm-6 m-pad-lr">
										<input type="text" id="state" placeholder="State" class="textbox text-box1" name="state" readonly="readonly"/>
									</div>
									<div class="col-sm-6 m-pad-lr">
										 <input type="text" id="country" placeholder="Country" name="country" class="textbox text-box1" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-12 m-pad-lr">
								<span id="zip_warn" style="font-size: 19px;"></span>
								</div>
								<div id="spinner">	
								<img src="../assets/image/spinner.gif"  alt="Loading..." style="display:none;" id="spin"/> 
								</div>
								<div class="clearfix mar-bot-30"></div>
								<g:submitButton name="Save and continue" class="blue-btn" id="savelive"/>
								</g:form>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link action="c4" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">6/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>6 more questions for 20% profile completion</p>				
				
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
				<div class="bar-text">6/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>6 more questions for 20% profile completion</p>				
				
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