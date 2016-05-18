<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : getNewConnections
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
<title>::.. Healpal | New Connections ..::</title>
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
							<div class="dark-graybox1">
        <img
         src="${resource(dir:'assets/images',file:'Dashboard-image1.jpg')}"
         class="img-responsive" />
        <div class="text-center">
         <h2>Spread the Mission</h2>
         <g:link controller="patientMatch" action="patientMatch" class="view-profile-btn">Invite Friends</g:link>
        </div>
       </div>
							
						</div>
						<div class="col-sm-9 col-xs-12 dashboard-sidebar-right"
							id="messages">
							<table width="100%" border="0" cellpadding="5"
								class="right-profile-cont">
								<g:if test="${connectionList || acceptList} ">
									<thead>
										<tr>
											<th width="30%">Patient Name</th>
											<th width="30%">Requested Date</th>
											<th width="40%">Actions</th>
										</tr>
									</thead>
									<tbody>
									<g:if test="${connectionList}">
										<g:each in="${connectionList}" status="i" var="connection">
											<tr>
												<td>
													${connection?.patientByPatientFk1?.person?.fullName}
												</td>
												<td><g:formatDate format="yyyy-MM-dd HH:mm"
														date="${connection?.rowCreated}" /></td>
												<td><g:link controller="dashboard"
														action="permitConnection"
														params="[connectionId: connection?.id, state: 'approve']"
														onclick="return approveConnection();">Approve</g:link> <g:link
														controller="dashboard" action="permitConnection"
														params="[connectionId: connection?.id, state: 'ignore']"
														onclick="return ignoreConnection();">Ignore</g:link></td>
											</tr>
										</g:each>
										</g:if>
										<g:elseif test="${acceptList}">
										<g:each in="${acceptList}" status="i" var="accept">
											<tr>
												<td>
													${accept?.patientByPatientFk2?.person?.fullName}
												</td>
												<td><g:formatDate format="yyyy-MM-dd HH:mm"
														date="${accept?.rowCreated}" /></td>
												<td><g:link controller="dashboard"
														action="permitConnection"
														params="[connectionId: accept?.id, state: 'ok']"
														>Connected</g:link> </td>
											</tr>
										</g:each>
										</g:elseif>
									</tbody>
								</g:if>
								<g:else>
									No New Connections
								</g:else>
							</table>
							<g:link controller="dashboard" action="view">Back</g:link>
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
		function ignoreConnection() {
			if (confirm("Are you sure want to ignore connection?")) {
				return true;
			} else {
				return false;
			}
		}

		function approveConnection() {
			if (confirm("Please let us know if we could Approve your New Connection?")) {
				return true;
			} else {
				return false;
			}
		}
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
$(".header-search-box").hide();
		});
	</script>
</body>
</html>