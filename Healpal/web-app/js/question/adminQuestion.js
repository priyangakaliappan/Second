$("document").ready(function(){
	if($("#actionTypeId").val()=='edit' && $("#diagnosisHaveId").val() != ""){
		$("#diagnosisId").prop("disabled", false);
		$("#diagnosisDiv").show();
	}else{
		$("#diagnosisId").attr('disabled','true');
		$("#diagnosisDiv").hide();
	}
	
	
	
	$("#patientMatchPointsId").keydown(function (event) {


        if (event.shiftKey == true) {
            event.preventDefault();
        }

        if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105) || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 190) {

        } else {
            event.preventDefault();
        }
        
        if($(this).val().indexOf('.') !== -1 && event.keyCode == 190)
            event.preventDefault();

    });
	
	$("#questionForm").submit(function(){ 
		
		if($("#optionsformatId option:selected").text()!='TextField' && $("#noOptionId").val()=="no"){ 
			$("#res").html("Please add options for this question");
			return false;
		}else{
			var temp;
			$.ajax({
				async:false,
				type:'POST',
				url:'../dynamicProfileQues/isExist',
				data:{
					quesText:$("#questionTextId").val(),
					actionTypeId:$("#actionTypeId").val(),
					quesHiddenid:$("#quesHiddenid").val()
					},
				success:function(res){
					temp = res;
				}
			});
			if(temp == 'true'){
				$("#res").html("Question Text already exist");
				return false;
			}
		}	
	});
	
	
});

function changeCategory(){
	var category = $("#questionCategoryId option:selected").text(); 
	if(category != "" && (category=="Diagnosis" || category=="Treatment")){
		$("#diagnosisId").prop("disabled", false);
		$("#diagnosisDiv").show();
	}else{
		$("#diagnosisId").attr('disabled','true');
		$("#diagnosisDiv").hide();
	}
}