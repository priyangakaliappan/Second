$(document).ready(function() {							
							if ($("#sigin_rule").val() == "") {
								$("#review_warn_info").addClass("review_warn")
								$(".review_warn ul")
										.append(
												'<li class="err_msg" style="list-style-type:none;">Please <a href="#" class="sign_link check-layout" data-toggle="modal" data-target="#signin">Sign in</a> to write a review</li>');
										}
							$(".radios").click(function() {
								if ($(this).is(':checked')) {
									var reviewId = $(this).attr('id')
									$.ajax({
										async : false,
										type : 'POST',
										url : '../home/ajaxQuestionOptions',
										data : {
											reviewId : reviewId
										},
										success : function(res) {
											$("#divRad1").html(res);
										}
									});

								}
							});

						});

// For Required fields validation

function check() {
	$("li.err_msg").remove();
	$("#flash_msg").remove();
	var dtValue = $("#reviewDate").val()
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
	if ($("#diagnosis").val() == "" || $("#title").val() == ""
			|| $("#yourReview").val() == ""
			/*|| $("#cancerExpert").val() == ""
			|| $("#clinicLocation").val() == ""*/
			|| !$(".reviewAbout").is(':checked')) {
		
		$("#review_warn_info").addClass("review_warn")
		//$(".review_warn").show();
		if ($("#diagnosis").val() == "") {
			$(".review_warn ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please choose diagnosis</li>');
			$("#diagnosis").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}
		if ($("#title").val() == "") {
			$(".review_warn ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please enter review title</li>');
			$("#title").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}
		if ($("#yourReview").val() == "") {
			$(".review_warn ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please enter your review</li>');
			$("#yourReview").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}
		/*if ($("#cancerExpert").val() == "") {
			$(".review_warn ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please enter your cancer expert</li>');
			$("#cancerExpert").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}
		if ($("#clinicLocation").val() == "") {
			$(".review_warn ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please enter clinical location</li>');
			$("#clinicLocation").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}*/
		if(!$(".reviewAbout").is(':checked')){
			$(".review_warn ul")
			.append(
					'<li class="err_msg" style="list-style-type:none;">Please choose your Review about</li>');
		}
		window.scrollTo(0, 0); // Important for scroll top
		return false;
	}
	
	else if($("#text").val() != "" && $("#reviewAnswer_text").val() == ""){
		$("#review_warn_info").addClass("review_warn")
		$(".review_warn ul")
		.append(
				'<li class="err_msg" style="list-style-type:none;">Please answer for '+$('input[name=reviewQuestion]:checked').val()+' </li>');
		/*$("#reviewAnswer_text").css({
			"border-color" : "#bd202e",
			//"border" : "1px solid red",
			"color" : "#bd202e"
		});*/
		window.scrollTo(0, 0); // Important for scroll top
		return false;
	}
	else if($("#radio").val() != undefined && $('input[name="reviewAnswer_radio"]:checked').length == 0){
		$("#review_warn_info").addClass("review_warn")
		$(".review_warn ul")
		.append(
				'<li class="err_msg" style="list-style-type:none;">Please answer for '+$('input[name=reviewQuestion]:checked').val()+' </li>');
		window.scrollTo(0, 0); // Important for scroll top
		return false;
		
	}
	
	else if($("#drop-down").val() != undefined && ($('#treatment').val() == '' || ($("#treatment").val() == 'other' && $("#otherOption").val() == ""))){
		$("#review_warn_info").addClass("review_warn")
		$(".review_warn ul")
		.append(
				'<li class="err_msg" style="list-style-type:none;">Please answer for '+$('input[name=reviewQuestion]:checked').val()+' </li>');
		$("#otherOption").css({
			"border-color" : "#bd202e !important" ,
			"color" : "#bd202e"
		});
		
		window.scrollTo(0, 0); // Important for scroll top
		return false;
		
	}
	else if($("#reviewDate").val() != ""
				&& date_regex.test(dtValue) == false) {
			//$(".review_warn").show();
		$("#review_warn_info").addClass("review_warn")
			$(".review_warn ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Sorry review date format is incorrect</li>');
			$("#clinicLocation").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			});
			window.scrollTo(0, 0); // Important for scroll top
			return false;
		}
};

// For character count in text area
function countChar(val) {
    var len = val.value.length;
    if (len > 500) {
      val.value = val.value.substring(0, 500);
    } else {
      $('#charCounter').text(500-len+(" more characters needed"));
    }
  };
 
  // For Rating star
  $("#rateId1").jRate({
		rating: 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		backgroundColor: "#C8C8C8",
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId11").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId2").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId12").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId3").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId13").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId4").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId14").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId5").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId15").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId6").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId16").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId7").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId17").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId8").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId18").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
	$("#rateId9").jRate({
		rating : 0,
		strokeColor : 'black',
		precision : 1,
		minSelected : 0,
		onChange : function(rating) {
			//console.log("OnChange: Rating: "+rating);
		},
		onSet : function(rating) {
			$("#rateId19").val(rating);
			console.log("OnSet: Rating: " + rating);
		}
	});
  
  
  
  
  