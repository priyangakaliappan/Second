<%@page import="com.healpal.care.ShareYourStoryComments"%>
<%@page import="com.healpal.care.Diagnosis"%>
<%@page import="com.healpal.care.Patient"%>
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.DashboardController"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="homeLayout"/>
<title>Share Your Story</title>
</head>
<body>
  <div class="body">
  
  <section class="inner-white-bg review-page">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
				<div class="col-sm-8 col-xs-12 pad-lr-0">
					<g:form controller="home" action="shareYourStory" method="post" enctype="multipart/form-data">
						<h2>Share Your Story</h2>
						<div class="txt-20">Give hope and inspiration to others fighting their own battle against cancer.</div>
						<div class="require-text">*Required Fields</div>
						<div id="alertHide" class="alert alert-danger">
								<ul>
								</ul>
							</div>
							<g:if test="${session.user}">
						<g:if test="${flash.msg}">
						<div id="flash_msg" class="alert alert-danger" style="text-align: left;font-size: medium;font-size: medium; margin-left: -1px; margin-top: 23px; width: 60%; margin-bottom: 0px;">${flash.msg}</div>
						</g:if>
						</g:if>
						<h5>Select your diagnosis*</h5>
						<div class="col-md-6 col-sm-8 col-xs-12 pad-lr-0">
							<g:select class="diagno-select" id="diagnosis" name="diagnosis"
   							 noSelection="${['null':'Please Select One']}"
    						from='${diagnosisList}'
    						optionKey="id" optionValue="diagnosisName"></g:select>
						</div>
						<div class="clearfix"></div>
						<h5>Your status</h5>
						<div><input id="radio8" type="radio" name="radio" value="Caregiver"><label for="radio8"><span><span></span></span>Caregiver</label></div>
						<div><input id="radio5" type="radio" name="radio" value="Family /Friend"><label for="radio5"><span><span></span></span>Family /Friend</label></div>
						<div><input id="radio6" type="radio" name="radio" value="Lost loved one"><label for="radio6"><span><span></span></span>Lost loved one</label></div>
						<div><input id="radio1" type="radio" name="radio" value="Newly diagnosed patient"><label for="radio1"><span><span></span></span>Newly diagnosed patient</label></div>
						<div><input id="radio3" type="radio" name="radio" value="Partner /Spouse"><label for="radio3"><span><span></span></span>Partner /Spouse </label></div>
						<div><input id="radio4" type="radio" name="radio" value="Patient on treatment"><label for="radio4"><span><span></span></span>Patient on treatment</label></div>
						<div><input id="radio7" type="radio" name="radio" value="Physician"><label for="radio7"><span><span></span></span>Physician</label></div>
						<div><input id="radio2" type="radio" name="radio" value="Survivor"><label for="radio2"><span><span></span></span>Survivor</label></div>
						
						<div class="clearfix">&nbsp;</div>
						<div class="clearfix">&nbsp;</div>
						<h5>Narration date</h5>
						<div class="col-md-4 col-sm-6 col-xs-12 pad-lr-0">
						<input class="datepicker date_picker text-box" type="text" placeholder="mm/dd/yyyy" id="narrationDate" name="narrationDate">
						</div>
						
						
						<div class="clearfix"></div>						
						<h5>Story title*</h5>
						<input type="text" class="text-box" name="storyTitle" placeholder="Conquering my fears....." id="storyTitle">
						<h5>Your Story	*</h5>
						<textarea name="yourStory" onkeyup="countChar(this)"  id="yourStory" placeholder="Your story"></textarea>
						<div class="mar-bot-30"><small id="charCounter">2000 characters or less</small></div>
						<h5>Add Photo <small>(If you feel neccessary)</small></h5>
						<div class="photo-box text-center">
							<p>Drag and drop files here</p>
							<div class="text-center center-align">
							<%--<img class="img-responsive"
						src="${resource(dir:'assets/new-design/img',file:'photo-img.jpg')}">
						<img class="img-responsive"
						src="${resource(dir:'assets/new-design/img',file:'video-img.jpg')}">
							</div>
							<p>or</p>
							<a class="btn-default inner-orange-btn" href="JavaScript:void(0)">Select photos</a>	--%>
							
							<input type="file" name="uploadPhoto" maxlength="255"
									value="Upload your photo"
									accept="image/*" class="btn-default inner-orange-btn browse-widthbar"/>
						</div>
						</div>
						<div class="clearfix"></div>
						
						<div class="clearfix"></div>
						<h4>Submit Your Story</h4>
						<div class="pull-left"><input id="mcheckbox1" type="checkbox" name="checkme" value="1"  checked="checked"><label for="checkbox1" ><span></span></label></div>
						<div class="checkbox-text">I certify this story is my experience. I have no personal or business relationship with this provider or practice. I have also not received any offer or incentive from them to write this story. Once I click submit, I understand this content will appear publicly and cannot be removed.</div>
						<g:if test="${session.user}">
						<button class="btn btn-default btn-lg orange-btn submit-btn" type="submit" id="storyValidation" onclick="return showAlert()">Submit</button>
						</g:if>
						<g:if test="${!session.user}">
							<a href="#" data-toggle="modal" data-target="#join" class="btn btn-default btn-lg orange-btn submit-btn">Submit</a>
							</g:if>
						<div class="clearfix mar-bot-15"></div>
						<p>Once your story has been formatted by HealPal it will be posted within 2-3 days.</p>
						</g:form>
						
						
					</div>
						
					<div
							class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar right-side-content">
							<h3 class="right-sidebar-content">You can also read stories written by other members of the HealPal community.</h3>
							<div class="h3-border-line"></div>
							<div id="more">
							<g:render template="moreStories"></g:render>
							
							
							
							
							
							
							
					<%--<h3>You can also read reviews written <br>by other members of the HealPal community</h3>
					<ul>
					<g:each in="${shareYourStory}" var="list">
					<g:link controller="home" action="singleStoryPage">
					<li>
						<h5>${list?.patientFk?.person?.fullName}</h5>
						<p>${list?.diagnosis?.diagnosisName}<br>
						${list?.patientFk?.patientAddresses?.address?.city}<br>
						${list?.yourStory}.<br>
						${list?.storyTitle}.<br>
						<g:formatDate format="yyyy-MM-dd" date="${list?.rowCreated}"/>.<br></p>
						</g:link>
						
						</g:each>
						</ul>
						<a href="#" class="read-view-text pull-right">Read more Views<i
								class="view-more-icon1"></i></a>
					--%></div>
				
				</div>
			
			</div>
		</div>
	</section>

  </div>
  <script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
  <script type="text/javascript" src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js',file:'reviewRate.js')}"></script>
<script type="text/javascript">
$(document).ready(function () {
    $("#narrationDate").datepicker({
    	endDate: '+0d',
        autoclose: true
    });  

});



function call(i){		        
    var kcyear = document.getElementsByName("year")[0],
	  kcmonth = document.getElementsById("month")[0],
	  kcday = document.getElementsByName("date")[0];
    alert(kcyear)
	  var d = new Date();
	  var n = d.getFullYear();
	  for (var i = n; i >= 1920; i--)
		    { 
		    var opt = new Option(); opt.value = opt.text = i; kcyear.add(opt);

		     }
	        kcyear.addEventListener("change", validate_date);
	        kcmonth.addEventListener("change", validate_date);
	         
	 function validate_date() { 
		    var y = +kcyear.value,
		     m = kcmonth.value,
		     d = kcday.value;
		    if (m === "1") 
			    var mlength = 28 + (!(y & 3) && ((y % 100) !== 0 || !(y & 15)));
		     else var mlength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][m - 1]; kcday.length = 0;
		      for (var i = 1; i <= mlength; i++) { 
			            var opt = new Option(); 
			            opt.value = opt.text = i;
			            if (i == d) opt.selected = true;
			             kcday.add(opt);
			              }
		               } 
             validate_date(); 
    
	               } 


$("#alertHide").hide();
		function showAlert() {
			$("li.err_msg").remove();
			$("#flash_msg").remove();
			if ($("#diagnosis").val() == "null" || $("#storyTitle").val() == ""
					|| $("#yourStory").val() == "") {
				$(".alert-danger ul")
				$(".alert-danger").show();
				if ($("#diagnosis").val() == "null") {
					$(".alert-danger ul")
							.append(
									'<li class="err_msg" style="list-style-type:none;">Please choose diagnosis</li>');
					$("#diagnosis").css({
						"border-color" : "#bd202e",
						"color" : "#bd202e"
					})
				}
				if ($("#storyTitle").val() == "") {
					$(".alert-danger ul")
							.append(
									'<li class="err_msg" style="list-style-type:none;">Please enter story title</li>');
					$("#storyTitle").css({
						"border-color" : "#bd202e",
						"color" : "#bd202e"
					})
				}
				if ($("#yourStory").val() == "") {
					$(".alert-danger ul")
							.append(
									'<li class="err_msg" style="list-style-type:none;">Please enter Your story</li>');
					$("#yourStory").css({
						"border-color" : "#bd202e",
						"color" : "#bd202e"
					})
				}
				

				
				window.scrollTo(0, 0); // Important for scroll top
				return false;
			}
		};
	</script>
	
	
	<script>
      function countChar(val) {
        var len = val.value.length;
        if (len > 2000) {
          val.value = val.value.substring(0, 2000);
        } else {
          $('#charCounter').text(2000-len+(" characters or less"));
        }
      };
    </script>
	
  
</body>
</html>