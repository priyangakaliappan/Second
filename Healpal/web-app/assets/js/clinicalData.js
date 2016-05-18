

function saveClinical(value){
	if(value != null && value != ""){
		alert(value)
		$.ajax({
			async : false,
			type : 'POST',
			url : '../profile/clinicalSelect',
			data : {clinicalValue:value},
			success : function(res) {
				//do nothing
			}
		});
	}
}