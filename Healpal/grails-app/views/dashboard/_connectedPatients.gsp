<%@page import="com.healpal.care.DashboardController"%>
<%DashboardController getMessage=new DashboardController(); %>
<ul class="nav nav-tabs tabs-left" id="searchConnections">
	<g:if test="${mess}">
		<g:each in="${mess}" var="messageLists" status="i">
			<% def profilePhotoss=getMessage?.getPersonsProfileImage(messageLists?.getKey()?.person?.id)%>
			<li class="viewMessage active-ans" id="${messageLists?.getKey()?.id}">
				<a href="#" onclick="patientMessage(this,'')"
				id="${messageLists?.getKey()?.id}">
					<div class="col-xs-3 pad-lt-0 pad-rt-10">
						<g:if test="${profilePhotoss}">
							<img 
								src="${resource(dir:'assets/patient-photo',file:profilePhotoss)}"
								width="50" height="50" />
						</g:if>
						<g:else>
							<img width="50"
								src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}"
								width="50" height="50">
						</g:else>
					</div>
					<div class="col-xs-7 pad-lt-0">
						<h4>
							${messageLists?.getKey()?.person?.fullName}
						</h4>
						<p style="font-size: 13.5px;height:21px;overflow: hidden;">
							<g:patientLastMessages currentUser="${session.user}"
								receiverId="${messageLists?.getKey()?.id}" />
						</p>
					</div>
					<div class="col-xs-2 pad-lr-0 tab-date-last">
						<g:patientLastMessageDate currentUser="${session.user}"
							receiverId="${messageLists?.getKey()?.id}" />
					</div>
			</a>
			</li>
		</g:each>
	</g:if>
	<g:if test="${groupLists}">
		<g:each in="${groupLists}" var="messageLists1" status="i">
			<%def groupPhoto=getMessage?.getGroupImage(messageLists1?.id)%>
			<li class="viewGroup-message active-ans" id="${messageLists1?.id}">
				<a href="#" onclick="patientMessage(this,'group')"
				id="${messageLists1?.id}">
					<div class="col-xs-3 pad-lt-0 pad-rt-10">
						<g:if test="${groupPhoto}">
							<img 
								src="${resource(dir:'assets/group-photo',file:groupPhoto)}"
								width="50" height="50" />
						</g:if>
						<g:else>
							<img width="50"
								src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}"
								width="50" height="50">
						</g:else>
					</div>
					<div class="col-xs-7 pad-lt-0">
						<h4>
							${messageLists1?.messageGroupName}
						</h4>
						<p style="font-size: 13.5px;height:21px;overflow: hidden;">
							<g:groupMessages currentUser="${session.user}"
								groupId="${messageLists1?.id}" />
						</p>
					</div>
					<div class="col-xs-2 pad-lr-0 tab-date-last">
						<g:groupMessagesDate currentUser="${session.user}"
							groupId="${messageLists1?.id}" />
					</div>
			</a>
			</li>
		</g:each>
	</g:if>
</ul>
<script type="text/javascript">
	/* Active patient when click on patient to chat*/
	if ($("#viewGroupMessageId").hasClass('active')) {
		$("#viewMessageId").removeClass('active');
		$("#viewGroupMessageId").addClass('active');
		$(".viewMessage").hide();
		$(".viewGroup-message").show();
		$(".active-ans").removeClass("active");
		if(!msgCountInc){
			$(".viewGroup-message:first").addClass("active");
		}else{
			$("#"+sessionStorage.getItem("groupId")).addClass("active");
		}
		
	}
	if ($("#viewMessageId").hasClass('active')) {
		$("#viewGroupMessageId").removeClass('active');
		$("#viewMessageId").addClass('active')
		$(".viewGroup-message").hide();
		$(".viewMessage").show();
		$(".active-ans").removeClass("active");
		if(!msgCountInc){
			$(".viewMessage:first").addClass("active");
		}else{
			$("#"+sessionStorage.getItem("receiverId")).addClass("active");
			
			}
		
	}
</script>