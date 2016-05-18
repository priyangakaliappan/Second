

function saveCancerStatus(value){
	if(value != null && value != ""){
		$.ajax({
			async : false,
			type : 'POST',
			url : '../profile/updateCancerStatus',
			data : {value:value},
			success : function(res) {
				//do nothing
			}
		});
	}
}