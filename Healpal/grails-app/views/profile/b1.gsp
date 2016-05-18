<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: b1
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
		<g:form controller="profile" action="b1" name="myUpload"
			enctype="multipart/form-data">
		<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/user-icon1.jpg" /></div>
								<div class="col-md-10 col-xs-12 center-align">
									<input type="file" name="uploadPhoto" maxlength="255"
									value="Upload your photo"
									accept="image/*" id="upload_file" onchange="pressed()" class="blue-btn upload-photo-btn choose-file-btn"/>
									<label id="err_field"></label>
									<h1>Why upload a photo?</h1>
									<p class="human-text">A photo makes an instantaneous human connection with others.<br/> A picture speaks a thousand words indeed!</p>
									<g:submitButton name="Save and Continue" class="blue-btn" id="submitPhoto" onclick="return check()"/>
								</div>
								<div class="clearfix">&nbsp;</div>
							</div>
								<g:link class="back-link" controller="profile" action="a7"><i class="back-arrow"></i>Back</g:link>
								<g:link class="skip-text" controller="profile" action="b2">Skip</g:link>
							</div>
						</div>
		</g:form>
		</div></div></section>
		<script type="text/javascript">
		function check(){
			$("#err_field").html("")
			var ext = $('#upload_file').val().split('.').pop().toLowerCase();
		if($("#upload_file").val()==""||$("#upload_file").val()==null){
		$("#err_field").html("Please choose a file")
		return false;
			}
		else if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1){
			$("#err_field").html("Sorry ! Invalid file format")
		return false;
			}
		else{
		return true;
			}
			}
		</script>
</body>
</html>