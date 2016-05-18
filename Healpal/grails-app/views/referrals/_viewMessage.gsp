<script type="text/javascript" src="${resource(dir:'js',file:'jRate.js')}"></script>

<g:if test="${referral}">

	Message : <br/>
	<g:textArea name="message" class="form-control" rows="5">${referral?.message}</g:textArea>
	<br/>
	<g:if test="${referral?.referralType?.equalsIgnoreCase('provide') && referral?.referralCategory?.categoryName?.equalsIgnoreCase('Experts')}">
	Doctor Detail: <br/>
				
								<%@ page contentType="text/html;charset=UTF-8" %>
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
									
										<div class="col-sm-6 col-xs-12">
											<g:textField name="firstName" value="${doctor?.firstName}" id="d1" maxlength="150" placeholder="firstname" placeholder="First Name" class="form-control desktop"/>
										</div>
										<div class="col-sm-6 col-xs-12">
											<g:textField name="lastName" value="${doctor?.lastName}" id="d2" maxlength="150" placeholder="Last Name" class="form-control desktop"/>
										</div>
									</div>
									
									<div class="col-sm-12 col-xs-12 visible-xs" >
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="firstName"  value="${doctor?.firstName}" id="d3" maxlength="150" placeholder="firstname"  placeholder="First Name" class="form-control mobile"/>
										</div>
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="lastName" value="${doctor?.lastName}" id="d4" maxlength="150" placeholder="Last Name"class="form-control mobile" />
										</div>
									</div>
									
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0" >
										<div class="col-sm-6 col-xs-12">
											<g:textField name="phoneNumber" maxlength="15" id="d13" value="${doctor?.phoneNumber}" placeholder="Contact number" class="form-control desktop" />
										</div>
										<div class="col-sm-6 col-xs-12">
											<g:textField name="specialty" id="d6" value="${doctor?.specialty}"  maxlength="150" placeholder="Specialty" class="form-control desktop" />
										</div>
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs">
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="phoneNumber" maxlength="15" id="d14" value="${doctor?.phoneNumber}" placeholder="Contact number" class="form-control mobile" />
										</div>
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="specialty" id="d8" value="${doctor?.specialty}" maxlength="150" placeholder="Specialty" class="form-control mobile" />
										</div>
									</div>
									 
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
										<div class="col-sm-6 col-xs-12">
											<g:textField name="zipcode" maxlength="10" id="d9" value="${doctor?.address?.zipcode}" placeholder="Zip code or postal" class="form-control desktop" />
										</div>
										<div class="col-sm-6 col-xs-12">
											<g:textField name="state" maxlength="50" id="d10" value="${doctor?.address?.state}"  placeholder="State" class="form-control desktop" />
										</div>
									</div>
									<div class="col-sm-12 col-xs-12  visible-xs">
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="zipcode" maxlength="10" id="d11" value="${doctor?.address?.zipcode}" placeholder="Zip code or postal" class="form-control mobile" />
										</div>
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="state" maxlength="50" id="d12" value="${doctor?.address?.state}"  placeholder="State" class="form-control mobile" />
										</div>
									</div>
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
										<div class="col-sm-6 col-xs-12">	
											<g:textField name="county" id="d5" maxlength="50" class="form-control desktop" value="${doctor?.address?.county}" placeholder="Country"/>
										</div>
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs">
										<div class="col-sm-6 col-xs-12 mar-bot-10">
											<g:textField name="county" id="d7" maxlength="50" class="form-control mobile" value="${doctor?.address?.county}" placeholder="Country"/>
										</div>
									</div>
				
				
								<p>Reason for recommendation:</p>
								<script> 
									$("#rateId1").jRate({
										rating: ${referral?.reasonForReferrals?.split(",")[0]?.toInteger()},
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
										rating: ${referral?.reasonForReferrals?.split(",")[1]?.toInteger()},
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
										rating: ${referral?.reasonForReferrals?.split(",")[2]?.toInteger()},
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
										rating: ${referral?.reasonForReferrals?.split(",")[3]?.toInteger()},
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
										rating: ${referral?.reasonForReferrals?.split(",")[4]?.toInteger()},
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
								
								
								  <div class="col-sm-12 col-xs-12 pad-lt-0">
										<div class="col-sm-8 col-xs-12 text-left">
											<ul>
												<li><a href="#" style="line-height:34px;">Accurate Diagnosis</a></li>
												<li><a href="#" style="line-height:34px;">Treatment Excellence </a></li>
												<li><a href="#" style="line-height:34px;">Empathy</a></li>
												<li><a href="#" style="line-height:34px;">Courteous Staff</a></li>
												<li><a href="#" style="line-height:34px;">Patient Satisfaction</a></li>
											</ul>
										</div>
										<div class="col-sm-4 col-xs-12 star-cont">
											<ul>
												<li><span id="rateId1"></span><g:hiddenField name="rateId1" id="rateId11" value="1"/></li>
												<li><span id="rateId2"></span><g:hiddenField name="rateId2" id="rateId12" value="1"/></li>
												<li><span id="rateId3"></span><g:hiddenField name="rateId3" id="rateId13" value="1"/></li>
												<li><span id="rateId4"></span><g:hiddenField name="rateId4" id="rateId14" value="1"/></li>
												<li><span id="rateId5"></span><g:hiddenField name="rateId5" id="rateId15" value="1"/></li>
											</ul>
										</div>
									</div>
				
	</g:if>
	
	<!-- 
	<g:if test="${referral?.referralCategory?.categoryName?.equalsIgnoreCase('Clinic Trial')}">
	Clinic Trial :<br/>
				<g:select name="clinicalTrial" class="form-control" from="${clicnics}" optionValue="name" optionKey="id" noSelection="['':'Choose']" required="" value="${referral?.clinicalTrial?.id}"/>
	</g:if>  -->
	
</g:if>
<g:else>
	Message not found !!
</g:else>


