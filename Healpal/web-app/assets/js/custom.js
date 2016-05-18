$(document).ready(function(){
    //$(".from, .to").datepicker();
	
	/***********adding display block below 768***********/
	/**/$(window).resize(function(){
		var win_width = $(this).width();
		if(win_width <768){
			$(".navbar-nav-fix .navbar-nav li").css("display","block");	
		} else {
			$(".navbar-nav-fix .navbar-nav li").css("display","table-cell");	
		}
	});
	var win_width = $(this).width();
	if(win_width <768){
		$(".navbar-nav-fix .navbar-nav li").css("display","block");	
	} else {
		$(".navbar-nav-fix .navbar-nav li").css("display","table-cell");	
	}

		/***********adding display block below 768***********/
		
	//tooltip BS
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});

});

//script for browse file
$(document).on('change', '.btn-file :file', function() {
  var input = $(this),
	  numFiles = input.get(0).files ? input.get(0).files.length : 1,
	  label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
  input.trigger('fileselect', [numFiles, label]);
});

$(document).ready( function() {
  $('.btn-file :file').on('fileselect', function(event, numFiles, label) {
		
		var input = $(this).parents('.input-group').find(':text'),
			log = numFiles > 1 ? numFiles + ' files selected' : label;
		
		if( input.length ) {
			input.val(log);
		} else {
		  if( log ) alert(log);
		}
  });
  
  /***********breast cancer em************/   
	var doc_height = $(".orange-bg2").height();
	var doc_height2 = doc_height+60;
	$("#em").css("min-height",doc_height2+"px");
	
	//var doc_height = $(".orange-bg2").height();
	$("#em2").css("min-height",doc_height2+"px");	
	
	/*var cancer_grey_left = $(".cancer-grey-left").height();
	$(window).load(function(){
		var win_width = $(this).width();
		if(win_width <768){
			$("#em2").css("top",cancer_grey_left+"px");	
		} else {
			$("#em2").css("top","auto");	
		}
	});*/
	
	$(".nav li a[href^='#']").on('click', function(e) {
	   // prevent default anchor click behavior
	   e.preventDefault();
	   // store hash
	   var hash = this.hash;
	   // animate
	   $('html, body').animate({
		   scrollTop: $(this.hash).offset().top
		 }, 300, function(){
		   // when done, add hash to url
		   // (default click behaviour)
		   window.location.hash = hash;
		 });
	});
	
	$(".logo a[href^='#']").on('click', function(e) {
	   // prevent default anchor click behavior
	   e.preventDefault();
	   // store hash
	   var hash = this.hash;
	   // animate
	   $('html, body').animate({
		   scrollTop: $(this.hash).offset().top
		 }, 300, function(){
		   // when done, add hash to url
		   // (default click behaviour)
		   window.location.hash = hash;
		 });
	});
	
});
