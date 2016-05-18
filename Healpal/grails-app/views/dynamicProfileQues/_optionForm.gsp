
	<g:formRemote name="options" url="[controller:'dynamicProfileQues',action:optionAction]" method="POST" update="optionsListId">
	
	<div class="control-group">
	<label class="control-label"><b>Option Text :</b></label>
		<div class="controls">
			<g:textField name="questionOptions" required="" id="questionOptionsId" value="${questionOption?.questionOptions}"/>
		</div>
	</div>
	
	<div class="control-group">
		<div class="controls">
			<g:hiddenField name="hiddenOptionId" value="${params.opId}"/>
			<a href="#" class="btn btn-info">Cancel</a>
			<g:submitButton name="save" value="Save" class="btn btn-info"/>
		</div>
	</div>
	</g:formRemote>  