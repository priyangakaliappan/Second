<%@page import="com.healpal.care.DashboardController"%>
<link href="${resource(dir:'assets/progress/css',file:'jquery-ui.css')}" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${resource(dir:'assets/progress/js',file:'jquery.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'assets/progress/js',file:'jquery-ui.min.js')}"></script>
    <%
	DashboardController profile=new DashboardController();
	def profileCompletion=profile?.view()?.profileCompletion
	 %>
    
					<div id="profileCompletionShow">
						<g:if test="${profileCompletion?.goToProfilePage=='ca13' && profileCompletion?.profileUpdated==0 }">
						<div id="progressbar"  class="pull-left"><b style="padding-left: 11px; font-size:x-small;    padding: 5px 34px 3px; padding-top: 2px; position: absolute; text-decoration: none;">20%</b></div>
						<g:link controller="Profile" action="d1" class="complete-btn pull-right" hidden="true">Proceed to complete your profile</g:link><br><br>
						Your profile is 20% complete
						</g:if>
						
						<g:elseif test="${profileCompletion?.goToProfilePage=='f5' && profileCompletion?.profileUpdated==0 }">
						<div id="progressbar"  class="pull-left"><b style="padding-left: 70px; font-size:x-small; padding-top: 2px; position: absolute; text-decoration: none;">50%</b></div>
						<g:link controller="Profile" action="g1" class="complete-btn pull-right" hidden="true">Proceed to complete your profile</g:link><br><br>
						Your profile is 50% complete
						</g:elseif>
						
						<g:elseif test="${profileCompletion?.goToProfilePage=='h3' && profileCompletion?.profileUpdated==0 }">
						<div id="progressbar"  class="pull-left"><b style="padding-left: 110px; font-size:x-small; padding-top: 2px; position: absolute; text-decoration: none;">70%</b></div>
						<g:link controller="Profile" action="l1" class="complete-btn pull-right" hidden="true">Proceed to complete your profile</g:link><br><br>
						Your profile is 70% complete
						</g:elseif>
						
						<g:elseif test="${profileCompletion?.goToProfilePage=='j3' && profileCompletion?.profileUpdated==0 }">
						<div id="progressbar"  class="pull-left"><b style="padding-left: 130px; font-size:x-small; padding-top: 2px; position: absolute; text-decoration: none;">80%</b></div>
						<g:link controller="Profile" action="k1" class="complete-btn pull-right" hidden="true">Proceed to complete your profile</g:link><br><br>
						Your profile is 80% complete
						</g:elseif>
						
						<g:elseif test="${profileCompletion?.goToProfilePage=='l3' && profileCompletion?.profileUpdated==0 }">
						<%--<div id="progressbar"  class="pull-left"><b style="padding-left: 82px; font-size:x-small; padding-top: 3px; position: absolute;">100%</b></div>
						<g:link controller="Profile" action="m1" class="complete-btn pull-right" hidden="true">Proceed to complete your profile</g:link><br><br>
						Your profile is 100% complete
						--%></g:elseif>
						
						
						<g:elseif test="${profileCompletion?.goToProfilePage=='m1'  && profileCompletion?.goToProfilePage=='m2' && profileCompletion?.profileUpdated==1 }">
						
						</g:elseif>
					
						
						</div>
						<script>

						if('${profileCompletion?.goToProfilePage}'=="ca13")
						{
						$("#progressbar").progressbar({
							value: ${profileCompletion?.percentage}
						  });
						}

						else if('${profileCompletion?.goToProfilePage}'=="f5")
						{
						$("#progressbar").progressbar({
							value: ${profileCompletion?.percentage}
						  });
						}

						else if('${profileCompletion?.goToProfilePage}'=="h3")
						{
						$("#progressbar").progressbar({
							value: ${profileCompletion?.percentage}
						  });
						}

						else if('${profileCompletion?.goToProfilePage}'=="j3")
						{
						$("#progressbar").progressbar({
							value: ${profileCompletion?.percentage}
						  });
						}

						else if('${profileCompletion?.goToProfilePage}'=="l3")
						{
						$("#progressbar").progressbar({
							value: ${profileCompletion?.percentage}
						  });
						}


						</script>
						
