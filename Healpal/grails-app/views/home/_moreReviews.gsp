<%@page import="com.healpal.care.PatientMatchController"%>
<%@page import="com.healpal.care.WriteAReviewComments"%>
		<ul>
							
								<g:if test="${reviewList}">
									<g:each in="${reviewList}" var="reviews">
										 <g:link controller="home" action="singleWriteAReviewPage" params="${[singleReviewId:reviews.id]}">
											<li><g:hiddenField name="shareYourStoryId" />
												<div class="doctors-list-left client-img">
												<%
												PatientMatchController patientMatchController=new PatientMatchController();
												def photoName = patientMatchController?.getPhotoNameForFindReview(reviews?.patient?.id);
												def commentSize= WriteAReviewComments?.findAllByWriteReviewFk(reviews)?.size()
												 %>
					 <g:if test="${photoName}">
													<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photoName)}">
													 </g:if>
													 <g:else>
													  <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
													 </g:else>
													${reviews?.patient?.person?.fullName}
												</div>
												<div class="doctors-list-right right-sidedoctorlist">
												<h5>
														<strong> ${reviews?.reviewTitle}
														</strong>
													</h5>
													<div class="content-description">
														<g:if test="${reviews?.yourReview.length() > 100 }">${reviews?.yourReview.substring(0,100)} ... <%--<b>... </b> <a href="JavaScript:void(0)" class="orange-text"
														>read more</a>--%></g:if><g:else>${reviews?.yourReview}</g:else>
													</div>
													<i class="calender-img"></i><span class="orange-text"><g:formatDate
															date="${reviews?.rowAltered}" type="date"  format="dd/MM/yyyy" style="short"/></span>&nbsp;&nbsp; <i
														class="chat-icon"></i><span class="orange-text">${commentSize}
														comments</span>
												</div></li>
										</g:link>
									</g:each>
								</g:if>
								
							</ul>
							<g:if test="${total > 4  && total > offset && max < total}">
							<g:remoteLink controller="home" action="readMore" class="read-view-text pull-right" id="1" update="more" total="${total}" max="${max}" params="['size':total,'maxSize':max]" 
    					>Read more Views<i
								class="view-more-icon1"></i></g:remoteLink>
								</g:if>
	
