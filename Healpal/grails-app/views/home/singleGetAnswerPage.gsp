
<%@page import="com.healpal.care.PatientMatchController"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>::.. Healpal | Home ..::</title>
</head>
<body>
	<div class="body">
		<section class="inner-white-bg">
			<div class="container container-1330">
				<div class="row">
					<div class="col-lg-1 col-md-1 col-sm-2"></div>
					<div class="col-md-11">
						<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 single-review">
							<h3>
								${singleAnswerList?.yourQuestionIsRelatedTo}
							</h3>
							<div class="orange-text single-review">
								<ul>
									<li><i class="smal-img"></i> ${singleAnswerList?.patientFk?.person?.fullName}</li>
									<li><img
										src="../assets/new-design/img/location-icon-s.png" alt="image" />
										${singleAnswerList?.yourLocation}</li>
									<li><i class="calender-img"></i> <g:formatDate
											date="${singleAnswerList?.rowCreated}" style="short" type="date" /></li>

								</ul>
							</div>
							<%--<img src="../assets/new-design/img/location-icon-s.png"
								alt="image" />
							--%>
							<p>
								${singleAnswerList?.yourQuestion}
							</p>

							<div class="share-social-text">
								share &nbsp; &nbsp; <a
									href="https://plus.google.com/share?url=https://www.healpal.me${request.forwardURI + '?' + request.queryString}"
									onclick="javascript:window.open(this.href,
 '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;">
									<i class="gplus-icon"></i>
								</a> <a
									href="http://www.linkedin.com/shareArticle?mini=true&url=https://www.healpal.me${request.forwardURI + '?' + request.queryString}&title=Healpal LinkedIn
			              &summary=Healpal&source=Healpal Breast Cancer"
									onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><i
									class="linkedin-icon1"></i></a> <a
									href="https://twitter.com/home?status=https://www.healpal.me${request.forwardURI + '?' + request.queryString}"
									onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;">
									<i class="tweet-icon"></i>
								</a>
								 <%--<a href="javascript:void(0)"
									data-pin-do="buttonPin" data-pin-custom="true" class="pin_ico"> <i class="pin-icon1"></i></a>
									
									
									--%><%--
                       				 <a href="http://www.facebook.com/sharer.php?u=https://www.healpal.me${request.forwardURI + '?' + request.queryString}&picture=healpal.me/assets/new-design/img/logo.png" 
                       				 onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><i class="fb-icon1"></i></a>
							
							--%>
							
							 <a href="JavaScript:void(0)" title="Healpal" onclick="fb_share(this)">
									<i class="fb-icon1"></i> </a>
							</div>


							<h5>
								<strong>Doctor Answers</strong>
								<g:if test="${flash.msg}">
									<div class="alert alert-danger"
										style="text-align: left; margin-top: 23px; width: 60%;">
										${flash.msg}
									</div>
								</g:if>
								<p>
									${singleAnswerList?.answers}
								</p>
							</h5>



							<div>
								<g:submitButton
									class="btn btn-default btn-lg orange-btn submit-btn"
									type="submit" value="Ask your question now" name="answer"
									id="answer" onclick="return check();" />
							</div>
							<%--
							
							
							<div class="share-social-text">
								Share &nbsp; &nbsp; <i class="gplus-icon"></i> <i
									class="linkedin-icon1"></i> <i class="tweet-icon"></i> <i
									class="pin-icon1"></i> <i class="fb-icon1"></i>
							</div>

							<h5>
								<strong>Add a comment</strong>
							</h5>
							<textarea placeholder="Add a comment..." id="userComments"
								name="userComments"></textarea>

							<a href="#" class="comment-view-text">View more comments<i
								class="view-more-icon"></i></a>

							<div class="col-md-12 col-sm-12 col-xs-12 pad-lt-0">
								<div class="single-story-content">
									<ul>
										<g:if test="${commentsList}">
											<g:each in="${commentsList}" var="list" status="i">
												<li>
													<div class="col-lg-1 col-md-1  col-sm-1 pad-lr-0">
														<div class="pat-imgbox">
															<img src="../assets/new-design/img/diagnosis-img.jpg"
																alt="image" />
														</div>
													</div>
													<div class="col-lg-11 col-md-11 col-sm-11 pad-rt-0">
														<div class="single-right-content">
															<h6>Lorem ipsum dolor sit amet, consecteture</h6>
															<div class="orange-text">
																<i class="smal-img"></i>
																${list?.commentedPatient?.person?.fullName}
																&nbsp; &nbsp; <i class="calender-img"></i>
																<g:formatDate date="${list?.rowCreated}"
																	format="dd/mm/yyyy" />
															</div>
															<p>
																${list.comments}
															</p>
														</div>
													</div>
													<div class="clearfix"></div>
												</li>
											</g:each>
										</g:if>
									</ul>
									<a class="read-view-text orange-text" href="#">View More<i
										class="view-more-icon"></i></a>
								</div>
							</div>



						--%>
						</div>


						<div
							class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar right-side-content">

							<h3 class="right-sidebar-content">Related Content</h3>
							<div class="h3-border-line"></div>
							<div id="more">
								<g:render template="moreQuestions"></g:render>
								<%--<ul>
								<g:if test="${askAnswersHomePageList}">
									<g:each in="${askAnswersHomePageList}" var="list">
										
											<li><g:hiddenField name="askAnswersHomePageId" />
												<div class="doctors-list-left client-img doctor-name-text">
													<%
					PatientMatchController patientMatchController=new PatientMatchController();
					def photoName = patientMatchController?.getPhotoNameForFindReview(list?.patientFk?.person?.id);
					 %>
													<g:if test="${photoName}">
														<img class="img-responsive"
															src="${resource(dir:'assets/patient-photo',file:photoName)}">
													</g:if>
													<g:else>
														<img class="img-responsive"
															src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
													</g:else>
													${list?.patientFk?.person?.fullName}
												</div>
												<div class="doctors-list-right right-sidedoctorlist">
													<h5>
														<strong> ${list?.yourQuestionIsRelatedTo}
														</strong>
													</h5>
													<div class="content-description">
													<g:link controller="home" action="singleGetAnswerPage" params="${[singleAnswerPageId:list?.id]}">${list?.yourQuestion}</g:link>
													</div>
													
												</div></li>
										
									</g:each>
								</g:if>
							</ul>
							--%>
								<%--<a href="#" class="read-view-text pull-right">Read more Questions<i
								class="view-more-icon1"></i></a>
						--%>
							</div>
						</div>
					</div>
				</div>
		</section>
	</div>
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript">
function check(){

	 window.location.replace("../home/getAnswers");
}
</script>

<%--<script type="text/javascript">
function fb_share1(e){
	
		 var imgPath =$('.img-ban').prop('src'); 
	
		var link = window.location.href;
	
		//var description = $('.bjqs-caption:visible span:eq(2)').text(); //$(".right-gray-cont").find('p:first').text();
		var url = "http://www.facebook.com/sharer.php?u="+link+"&picture="+imgPath;
		javascript:window.open(url,'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
		return false;
	}
</script>
--%></body>
</html>