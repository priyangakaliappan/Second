<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: c3
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
							<div class="text-center">
								<h1>Gender</h1>
								<div class="col-md-12 col-xs-12 center-align">
									<div class="col-xs-6 m-pad-lr">
										<g:link action="c4" class="p-blue-text" onclick="return saveGender('Male');"><img src="../assets/profile/img/male-img.jpg" alt="" /><br />Male</g:link>
									</div>
									<div class="col-xs-6 m-pad-lr">
										<g:link action="c4" class="p-pink-text" onclick="return saveGender('Female');"><img src="../assets/profile/img/female-img.jpg" alt="" /><br />Female</g:link>
									</div>
								</div>
								<div class="clearfix mar-bot-20"></div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								
							</div>
							<g:link action="c2" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">4/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>8 more questions for 20% profile completion</p>				
				
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
				<div class="bar-text">4/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>8 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
	--%><script type="text/javascript"
		src="${resource(dir:'js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript">
		function saveGender(id) {
			if(id != null && id != ""){
				$.ajax({
					async : false,
					type : 'POST',
					url : '../profile/updateGender',
					data : {genderType:id},
					success : function(res) {
						//$("#messageBody").html(res);
					}
				});
				return true;
			}
		}
		</script>
</body>
</html>