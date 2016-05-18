<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : getAllMessages
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<%@page import="com.healpal.encryptdecrypt.CryptographyUtil"%>
<div id="messageBody">
	<g:if test="${patientMessages}">
		<g:each in="${patientMessages}" status="i" var="message">
			<span class="patientName">
				${message.patientByPatientFkSender?.person?.firstName+'  '} <g:formatDate
					format="hh:mm a" date="${message?.rowCreated}" />
			</span>
			<div>
				<span>
					<g:if test="${message.messageText}">
						${CryptographyUtil.decrypt(message.messageText)}
					</g:if>
				</span>
			</div>

		</g:each>
	</g:if>
</div>