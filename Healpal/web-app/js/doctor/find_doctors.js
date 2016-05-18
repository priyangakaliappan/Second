$(document).ready(
		function() {
			$(".search-doctor").click(
					function() {
						$("#header-links").hide();
						var keyword = $("#keyword").val();
						var location = $("#location").val();
						if (keyword != "" && location != "") {
							$(this).attr('href','../doctor/searchDoctors?keyword='+ keyword + '&location='+ location);
						} else {
							if (keyword == "") {
								$("#keyword").focus();
							} else if (location == "") {
								$("#location").focus();
							}
							return false;
						}
					});
		});