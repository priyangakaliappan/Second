<%@page import="com.healpal.care.PatientMatchController"%>
<%@page import="com.healpal.home.HomeController"%>
	<script type="text/javascript"
		src="${resource(dir:'js',file:'reviewRate.js')}"></script>
<div id="reviewList">
<g:if test="${reviewList}">
<div><h1><b>Review List</b></h1></div>
<div class="clearfix"></div>
<div class="clearfix"></div>
		<g:each in="${reviewList}" var="review" status="i">
			<%
              PatientMatchController patientMatchController = new PatientMatchController();
			  HomeController homeController= new HomeController();
			  def photoName = patientMatchController.getPhotoNameForFindReview(review?.patient?.person?.id);
			  def patientAddress = homeController.getPersonAddress(review?.patient?.id);
            %>
			<li>
				<div class="col-sm-9 pad-lr-0">
					<div class="col-sm-3">
					<div class="new-box-image">
							<g:if test="${photoName}">
								<img class="img-responsive"
									src="${resource(dir:'assets/patient-photo',file:photoName)}">
							</g:if>
							<g:else>
								<img class="img-responsive"
									src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
							</g:else>
							<div class="clearfix"></div>
							<div>
							${review?.patient?.person?.fullName}
							</div>
							<div>
							${patientAddress.address?.city} , ${patientAddress.address?.state}
							</div>
						</div>
					</div>
					<div  style="padding: 1px 248px;">
								<ul>
									<li>
										<div class="star-icon pull-left">
											<a id="rateId${i}"></a>
											<g:hiddenField name="rateId${i}" id="rateId${i}" value="1" />
									<%--<a class="orange-star-l" href="JavaScript:void(0)"></a>
										<a class="orange-star-l" href="JavaScript:void(0)"></a>
										<a class="orange-star-l" href="JavaScript:void(0)"></a> 
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
										<a class="gray-star-l" href="JavaScript:void(0)"></a>
									--%>
										</div> <a class="pull-left" href="JavaScript:void(0)">${review?.reviewDate}</a>
									</li>
									</ul>
					</div>
					<div style="padding: 1px 248px;">
						<h3><b>
						${review?.reviewTitle}</b>
						</h3>
					</div>
					<div style="padding: 1px 248px;">
					    ${review?.yourReview}
					</div>
				</div>
				
				<div class="clearfix"></div>
			</li>
		</g:each>
	</g:if><g:else>
	<div></div>
	
	</g:else>
	</div>
	<script type="text/javascript">


	<%
	if(reviewList!=null && !reviewList.equals("")){
	for(int i = 0; i < reviewList.size();i++){
		def review = reviewList.get(i);
		String rat = review.rating;
		String[] splitRating = rat.split(",");
		String overAllRating = splitRating[splitRating.length-1];
	%>
	
	$("#rateId${i}").jRate({
		rating : ${overAllRating},
		strokeColor : '#ff4500',
		precision : 1,
		minSelected : 1,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId${i}").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	
	<%  }
	}
	%>
	
		
	</script>