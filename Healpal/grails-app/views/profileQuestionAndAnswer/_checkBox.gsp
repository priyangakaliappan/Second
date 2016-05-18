<g:if test="${answerOptions?.questionOptions}">
<div class="list-content">
<g:each in="${answerOptions?.questionOptions}" var="options">
<div class="col-md-6 col-xs-12 pad-lt-0">
		<ul>
			<li><input type="checkbox" value="${options?.questionOptions}" id="${options?.id}" name="answer" class="checkboxSelect" />
			<label for="${options?.id}" style="font-size: 25px;"> ${options?.questionOptions}</label>
		</ul>
	</div>
	</g:each>
	</div>
</g:if>
