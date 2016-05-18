<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="care"/>
<title>::.. Healpal | Provide ..::</title>
</head>
<body>
  
  <g:render template="../template/careMenu"></g:render>
  
  <section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<g:render template="menu"></g:render>
				<div class="col-sm-8 col-xs-12 pad-rt-0">
					<div class="box-content9 box-content-provid">
						<h2>Provide a recommendation</h2>
						<p>Select a patient and provide a recommendation : 
							<select required="" name="patient" id="patients" onchange="defaultMessage1();">
								<option value="">Choose a patient</option>
								<g:each in="${connections}" var="pa">
									<g:if test="${(params.patientId?.toLong()) == (pa?.id)}"> 
										<option value="${pa?.id}" selected>${pa?.person?.fullName}</option>
									</g:if><g:else>
										<option value="${pa?.id}">${pa?.person?.fullName}</option>
									</g:else>
								</g:each>
							</select>
							
						</p>
						 
						<div class="col-sm-1 col-xs-2"><span class="orange-count-text">1</span></div> 
						<div class="col-sm-11 col-xs-10"><h3>Recommendation your cancer expert or experts <a  class="toggle-pad" data-toggle="modal" href="#myModal">+ Add a doctor</a> </h3> </div>
					
						
						<g:formRemote url="[controller:'referrals',action:'provide']" name="requestForm" update="requestExpertId" id="provideExpertForm" method="post" after="alertMe('#requestExpertId' ,'provideExpertForm');">
						<p>
						<span id="doctorsDiv">
						<g:render template="doctors"></g:render>
						</span>
						</p>
									<div id="viewDoctorDiv">
										<g:render template="viewDoctor"></g:render>
									</div>
									<p>Your Message </p>
									<div class="col-sm-12 col-xs-12">
										<div class="col-sm-1 col-xs-1 hidden-xs"></div>
										<div class="col-sm-11 col-xs-11 refferal-cont">
											<p>You can personalize this message if you&#146d like.</p>
										</div>
										<div class="col-sm-1 col-xs-1"></div>
										
										
										<g:textArea name="message" maxlength="500" id="msg1" class="col-sm-10 col-xs-11 reply-box" rows="5"></g:textArea>
										<g:hiddenField name="category" value="Experts"/> <!-- Hidden Field foe identifying Expert or Clinic -->
										<g:hiddenField name="patient" id="chosedPatientId1"/> <!-- Hidden Field foe Chosen patient -->
										<div class="col-sm-1 col-xs-1"></div>
									</div>
									<div class="clearfix"></div>
									<p>Reason for recommendation</p>
									<div class="col-sm-12 col-xs-12">
										<div class="col-sm-7 col-xs-12 text-left">
											<ul>
												<li><a href="#">Accurate Diagnosis</a></li>
												<li><a href="#">Treatment Excellence </a>
												</li><li><a href="#">Empathy</a></li>
												<li><a href="#">Courteous Staff</a></li>
												<li><a href="#">Patient Satisfaction</a></li>
											</ul>
										</div>
										<div class="col-sm-4 col-xs-12 star-cont pad-lt-0">
											<ul>
												<li><span id="rateId1"></span><g:hiddenField name="rateId1" id="rateId11" value="1"/></li>
												<li><span id="rateId2"></span><g:hiddenField name="rateId2" id="rateId12" value="1"/></li>
												<li><span id="rateId3"></span><g:hiddenField name="rateId3" id="rateId13" value="1"/></li>
												<li><span id="rateId4"></span><g:hiddenField name="rateId4" id="rateId14" value="1"/></li>
												<li><span id="rateId5"></span><g:hiddenField name="rateId5" id="rateId15" value="1"/></li>
											</ul>
										</div>
									</div>
									<div class="col-sm-12 col-xs-12 text-center">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-10 col-xs-10"></div>
											<g:submitButton name="save" value="Send" class="save-btn" onClick="return validate('expert');"/>
											<a class="save-btn" href="../Dashboard/view">Cancel</a>
										<div class="col-sm-1 col-xs-1"></div>
										<div id="requestExpertId" ></div> <!-- success message display div -->
									</div>
									
							</g:formRemote>
							
							
							 <g:formRemote url="[controller:'referrals',action:'provide']" name="requestForm" update="requesClinictId" id="provideClinicForm" method="post" after="alertMe('#requesClinictId' ,'provideClinicForm');">
									<div class="col-sm-1 col-xs-2"><span class="orange-count-text">2</span></div>
									<div class="col-sm-11 col-xs-10"><h3>Recommend a Clinical trial</h3></div>
									<div class="col-sm-1 col-xs-1 "></div>
									<div class="col-sm-11 col-xs-12">
										<div class="col-sm-1 col-xs-1 hidden-xs"></div>
										<!-- 
										<div class="col-sm-11 col-xs-11">
										  	 <g:select name="clinicalTrial" id="clinicsId" from="${clicnics}" optionValue="name" optionKey="id" noSelection="['':'Choose a Clinical trial']" required=""/>
										</div>  -->
									<div class="col-sm-1 col-xs-1"></div>
										<g:textArea maxlength="500" name="message" id="msg2" class="col-sm-11 col-xs-11 reply-box" rows="5"></g:textArea>
	  									<g:hiddenField name="category" value="Clinic Trial"/> <!-- Hidden Field foe identifying Expert or Clinic -->
	  									<g:hiddenField name="patient" id="chosedPatientId2"/> <!-- Hidden Field foe Chosen patient -->
										<div class="col-sm-1 col-xs-1"></div>
									</div>
									<div class="col-sm-12 col-xs-12 text-center">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-10 col-xs-10"></div>
										<g:submitButton name="save" value="Send" class="save-btn" onClick="return validate('clinic');"/>
										<a class="save-btn" href="../Dashboard/view">Cancel</a>
										<div class="col-sm-1 col-xs-1"></div>
										<div id="requesClinictId"></div>  <!-- success message display div -->
									</div>							
									<div class="clearfix"></div>
									
							</g:formRemote>
						</div>
				</div>
				<div class="col-sm-4 col-xs-12">
					<div class="box-content10">
						<h2>Is your recommendation important?</h2>
						<p>You can provide a recommend your doctor to a matched HealPal  member, if you had a successful response to the treatment. Make a difference in someone&#146s life while enhancing your own. </p> 
					</div>
				</div>
			</div>
		</div>
	</section>
  
  
  
  <div id="myModal" class="modal fade add-request-form" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<a href="#" class="close-icon" data-dismiss="modal"></a>
				<div class="login-bss">
					<div class="modal-header">
						<h2>Add Doctor</h2>
					</div>
					<div class="login-bss-cont">
						
						<div class="col-sm-8 pad-lt-0 login-right-cont">
							<div class="right">
								
								<g:render template="addDoctor"></g:render>
								
							</div> <!--right-->
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
  
<g:hiddenField name="sessionUser" value="${session.personName}" id="personName"/>
  
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/referrals',file:'provide.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/referrals',file:'request.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js',file:'jRate.js')}"></script>
<script>

$("#rateId1").jRate({
	rating: 1,
	strokeColor: 'black',
	precision: 1,
	minSelected: 1,
	onChange: function(rating) {
		//console.log("OnChange: Rating: "+rating);
	},
	onSet: function(rating) {
		$("#rateId11").val(rating);
		console.log("OnSet: Rating: "+rating);
	}
});
$("#rateId2").jRate({
	rating: 1,
	strokeColor: 'black',
	precision: 1,
	minSelected: 1,
	onChange: function(rating) {
		//console.log("OnChange: Rating: "+rating);
	},
	onSet: function(rating) {
		$("#rateId12").val(rating);
		console.log("OnSet: Rating: "+rating);
	}
});
$("#rateId3").jRate({
	rating: 1,
	strokeColor: 'black',
	precision: 1,
	minSelected: 1,
	onChange: function(rating) {
		//console.log("OnChange: Rating: "+rating);
	},
	onSet: function(rating) {
		$("#rateId13").val(rating);
		console.log("OnSet: Rating: "+rating);
	}
});
$("#rateId4").jRate({
	rating: 1,
	strokeColor: 'black',
	precision: 1,
	minSelected: 1,
	onChange: function(rating) {
		//console.log("OnChange: Rating: "+rating);
	},
	onSet: function(rating) {
		$("#rateId14").val(rating);
		console.log("OnSet: Rating: "+rating);
	}
});
$("#rateId5").jRate({
	rating: 1,
	strokeColor: 'black',
	precision: 1,
	minSelected: 1,
	onChange: function(rating) {
		//console.log("OnChange: Rating: "+rating);
	},
	onSet: function(rating) {
		$("#rateId15").val(rating);
		console.log("OnSet: Rating: "+rating);
	}
});
</script>
<script type="text/javascript">
		$(document).ready(function(){
			$(".header-search-box").hide();
					});

		</script>
</body>
</html>
