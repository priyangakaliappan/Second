
function checkPassword(str)
  {
    // at least one number, one lowercase and one uppercase letter
    // at least six characters that are letters, numbers or the underscore
   // var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
	var re= /(?=.*\d)(?=.*[A-Z]).{6,}/;
    return re.test(str);
  }
$("document").ready(function(e) {
	$("#err").hide();

	/*
	 * Update password
	 * */
	$("#resetForm").submit(function() {
		$("#err").hide();
		
		
		$("#err").html("");
		//$("#err").css({color:'red'});
		

		var pwd = $.trim($("#newPassword").val());
		var cpwd = $.trim($("#confirmPassword").val());

		var hiddenUserId = $.trim($("#hiddenUserIdd").val());
		//alert(hiddenUserId);
		var tempAnswer1 = null;

		if (pwd == '') {
			$("#err").show();
			$("#err").html("Please enter new password");
			$("#newPassword").focus();
			return false;
		} else if (cpwd == '') {
			$("#err").show();
			$("#err").html("Please enter confirm password");
			$("#confirmPassword").focus();
			return false;
		}
		
		else if(pwd.length<6)
		{
		$("#err").show();
		$("#err").html("Password should be atleast 6 characters long");
		 $("#newPassword").focus();
		return false;
		}
		/*else if(pwd != "" && pwd == cpwd) {
		    //  if(!checkPassword(pwd)) {
		    	  $("#err").show();
		    	//  $("#err").html("Password should be atleast 6 characters long and must contain a Caps and a number");
		    	  $("#err").html("Password should be atleast 6 characters long");
		          $("#newPassword").focus();
		          return false;
		        //}
		      }*/
		
		else if (pwd.length != 0 && cpwd.length != 0) {
			if (pwd != cpwd) {
				$("#err").show();
				$("#err").html("password do not match");
				$("#newPassword").val("");
				$("#confirmPassword").val("");
				$("#newPassword").focus();
				return false;
			} else {
				//alert("inside ajax");
				$.ajax({
					type : 'POST',
					async : false,
					url : "../forgotPassword/reset",
					data : "hiddenUserId=" + hiddenUserId,
					success : function(res) {
						tempAnswer1 = res;
					}
				});
			}

		}

	});

});