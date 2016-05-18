<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : getGroupMessages
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="care">
<title>::.. Healpal | All Group Messages ..::</title>
</head>
<body>
	<g:render template="../template/careMenu"></g:render>
	<section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-xs-12">
					<div class="box-content6">
						<div class="col-sm-3 col-xs-12 dashboard-sidebar-left">
							<div class="dark-graybox">
								<div class="new-box-image">
									<g:if test="${photoView}">
										<img class="img-responsive"
											src="${resource(dir:'assets/patient-photo',file:photoView)}">
									</g:if>
									<g:else>
										<img class="img-responsive"
											src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
									</g:else>
								</div>
								<g:link controller="profile" action="viewProfile"
									class="view-btn">View Profile</g:link>
								<g:link controller="profile" action="editProfile"
									class="edit-btn">Edit Profile</g:link>
							</div>
						</div>
						<div class="col-sm-9 col-xs-12 dashboard-sidebar-right"
							id="messages">
							<g:render template="allGroupMessageList"></g:render>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/bootstrap/js',file:'bootstrap.min.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery.colorbox.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'custom.js')}"></script>
		<script type="text/javascript">
	$(document).ready(function(){
$(".header-search-box").hide();
		});
	</script>
</body>
</html>