<%@page import="com.healpal.care.Referrals" %>
<%@ page import="com.healpal.care.ReferralCategory" %>

<div id="receivedDiv" class="received-box">
	<g:if test="${params.referralCategory}"><h2>${params.referralCategory}</h2></g:if>
	
			<div class="clearfix mar-bot-20"></div>
			<div class="col-md-12">
				<table class="received-table">
					<thead>
						<tr>
							<util:remoteSortableColumn property="patientByPatientFkSender.person.firstName" title="Request From" controller="referrals" action="ajaxPaginateReceived"  
														update="receivedDiv" params="[offset:offset, max: max ,size:total]" class="table-head-text" />
							<th width="40%">Message</th>
							<util:remoteSortableColumn property="rowCreated" title="Date-Time" controller="referrals" action="ajaxPaginateReceived"  
														update="receivedDiv" params="[offset:offset, max: max ,size:total]" class="table-head-text" />
							<th width="16%">Action</th>
						</tr>
					</thead>
					<tbody>
					<g:if test="${received}">
					<g:each in="${received}" status="i" var="re">
						<tr class="odd">
							<td>${re?.patientByPatientFkSender?.person?.firstName}</td>
							<td><g:recommendMsg val="${re?.message}"/> </td>
							<td><g:formatDate date="${re?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
							<td>
								 <a data-toggle="modal" href="#myModal" onClick="${remoteFunction(controller:'referrals',action:'viewMessage',
								  update:[success:'messageId',failure:'ohno'],
							 	  params:['referralId':re.id])}" class="view-btn">View</a>
				 	  
							 	  <g:if test="${re?.referralType?.toString()?.equalsIgnoreCase(Referrals.request)}">
									<g:link controller="referrals" action="provide" params="[patientId:re?.patientByPatientFkSender?.id]" class="view-btn">Provide</g:link>
								  </g:if> 	  
							</td>
						</tr>
						</g:each>
						</g:if><g:else>
							<tr><td colspan="4">No recommendations found</td></tr>
						</g:else>
						
					</tbody>
				</table>
			</div>
			
	<div class="col-sm-6 col-xs-12">
		<div class="pagination">
			<g:if test="${total}">
			<util:remotePaginate total="${total}" update="receivedDiv"
				controller="referrals" action="ajaxPaginateReceived" max="${max}"
				params="['size':total]"
				 /> <!--pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" -->
			</g:if>
		</div>
	</div>
	<div class="clearfix"></div>
</div>