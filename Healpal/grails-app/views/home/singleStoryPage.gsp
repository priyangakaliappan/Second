
<%@page import="com.healpal.home.HomeController"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.healpal.care.ShareYourStory"%>
<%@page import="com.healpal.care.ShareYourStoryComments"%>
<%@page import="com.healpal.care.Patient"%>
<%@page import="com.healpal.care.PatientMatchController"%>
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
								${singlepageList?.storyTitle}
							</h3>
							<div class="orange-text single-review">
								<ul>
									<li><i class="smal-img"></i> ${singlepageList?.patientFk?.person?.fullName}</li>
									<li><i class="calender-img"></i> <g:formatDate
											date="${singlepageList?.rowCreated}" style="short" type="date" /></li>
									<li><i class="chat-icon"></i><span id="cmd_size">
											${commentsTotal}
									</span> comments</li>
								</ul>
							</div>
							
							<%
					HomeController homeController=new HomeController();
					def photoName = homeController?.getPhotoNameForSingleStoryPage(singleStoryPageId);
					 %>
							<%--<img src="../assets/new-design/img/single-banner-image.jpg"
								alt="image" class="img-banner"/>
							--%>
							<g:if test="${photoName}">
														<img class="img-responsive"
															src="${resource(dir:'assets/reviewsPhotos',file:photoName)}">
													</g:if>
													<g:else>
														<img class="img-responsive"
															src="${resource(dir:'assets/reviewsPhotos',file:'noimage.jpg')}">
													</g:else>
							<p>
								${singlepageList?.yourStory}
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
								</a> <a href="javascript:void(0)"
									data-pin-do="buttonPin" data-pin-custom="true" class="pin_ico"> <i class="pin-icon1"></i></a>
                       				 <a href="JavaScript:void(0)" title="Healpal" onclick="fb_share(this)">
									<i class="fb-icon1"></i> </a>
							</div>

							<h5>
								<strong>Add a comment</strong>
							</h5>
								<g:if test="${session.user}">
							<textarea placeholder="Add a comment..." id="userComments"
								name="userComments"></textarea>
								</g:if>
								<g:else>
								<textarea placeholder="Add a comment..." id="showPopUp" class="signin-text check-layout"
								name="userComments"></textarea>
</g:else>
							<%--<a href="#" class="comment-view-text">View more comments<i
								class="view-more-icon"></i></a>

							--%>
							<div class="col-md-12 col-sm-12 col-xs-12 pad-lt-0">
								<div class="single-story-content" id="comments">
									<%--<ul>
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
								--%>


									<g:render template="commentsForStory"></g:render>
								</div>
							</div>



						</div>


						<div
							class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar right-side-content">

							<h3 class="right-sidebar-content">Related Stories</h3>

							<div class="h3-border-line"></div>

							<div id="more">
								<g:render template="moreStories"></g:render>



							</div>
						</div>
					</div>
				</div>
		</section>
	</div>
	<script type="text/javascript"
		src="../assets/new-design/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$("#showPopUp").click(function(){
		$("#signin").modal('show');
		});
	</script>

	<%--comments after enter inside Text Area--%>
	<script type="text/javascript">
		$(function() {
			$("#userComments").keypress(function(e) {
				if (e.which == 13) {
					var comments = $(this).val();
					var commentPatient =
	${params.singleStoryPageId}
		//alert($("#userComments").val());
					//submit form via ajax, this is not JS but server side scripting so not showing here
					// $("#userComments").append($(this).val() + "<br/>");
					$.ajax({
						async : false,
						type : "POST",
						url : "../home/commentsForStory",
						data : {
							comments : comments,
							commentPatient : commentPatient,
							comment_size:${commentsTotal},
							comment_maxSize:${commentsMax},
								commentPatient:${storyId}
						},
						success : function(res) {
							$("#comments").html(res)
							$("#userComments").val('');
							$("#cmd_size").html($("#hidden_size").val());
						}

					});
					e.preventDefault();
				}
			});
		});
	</script>
</body>
</html>