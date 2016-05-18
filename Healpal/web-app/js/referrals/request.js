function validate(str){
				$("#chosedPatientId1").val($("#patients").val());
				$("#chosedPatientId2").val($("#patients").val());
				
					if(str=="expert"){
						$("#requestExpertId").html("");
						if($("#patients").val()==""){
							$("#requestExpertId").addClass('alert alert-danger').html("Please choose a patient");
							return false;
						}else if($("#doctorsId").val()==""){
							$("#requestExpertId").addClass('alert alert-danger').html("Please choose a doctor");
							return false;
						}else if($("#msg1").val()==""){
							$("#requestExpertId").addClass('alert alert-danger').html("Please enter the message");
							return false;
						}
					}else if(str=="clinic"){
						$("#requesClinictId").html("");
						if($("#patients").val()==""){
							$("#requesClinictId").addClass('alert alert-danger').html("Please choose a patient");
							return false;
						}else if($("#msg2").val()==""){ 
							$("#requesClinictId").addClass('alert alert-danger').html("Please enter the message");
							return false;
						}
					}
			}

function alertMe(id ,form){ 
	$(id).addClass('alert alert-danger');
	if(form=='provideExpertForm'){
		$("#doctorsId ,#msg1 ,#d1,#d2,#d3,#d4,#d5,#d6,#d7,#d8,#d9,#d10,#d11,#d12,#d13,#d14").val('');
	}else if((form=='provideClinicForm') || (form=='requesClinicForm')){
		$("#clinicsId ,#msg2").val('');
	}else if(form=='requestExpertForm'){
		$("#msg1").val('');
	}
}

function before(){
	
}

function defaultMessage(){
	var receiverName = $("#patients option:selected").text();
	var senderName = $("#personName").val();
		msg1(receiverName ,senderName);
		msg2(receiverName ,senderName);
}

function msg1(receiverName ,senderName){ 
	if(receiverName != ''){
		var msg1 = 'Hi '+receiverName+",\nPlease recommend me your doctor or doctors.\n\nBest,\n"+senderName;
		//$("#msg1").html(msg1);
		$("#msg1").val(msg1);
	}
}

function msg2(receiverName ,senderName){
	if(receiverName != ''){
		var msg2 = 'Hi '+receiverName+",\nPlease recommend me a clinical trial that you participated in.\n\nBest,\n"+senderName;
		//$("#msg2").html(msg2);
		$("#msg2").val(msg2);
	}
}



function defaultMessage1(){
	var receiverName = $("#patients option:selected").text();
	var senderName = $("#personName").val();
	if(receiverName != null){
		var msg1 = 'Hi '+receiverName+",\nI am recommending doctor to you.You can contact\nhim for an appointment outside this platform.\nHope this helps!\n\n"+senderName;
		//$("#msg1").html(msg1);
		$("#msg1").val(msg1);
		
		var msg2 = 'Hi '+receiverName+",\nI am recommending a clinical trial which may be suitable\nfor you.\nBest,\n"+senderName;
		//$("#msg2").html(msg2);
		$("#msg2").val(msg2);
	}
}