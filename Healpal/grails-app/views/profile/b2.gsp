<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: b2
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
<title>::.. Healpal | Home ..::</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/user-icon1.jpg" /></div>
								<g:form controller="profile" action="b2" name="aboutYou">
								<div class="col-md-10 col-xs-12 center-align m-pad-lr">
									<textarea class="textarea" name="aboutYourself" id="aboutYourself"
							maxlength="255" placeholder="Write few lines about  yourself" required="required"></textarea>
									<input type="text" class="textbox" name="passionate"
							id="passionate" maxlength="100"
							placeholder="The one thing I am most passionate about" required="required">
									<g:submitButton  class="blue-btn" name="save and Continue" id="aboutYou"/>
								</div>
								<div class="clearfix">&nbsp;</div>
								</g:form>
							</div>
								<g:link class="back-link" controller="profile" action="b1"><i class="back-arrow"></i>Back</g:link>
								<g:link class="skip-text" controller="profile" action="b3">Skip</g:link>
							</div>
						</div>
</div></div></section>
</body>
</html>