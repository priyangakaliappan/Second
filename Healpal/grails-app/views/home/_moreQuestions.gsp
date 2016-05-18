<%@page import="com.healpal.care.AskAnswersHomePage"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<ul>
								<g:if test="${askAnswersHomePageList}">
									<g:each in="${askAnswersHomePageList}" var="list">
											<li><g:hiddenField name="askAnswersHomePageId" />
												<div class="doctors-list-left client-img doctor-name-text">
													<%
					PatientMatchController patientMatchController=new PatientMatchController();
					def photoName = patientMatchController?.getPhotoNameForFindReview(list?.patientFk?.person?.id);
					 %>
													<%--<g:if test="${photoName}">
														<img class="img-responsive"
															src="${resource(dir:'assets/patient-photo',file:photoName)}">
													</g:if>
													<g:else>
														<img class="img-responsive"
															src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
													</g:else>
													${list?.patientFk?.person?.fullName}
												--%></div>
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
							<g:if test="${total > 5  && total > offset && max < total}">
							<g:remoteLink controller="home" action="readMoreQuestions" class="read-view-text pull-right" id="1" update="more" total="${total}" max="${max}" params="['size':total,'maxSize':max]" 
    					>Read more Questions<i
								class="view-more-icon1"></i></g:remoteLink>
								</g:if>