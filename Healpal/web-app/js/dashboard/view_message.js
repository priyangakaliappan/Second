$(document).ready(function() {
	
	sessionStorage.setItem("receiverId",$("#scrolldown li.viewMessage.active").attr('id'));
	sessionStorage.setItem("groupId",$("#scrolldown li.viewGroup-message.active").attr('id'));
	
	var element = document.getElementById('messageLists');
	element.scrollTop = element.scrollHeight;
	if($("#new-group").val() == "" && $("#messageGroupId").val() == ""){
		$(".viewGroup-message").hide();
	}
	$(".header-search-box").hide();
	var messageCount = $("#messageCount").text();
	msgCountInc=false;
	setInterval(function() {
		//if(messageCount !=null && messageCount!="" && messageCount<=0 && messageCount != $("#messageCount").text())	{
			var uniqueId=$("#scrolldown li.viewMessage.active").attr('id');
			var groupIdd=$("#scrolldown li.viewGroup-message.active").attr('id');
			if($("#viewMessageId").hasClass('active')){
				if(uniqueId!=null && uniqueId!="" && uniqueId!="undefined"){
					// do nothing
				}else{
					uniqueId = sessionStorage.getItem("receiverId");
				}
			}else{
				if(groupIdd!=null && groupIdd!="" && groupIdd!="undefined"){
					// do nothing
				}else{
					groupIdd = sessionStorage.getItem("groupId");
				}
			}
			msgCountInc=true;
			searchPerson();
			if((uniqueId != null && uniqueId!="" && uniqueId!="undefined" && uniqueId ==$("#scrolldown li.viewMessage.active").attr('id')) || (groupIdd != null && groupIdd!="" && groupIdd!="undefined" && groupIdd ==$("#scrolldown li.viewGroup-message.active").attr('id'))){
				$.ajax({
					async : true,
					type : 'POST',
					url : '../dashboard/viewMessage',
					data : {
						patientId : uniqueId,
						messageGroupId : groupIdd,
						passbyAjax : true
					},
					success : function(res) {
						$("#tabcont1").html(res);
					}
				});
			}
		//}
	}, 5000); // 5 seconds
	
	
	$("#textmessage").keyup(function(e){
		 if (e.keyCode == 13) {
			 	sendMessage();
		     }
	});
});

var findspace = true;
function message() {
	
	$(".viewGroup-message").hide();
	$(".viewMessage").show();
	$("#viewGroupMessageId").removeClass("active");
	$("#viewMessageId").addClass("active");
	if($("#scrolldown li.viewMessage.active").hasClass("active")){
		// do nothing
	}else{
		patientMessage($("#scrolldown li.viewMessage:first"),'');
	}
}
function groupmessage() {
	
	$(".viewMessage").hide();
	$(".viewGroup-message").show();
	$("#viewMessageId").removeClass("active");
	$("#viewGroupMessageId").addClass("active");
	if($("#scrolldown li.viewGroup-message.active").hasClass("active")){
		// do nothing
	}else{
		patientMessage($("#scrolldown li.viewGroup-message:first"),'group');
	}

}

/* here we can pass param values to controller through ajax for sending messages */
function sendMessage() {
	var patientId
	var groupMessageId
	if ($.trim($("#textmessage").val()) != "") {
		
		findspace = /\s/.test($.trim($("#textmessage").val()));
		
		if (($("#textmessage").val().length < 30) || ($("#textmessage").val().length > 30 && findspace)) {
			
			var message = $.trim($("#textmessage").val());
			
			var searchValue = $.trim($("#searchId").val());
			
			if($("#viewMessageId").hasClass('active')){
				
				patientId = $("#scrolldown li.viewMessage.active").attr('id');
				if(patientId!=null && patientId!="" && patientId!="undefined"){
					// do nothing
				}else{
					patientId = sessionStorage.getItem("receiverId");
				}
			}else{
				groupMessageId = $("#scrolldown li.viewGroup-message.active").attr('id');
				if(groupMessageId!=null && groupMessageId!="" && groupMessageId!="undefined"){
					// do nothing
				}else{
					groupMessageId = sessionStorage.getItem("groupId");
				}
			}
		
			var newGroupId = $("#new-group").val();
			if (message != null && message != "") {
				
				if ((groupMessageId != null && groupMessageId != "") || (newGroupId != null && newGroupId != "")) {
					var groupId;
					if (groupMessageId != null && groupMessageId != "") {
						groupId = groupMessageId;
					} else if (newGroupId != null && newGroupId != "") {
						groupId = newGroupId;
					}
					$.ajax({
						async : true,
						type : 'POST',
						url : '../dashboard/replyMessage',
						data : {
							groupId : groupId,
							message : message
						},
						success : function(res) {
							$("#textmessage").val("");
							$("#tabcont1").html(res);
						}
					});
				} else {
					$.ajax({
						async : true,
						type : 'POST',
						url : '../dashboard/replyMessage',
						data : {
							patientId : patientId,
							message : message
						},
						success : function(res) {
							$("#textmessage").val("");
							$("#tabcont1").html(res);
						}
					});
				}
				$.ajax({
					async : true,
					type : 'POST',
					url : '../dashboard/searchConnectedMembers',
					data : {
						searchValue : searchValue,
						selectValue : ""
					},
					success : function(res) {
						$("#searchConnections").html(res);
					}
				});
			} else {
				//do nothing
			}
		} else {
			alert("Text string is too long. Please reduce the number of characters used");
		}
	} else {
		alert("You are sending a blank message.....");
	}
}
/* This function is for view patient messages */
function patientMessage(e, check) { 
	
	if(e.id == null || e.id == "" || e.id == "undefined"){
		e.id = e.attr("id");
	}
	$(".active-ans").removeClass("active");
	$("#"+e.id).addClass("active");
	
	var patientId = "";
	var messageGroupId = "";
	if (check != "" && check != null && check == 'group') {
		sessionStorage.setItem("groupId",e.id);
		messageGroupId = e.id;
	} else {
		patientId = e.id;
		sessionStorage.setItem("receiverId",e.id);
		$.ajax({
			async : true,
			type : 'POST',
			url : '../dashboard/updatePatientViewMessage',
			data : {
				patientId : patientId
			},
			success : function() {
			}
		});
	}
	
	$.ajax({
		async : true,
		type : 'POST',
		url : '../dashboard/viewMessage',
		data : {
			patientId : patientId,
			messageGroupId : messageGroupId,
			passbyAjax : true
		},
		success : function(res) {
			$("#tabcont1").html(res);
		}
	});
}
/* Here we can search patient by passing search values*/
function searchPerson() {
	var searchValue = $.trim($("#searchId").val());
	var selectValue = "";
	$.ajax({
		async : true,
		type : 'POST',
		url : '../dashboard/searchConnectedMembers',
		data : {
			searchValue : searchValue,
			selectValue : selectValue
		},
		success : function(res) {
				
			$("#scrolldown").html(res);
			
			$("#scrolldown").append('<p class="viewMessage no-record" style="font-size: 15px;padding-top: 10px;text-align: center;"></p>');
			$("#scrolldown").append('<p class="viewGroup-message no-record" style="font-size: 15px;padding-top: 10px;text-align: center;"></p>');
			
			if($('ul li.viewMessage').text()=="" && $('ul li.viewGroup-message').text()==""){
				
				$("p.viewMessage").html("No records found");
				$("p.viewGroup-message").html("No records found");
				
				if($("#viewMessageId").hasClass("active")){
					$("p.viewGroup-message").hide();
				}else{
					$("p.viewMessage").hide();
				}
			}else{
				
				if($("#viewMessageId").hasClass("active") && $('ul li.viewMessage').text()==""){
					$("p.viewGroup-message").hide();
					$("p.viewMessage").html("No records found");
				}
				else if($("#viewGroupMessageId").hasClass("active") && $('ul li.viewGroup-message').text()==""){
					$("p.viewMessage").hide();
					$("p.viewGroup-message").html("No records found");
				}
			}
			
		}
	});
}
