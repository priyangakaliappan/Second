<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg">
						<div class="icon-box-top text-center"><img src="../assets/profile/img/c5-icon.jpg" /></div>
							<div class="text-center">
								<h1>Where do you live?</h1>
								<g:form controller="updateProfile" action="whereDoYouLive"
				name="address" autocomplete="off">
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
									<div class="col-sm-6 m-pad-lr  pad-lt-0">
									<input type="text" class="textbox text-box1" id="zip" name="zip" value="${zipCode}" placeholder="Zip/ Postal code" maxlength="5" onKeyPress="return checkOnlyNumber(event);"/>
									</div>
									<div class="col-sm-6 m-pad-lr  pad-lt-0">
										<input type="text" id="city" class="textbox text-box1" value="${city}" placeholder="City"  name="city" readonly="readonly"/>
									</div>
									</div>
									<div class="col-md-12 m-pad-lr  pad-lr-0">
									<div class="col-sm-6 m-pad-lr pad-lt-0">
										<input type="text" id="state" placeholder="State" class="textbox text-box1" value="${state}" name="state" readonly="readonly"/>
									</div>
									<div class="col-sm-6 m-pad-lr  pad-lt-0">
										 <input type="text" id="country" placeholder="Country" name="country" value="${country}" class="textbox text-box1" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-12 m-pad-lr">
								<span id="zip_warn" style="font-size: 19px;"></span>
								</div>
								<div class="clearfix mar-bot-30"></div>
								<g:submitButton name="Save and continue" class="blue-btn" id="savelive"/>
								</g:form>
								</div>
							</div>
							</div>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script type="text/javascript"
	src="${resource(dir:'assets/js/forgot',file:'jquery.ziptastic.js')}"></script>
<script type="text/javascript">
	// Automatic calculations of state,city and country for valid zipcode
	(function($) {
		$(function() {
			var duration = 200;
			var elements = {
				country : $('#country'),
				state : $('#state'),
				state_short : $('#state-short'),
				city : $('#city'),
				zip : $('#zip')
			}
			// Initially hide the city/state/zip
			//elements.country.parent().hide();
			//elements.state.parent().hide();
			//elements.state_short.parent().hide();
			//elements.city.parent().hide();
			// Initialize the ziptastic and bind to the change of zip code
			elements.zip.ziptastic().on(
					'zipChange',
					function(evt, country, state, state_short, city, zip) {
						// Country
						elements.country.val(country).parent().show(duration);
						// State
						elements.state_short.val(state_short).parent().show(
								duration);
						elements.state.val(state).parent().show(duration);
						// City
						elements.city.val(city).parent().show(duration);
					});
		});
	}(jQuery));
</script>
<script>
	$("#savelive").click(function() {
		if ($("#zip").val() == "" || $("#zip").val() == null) {
			alert("Please enter Zip Code");
			return false;
		} else if ($("#city").val() == "" || $("#city").val() == null) {
			alert("Zip Code not valid");
			return false;
		} else if ($("#state").val() == "" || $("#state").val() == null) {
			alert("Zip Code not valid");
			return false;
		} else if ($("#country").val() == "" || $("#country").val() == null) {
			alert("Zip Code not valid");
			return false;
		} else {
			return true;
		}
	});
</script>
