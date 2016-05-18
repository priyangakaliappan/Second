<%@page import="com.healpal.care.ShareYourStoryComments"%>
<%@page import="com.healpal.care.ShareYourStory"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<ul>
								<g:if test="${shareYourStoryList}">
									<g:each in="${shareYourStoryList}" var="list">
										<g:link controller="home" action="singleStoryPage"
											params="${[singleStoryPageId:list?.id]}">
											<li><g:hiddenField name="shareYourStoryId" />
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
														<strong> ${list?.storyTitle}
														</strong>
													</h5>
													<div class="content-description">
													<g:if test="${list?.yourStory.size()<=30}">
														${list?.yourStory}<br>
														</g:if>
														<g:elseif test="${list?.yourStory.size()>=30}">
														${list?.yourStory.substring(0, 30)}<br>
														${list?.yourStory.substring(41, 70)}<br>
														${list?.yourStory.substring(71, 100)+"..."}</g:elseif>
													</div>
													<i class="calender-img"></i><span class="orange-text"><g:formatDate
															date="${list?.rowAltered}" type="date"
															 style="short" /></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
															<%
															def commentSize= ShareYourStoryComments?.findAllByShareYourStoryFk(list)?.size()
															
															 %>
													<i class="chat-icon"></i><span class="orange-text">${commentSize}
														comments</span>
												</div></li>
										</g:link>
									</g:each>
								</g:if>
							</ul>
							<g:if test="${total > 4  && total > offset && max < total}">
							<g:remoteLink controller="home" action="readMoreStories" class="read-view-text pull-right" id="1" update="more" total="${total}" max="${max}" params="['size':total,'maxSize':max]" 
    					>Read more Views<i
								class="view-more-icon1"></i></g:remoteLink>
								</g:if>