$("document").ready(function(){
	
	

	//***** Saving Comments
	$("#commentId").keyup(function(event){ 
		var keycode = (event.keyCode ? event.keyCode : event.which);
        if(keycode == '13' && $("#commentId").val().length >0){
            //alert('You pressed a "enter" key in textbox');
        	$.ajax({
        		type:'POST',
        		async:false,
        		url:'../BreastContent/commentSave',
        		data:{
        			section:$("#sectionId").val(),
        			page:$("#pageId").val(),
        			message:$("#commentId").val(),
        		},
        		success:function(res){
        			//if(res != 'Thanks' || res != 'You need to be signed in to comment'){
        				$("#comments").html(res);
        				$("#commentId").val("");
        		}
        	});
        }
        event.stopPropagation();
	});
	
	
	
	
});

function rateMe(section ,page ,type){
	$.ajax({
		async : false,
		type : 'POST',
		url : '../BreastContent/saveRate',
		data :{
			section : section,
			page : page,
			type : type
		},
		success : function(res) {
			alert(res);
		}
	});
}


/*function rateMe(){
	alert('Thanks a lot for your response. We shall have more information coming soon')
}*/

