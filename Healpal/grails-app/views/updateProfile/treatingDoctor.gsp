<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg highest-box">
						<g:form controller="updateProfile" action="treatingDoctor"
			name="treating">
							<div class="col-md-12 col-xs-12 center-align text-center m-pad-lr pad-lr-0">
							<div class="icon-box-top"><img src="../assets/profile/img/ca11-icon.jpg" /></div>
								<h3 style="font-family: Opensans Light; font-size: 22px; margin-bottom: 20px;">Details of your treating doctor </h3>
								<div class="col-md-9 col-xs-12 center-align text-center m-pad-lr"><input class="textbox text-box1 mar-top-0" type="text" id="treatingDoctor" type="text" name="treatingDoctor"  
								placeholder="Please enter your Treating Doctor Name" value="${doctorName}" onKeyPress="return onlyAlphabets(event);"/></div>
								<div
								class="col-md-12 col-xs-12 center-align text-center mar-top-30">
								<div class="col-md-6">
									<input class="textbox text-box1" id="zipcode" type="text" name="zipcode"
										placeholder="Zip code of Physician" maxlength="5"
										onKeyPress="return checkOnlyNumber(event);" value="${zipCode}" />
								</div>
								<div class="col-md-6">
									<input class="textbox text-box1" id="contactNumber" type="text"
										name="contactNumber" value="${phoneNumber}"
										onKeyPress="return checkOnlyNumber(event);"
										placeholder="Contact number of doctor" maxlength="10" />
								</div>
							</div>
								<div class="box-content2">
									<div class="box-content2-bg"><g:link controller="updateProfile" action="treatingDoctor"
							params="[others:'other']"><h3><span>I do not have a treating physician yet</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg"><g:link controller="updateProfile" action="treatingDoctor"
							params="[others:'other']"><h3><span>I prefer not to answer</span></h3></g:link></div>
								</div>
								<div class="clearfix"></div>
								<g:submitButton name="Save and Continue" class="blue-btn" id="saveTreatingDoctor"/>
								</div>
								<g:hiddenField name="hidden_val" id="hidden_val"/>
								</g:form>
							</div>
							
							</div>
<script src="../js/profile/profile.js"></script>
<script type="text/javascript">
	// To check valid zipcode

	(function($) {

		var requests = {};
		var zipValid = {
			us : /[0-9]{5}(-[0-9]{4})?/
		};

		$.ziptastic = function(country, zip, callback) {

			// If only zip and callback are given default to US
			if (arguments.length == 2 && typeof arguments[1] == 'function') {
				callback = arguments[1];
				zip = arguments[0];
				country = 'US';
			}

			country = country.toUpperCase();
			// Only make unique requests
			if (!requests[country]) {
				requests[country] = {};
			}
			if (!requests[country][zip]) {
				requests[country][zip] = $
						.getJSON('https://zip.getziptastic.com/v2/' + country
								+ '/' + zip);
			}

			// Bind to the finished request
			requests[country][zip].done(function(data) {
				if (typeof callback == 'function') {
					callback(zip);
				}
			});

			// Allow for binding to the deferred object
			return requests[country][zip];
		};

		$.fn.ziptastic = function(options) {
			return this.each(function() {
				var ele = $(this);

				ele.on('keyup change', function() {
					var zip = ele.val();
					$("#hidden_val").val("");
					// TODO Non-US zip codes?
					if (zipValid.us.test(zip)) {
						$("#hidden_val").val("");
						$.ziptastic(zip, function() {
							// Trigger the updated information
							$("#hidden_val").val("correct");
							ele.trigger('zipChange', [ zip ]);
						});
					}
				});
			});
		};
	})(jQuery);
</script>

<script type="text/javascript">
	(function($) {
		$(function() {

			var elements = {
				zip : $('#zipcode')
			}
			elements.zip.ziptastic().on('zipChange', function(evt, zip) {
			});
		});
	}(jQuery));
</script>


