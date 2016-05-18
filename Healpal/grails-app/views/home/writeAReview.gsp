<%@page import="com.healpal.care.WriteAReviewComments"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<%@page import="com.healpal.care.WriteAReview"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.DashboardController"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>Write a Review</title>
<link href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}" rel="stylesheet">
<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
<style type="text/css">
.disable_btn{
cursor: not-allowed;
}
</style>
</head>
<body>
	<section class="inner-white-bg review-page">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div class="col-sm-8 col-xs-12 pad-lr-0">
						<g:form controller="home" action="writeAReview" enctype="multipart/form-data">
							<h2>Write a Review</h2>
							<div class="txt-20">Your opinions and experience can help
								others make better decisions.</div>
							<div class="require-text mar-bot-10">*Required Fields</div>
							<g:if test="${flash.msg}">
							<div class="clearfix mar-bot-15"></div>
								<span id="flash_msg"
									style="background-color: #f2dede; border-color: #ebccd1; color: #a94442; border-radius: 4px; color: #a94442; margin-bottom: 20px; padding: 11px 21px; width: 300px;font-size: 16px; font-family: Opensans Light !important; ">
									${flash.msg}
								</span>
							</g:if>							
							
							<div id="review_warn_info">
								<ul>
								</ul>
							</div>
							
							<h5>Select your diagnosis*</h5>
							<div class="col-md-6 col-sm-8 col-xs-12 pad-lr-0">
								<g:select class="diagno-select" id="diagnosis" name="diagnosis"
									noSelection="${['':'Please Select One']}"
									from='${diagnosisList}' optionKey="id"
									optionValue="diagnosisName"></g:select>
							</div>
							<div class="clearfix"></div>
							<h5>Review about*</h5>
							<g:each in="${reviewAboutList}" var="reviewList" status="i">
								<div class="review-radiobtn">
									<input id="${reviewList.id}" class="radios reviewAbout" type="radio"
										name="reviewQuestion" value="${reviewList.reviewAbout}"><label
										for="${reviewList.id}"><span><span></span></span>
										${reviewList.reviewAbout}</label>
								</div>
							</g:each>


							<div id="divRad1" class="clearfix"></div>
							<h5>Review date</h5>
							<div class="col-md-4 col-sm-6 col-xs-12 pad-lr-0">
								<input class="datepicker date_picker text-box" type="text" placeholder="mm/dd/yyyy"
									id="reviewDate" name="reviewDate">
							</div>
							<div class="clearfix"></div>
							<h5>Review title*</h5>
							<input type="text" class="text-box review-text"
								placeholder="Should represent the procedure you have undergone."
								name="title" id="title" maxlength="100">
							<h5>Your review*</h5>
							<textarea name="yourReview"
								placeholder="Describe your experience, the pros and cons, the outcome, etc."
								id="yourReview" onkeyup="countChar(this)" maxlength="500"></textarea>
							<div class="mar-bot-30">
								<small id="charCounter">500  characters needed</small>
							</div>
							<h5>Add Photo <small>(If you feel neccessary)</small></h5>
						<div class="photo-box text-center">
							<p>Drag and drop files here</p>
							<div class="text-center">
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
							<%--<div class="clearfix"></div>
							<h5>
								Name the cancer expert who treated you <small>(Required)</small>
							</h5>
							<div class="col-md-4 col-sm-6 col-xs-12 pad-lr-0">
								<input type="text" class="text-box"
									placeholder="e.g., &#146Dr. John Smith&#146" name="cancerExpert"
									id="cancerExpert">
							</div>
							<div class="clearfix"></div>
							<h5>
								Office or clinic location* <small>(You can update this
									later.)</small>
							</h5>
							<div class="col-md-4 col-sm-6 col-xs-12 pad-lr-0">
								<input type="text" class="text-box"
									placeholder="e.g., &#146Houston, Texas&#146" name="clinicLocation"
									id="clinicLocation">
							</div>
							<div class="clearfix"></div>
							<h5>Review your cancer expert</h5>
							<textarea name="reviewExpert"
								placeholder="Describe your interactions with the cancer expert who treated you."></textarea>
							<div class="clearfix"></div>
							--%><%--<div class="review-text">
								<ul>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId1"></a>
											<g:hiddenField name="rateId1" id="rateId11" value="1" />
											<a class="orange-star-l" href="JavaScript:void(0)"></a>
										<a class="orange-star-l" href="JavaScript:void(0)"></a>
										<a class="orange-star-l" href="JavaScript:void(0)"></a> 
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Wait times</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId2"></a>
											<g:hiddenField name="rateId2" id="rateId12" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Bedside
											manner</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId3"></a>
											<g:hiddenField name="rateId3" id="rateId13" value="1" />
											<a class="orange-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Answered
											my questions</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId4"></a>
											<g:hiddenField name="rateId4" id="rateId14" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Time spent
											with me</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId5"></a>
											<g:hiddenField name="rateId5" id="rateId15" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Treatment
											results</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId6"></a>
											<g:hiddenField name="rateId6" id="rateId16" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Aftercare
											and follow-up</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId7"></a>
											<g:hiddenField name="rateId7" id="rateId17" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Staff
											professionalism and courtesy</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId8"></a>
											<g:hiddenField name="rateId8" id="rateId18" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Payment
											process</a>
									</li>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId9"></a>
											<g:hiddenField name="rateId9" id="rateId19" value="1" />
											<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									
										</div> <a class="pull-left" href="JavaScript:void(0)">Overall
											rating</a>
									</li>
								</ul>
							</div>
							--%><div class="clearfix"></div>
							<h4>Submit your review</h4>
							<div class="pull-left">
								<input id="mcheckbox1" type="checkbox" name="checkbox" value="1"
									checked><label for="checkbox1"><span></span></label>
							</div>
							<div class="checkbox-text">I certify this review is my
								experience. I have no personal or business relationship with
								this provider or practice. I have also not received any offer or
								incentive from them to write this review. Once I click submit, I
								understand this content will appear publicly and cannot be
								removed.</div>
							<g:hiddenField name="sigin_rule" value="${session.user}" id="sigin_rule"/>
							<g:if test="${!session.user}">
							<g:submitButton
								class="btn btn-default btn-lg orange-btn submit-btn disable_btn"
								type="submit" value="Submit" name="reviewSub" id="reviewSub" disabled="disabled"
								onclick="return check();"/>
							</g:if>
							<g:else>
							<g:submitButton
								class="btn btn-default btn-lg orange-btn submit-btn"
								type="submit" value="Submit" name="reviewSub" id="reviewSub"
								onclick="return check();" />
								</g:else>
								
							<div class="clearfix mar-bot-15"></div>
							<p>Once your review has been approved by HealPal it will be
								posted within 2-3 days.</p>
						</g:form>
					</div>
					
					
					<%def writeAReviewList=WriteAReview?.createCriteria()?.list{ 
						eq('approved',1)
						order('rowAltered','desc')}
					 %>
<div
							class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar right-side-content">
							
							<h3 class="right-sidebar-content">You can also read reviews written by other members of the HealPal community</h3>						
								<div class="h3-border-line"></div>
								
								<div id="more">
							<g:render template="moreWriteAReviews"></g:render>
							
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
		</div>
	</section>
	<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js',file:'reviewRate.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/review',file:'reviewValidation.js')}"></script>	
	
	<script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                $("#reviewDate").datepicker({
                	endDate: '+0d',
                    autoclose: true
                });  
            
            });
        </script>
          
	





	



