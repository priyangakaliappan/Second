<%@ page contentType="text/html;charset=UTF-8" %>

<div id="usersList" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
		<g:if test="${flash.msg}">
		<h6 class="red-text">
		</h6>
	    </g:if><%--
	   <g:link  class="btn btn-info btn-medium" onclick="getMatchedPatient();">Send Mail</g:link>
	   --%><g:submitButton class="btn btn-orange" id="submit" value="Send Mail" name="submit" onclick="getMatchedPatient();"/>
	   
	   <div id="alertHide" class="alert alert-danger" style="text-align: right;font-size: small; margin-left: -152px; margin-top: 19px; width: 30%; margin-bottom: 0px;">
								<ul>
								</ul>
							</div>
				<%--<div class="col-xs-6">
							<div class="dataTables_filter" id="tbl_user_filter">
								<label>Search: <input type="text" class="textbox" aria-controls="tbl_user"></label>
							</div>
						</div>
				--%><br>
		<br>
		<td>
        <input type="checkbox" id="selectall" class="css-checkbox " name="selectall" />Select All<br>
         </td>
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="emailAddress"  title="Email" controller="GroupMail" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="cancerType"  title="CancerType" controller="GroupMail" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="GroupMail" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="GroupMail" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			
				
			</tr>
				</thead>
				<tbody>
				<g:if test="${groupMail}">
						<g:each in="${groupMail}" var="list" status="i">
							<tr>
								<td> 
								
									<input type="checkbox" class="checkboxall" name="emailAddress" id="emailAddress" value=" ${list?.emailAddress}"  > ${list?.emailAddress}<br/>
								<td>
								${list?.cancerType}
								</td>	
								<g:if test="${list?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
								<td>
					<g:formatDate date="${list?.rowCreated}" type="datetime"
								style="MEDIUM" />	
				</td>
				</g:each>
					</g:if>
					<g:else>
						<tr>
							<td colspan="3">No Results Found</td>
						</tr>
					</g:else>
				</tbody>
			</table>
		
			<g:if test="${total}">
	<util:remotePaginate total="${total}" update="usersList"
		controller="GroupMail" action="ajaxPaginate" max="${max}"
		params="['size':total,'searchValue':searchValue]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#selectall").click(function(){
	        if(this.checked){
	            $('.checkboxall').each(function(){
	                this.checked = true;
	            })
	        }else{
	            $('.checkboxall').each(function(){
	                this.checked = false;
	            })
	        }
	    });
	});
</script>
<script type="text/javascript">
function getMatchedPatient(){
	
	
    var emailAddress = "";
    var agree = $('.checkboxall').is(':checked');
   
    if(!agree){
    	$(".alert-danger").show();
    	$(".alert-danger ul")
		.append(
				'<li class="err_msg" style="list-style-type:none;">Please choose email</li>');
        }
    $.each($("input[name='emailAddress']:checked"), function(i){ 
        if(i == 0){          
        	emailAddress  = emailAddress + $(this).val();
        	//alert(emailAddress)
        }else{
        	emailAddress  = emailAddress + ","+$(this).val();
        	//alert("emails"+emailAddress)
        }
    });
if(emailAddress!=null){
	    $.ajax({
	        async  : false,
	        type   : "POST",
	        url    : "../groupMail/sendMail",
	        data   : {emailAddress:emailAddress},
	        success : function(res){
	        	 window.location.replace("../groupMail/view");
	        }
	    });
	    return false;
}else{
   return false;
}
}


</script>

<script type="text/javascript">
$(document).ready(function(){
	$(".alert-danger").hide();
});
</script>
