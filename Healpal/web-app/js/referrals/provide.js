$("document").ready(function(){
	if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
		 	$('.desktop').attr('disabled','true');
		 	$(".mobile").prop("disabled", false);
		} else {
			$(".desktop").prop("disabled", false);
			$('.mobile').attr('disabled','true');
		}
});

$("#d9 ,#d11,#dd9 ,#dd11 ,#dd13 ,#dd14").keydown(function (event) {

    if (event.shiftKey == true) {
        event.preventDefault();
    }

    if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105) || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 190) {

    } else {
        event.preventDefault();
    }

});


//$("#d13 ,#d14,#dd13 ,#dd14").keydown(function (event) {
//	
//    if (event.shiftKey == true) {
//        event.preventDefault();
//    }
//
//    if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105) || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 190) {
//
//    } else {
//        event.preventDefault();
//    }
//
//});


