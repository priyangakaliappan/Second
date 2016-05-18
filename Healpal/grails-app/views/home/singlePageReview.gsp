

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
					<div class="col-lg-1 col-md-1"></div>
					<div class="col-md-11 col-sm-12">
						<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 single-review">
							<h3>
								${singlepageList?.reviewTitle}
							</h3>
							<div class="orange-text single-review">
								<ul>
									<li><i class="smal-img"></i> ${singlepageList?.patient?.person?.fullName}</li>
									<li><i class="calender-img"></i><g:formatDate date="${singlepageList?.reviewDate}" format="MM/dd/yyyy" style="Long"/> <%--${singlepageList?.rowCreated}<g:formatDate
											date="${singlepageList?.rowCreated}" format="dd/mm/yyyy" /></li>--%>
									<li><i class="chat-icon"></i><span id="cmd_size">${commentsTotal}</span> comments</li>
								</ul>
							</div>
							<p>
								${singlepageList?.yourReview}
							</p>
							<div class="share-social-text">
								share &nbsp; &nbsp; <a href="https://plus.google.com/share?url=https://www.healpal.me${request.forwardURI + '?' + request.queryString}"  onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><i class="gplus-icon"></i></a> 
                       
                       <a href="http://www.linkedin.com/shareArticle?mini=true&url=https://www.healpal.me${request.forwardURI + '?' + request.queryString}&title=Healpal LinkedIn
			              &summary=Healpal&source=Healpal Breast Cancer" onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><i
									class="linkedin-icon1"></i></a> 
									<a href="https://twitter.com/home?status=https://www.healpal.me${request.forwardURI + '?' + request.queryString}"  onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;">     <i class="tweet-icon"></i> </a>
									
									<a href="https://pinterest.com/pin/create/button/?url=https://www.healpal.me${request.forwardURI + '?' + request.queryString}"  onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"> <i class="pin-icon1"></i></a> 
                       
                       <a href="http://www.facebook.com/sharer.php?u=https://www.healpal.me${request.forwardURI + '?' + request.queryString}" onclick="javascript:window.open(this.href,
                       '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><i class="fb-icon1"></i></a>
							</div>
							<h5>
								<strong>Add a comment</strong>
							</h5>
							<textarea placeholder="Add a comment..." id="userComments"
								name="userComments"></textarea>
							<%--<a href="javascript:void(0)" class="comment-view-text">View more comments<i
								class="view-more-icon"></i></a>
								
								--%><div class="col-md-12 col-sm-12 col-xs-12 pad-lt-0">
								<div class="single-story-content" id="comments">
						
								<g:render template="comments"></g:render>
								
						</div>
					</div>
						</div>
						<div
							class="col-md-4 col-sm-4 find-doctors-sidebar single-right-bar">
							
							<h3>More reviews about Treatment</h3>
							<div id="more">
						<g:render template="moreReviews"></g:render>
								
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#userComments").keypress(function(e) {
				if (e.which == 13) {
					var comments = $(this).val();
					var commentPatient =
				${params.singleReviewId}
					//var commentPatient = 
		//alert($("#userComments").val());
					//submit form via ajax, this is not JS but server side scripting so not showing here
					// $("#userComments").append($(this).val() + "<br/>");
					$.ajax({
						async : false,
						type : "POST",
						url : "../home/comments",
						data : {
							comments : comments,
							commentPatient : commentPatient,
							comment_size:${commentsTotal},
											comment_maxSize:${commentsMax},
												commentPatient:${reviewId}
							
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