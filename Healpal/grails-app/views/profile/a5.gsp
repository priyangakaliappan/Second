<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: a5
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
    <meta name="layout" content="createProfile">
    <title> ::.. Healpal | Home ..:: </title>  
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
             <div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
								<h2>We will create your profile using our questionnaire. Please answer as many questions you can to the best of your ability. </h2>
								<div class="clearfix"></div>
								<h1>These questions are vital to creating your profile</h1>
								<div class="clearfix"></div>
								<p class="find-text">Our abilty to find the closest match for you depends on the completeness of your profile</p>
								<div class="clearfix mar-bot-20"></div>
								<g:link controller="profile" action="a6" class="blue-btn agree-btn">I agree to the terms of use and privacy Policy</g:link>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
							</div>
							<g:if test="${backToa2W}"><g:link class="back-link" controller="profile" action="a2w"><i class="back-arrow"></i>Back</g:link>
							</g:if>	
							<g:else>
							<g:link class="back-link" controller="profile" action="a2"><i class="back-arrow"></i>Back</g:link>
							</g:else>
							</div>
						</div>
						</div></div>
</section>
</body>
</html>