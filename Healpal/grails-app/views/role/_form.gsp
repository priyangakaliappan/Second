<%@ page contentType="text/html;charset=UTF-8" %>
			<g:form controller="role" action="${action}" method="post" class="form-horizontal" onSubmit="return doSave();">
		<div class="control-group">
		
		<g:hasErrors bean="${role}">
				<span class="red-text"><g:renderErrors bean="${role}"
						as="list" /></span>
			</g:hasErrors>
			<div id="err"></div>
		<label class="control-label"><b>Authority:</b></label>
		   
		
		<div class="controls">
			<input type="text" id="role" name="authority" placeholder="Please type authority" required maxlength="25"  autocomplete="off" value="${role?.authority}"/>
		</div>
	</div>
	
		<div class="control-group">
		<g:if test="${action == 'edit'}">
		
		<label class="control-label"><b>Status:</b></label>
		<div class="controls">
					<g:if test="${role?.isActive==1}">
						<g:set var="ch" value="checked"></g:set>
					</g:if>
					<g:else>
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
  				<g:link controller="role" action="view" class="btn btn-info">Cancel</g:link>	
  				<g:submitButton name="save" value="Save" class="btn btn-info"/>
		</div>
	</div>
			
	</g:form>	
  			
  			
			
			
		
		
		
		