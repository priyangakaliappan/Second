<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : inbox
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Insert title here</title>
</head>
<body>
	<div class="body" id="messageBody">
		<g:form name="message" controller="Message">
			<h1>View Messages</h1>
			<table id="inbox" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="200">Patient Name</th>						
						<th width="200">Date</th>
					</tr>
				</thead>
				<tbody>
					<g:if test="${inboxList}">
						<g:each in="${inboxList}" status="i" var="inbox">
							<tr>
								<td onclick="viewPatientMessages('${inbox.getKey()?.id}');">
									<a>${inbox.getKey()?.person?.firstName}</a>
								</td>
								<td>
									${inbox.getValue()?.get(inbox.getValue()?.size()-1)?.rowCreated}
								</td>
							</tr>
						</g:each>
					</g:if>
				</tbody>
			</table>
		</g:form>
	</div>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript">
		function viewPatientMessages(id){
			if(id != null && id != ""){
				$.ajax({
					async:false,
					url:"../message/getMessages",
					type:"POST",
					data:{"patientId":id},
					success:function(res){
						$("#messageBody").html(res);
					}
				});
			}
		}
	</script>
</body>
</html>