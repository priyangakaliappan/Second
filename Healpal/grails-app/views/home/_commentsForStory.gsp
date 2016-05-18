<%@page import="com.healpal.care.PatientMatchController"%>
<span> ${flash.msg}</span>
<ul>
										<g:if test="${commentsList}">
											<g:each in="${commentsList}" var="list" status="i">
												<li>
													<div class="col-lg-1 col-md-1  col-sm-1 pad-lr-0">
														<div class="pat-imgbox">
														<%
					PatientMatchController patientMatchController=new PatientMatchController();
					def photoName = patientMatchController?.getPhotoNameForFindReview(list?.commentedPatient?.person?.id);
					 %>
															<g:if test="${photoName}">
													  <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photoName)}">
													 </g:if>
													 <g:else>
													  <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
													 </g:else>
														</div>
													</div>
													<div class="col-lg-11 col-md-11 col-sm-11 pad-rt-0">
														<div class="single-right-content">
															<%--<h6>Lorem ipsum dolor sit amet, consecteture</h6>
															--%><div class="orange-text">
																<i class="smal-img"></i>
																${list?.commentedPatient?.person?.fullName}
																&nbsp; &nbsp; <i class="calender-img"></i>
																<g:formatDate date="${list?.rowCreated}"
																	type="date"
								style="short" />
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
									<g:hiddenField name="hidde" id="hidden_size" value="${commentsTotal}" />

<g:if test="${commentsTotal > offset && commentsMax < commentsTotal}">
	<g:remoteLink controller="home" action="comments"
		class="read-view-text orange-text" id="1" update="comments"
		total="${commentsTotal}" max="${commentsMax}"
		params="['comment_size':commentsTotal,'comment_maxSize':commentsMax,'commentPatient':storyId,viewMore:'true']">View More<i
			class="view-more-icon"></i>
	</g:remoteLink>
</g:if>
								