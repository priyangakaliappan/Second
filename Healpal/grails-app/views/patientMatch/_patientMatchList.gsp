<%--/**
 * Author    : Thirumal R
 * Project   : HealPal
 * Date      : 11/02/2015
 * FileName  : PatientMatchList
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Thirumal R     1.0       11/02/2015      Initial Creation
 *
 *
 **/
--%>

<%@page import="com.healpal.care.PatientMatchController"%>
<div id="patientmatchList">
<link href="${resource(dir:'assets/progress/css',file:'jquery-ui.css')}" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${resource(dir:'assets/progress/js',file:'jquery.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'assets/progress/js',file:'jquery-ui.min.js')}"></script>
    <g:hiddenField name="searchValueTotal" value = "${patientMatchMapTotal}"/>
    <g:render template="/dashboard/profileCompletionStatusBar"></g:render>
<g:if test="${patientList}">
                          <div class="box-contant-text">
							<h2>You are connected to matched patients most similar to you.</h2>
						  </div>
				           <g:hiddenField name="patientId" id="patientId"/> 				           
				           <g:hiddenField name="patientListajax" id="patientListajax" value="${patientList}"/> 
				           <g:each in="${patientList}" var="patientMatch" status="i">
				               <%
                                  PatientMatchController patientMatchController = new PatientMatchController();
								  def status = patientMatchController.checkIsConnected(patientMatch?.patient?.id);
								  def photoName = patientMatchController.getPhotoName(patientMatch?.patient?.id);
                                %>
                                <g:if test="${status == null || status =='' || !status.equals('connected')}">
                                <table width="100%" border="0" cellpadding="5" class="right-profile-cont1">
									<tbody>
										<tr>
											<td width="70%">
												<div>${patientMatch?.patient?.person?.fullName}</div>
												<div><g:state patientId ="${patientMatch?.patient?.id}"/></div>
												<div class="clearfix mar-bot-10"></div>
												<div><g:breastcancer patientId ="${patientMatch?.patient?.id}"/></div>
												<div><g:cancerStage patientId ="${patientMatch?.patient?.id}"/>
												</div>
												<div class="clearfix mar-bot-10"></div>
												<div><g:patientmemberYear patientId ="${patientMatch?.patient?.id}"/></div>
												<%--<div>HealPal Goodwill Points: ${patientMatch?.patient?.person?.goodWillPoints }</div>
												--%><div class="clearfix mar-bot-20"></div>
									            <div id="progressbar${i}"></div><div class="pad-lt">${patientMatch?.percentage?.intValue()}% Match</div>
									       </td>
											<td>
												<div class="img-width">
												<g:if test="${photoName}">
												   <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photoName)}">
												</g:if><g:else>
												  <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
												</g:else>
													<g:if test="${status ==null || status ==''}">
													<a onclick="isConnected(${patientMatch?.patient?.id},'${toAge}','${fromAge}','${zipcode}','${selectedCancerStage}','${selectedCancerStatusList}','${patientMatchSearch}');"  class="filter-btn1">&nbsp;&nbsp;&nbsp;&nbsp;<span style="cursor:pointer"><span id="spinId">Connect</span><div class="right_div" >
			<img class="img-responsive" src="../assets/new-design/img/spinner.gif" style="display:none;" id="spinIdRotate">
			</div></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
													</g:if><g:else>
										             <a class="filter-btn2">&nbsp;&nbsp;&nbsp;&nbsp;Invite Sent&nbsp;&nbsp;&nbsp;&nbsp;</a>
										             </g:else>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
								</g:if>
								</g:each>
								<div class="right-contant-btm text-center">
								  <g:if test="${patientMatchMapTotal >= 10 && patientMatchMapTotal > offset}">
									<a onclick="getNextRecords('${patientMatchMapTotal}','${toAge}','${fromAge}','${zipcode}','${selectedCancerStage}','${selectedCancerStatusList}','${patientMatchSearch}','${offset}')"><span style="cursor:pointer">View more connections</span> <i class="fa fa-angle-double-down"></i> </a>
		                           </g:if>
								</div>
								<%--<div class="pagination">
									 <util:remotePaginate total="${patientMatchMapTotal}" update="patientmatchList" params="['size':patientMatchMapTotal,'toAge':toAge,'fromAge':fromAge,'zipcode':zipcode,'selectedCancerStage':selectedCancerStage,'patientMatchSearch':patientMatchSearch]" controller="patientMatch" action="ajaxPaginatePatientMatch"/>
							   </div>
						--%></g:if><g:else>
						
						
						
						
						  <div class="box-contant-text">
							<h2>Do not have matched patients most similar to you.</h2>
						  </div>
						</g:else>
	<script type="text/javascript">		
					
	<%
	if(patientList!=null && !patientList.equals("")){
	for(int i = 0; i < patientList.size();i++){
		def patientMatch = patientList.get(i);
	
	%>
	$( "#progressbar${i}" ).progressbar({
		value: ${patientMatch?.percentage}
	  });
	
	<%  }
	}
	%>
</script>

<script>
		
		if (typeof jQuery !== 'undefined') {
		
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}


$(document).ready(
    function(){
        $("#spinId").click(function () {
           jQuery('#spinIdRotate').show();
        });
    });

		
		
		</script>

</div>