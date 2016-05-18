<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : replyMessages
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->

<%@page import="com.healpal.encryptdecrypt.CryptographyUtil"%>

<div id="messageBody">
	<g:form name="message" controller="Message">
		<g:if test="${patientTo}">
			<g:hiddenField name="to" value="${patientTo}"/>
		</g:if>
		<g:if test="${msgGroupId}">
			<g:hiddenField name="groupId" value="${msgGroupId}"/>
		</g:if>
		<g:if test="${patientMessages}">
			<g:each in="${patientMessages}" status="i" var="message">
				<div>
					<span class="patientName">
						${message.patientByPatientFkSender?.person?.firstName+'  '} <g:formatDate
							format="hh:mm a" date="${message?.rowCreated}" />
					</span>
					<div>
						<span align="center">
							${CryptographyUtil.decrypt(message.messageText)}
						</span>
					</div>
				</div>
			</g:each>			
		</g:if>
		<g:textArea name="message"></g:textArea>
		<g:actionSubmit value="Send" action="replyMessage"/>
	</g:form>
</div>