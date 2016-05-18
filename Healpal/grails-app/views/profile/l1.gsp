<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: l1
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
							<div class="col-md-10 col-xs-12 center-align text-center">
								<div class="icon-box-top"><img src="${resource(dir:'assets/icon',file:'l1-icon.jpg')}"/></div>
								<h2>Do you have any associated medical conditions ?</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="medical-conditions-yes"><g:link controller="profile" action="l2"
						onclick="saveQuestionValues('Do you have any associated medical conditions?', 'Yes');">
								<h3>
									<span>Yes</span>
								</h3>
							</g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="medical-conditions-no"><g:link controller="profile" action="l3" onclick="saveQuestionValues('Do you have any associated medical conditions?', 'No');"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="medical-conditions-notsure"><g:link controller="profile" action="l3" onclick="saveQuestionValues('Do you have any associated medical conditions?', 'Not Sure');"><h3><span>Not sure</span></h3></g:link></div>
								</div>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
					<g:link class="back-link" controller="profile" action="k1"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-3-slider pull-left">
				<div class="bar-text">2/3</div>
				<ul>
					<div class="per-text pull-left">80%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">100%</div>
				</ul>
				<p>1 more questions for 100% profile completion</p>				
				
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
			<div class="prograss-bar bar-3-slider pull-left">
				<div class="bar-text">2/3</div>
				<ul>
					<div class="per-text pull-left">80%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">100%</div>
				</ul>
				<p>1 more questions for 100% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
	--%><script type="text/javascript"
		src="${resource(dir:'js',file:'jquery-1.10.2.js')}"></script>
	<script type="text/javascript">
		function saveQuestionValues(question, answer){
			if(question != null && question != "" && answer != null && answer != ""){
				$.ajax({
					async : false,
					type : 'POST',
					url : '../profile/saveQuestionValue',
					data : {question:question,
							answer:answer},
					success : function(res) {
						//do nothing
					}
				});
			}
		}
	</script>
</body>
</html>