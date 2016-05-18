<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : careMenu
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<div class="light-gray-bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="header-navbar">
					<ul>
						<li id="dashId" class="${dashActive?:''}"><g:link  controller="dashboard" action="view" class="care_links">Dashboard</g:link></li>
						<li id="profId" class="${profileActive?:''}"><g:link  controller="profile" action="editProfile" class="care_links">Profile</g:link></li>
						<li id="patientMatId" class="${matchActive?:''}"><g:link controller="patientMatch" action="patientMatch" class="care_links">Matches</g:link></li>
						<li id="connectId" class="${connectActive?:''}"><g:link controller="connection" action="list" class="care_links">Connections</g:link></li>
						<li id="referId" class="${referActive?:''}"><g:link controller="Referrals" action="request" class="care_links">Recommendations</g:link></li>
						<li id="messagesId" class="${messagesId?:''}"><g:link controller="dashboard" action="viewMessage" params="[menuMessages:true]" class="care_links">Messages</g:link></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
