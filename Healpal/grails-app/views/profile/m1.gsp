<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: m1
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/02/2015      Initial Creation
 * 
 *
 */
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="profile">
    <title> ::.. Healpal | Home ..:: </title>
    
</head>
<body>
	<div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form name="patientAccountAuthentication" controller="profile" action="m1" class="form-horizontal" id="checkout_form" name="checkout_form">
							<div class="text-center">
								<div class="icon-box-top"><img  src="${resource(dir:'assets/icon',file:'authentication-icon.png')}" /></div>
								<h1>Authentication</h1>
								<h2><strong>You can get access to matched patients. <br/> ONLY after you provide your account authentication.</strong></h2>
								<h2 class="dark-blue">Step1 <br/> Authentication with your credit card information.</h2>
							</div>	
							<div class="clearfix mar-bot-20"></div>
							<div class="col-md-6 col-xs-12 center-align">
								<span class="log-icon pull-left"></span>
								<div class="col-md-10">
									<div class="security-cont pull-left">
										<h5>Secure Payment Info</h5>
										<div class="pull-left"><input type="radio" name="cardType" id="cardName" value="Visa"/></div>
										<div class="pull-left card-img">
											<a href="#"><img  src="${resource(dir:'assets/icon',file:'visa-card.png')}" /></a>
										</div>
										
										<div class="pull-left"><input type="radio" name="cardType" id="cardName" value="MasterCard" /></div>
										<div class="pull-left card-img">
											 <a href="#"><img  src="${resource(dir:'assets/icon',file:'master-card.png')}" /></a>
										</div>
										<div class="pull-left"><input type="radio" name="cardType" id="cardName" value="DiscoverCard" /></div>
										<div class="pull-left card-img">
										     <a href="#"><img  src="${resource(dir:'assets/icon',file:'discover-card.png')}" /></a>
										</div>
										<div class="pull-left"><input type="radio" name="cardType" id="cardName" value="AmericanExpress" /></div>
										   <div class="pull-left card-img">
										      <a href="#"><img  src="${resource(dir:'assets/icon',file:'american-express-card.png')}" /></a>
										 </div>
										 <div class="pull-left"><input type="radio" name="cardType" id="cardName" value="Paypal" /></div>
											 <div class="pull-left card-img">
											     <a href="#"><img  src="${resource(dir:'assets/icon',file:'paypal-card.png')}" /></a>
										</div>
										<div class="clearfix"></div>
										<label>Name (as it appears on your card)</label>
										<input type="text"  placeholder="name" name="name" id="name"/>
										<label>Card number (no dashes or spaces) (for testing purposes use 4242424242424242)</label>
										<input type="text"  placeholder="name" name="cc_number"  id="cc_number" value="4242424242424242"/>
										<label>Expiration Date</label>
										<div class="col-md-6 pad-lt-0">
											<input type="text" name="exp_month" value="" id="exp_month" maxlength="2" placeholder="month"/>
											 
										</div>
										<div class="col-md-6 pad-rt-0">
											<input type="text" name="exp_year" value="" id="exp_year" placeholder="year" maxlength="4"/>
										</div>	
										
										<label>Security code (3 on back, amex: 4 on front )</label>
										<div class="col-md-6 pad-lt-0">
											<input type="text"  placeholder="Security code" name="cvc" value="" id="cvc" maxlength="3"/>
										</div>
										
										<!-- * Important * you will need to set a hidden form input after retrieving the Stripe Token-->
										<input type="hidden" name="stripeToken" value="" id="stripeToken"/>
										
										<div class="col-md-3 pad-lt-0 text-center">
										<img  src="${resource(dir:'assets/icon',file:'security-code-img.png')}" />
										</div>
										<div class="col-md-3 pad-rt-0 text-center">
										<img  src="${resource(dir:'assets/icon',file:'security-code-img.png')}" />
										</div>	
									</div>
								</div>
								<div class="col-md-2"></div>	
							</div>	
							<div class="clearfix"></div>
							<div class="text-center">
								<p>We will not CHARGE your credit card since the service is free of charge. <br/> But, your credit card information will be used for authentication.</p>
								<button type="submit" id="submit" class="pink-btn">SUBMIT</button>
								<h4>${flash.message}</h4>
							</div>	
							<g:link class="back-link" controller="profile" action="l3"><i class="back-arrow"></i>Back</g:link>
							<g:link class="skip-text" controller="profile" action="m2">Skip</g:link>
							</g:form>
						</div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
	<%--<script type="text/javascript" src="${resource(dir:'js',file:'stripe.js')}"></script>
--%></body>
</html>