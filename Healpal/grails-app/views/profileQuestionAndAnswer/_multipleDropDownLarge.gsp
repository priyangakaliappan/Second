<g:if test="${answerOptions?.questionOptions}">
	<ul>
		<g:each in="${answerOptions?.questionOptions}" var="options"
			status="i">
			<g:if test="${i<=5}">
				<li><input type="checkbox" value="${options?.questionOptions}" name="answer"
					class="checkboxSelect" id="${options?.id}" onclick="otherOption()" />
					<label for="${options?.id}" class="selectedLabels">
						${options?.questionOptions}
				</label></li>
			</g:if>
		</g:each>
	</ul>
</g:if>