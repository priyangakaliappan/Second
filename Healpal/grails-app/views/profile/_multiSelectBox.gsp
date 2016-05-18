	 <g:if test="${questionCategory}">
	 <g:select id="question" class="" from="${questionCategory}" multiple="multiple"
				optionKey="id" name="questionCategory" optionValue="questionCategory"
				noSelection="['': 'Select']"/>
	  </g:if>
 