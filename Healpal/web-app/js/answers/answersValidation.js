$(document).ready(function() {	
							if ($("#sigin_rule").val() == "") {
								$("#review_warn_info").addClass("review_warn")
								$(".review_warn ul")
										.append(
												'<li class="alert alert-danger" style="list-style-type:none;">Please <a href="#" class="sign_link check-layout" data-toggle="modal" data-target="#signin">Sign in</a> to write your Question</li>');
										}
							
						});

// For Required fields validation
$("#alertHide").hide();
function check() {
	
	$("li.err_msg").remove();
	$("#flash_msg").remove();
	
	
	if ($("#concise").val() == "" || $("#location").val() == "") {
		
		$(".alert-danger ul")
		$(".alert-danger").show();
		
		if ($("#concise").val() == "") {
			$(".alert-danger ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please write Your Question</li>');
			$("#concise").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}
		if ($("#location").val() == "") {
			$(".alert-danger ul")
					.append(
							'<li class="err_msg" style="list-style-type:none;">Please enter Your Location</li>');
			$("#location").css({
				"border-color" : "#bd202e",
				"color" : "#bd202e"
			})
		}
		
		
		
		window.scrollTo(0, 0); // Important for scroll top
		return false;
	}
	
	
};


 

  
	
	
	
	
	
  
  
  
  
  