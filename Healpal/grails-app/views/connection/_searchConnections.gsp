<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : searchConnections
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               13-11-2015         Initial Creation
 *
 */-->
<%@page import="com.healpal.care.ConnectionController"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<%@page import="com.healpal.care.PatientAddress"%>
<ul id="searchConnections">
	<%--<div class="new-first-pad">
		<li><input type="checkbox" name="text" value="">Select
			All</li>
	</div>
	--%>
	<g:hiddenField name="connectionListSize" id="connectionListSize" value="${connectionList?.size()}"/>
	<g:if test="${connectionList}">
		<g:each in="${connectionList}" var="connection" status="i">
			<%
                                  PatientMatchController patientMatchController = new PatientMatchController();
								  def photoName = patientMatchController.getPhotoName(connection?.id);
								  ConnectionController connectionController = new ConnectionController();
								  def daysOrMonth = connectionController.getDaysOrMonth(connection?.id);
                                 %>
			<li>
				<div class="col-sm-9 pad-lr-0">
					<div class="col-sm-3">
						<%--<input type="checkbox" id="checkbox${i}" name="checkbox${i}"
							class="pull-left" value="${connection?.id}" onclick="addPatientId('checkbox${i}');"/>
						--%><div class="new-box-image">
							<g:if test="${photoName}">
								<img class="img-responsive"
									src="${resource(dir:'assets/patient-photo',file:photoName)}">
							</g:if>
							<g:else>
								<img class="img-responsive"
									src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
							</g:else>
						</div>
					</div>
					<div style="padding: 1px 248px;">
						<h3>
						${connection?.person?.fullName}
							<%--${connection?.person?.firstName}
							${connection?.person?.lastName}
						--%></h3>
						<p>
							${PatientAddress.findByPatient(connection)?.address?.city},
							${PatientAddress.findByPatient(connection)?.address?.state}
						</p>
					</div>
				</div>
				<div class="col-sm-3 pull-right text-right">
					<div class="new-right-cont">
						<div>
							<g:if test="${daysOrMonth}">
								${daysOrMonth}
							</g:if>
							<g:else>
								Today
							</g:else>
						</div>
						<i class="new-email"></i> <a data-toggle="modal" href="#myModal"
							onclick="setPatientValue(${connection?.id});">Message</a> <br />
						<%-- <i class="new-email"></i> <a href="#">Message</a> <br />--%>
						<br /> <i class="new-close-icon"></i>
						<g:link controller="connection" action="removeConnection"
							params="[patientId: connection?.id]"
							onclick="return removeConnection();">&nbsp;&nbsp;Remove connection</g:link>
					</div>
				</div>
				<div class="clearfix"></div>
			</li>
		</g:each>
		<div class="clearfix mar-bot-10"></div>
		<div class="clearfix mar-bot-10"></div>
	</g:if>
	<g:if test="${total}">
		<util:remotePaginate total="${total}" update="searchConnections"
			controller="connection" action="ajaxPaginateConnection" max="${max}"
			params="['size':total]"
			pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
	</g:if><g:else>
	 <div align="center">
			No connection found .
		 </div>
	</g:else>
</ul>