<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : list
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               13-11-2015         Initial Creation
 *
 */-->

<%@page import="com.healpal.care.ConnectionController"%>
<%@page import="com.healpal.care.HealpalUser"%>
<%@page import="com.healpal.care.PatientMatchController"%>
<%@page import="com.healpal.care.PatientAddress"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="care">
<title>::.. Healpal | Connections ..::</title>
</head>
<body>
	<g:render template="../template/careMenu"></g:render>
	<section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="box-content4 mar-bot-10">
						<div class="col-sm-1">
							<i class="connection-image"></i>
						</div>
						<div class="col-sm-11">
							<h2>Connections</h2>
							<p>Make your connections lead you to the right cancer
								experts!</p>
								<g:render template="/dashboard/profileCompletionStatusBar"></g:render>
						</div>
						<div class="clearfix"></div>
					</div>
					
					<div class="box-content5 mar-bot-10">
						<div class="col-sm-4 pull-left pad-lr-30">
							
						
							Sort By <select name="sortBy" id="sortBy"
								style="padding-left: 1em">
								<option value="">Choose</option>
								<option value="First">Firstname</option>
								<option value="Last">Lastname</option>
								<%--<option value="New">New</option>
							--%></select>
						</div>
						<div class="col-sm-4 pad-lr-30"
							id="searchPatientId">
							<%--<i class="new-search-icon pull-left"></i>
							--%>
							<input
								type="text" name="search" id="searchId" class="pull-left"
								placeholder="Search">
						
							
						</div>
						<div class="col-sm-4 text-center pad-lr-30"><a class="btn btn-info btn-sm modal_link create_group-btn" data-toggle="modal" data-target="#createGroup" href="">Create Group</a></div>
						<div class="clearfix"></div>
						<g:render template="searchConnections"></g:render>
						<span id="groupErr" class="alert alert-danger"></span>
						<div class="clearfix mar-bot-10"></div>
						<div class="clearfix mar-bot-10"></div>
						<%--<input type="text" name="groupName" id="groupName" maxlength="30" />
						<a href="#" onclick="return checkboxValues();">Create Group</a>
						--%><div class="clearfix">&nbsp;</div>
						<div class="clearfix">&nbsp;</div>
						<div class="clearfix">&nbsp;</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div id="myModal" class="modal fade message-popup" role="dialog">
		<div class="modal-dialog">
			<a href="#" class="close-icon" data-dismiss="modal"></a>
			<div class="login-bss-cont">
				<div class="col-sm-3 pad-lt login-right-cont">
					<div id="msg_div">
						<h4>HealPal Message</h4>
						<div id="messageErr"  class="alert alert-danger" style="text-align: center;font-size: small;"></div>
						<g:hiddenField name="msgPatientId" id="msgPatientId" />
						<div class="text-center">
							<div class="text-center">
								<g:textArea name="msgContent" id="msgContendId" rows="5" maxlength="200"
									placeholder="Your message to" class="col-sm-10 profile-box-pad form-control" />
								<%--<i class="msg_error text-danger" id="messageErr"> </i>
							--%></div>
						</div>
						<!--form-group-->
						<div class="clearfix mar-bot-10"></div>

						<div class="text-right" id="btn_div">
							<input name="flag" value="" type="hidden"> <input
								type="button" class="btn btn-brand-f btn-orange" name="submit"
								id="sendMsgId" value="Send" onclick="return sendMessage();" />
							&nbsp; <input type="button" class="btn btn-brand-f btn-orange"
								name="reset" id="cancelMsgId" value="Reset"
								onclick="clearValue();" />
						</div>
					</div>
					<!--right-->
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="createGroup" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<a href="#" class="close-icon" data-dismiss="modal"></a>
				<div class="modal-body"></div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	
	
	
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript">

	
	
		var selectedPatientIds= [];
		function removeConnection(){
			if(confirm("Are you sure you want to remove the Connection?") == true){
				return true;
			}else{
				return false;
			}
		}
	<%--	function checkboxValues(){
			$("#groupErr").html("");
			var temp = "false";
			var count = selectedPatientIds.length;
			if(count != 0){
				var groupName = $.trim($("#groupName").val());
				if(groupName != null && groupName != ""){
					$.ajax({
						async : false,
						type : 'POST',
						url : '../connection/isGroupNameExist',
						data : {groupName:groupName},
						success : function(res) {
							if(res == "true" || res == true){
								temp = "true";
							}
						}
					});
					if(temp == "true"){
						$("#groupErr").show();
						$("#groupErr").html("Groupname already exist");
						$("#groupName").focus();
						return false;
					}else{
						if(selectedPatientIds[1] == undefined || selectedPatientIds[1] == "undefined"){
							$("#groupErr").show();
							$("#groupErr").html("Please choose two or more connections");
							$("#groupName").focus();
							return false;
						}else{
							$.ajax({
								async : false,
								type : 'POST',
								url : '../connection/createGroup',
								data : {groupName:groupName,
									patientIds:selectedPatientIds},
								success : function(res) {
									
								}
							});

							var connectionSize = parseInt($("#connectionListSize").val());
							for(var j = 0; j < connectionSize; j++){
								var checkboxSelect = $('#checkbox'+j).val();
								for (var i = 0; i < selectedPatientIds.length ; ++i){
									if(selectedPatientIds[i] == checkboxSelect){
										$('#checkbox'+j).prop("checked", false);
									}
								 }
							}
							selectedPatientIds = [];
							$("#groupName").val('');
							$("#groupName").focus();
							$("#groupErr").show();
							$("#groupErr").html(groupName+" group created!");
							return true;
						}
					}
				}else{
					$("#groupName").focus();
					$("#groupErr").show();
					$("#groupErr").html("Please enter groupname");
					return false;
				}
			}else{
				$("#groupErr").show();
				$("#groupErr").html("Please choose two or more connections");
				return false;
			}
		} --%>
		

		function setPatientValue(id){
			$("#messageErr").html("");
			$("#messageErr").hide();
			$("#msgContendId").val("");
			if(id != null && id != ""){
				$("#msgPatientId").val(id);
			}else{
				//do nothing
			}
		}

		function clearValue(id){
			$("#messageErr").hide();
			$("#msgContendId").val("");
		}

		function sendMessage(){

			$("#messageErr").html("");
			$("#messageErr").removeClass("alert-danger");
			var patientId = $.trim($("#msgPatientId").val());
			var message = $.trim($("#msgContendId").val());
			if((patientId != null && patientId != "") && (message != null && message != "")){
				$.ajax({
					async : true,
					type : 'POST',
					url : '../connection/sendMessage',
					data : {message:message,
						patientId:patientId},
					success : function(res) {
						$('#myModal').modal('hide');
						//$("#searchConnections").html(res);
					}
				});
				//$('#myModal').modal('hide');
				return true;
			} else if(message == null || message == ""){
				$("#messageErr").addClass("alert-danger");
				$("#messageErr").show();
				$("#messageErr").html("Message should not be empty");
				return false;
			}else{
				//return true;
			}
		}

		$("document").ready(function(){
			$("#messageErr").hide();
			$("#groupErr").hide();
			$("#groupName").keyup(function(){
				$("#groupErr").hide();
				$("#groupErr").html("");
			});
			$("#searchId").keyup(function(){
				var searchValue = $.trim($("#searchId").val());
				var selectValue = $("#sortBy").val();
				$.ajax({
					async : true,
					type : 'POST',
					url : '../connection/searchConnections',
					data : {searchValue:searchValue, selectValue:selectValue},
					success : function(res) {
						$("#searchConnections").html(res);
					}
				});
				var connectionSize = parseInt($("#connectionListSize").val());
				for(var j = 0; j < connectionSize; j++){
					var checkboxSelect = $('#checkbox'+j).val();
					for (var i = 0; i < selectedPatientIds.length ; ++i){
						if(selectedPatientIds[i] == checkboxSelect){
							$('#checkbox'+j).prop("checked", true);
						}
					 }
				}
			});

			$("#matchSearch").keyup(function(){
				var searchValue = $.trim($("#matchSearch").val());
				var selectValue = $("#sortBy").val();
				$.ajax({
					async : true,
					type : 'POST',
					url : '../connection/searchConnections',
					data : {searchValue:searchValue, selectValue:selectValue},
					success : function(res) {
						$("#searchConnections").html(res);
					}
				});
				var connectionSize = parseInt($("#connectionListSize").val());
				for(var j = 0; j < connectionSize; j++){
					var checkboxSelect = $('#checkbox'+j).val();
					for (var i = 0; i < selectedPatientIds.length ; ++i){
						if(selectedPatientIds[i] == checkboxSelect){
							$('#checkbox'+j).prop("checked", true);
						}
					 }
				}
			});
			
			$("#sortBy").change(function(){
				var selectValue = $("#sortBy").val();
				var searchValue = $.trim($("#searchId").val());
				$.ajax({
					async : true,
					type : 'POST',
					url : '../connection/searchConnections',
					data : {searchValue:searchValue, selectValue:selectValue},
					success : function(res) {
						$("#searchConnections").html(res);
					}
				});

				var connectionSize = parseInt($("#connectionListSize").val());
				for(var j = 0; j < connectionSize; j++){
					var checkboxSelect = $('#checkbox'+j).val();
					for (var i = 0; i < selectedPatientIds.length ; ++i){
						if(selectedPatientIds[i] == checkboxSelect){
							$('#checkbox'+j).prop("checked", true);
						}
					 }
				}
			});
			$(document).on('click','.modal_link',function(){
				$("#groupName").val("");
				$('.members').remove();
				var url="../connection/createGroup";
				$("#createGroup .modal-body").load(url);
			});
		});

		function addPatientId(checkboxId){
			if($('#'+checkboxId).prop('checked')){
				selectedPatientIds.push($('#'+checkboxId).val());
			}else{
				var checkboxValue = $('#'+checkboxId).val();
				 for (var i = 0; i < selectedPatientIds.length ; ++i){
					if(selectedPatientIds[i] == checkboxValue){
						selectedPatientIds.splice(i, 1);
					}
				 }
			}
		}
	</script>
</body>
</html>
