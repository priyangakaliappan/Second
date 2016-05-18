// for menu active
$(document).ready(function() {
	$('#search-bar').click(function() {
		$('.search-active').addClass("active");
	});
	$('#search-toggle').click(function() {
		$('#collapseOne').toggle();
		$('.learn-active').removeClass("active");
		$('.match-active').removeClass("active");
		$('.connect-active').removeClass("active");
		$('.how-active').removeClass("active");
	});

	$('#signin').click(function() {
		$('#patient_login_form').trigger("reset");
		$('#collapseOne').hide();
	});
	$(".learn-active").click(function() {
		$('#collapseOne').hide();
		$('.learn-active').addClass("active");
		$('.match-active').removeClass("active");
		$('.connect-active').removeClass("active");
		$('.how-active').removeClass("active");
		$('.search-active').removeClass("active");
	});
	$(".match-active").click(function() {
		$('#collapseOne').hide();
		$('.learn-active').removeClass("active");
		$('.match-active').addClass("active");
		$('.connect-active').removeClass("active");
		$('.how-active').removeClass("active");
		$('.search-active').removeClass("active");
	});
	$(".connect-active").click(function() {
		$('#collapseOne').hide();
		$('.learn-active').removeClass("active");
		$('.match-active').removeClass("active");
		$('.how-active').removeClass("active");
		$('.connect-active').addClass("active");
		$('.search-active').removeClass("active");
	});
	$(".how-active").click(function() {
		$('#collapseOne').hide();
		$('.how-active').addClass("active");
		$('.learn-active').removeClass("active");
		$('.match-active').removeClass("active");
		$('.connect-active').removeClass("active");
		$('.search-active').removeClass("active");
	});
});