<%--
 *
 * Author  		: Subhapriya M
 * Project 		: HealPal
 * Date    		: 29/01/2016
 * FileName 	: learn
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Subhapriya M     1.0    29/01/2016      Initial Creation
 * 
 *
 */
--%>
<%@page import="com.healpal.care.AskAnswersHomePage"%>
<%@page import="com.healpal.care.Diagnosis"%>
<%@page import="com.healpal.care.Patient"%>
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.DashboardController"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>Learn</title>
<link href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}" rel="stylesheet">

<style type="text/css">
.disable_btn{
cursor: not-allowed;
}
</style>
</head>
<body>
	
	<section class="inner-white-bg answer-page">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0">
					<g:form controller="home" action="getAnswers" method="post">
						<h2>Get Answers</h2>
						<div id="alertHide" class="alert alert-danger" style="text-align: left;font-size: medium;font-size: medium; margin-left: -1px; margin-top: 23px; width: 30%; margin-bottom: 0px;">
								<ul>
								</ul>
							</div>
							<g:if test="${session.user}">
						<g:if test="${flash.msg}">
						<div id="flash_msg" class="alert alert-danger" style="text-align: left;font-size: medium;font-size: medium; margin-left: -1px; margin-top: 23px; width: 60%; margin-bottom: 0px;">${flash.msg}</div>
						</g:if>
						</g:if>
						
							<div id="review_warn_info" style="text-align: left;font-size: medium;font-size: medium; margin-left: -1px; margin-top: 23px; width: 40%; margin-bottom: 0px;">
								<ul>
								</ul>
							</div>
							
						<h5>Your question is related to*</h5>
						<div><input id="radio" type="radio" name="radio" value="Cancer prevention"><label for="radio1"><span><span></span></span>Cancer prevention</label></div>
						<div><input id="radio" type="radio" name="radio" value="Clinical Trials"><label for="radio2"><span><span></span></span>Clinical Trials</label></div>
						<div><input id="radio" type="radio" name="radio" value="Coping and lifestyle issues"><label for="radio3"><span><span></span></span>Coping and lifestyle issues</label></div>
						<div><input id="radio" type="radio" name="radio" value="Diagnosis"><label for="radio4"><span><span></span></span>Diagnosis</label></div>
						<div><input id="radio" type="radio" name="radio" value="Initial doctor visit"><label for="radio5"><span><span></span></span>Initial doctor visit</label></div>
						<div><input id="radio" type="radio" name="radio" value="Treatment"><label for="radio6"><span><span></span></span>Treatment</label></div>
						
						
						<h5>Your Question*</h5>
							<textarea name="concise"
								placeholder="It helps to be clear and concise."
								id="concise" onkeyup="countChar(this)" maxlength="300"></textarea>
							<div class="mar-bot-30">
								<small id="charCounter">300 more characters needed</small>
							
							</div>
							
						
						
						<%--<h6><span>Add Photos</span></h6>
						<div class="photo-box text-center">
							<p>Drag and drop files here</p>	
							<p>or</p>
							<a class="btn-default inner-orange-btn" href="JavaScript:void(0)">Select photos</a>	
						</div>
						--%><div class="clearfix"></div>
						<h5>Your Location*</h5>
						<input type="text" class="loc-textbox" name="location" id="location" placeholder="City / State" />
						<div class="clearfix"></div>
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
						<%--<button class="btn btn-default btn-lg orange-btn submit-btn" type="submit" onclick="return showAlert()">Submit question</button>
						--%><p><span class="dary-gray-text">Important:</span> All questions are public and cannot be removed. Be sure to omit personal information that you don't want to be shared (like your name, identifiable marks etc.) </p>
						</g:form>
					</div>
					<div class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar right-side-content ">
						<h5>Accurate and easy</h5>
						<p>Get accurate answers from cancer experts easily.</p>
						<h5>Recommended cancer experts</h5>
						<p>Thousands of board-certified cancer experts from around the world at your fingertips.</p>
						<h5>Personalized answers</h5>
						<p>We notify you when cancer experts answer your questions.</p>
					</div>
					<%--<div class="clearfix mar-bot-80"></div> 
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0">
					<h3 class="pull-left">Most Active Doctors</h3>
						<div class="pull-left">
							<select class="select-condition" name="condition" onChange="condition(this.value)">
								<option>LAST 30 DAYS</option>
								<option value="introduction">Breast Cancer</option>
							</select>
						</div>
						<div class="clearfix"></div>
						<div class="doctor-list">
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml1.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>John Slater, MD</h6>
									<h6>Medical Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="#" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">14 reviews</a>
								</div>	
							</div>
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml2.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Lucy Mcdermott, MD</h6>
									<h6>Breast Cancer Surgeon</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">30 reviews</a>
								</div>	
							</div>
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml3.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>George Mcgee, MD</h6>
									<h6>Medical Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">10 reviews</a>
								</div>	
							</div>	
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml4.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Kathryn Anada, MD</h6>
									<h6>Radiation Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">50 reviews</a>
								</div>	
							</div>
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml5.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Cameron Gibbs, MD</h6>
									<h6>Breast Cancer Surgeon</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">20 reviews</a>
								</div>	
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="doctor-list">
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml6.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Aden Kelin, MD</h6>
									<h6>Medical Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">14 reviews</a>
								</div>	
							</div>
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml7.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Serena James, MD</h6>
									<h6>Breast Cancer Surgeon</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">30 reviews</a>
								</div>	
							</div>
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml8.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Beldwin Slater, MD</h6>
									<h6>Medical Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">10 reviews</a>
								</div>	
							</div>	
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml4.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>Bernetta Gibbs, MD</h6>
									<h6>Medical Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">40 reviews</a>
								</div>	
							</div>
							<div class="col-md-2 pad-lr-0">
								<div class="box-img-sml">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml10.jpg">
								</div>
								<div class="box-img-sml-caption">
									<h6>arolyan Mcgee, MD</h6>
									<h6>Medical Oncologist</h6>
									<div class="star-icon pull-left">
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="orange-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
										<a href="JavaScript:void(0)" class="gray-star-sml"></a>
									</div>
									<a href="JavaScript:void(0)" class="pull-left">50 reviews</a>
								</div>	
							</div>
							<div class="clearfix"></div>
						</div>		
					</div>
					<div class="col-md-4 col-sm-4 answer-sidebar pad-top-0">
						<h3>Recently Asked Questions</h3>
						<div class="clearfix mar-bot-30"></div>
						<h5>Initial doctor  visit</h5>
						<p>How can I tell if changes in my breasts are normal and not a breast cancer symptom?</p>
						<p>Am I more likely to get breast cancer than anyone else?</p>
						<h5>Diagnosis</h5>
						<p>How painful is the breast biopsy?</p>
						<p>Do mammograms miss breast cancer?</p>
						<h5>Treatment</h5>
						<p>What are the side-effects of chemotherapy?</p>
						<p>What are the results of Herceptin?</p>
						<h5>Cancer prevention</h5>
						<p>If my mammogram is abnormal, what follow up tests will I need to undergo? </p>
						<p>Are mammograms painful?</p>
						<h5>Clinical trials</h5>
						<p>What are the possible side effects or risks of the new treatment in the clinical trial?</p>
						<p>How do the possible risks and benefits of this clinical trial compare to those of the standard treatment?</p>
					
					
					</div>
					 
							--%>
							<div
							class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar right-side-content">
							<h3 class="right-sidebar-content">Recently Asked Questions</h3>
							<div class="h3-border-line"></div>
							<%--<div id="more">
							<g:render template="moreQuestions"></g:render>
							--%><ul>
								<g:if test="${answer}">
									<g:each in="${answer}" var="list">
										
											<li><g:hiddenField name="askAnswersHomePageId" />
												<div class="doctors-list-left client-img doctor-name-text">
												<%
					PatientMatchController patientMatchController=new PatientMatchController();
					def photoName = patientMatchController?.getPhotoNameForFindReview(list?.patientFk?.person?.id);
					 %>
					    
													
												</div>
												<div class="doctors-list-right right-sidedoctorlist">
													<h5><strong>${list?.yourQuestionIsRelatedTo}</strong></h5>
													<div class="content-description">
												<g:link controller="home" action="singleGetAnswerPage" params="${[singleAnswerPageId:list?.id]}">${list?.yourQuestion}</g:link>
													</div>
													
														
												</div></li>
											
									</g:each>
								</g:if>
							</ul>
							</div>
					</div>
				</div>
			</div>
		
	</section>
	<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/answers',file:'answersValidation.js')}"></script>	
	
		
	
	
<script type="text/javascript">
	function countChar(val) {
	    var len = val.value.length;
	    if (len > 300) {
	      val.value = val.value.substring(0, 300);
	    } else {
	      $('#charCounter').text(300-len+(" more characters needed"));
	    }
	  };
	
	</script>	

</body>
</html>

