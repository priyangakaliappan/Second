<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: m2
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
<title>::.. Healpal | Home ..::</title>

</head>
<body>
	<div class="profile-box-bg">
		<g:form name="uploadingMedicalDocument" controller="profile"
			action="m2" enctype="multipart/form-data">
			<div class="formRow text-center">
				<div class="icon-box">
					<img
						src="${resource(dir:'assets/icon',file:'authentication-icon.png')}" />
				</div>
				<h1>Authentication</h1>
				<h2 class="dark-blue">
					<strong>Step2 <br /> Authentication by uploading your
						medical document.
					</strong>
				</h2>
				<div class="col-sm-1 col-xs-2 pad-lt-0">
					<img src="${resource(dir:'assets/icon',file:'secure-icon.jpg')}" />
				</div>
				<div class="col-sm-11 col-xs-10 text-left">
					<h4 class="pad-lt-5">
						<span class="darkorange-text text-uppercase"><strong>Securely
								upload</strong> </span>relevant medical documents to our cloud platform that
						will complete your authentication. We usually confirm your
						authentication in 72 hours.
					</h4>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="col-md-10 center-align">
				<div class="box-content3 text-center">
					<h3>Drag and Drop Medical Documents Here</h3>
					<p>
						<small>Supported files types : PDF, JPG, PNG, RTF and DOC</small>
					</p>
					<div class="text-center"></div>

					<div class="file-upload col-md-7 center-align">
						<input type="file" id="url" name="url[]" multiple>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="text-center">
					<h5>
						For Patients Outside The UNITED STATES: ALL medical documents<br />
						should be uploaded in <span class="darkorange-text">English
							Only.</span></br> Please use <span class="darkorange-text">Google
							Translate</span> or a professional translation</br> service if necessary.
					</h5>
					<p class="mar-top-30">
						Watch tutorial on how to upload Medical Document</br> and Radiology
						Images.
					</p>
					<div>
					<span id="load-msg" style="font-size: 25px;"></span>
					<p id="load-img"></p>
					</div>
					<input type="submit" id="_submit" value="SUBMIT" class="pink-btn" />
				</div>
			</div>
			<g:link class="back-link" controller="profile" action="m1">
				<i class="back-arrow"></i>Back</g:link>
				<g:link class="skip-text" controller="dashboard" action="view">Skip</g:link>
		</g:form>
	</div>
	
	<script>
	
		window.addEvent('domready', function() {
			var upload = new Form.Upload('url', {
				onComplete : function() {
					window.location.href = "../dashboard/view";
				}
			});
			if (!upload.isModern()) {
				// Use something like
			}
		});
	</script>
</body>
</html>