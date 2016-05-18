<%--	<span id="userErr" style="color: red">
		<g:hasErrors
		bean="${user}">
		<span style="color: red"><g:renderErrors bean="${user}"
				as="list" /></span>
	</g:hasErrors> </span>
	
--%>

<div class="alert alert-danger" id="Err">
		<g:hasErrors
		bean="${user}">
		<span><g:renderErrors  bean="${user}" /></span>
	</g:hasErrors> 
	
</div>

