<g:if test="${selectList}">
	 <g:select id="question" class="" from="${selectList}"
				optionKey="${optionValue}" name="optionName" optionValue="${optionValue}" value="${value}"
				noSelection="['': 'Select']"/>
	  </g:if>