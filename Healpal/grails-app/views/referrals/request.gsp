<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="care"/>
<title>::.. Healpal | Request ..::</title>
</head>
<body>
  
  <g:render template="../template/careMenu"></g:render>
  
  <section class="new-profile-bg">
  
		<div class="container">
			<div class="row">
			
				<g:render template="menu"></g:render>
		
				
				<div class="col-sm-8 col-xs-12 pad-rt-0">
					<div class="col-sm-11" style="padding: 10px;"><g:render template="/dashboard/profileCompletionStatusBar"></g:render></div>
					<div class="box-content9">
						<h2>Request a recommendation</h2>
						<p>Request a recommendation to :
							<select required="" name="patient" id="patients" onchange="defaultMessage();">
								<option value="">Choose a Patient</option>
								<g:each in="${connections}" var="pa">
									<option value="${pa?.id}">${pa?.person?.fullName}</option>
								</g:each>
							</select>
						</p>
						
						<div class="col-sm-1 col-xs-2"><span class="orange-count-text">1</span></div>
						<div class="col-sm-11 col-xs-10"><h3>Request a recommendation for a cancer expert or experts</h3></div>
						<div class="clearfix"></div>
							<p>Your Message </p> <!-- to Susan: -->
						<g:formRemote url="[controller:'referrals',action:'request']" name="requestForm" update="requestExpertId" id="requestExpertForm" method="post" after="alertMe('#requestExpertId' ,'requestExpertForm');">
							<div class="col-sm-12 col-xs-12">
								<div class="col-sm-1 col-xs-1 hidden-xs"></div>
								<div class="col-sm-11 col-xs-11 refferal-cont">
									<p>You can personalize this message if you would like.</p>
								</div>
								<div class="col-sm-1 col-xs-1"></div>
								
								<g:textArea name="message" id="msg1" class="col-sm-10 col-xs-11 reply-box" rows="5" maxlength="500"></g:textArea>
	  							<g:hiddenField name="category" value="Experts"/> <!-- Hidden Field foe identifying Expert or Clinic -->
								<g:hiddenField name="patient" id="chosedPatientId1"/> <!-- Hidden Field foe Chosen patient -->
								
								<div class="col-sm-1 col-xs-1"></div>
							</div>
							<div class="clearfix"></div>
							<div class="col-sm-12 col-xs-12 text-center">
							<div class="col-sm-1 col-xs-1"></div>
								<div class="col-sm-10 col-xs-10"></div> 
									<g:submitButton class="save-btn" name="save" value="Send" onClick="return validate('expert');"/>
									<a class="save-btn" href="../Dashboard/view">Cancel</a>
									<div class="col-sm-1 col-xs-1"></div>
									<div id="requestExpertId"></div>  <!-- success message display div -->
							</div>
							
							</g:formRemote>
							
							<g:formRemote url="[controller:'referrals',action:'request']" name="requestForm" update="requesClinictId" id="requesClinicForm" method="post" after="alertMe('#requesClinictId' ,'requesClinicForm');">
								<div class="col-sm-1 col-xs-2"><span class="orange-count-text">2</span></div>
								<div class="col-sm-11 col-xs-10"><h3>Request a recommendation for a Clinical trial</h3></div>
								<div class="col-sm-1 col-xs-1"></div>
								
								<div class="col-sm-11 col-xs-12">
									<div class="col-sm-1 col-xs-1 hidden-xs"></div>
									<!--  <div class="col-sm-11 col-xs-11">
									<g:select name="clinicalTrial" id="clinicsId" from="${clicnics}" optionValue="name" optionKey="id" noSelection="['':'Choose a Clinical trial']" required=""/>
									</div>  -->
								<div class="col-sm-1 col-xs-1"></div>
									<g:textArea name="message" id="msg2" class="col-sm-11 col-xs-11 reply-box" rows="5" cols="5" maxlength="500"></g:textArea>
	  								<g:hiddenField name="category" value="Clinic Trial"/> <!-- Hidden Field foe identifying Expert or Clinic -->
									<g:hiddenField name="patient" id="chosedPatientId2"/> <!-- Hidden Field foe Chosen patient -->
									
									<div class="col-sm-1 col-xs-1"></div>
								</div>
								<div class="col-sm-12 col-xs-12 text-center">
								<div class="col-sm-1 col-xs-1"></div>
									<div class="col-sm-10 col-xs-10"></div> 
									<g:submitButton class="save-btn"  name="save" value="Send" onClick="return validate('clinic');"/>
									<a class="save-btn" href="../Dashboard/view">Cancel</a>
									<div class="col-sm-1 col-xs-1"></div>
									<div id="requesClinictId"></div> <!-- success message display div -->
								</div>							
								<div class="clearfix"></div>
							</g:formRemote>
						</div>
				</div>
				<div class="col-sm-4 col-xs-12 pad-lt-0">
					<div class="box-content10 mar-lt">
						<h2>Is your recommendation important?</h2>
						<p>You can get seamless recommendations to the expert who treated your matched connection. This enables you to find Dr. &#147Right&#148 quickly and effortlessly. </p>
					</div>
				</div>
			</div>
		</div>
		<g:hiddenField name="sessionUser" value="${session.personName}" id="personName"/>
	</section>
  <script type="text/javascript">
		$(document).ready(function(){
			$(".header-search-box").hide();
					});

		</script>
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/referrals',file:'request.js')}"></script>

  
</body>
</html>
