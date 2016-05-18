$("document").ready(function(e) {
	
	
	$("#err").hide();

	/*
	 * Update password
	 * */
	$("#password").submit(function() {
		
		
		$("#err").hide();
		$("#err").html("");
		//$("#userErr").html("");
		
		//$("#err,#userErr").css({color:'red'});//css({color:'#f37021'});
		var name=$.trim($("#form_email").val());
		
			if(name==""){
				$("#err").show();
				$("#err").html("Please enter email");
				$("#form_email").focus();
				return false;
			}
			

	});
	/*$('.check-layout').click(function(){
		$('#loginPath').val('home layout');
	})*/
});


