function savePositive(type, value) {
	if (type != null && type != "" && value != null && value != "") {
		$.ajax({
			async : false,
			type : 'POST',
			url : '../profile/updatePositive',
			data : {
				type : type,
				value : value
			},
			success : function(res) {
				// do nothing
			}
		});
	}
}

function addAccount() {
	if (document.getElementById("healthcareSystem").value == "") {
		alert("Please choose Health Care System");
		return false;
	} else if (document.getElementById("username").value == "") {
		alert("Please enter Username");
		return false;
	} else if (document.getElementById("password").value == "") {
		alert("Please enter Password");
		return false;
	} else {
		return true;
	}
}
function checkOnlyNumber(e) {
	var charCode = e.which;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)
			|| (charCode == 46)) {
		alert("Please enter only Numbers");
		return false;
	} else {
		return true;
	}
};

function checkOnlyDate(e) {
 	var charCode = e.keyCode || e.which;
 	if (charCode != 46 && charCode != 47 && charCode > 31 && (charCode < 48 || charCode > 57)
			|| (charCode == 46)) {
 		alert("Please enter only Number and ' / '");
		return false;
	} else {
		return true;
	}
}

function onlyAlphabets(e) {
 	var charCode = e.keyCode || e.which;
if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode   <123) || (charCode == 8) || (charCode == 37) || (charCode == 9) || (charCode == 46) || (charCode >=37 && charCode<=40) || (charCode == 32))                    
         {
             return true;
         } 
         else 
         {
         	alert("please enter only Alphabets");
             return false;
         }
         }  

// For d4 and c2 pages
$(document).ready(function() {

	//for active month in date of birth, date of surgery, date of cancer diagnosis
	$(".month").click(function() {
		var id = $(this).attr('id');
		$("#selectedMonth").val(id);
		$('.month').removeClass("monthactive");
		$('#' + id).addClass("monthactive");
	});
	// "checkboxSelect" class name in c9.gsp
	$('.checkboxSelect').click(function() {
		if ($(this).parent('li').hasClass('active')) {
			$(this).parent('li').removeClass('active');
			if ($(this).attr('checked')) {
				$(this).removeAttr('checked');
			}
			$(this).parent('li').removeClass('highLight');
		} else {
			$(this).parent('li').toggleClass('highLight');
		}
	});
	// for single select popup page in dashboard edit profile
	$(".changeActive").click(function() {
		$('.changeActive').removeClass("active");
		$('#' + id).addClass("active");

	});
	

});

// For b1 page  File Upload
window.pressed = function() {
	var a = document.getElementById('upload_file');
	if (a.value == "") {
		fileLabel.innerHTML = "No File Selected";
	} else {
		var theSplit = a.value.split('\\');
		fileLabel.innerHTML = theSplit[theSplit.length - 1];
	}
};
$("document").ready(function() {
	$('#savelive').attr('disabled',true);
	$('#savelive').css("cursor", "not-allowed");
	$("#zip_warn").html("");
	//for c2,d4 and e4 pages
	$("#saveDate").click(function() {
		/*var dtValue=$("#example1").val()
    	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
		var testDate = date_regex.test(dtValue)*/
		/*var age = getAge(new Date($("#example1").val()));
		alert("ageeeeeee"+age);*/
		var dob=$("#example1").val()
		var d = new Date();
		var bits = dob.split('/')
		d.setHours(0,0,0,0); //normalise
		d.setFullYear(bits[2])
		d.setMonth(bits[1]-1)
		d.setDate(bits[0])
		var now = new Date();
		now.setHours(0,0,0,0); //normalise
		var years = now.getFullYear()-d.getFullYear();
		d.setFullYear(now.getFullYear())
		var diff = now.getTime()-d.getTime()
		if ( diff <0) years--;
		if ($("#example1").val() == "") {
			alert("Please choose your date of birth");
			return false;
		}
		else if(years<18){
			alert("The User is not permitted to access this site due to age restrictions");
			var stateTime=20
            var myVar = setInterval(function(){ myTimer() }, 1000);

    function myTimer() {
        $("#timer").html("You would be redirected to the Home Page in "+stateTime+" seconds");
        stateTime--;
        if(stateTime==0){
        	clearInterval(myVar);
        	$("#timer").html("");
       	 window.location.href = "../home";
            }
    		}
			return false;
			
			
		}
		/*else if(testDate == 'false'){
			alert("Incorrect format")
		}
		else if(Date.parse(dtValue) >  Date.parse(new Date())){
			alert("Date must not be greater than today")
		}*/
		else {
			return true;
		}
	});
	
	$("#editDOB").click(function(){
		var dob=$("#example2").val()
		var d = new Date();
		var bits = dob.split('/')
		d.setHours(0,0,0,0); //normalise
		d.setFullYear(bits[2])
		d.setMonth(bits[1]-1)
		d.setDate(bits[0])
		var now = new Date();
		now.setHours(0,0,0,0); //normalise
		var years = now.getFullYear()-d.getFullYear();
		d.setFullYear(now.getFullYear())
		var diff = now.getTime()-d.getTime()
		if ( diff <0) years--;
		if ($("#example2").val() == "") {
			alert("Please choose your date of birth");
			return false;
		}
		else if(years<18){
			alert("The User is not permitted to access this site due to age restrictions");
			return false;
		}
		
	});
	
	$("#saveDateOfDiagnosis").click(function() {
	if($("#d4").val() == "") {
		alert("Please choose your date of cancer diagnosis");
		return false;
	}
	
	else {
		return true;
	}
});
	
	$("#saveDateOfSurgery").click(function() {
		if($("#e4").val() == "") {
			alert("Please choose your date of surgery");
			return false;
		}
		
		else {
			return true;
		}
	});
	//for c5 page
	$("#savelive").click(function() {
		if ($("#zip").val() == "" || $("#zip").val() == null) {
			alert("Please enter Zip Code");
			return false;
		} else if ($("#state").val() == "" || $("#state").val() == null) {
			alert("Zip Code not valid");
			return false;
		}
		else if ($("#country").val() == "" || $("#country").val() == null) {
			alert("Zip Code not valid");
			return false;
		} else if ($("#zip").val() == "" || $("#zip").val() == null) {
			alert("Please enter Zip Code");
			return false;
		} else if ($("#state").val() == "" || $("#state").val() == null) {
			alert("Zip Code not valid");
			return false;
		}else {
			return true;
		}
	});
	//for ca11 page
	$("#saveTreatingDoctor").click(function() {
		if ($("#treatingDoctor").val() == "") {
			alert("Please enter your Treating Doctor Name");
			return false;
		}
		else if ($("#zipcode").val() == "") {
			alert("Please enter Treating Doctor Zipcode ");
			return false;
		}
		else if ($("#contactNumber").val() == "") {
			alert("Please enter Treating Doctor Contact Number");
			return false;
		}
		
		else if($("#hidden_val").val()==""||$("#hidden_val").val()==null){
			alert("Sorry, Zipcode you have entered is not valid");
			return false;
		}
		else{
			return true;
		}
	});
	
	// for  d2 page
	$("#saveDiagnosis").click(function() {
		if ($("#diagnosis").val() == "") {
			alert("Please select your Condition");
			return false;
		} else {
			return true;
		}
	});
	$("#saveAge").click(function() {
		if ($("#age").val() == "") {
			alert("Please enter your Age");
			return false;
		} else {
			return true;
		}
	});
	$(".border").click(function() {
		$(this).find('label').addClass("img-border");
		var check = $(this).find('input[type=checkbox]').is(':checked')
		if (!check) {
			$(this).find('label').removeClass("img-border");
		}

	});
	//for next button in profile
	$("form").submit(function() {
		if($("input").hasClass("checkboxSelect")){
			var aVariable = $('input.checkboxSelect[type="checkbox"]:checked', this).length;
			if(aVariable<=0){
				alert("Please select atleast one of the above");
				//$("#err").html("Please select atleast one of the above");
				return false;
			}
	    }
	    
	});
	$("#aboutyou").click(function(){
		if($("#aboutYourself").val().trim() == "" || $("#aboutYourself").val().trim() == null){
			alert("Please write about your self");
			return false;
	}
		else if($("#passionate").val().trim() == "" || $("#passionate").val().trim() == null){
			alert("Please write about your passion");
			return false;
	}
		});
	$("#participated").click(function(){
		if($("#participate").val().trim() == "" || $("#participate").val().trim() == null){
			alert("Please enter the clinical trial you participated in");
			return false;
	}
		});
});
//for multiple select boxes
$("document").ready(function(){
	var incVal=0;
$(".checkboxSelect").on('click',function(){
	if(incVal!=0){
	var c = this.checked ? incVal++ : incVal--;
	}else{
		var c = this.checked ? incVal++ : incVal;
		}
	$("#selectedDrugs").val(incVal);
});
$("#selectedDrugs").val(incVal);	
});
function validateEmail(){
	var emailed= /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	return emailed;	
}

function checkEmailValidation(){
	var x=validateEmail();
	var mailIds=$("#emails").val();
	
	var url      = window.location.href; 
	if(mailIds!=null && mailIds!=""){
		var splittedMails=mailIds.split(",");
		for(i = 0; i < splittedMails.length; i++){
	        if(x.test(splittedMails[i])==false){
	        alert("Please enter valid Email Id")
	        return false;
	        }
	        }
		if($("#yourName").val()!=null && $("#yourMail").val()!=null){
			return shareLink($("#yourName").val(),$("#yourMail").val(),mailIds)	
		}
		
		}
		else{
			alert("Please Enter email id");
			return false;
		}
	}
function shareLink(yourName,yourMail,emails){
	var url      = window.location.href;
	var x=validateEmail();
	if($("#yourName").val()==""){
		alert("please enter your name")
		return false;
	}
	else if($("#yourMail").val()==""){
		alert("please enter your mail id");
		return false;
	}
	else if(x.test($("#yourMail").val())==false){
		alert("please enter valid mail id");
		return false;
		}

	else{

	$.ajax({
		async : false,
		type : 'POST',
		url : '../BreastContent/shareLink',
		data : {
			yourName : yourName,
			yourMail : yourMail,
			url : url,
			emails : emails
			
		},
		success : function(res) {
			alert(res)
		}
	});
	return true;
	}
}