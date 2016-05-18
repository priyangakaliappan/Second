<%@ page contentType="text/html;charset=UTF-8"%>
<g:hiddenField name="hiddenField" value="okokooko" id="samplee" />

								<span id="err" class="alert alert-danger" style="text-align: center;font-size:11px;padding:0 2px 2px 4px;">${msg}</span>
								

<script type="text/javascript">


<%--

$("document").ready(function() {
	var temp="";
	var path="";
	var location ="";
	$("#res").html("");
	if('${createAccount}' == 'true'){
		path = '../auth/ajaxLogin';
		location='../auth/jsRoleCheck';
	}else{
		path = 'auth/ajaxLogin';
		location='auth/jsRoleCheck';
	}
	$.ajax({
		async:false,
		type:'POST',
		url:path,
		data:{
			username:'${userName}',
			password:'${password}'
			},
		success:function(res){
			temp = res;
		}
	});
	if(temp=="login success"){
		window.location.href=location;
	}else{
		$("#res").html(temp);
	}
});

--%></script>
