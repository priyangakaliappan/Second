<%@page import="com.healpal.care.PatientMatchController"%>
<%@page import="com.healpal.care.WriteAReviewComments"%>

<ul>
								<g:if test="${writeASingleReviewList}">
									<g:each in="${writeASingleReviewList}" var="list">
										<g:link controller="home" action="singleWriteAReviewPage"
											params="${[singleReviewId:list?.id]}">
											<li><g:hiddenField name="shareYourStoryId" />
												<div class="doctors-list-left client-img doctor-name-text">
													<%
					PatientMatchController patientMatchController=new PatientMatchController();
					def photoName = patientMatchController?.getPhotoNameForFindReview(list?.patient?.person?.id);
					 %>
					 					<div class="more-review-img">
													<g:if test="${photoName}">
														<img class="img-responsive"
															src="${resource(dir:'assets/patient-photo',file:photoName)}">
													</g:if>
													<g:else>
														<img class="img-responsive"
															src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
													</g:else>
													</div>
													${list?.patient?.person?.fullName}
												</div>
												<div class="doctors-list-right right-sidedoctorlist">
													<h5>
														<strong> ${list?.reviewTitle}
														</strong>
													</h5>
													<div class="content-description">
														<g:if test="${list?.yourReview.size()<=30}">
														${list?.yourReview}<br>
														</g:if>
														<g:elseif test="${list?.yourReview.size()>=30}">
														${list?.yourReview.substring(0, 30)}<br>
														${list?.yourReview.substring(41, 70)}<br>
														${list?.yourReview.substring(71, 100)+"..."}</g:elseif>
													</div>
													<i class="calender-img"></i><span class="orange-text"><g:formatDate
															date="${list?.rowCreated}" type="date"
															format="dd/MM/yyyy" style="short" /></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
															<%
															def commentSize= WriteAReviewComments?.findAllByWriteReviewFk(list)?.size()
															
															 %>
													<i class="chat-icon"></i><span class="orange-text">${commentSize}
														comments</span>
												</div></li>
										</g:link>
									</g:each>
								</g:if>
							</ul>
							
							<g:if test="${total > 4  && total > offset && max < total}">
							<g:remoteLink controller="home" action="readMoreSinglewriteAReview" class="read-view-text pull-right" id="1" update="more" total="${total}" max="${max}" params="['size':total,'maxSize':max]" 
    					>Read more Views<i
								class="view-more-icon1"></i></g:remoteLink>
							
							</g:if>