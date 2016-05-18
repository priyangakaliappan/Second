
<div id="providedDiv" class="received-box">

			<div class="clearfix mar-bot-20"></div>
		
		
		
		<div class="col-md-12">
				<table class="received-table">
					<thead>
						<tr>
							<util:remoteSortableColumn property="patientByPatientFkSender.person.firstName" title="Sent To" controller="referrals" action="ajaxPaginateProvided"  
														update="providedDiv" params="[offset:offset, max: max ,size:total]"/>
							<th width="40%">Message</th>
							<util:remoteSortableColumn property="rowCreated" title="Date-Time" controller="referrals" action="ajaxPaginateProvided"  
														update="providedDiv" params="[offset:offset, max: max ,size:total]" class="pad-lt-0"/>
							<th width="16%">Action</th>
						</tr>
					</thead>
					<tbody>
					<g:if test="${provided}">
					<g:each in="${provided}" status="i" var="re">
						<tr class="odd">
							<td>${re?.patientByPatientFkReceiver?.person?.firstName}</td>
							<td><g:recommendMsg val="${re?.message}"/></td>
							<td><g:formatDate date="${re?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
							<td>
								<a data-toggle="modal" href="#myModal" onClick="${remoteFunction(controller:'referrals',action:'viewMessage',
					 			 update:[success:'messageId',failure:'ohno'],
				 	  				params:['referralId':re.id])}" class="view-btn">View</a>  
							</td>
						</tr>
						</g:each>
						</g:if><g:else>
							<tr><td colspan="4">No recommendations found</td></tr>
						</g:else>
						
					</tbody>
				</table>
			</div>
		
		
	<div class="clearfix"></div>
	<div class="col-sm-6 col-xs-12">
		<div class="pagination">
			<g:if test="${total}">
			<util:remotePaginate total="${total}" update="providedDiv"
				controller="referrals" action="ajaxPaginateProvided" max="${max}"
				params="['size':total]"
				/> <!-- pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" -->
			</g:if>
		</div>
	</div>
	<div class="clearfix"></div>
	
	
	
</div>