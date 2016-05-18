	<%@page import="com.healpal.care.PatientMatchController"%>
	<%@page import="com.healpal.home.HomeController"%>
	<%@page import="com.healpal.care.WriteAReviewComments"%>
	<g:if test="${reviewList}">
	<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 pad-lr-0">
					<div class="review-top-border"></div>
					<div class="review-rightside-bar">
					
						<ul>
						<g:each in="${reviewList}" var="review" status="i">
			<%
              PatientMatchController patientMatchController = new PatientMatchController();
			  HomeController homeController= new HomeController();
			  def photoName = patientMatchController.getPhotoNameForFindReview(review?.patient?.person?.id);
			  def patientAddress = homeController.getPersonAddress(review?.patient?.id);
			  def category = homeController.getReviewCategory(review?.patient?.id , review?.id)
			  def commentSize= WriteAReviewComments?.findAllByWriteReviewFk(review)?.size()												 
            %>
            <g:link controller="home" action="singleWriteAReviewPage" class="review_link" params="${[singleReviewId:review.id]}">
							<li>
								<div class="col-lg-2 col-md-2 pad-lr-0 img-w">
								<div class="find-review-img">
								<g:if test="${photoName}">
								<img class="responsive" src="${resource(dir:'assets/patient-photo',file:photoName)}" alt="image"/>
								</g:if>
								<g:else>
								<img class="responsive" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" alt="image"/>
								</g:else>
								</div> <div class="pat-name-text">${review?.patient?.person?.fullName}</div></div>
								<div class="col-lg-10 col-md-2 pad-rt-0 search-review-width">
									<h5>${review?.reviewTitle}</h5>								
									<div class="doc-name doc-name-icons"><span class="orange-text"><i class="calender-img"></i><g:if test="${review?.diagnosis?.diagnosisName}">${review?.diagnosis?.diagnosisName}    &nbsp; &nbsp;</g:if><i class="calender-img"></i><g:if test="${category}">${category}    &nbsp; &nbsp;<i class="calender-img"></i><g:formatDate date="${review?.reviewDate}" format="MM/dd/yyyy" style="Long"/> &nbsp;&nbsp; <i class="chat-icon"></i>
<span class="orange-text">${commentSize} comments </span> </g:if></span></div>		
									
								<div class="clearfix mar-bot-20"></div>
								<div class="col-lg-11 col-md-2 pad-lr-0">
								<g:hiddenField name="more_reviews" id="review${review?.id}" value="${review?.yourReview}"/>
									<p><span class="reviews ${review?.id}"><g:if test="${review?.yourReview.length() > 230}">${review?.yourReview.substring(0,230)} <b>...</b> <a href="JavaScript:void(0)" id="${review?.id}" class="orange-text read_more" onclick="check(this)">read more</a></g:if>       <g:else>${review?.yourReview}</g:else></span> </p>
								</div>
								<g:hiddenField name="size" id="size" value="${total}"/>
								<g:hiddenField name="max" id="max" value="${max}"/>
								<g:hiddenField name="offset" id="offset" value="${offset}"/>
								</div>
								<div class="clearfix mar-bot-20"></div>
								<%--<div class="col-lg-1 img-sml-w pad-lr-0">${review?.patient?.person?.fullName}</div>
								
							--%></li>
							</g:link>
							</g:each>
							<%--<div class="col-sm-3 text-center"><p class="page-text">Page 1 of ${total}</p></div>
							<div class="col-sm-9">
								<ul class="review-num-list">
									<li class="active">1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li>6</li>
									<li>7</li>
									<li>8</li>
									<li>9</li>
									<li>10</li>
									<li>Next</li>
									<i class="next-arrow-sml"></i>
								</ul>
							</div>							
							
							--%><%--Page 1 of ${total}
							--%><div class="col-sm-3 text-center"><p class="page-text">&nbsp;</p></div>
							<div class="col-sm-9 paginate">
							<g:if test="${total > 4}">
							<util:remotePaginate total="${total}" update="results" class="review-num-list" controller="home" action="ajaxPaginate" max="${max}" params="['size':total,'max':max,'offset':offset]"/>
							</g:if>
							
						</ul>
						
						
					</div>
				</div>
				</g:if>
						<g:else>
						<div class="text-center found-text col-md-8">
							No Records found..
						</div>
						</g:else>
				