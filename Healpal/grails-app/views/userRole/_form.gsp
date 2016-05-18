<%@ page contentType="text/html;charset=UTF-8" %>


	<g:form controller="userRole" action="${action}" method="post" class="form-horizontal">
	<div class="control-group">
		<g:if test="${action == 'edit'}">
			<label class="control-label"><b>Status:</b></label>
			<div class="controls">
				    <g:select name="healpalUser" from="${usersList}" optionValue="userName" disabled="true" required="" optionKey="id" noSelection="['': 'Select']" value="${userrole?.healpalUser?.id}"/>
					<g:if test="${userrole?.role?.authority=='Patient'}">
							<g:select name="role" from="${roleList}"  optionValue="authority" optionKey="id" required="" noSelection="['': 'Select']" value="${userrole?.role?.id}"/>
					</g:if><g:else>
							<g:select name="role" from="${roleList}" optionValue="authority" optionKey="id" required="" noSelection="['': 'Select']" value="${userrole?.role?.id}"/>
					</g:else>
					</div>
		</g:if>
		<g:else>
		<div class="control-group">
		<label class="control-label"><b>User:</b></label>
		<div class="controls">
					<g:select name="healpalUser" from="${usersList}" optionValue="userName"  required="" optionKey="id" noSelection="['': 'Select']" value="${userrole?.healpalUser?.id}"/>
				</div>
				</div>
				<div class="clearfix">&nbsp;&nbsp;</div>
		<div class="control-group">
		<label class="control-label"><b>Role:</b></label>
		<div class="controls">
					<g:select name="role" from="${roleList}" optionValue="authority" optionKey="id" required="" noSelection="['': 'Select']" value="${userrole?.role?.id}"/>
				</div>
				</div>
				</g:else>
		
		</div>
		
		
		
		<div class="control-group">
		<g:if test="${action == 'edit'}">
			<label class="control-label"><b>Status:</b></label>
			<div class="controls">
				    <g:if test="${userrole?.isActive==1}">
						<g:set var="ch" value="checked"></g:set>
					</g:if><g:else>
						<g:set var="ch1" value="checked"></g:set>
					</g:else>
					
					Active<input type="radio" name="isActive" ${ch} value="1"/>
				    InActive<input type="radio" name="isActive" ${ch1} value="0"/>
					
					</div>
		    </g:if>
		</div>
		<div class="control-group">
		<div class="controls">
			 <g:hiddenField name="hiddenId" value="${params.id}"/>
				<g:link controller="userRole" action="view" class="btn btn-info">Cancel</g:link>
				<g:submitButton name="save" value="Save" class="btn btn-info"/>
		</div>
	</div>
				
	</g:form>
	

	
	

	

	

	

	
	
	
	
	