	<g:if test="${manualList}">
	 <g:select id="question" from="${manualList}"
				name="optionName" value="${value}"
				noSelection="['': 'Select']"/>
	  </g:if>