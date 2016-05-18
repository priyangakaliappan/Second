<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : groupMessages
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->

<div id="messageBody" style="width: 550px; height: 250px;">
	<g:if test="${messageList}">
		<g:each in="${messageList}" status="i" var="message">
			<div>
				<g:if
					test="${message?.patientByPatientFkSender?.person?.firstName == person?.firstName}">
					<span
						style="background-color: #cfedfb; line-height: 17px; float: right; padding: 5px 10px; white-space: pre-line; font-size: 13px; font-style: normal; max-width: 40%; display: inline-block; color: #333;">
						${message?.messageText} <br> <g:formatDate format="hh:mm a"
							date="${message?.rowCreated}" />
					</span>
				</g:if>
				<g:else>
					<span
						style="background-color: #F0FFFF; line-height: 17px; float: left; padding: 5px 10px; white-space: pre-line; font-size: 13px; font-style: normal; max-width: 40%; display: inline-block; color: #333;">
						${message?.patientByPatientFkSender?.person?.firstName+'  '}:${message?.messageText}
						<br> <g:formatDate format="hh:mm a"
							date="${message?.rowCreated}" />
					</span>
				</g:else>
				<br>
			</div>
		</g:each>
	</g:if>
</div>