<div id="matchList">

<table
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="cancerContentPage"  title="CancerContentPage" controller="BreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="satisfactoryCount"  title="SatisfactoryCount" controller="BreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="perfectCount" title="PerfectCount" controller="BreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="notClearCount" title="NotClearCount" controller="BreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			<util:remoteSortableColumn property="notWhatIWantedCount" title="NotWhatIWantedCount" controller="BreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
				
			</tr>
				</thead>
				<tbody>
				<tr>
				<g:if test="${cancerVal}">
						<g:each in="${cancerVal}" var="list" status="i">
						
						<g:each in="${list}" var="list1" status="j">
						<td>
						 <span class="list1 ${j == 4 ? 'selected' : ''}">${list1}</span>
						 </td>
			            <g:if test="${j==4}">
						<tr>
						<td>
                       </td>		
                        </tr>	
             </g:if>		
				</g:each>
				</g:each>
					</g:if>
					<g:else>
						<tr>
							<td colspan="3">No Results Found</td>
						</tr>
					</g:else>
					</tr>
				</tbody>
			</table>


</div>