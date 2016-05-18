
<g:if test="${answerOptions?.questionOptions}">
	<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
		<ul>
			<g:each in="${answerOptions?.questionOptions}" var="options"
				status="i">
					<g:if test="${i%2==0}">
					<li><input type="checkbox" value="${options?.questionOptions}" name="answer"
						class="checkboxSelect" id="${options?.id}" onclick="otherOption()" />
						<label for="${options?.id}" class="selectedLabels">
							${options?.questionOptions}
					</label></li>
				</g:if>
			</g:each>
		</ul>
	</div>

	<div class="col-md-6 col-xs-12 pad-rt-0 hidden-xs hidden-sm">
		<ul>
			<g:each in="${answerOptions?.questionOptions}" var="options"
				status="i">
				<g:if test="${i%2 ==1}">
					<li><input type="checkbox" value="${options?.questionOptions}" name="answer"
						class="checkboxSelect" id="${options?.id}" onclick="otherOption()" />
						<label for="${options?.id}" class="selectedLabels">
							${options?.questionOptions}
					</label></li>
				</g:if>
			</g:each>
		</ul>
	</div>

</g:if>

