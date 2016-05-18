<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: k1
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/02/2015      Initial Creation
 * 
 *
 */
--%>
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
  <g:form controller="profile" action="k1" method="POST">
  <div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/icon/k1-icon.jpg" /></div>
								<h3 class="pad-bot-0">Please select the side effects you have experienced during your cancer treatment</h3>
								<div class="list-content">
									<ul>
										<li><input type="checkbox" value="None" name="answer1" class="checkboxSelect" id="answer1"/>
										<label for="answer1" class="selectedLabels">None</label></li>
										<li><input type="checkbox" value="Not started treatment yet" name="answer2" class="checkboxSelect" id="answer2"/>
										<label for="answer2"  class="selectedLabels">Not started treatment yet</label></li>
										<li><input type="checkbox" value="Early menopause" name="answer3" class="checkboxSelect" id="answer3"/>
										<label for="answer3"  class="selectedLabels">Early menopause</label></li>
										<li><input type="checkbox" value="Menopausal symptoms (such as hot flashes and vaginal symptoms)" name="answer4" class="checkboxSelect" id="answer4"/>
										<label for="answer4"  class="selectedLabels">Menopausal symptoms (such as hot flashes and vaginal symptoms)</label></li>
										<li><input type="checkbox" value="fetility issues" name="answer5" class="checkboxSelect" id="answer5"/>
										<label for="answer5"  class="selectedLabels">Fertility  issues</label></li>
										<li><input type="checkbox" value="Insomnia (trouple sleeping)" name="answer7" class="checkboxSelect" id="answer7"/>
										<label for="answer7"  class="selectedLabels">Insomnia (trouble sleeping)</label></li>
										<li><input type="checkbox" value="Axillary Lymph Node Dissection" name="answer8" class="checkboxSelect" id="answer8"/>
										<label for="answer8"  class="selectedLabels">Fear of recurrence (relapse)</label></li>
										<li><input type="checkbox" value="Sexuality and intimacy issues" name="answer9" class="checkboxSelect" id="answer9"/>
										<label for="answer9"  class="selectedLabels">Sexuality and intimacy issues</label></li>
										<li><input type="checkbox" value="Changes in the look and feel of the breast" name="answer10" class="checkboxSelect" id="answer10"/>
										<label for="answer10"  class="selectedLabels">Changes in the look and feel of the breast</label></li>
										<li><input type="checkbox" value="Lymphedema" name="answer11" class="checkboxSelect" id="answer11"/>
										<label for="answer11"  class="selectedLabels">Lymphedema</label></li>
										<li><input type="checkbox" value="Early menopause(including fertility issues)" name="answer12" class="checkboxSelect" id="answer12"/>
										<label for="answer12"  class="selectedLabels">Early menopause (including Fertility issues)</label></li>
										<li><input type="checkbox" value="Weight gain" name="answer13" class="checkboxSelect" id="answer13"/>
										<label for="answer13"  class="selectedLabels">Weight gain</label></li>
										<li><input type="checkbox" value="Fatique" name="answer14" class="checkboxSelect" id="answer14"/>
										<label for="answer14"  class="selectedLabels">Fatigue</label></li>
										<li><input type="checkbox" value="Decline in Cognitive function (chemo-brain)" name="answer15" class="checkboxSelect" id="answer15"/>
										<label for="answer15"  class="selectedLabels">Decline in Cognitive function (chemo-brain)</label></li>
									</ul>
									<div class="clearfix mar-bot-20"></div>
									<p>( You can select one or multiple choices )</p>
								</div>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="j3" class="back-link"><i class="back-arrow"></i>Back</g:link>
							<g:link class="skip-text"><g:submitButton name="NEXT"/></g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-3-slider pull-left">
				<div class="bar-text">1/3</div>
				<ul>
					<div class="per-text pull-left">80%</div>
					<li class="active"></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">100%</div>
				</ul>
				<p>2 more questions for 100% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
					</g:form></div></div></section>
					<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-3-slider pull-left">
				<div class="bar-text">1/3</div>
				<ul>
					<div class="per-text pull-left">80%</div>
					<li class="active"></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">100%</div>
				</ul>
				<p>2 more questions for 100% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
					--%><script>

					$(document).ready(function() {
					    $('input:checkbox').change(function(){
					    	if($(this).is(":checked")) {
					    	  $(this).closest('li').addClass("active");
					    	}
					    	else
						    	{
					    		$(this).closest('li').removeClass("active");
						    	}
					    });
					});
					</script>
  </div>
</body>
</html>