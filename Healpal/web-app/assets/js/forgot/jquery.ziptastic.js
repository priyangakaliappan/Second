(function( $ ) {
if (typeof jQuery !== 'undefined') {
		
		(function($) {
			$('#spinner').ajaxStart(function() {
				$(this).fadeIn();
			}).ajaxStop(function() {
				$(this).fadeOut();
			});
		})(jQuery);
	}

	
	var requests = {};
	var zipValid = {
		us: /[0-9]{5}(-[0-9]{4})?/
	};

	$.ziptastic = function(country, zip, callback){
		
		// If only zip and callback are given default to US
		if (arguments.length == 2 && typeof arguments[1] == 'function') {
			callback = arguments[1];
			zip = arguments[0];
			country = 'US';
		}

		country = country.toUpperCase();
		// Only make unique requests
		if(!requests[country]) {
			requests[country] = {};
		}
		if(!requests[country][zip]) {
			requests[country][zip] = $.getJSON('https://zip.getziptastic.com/v2/' + country + '/' + zip);
		}

		// Bind to the finished request
		requests[country][zip].done(function(data) {
			if (typeof callback == 'function') {
				callback(data.country, data.state, data.state_short, data.city, zip);
			}
		});

		// Allow for binding to the deferred object
		return requests[country][zip];
	};

	$.fn.ziptastic = function( options ) {
		return this.each(function() {
			var ele = $(this);

			ele.on('keyup change', function() {
				var zip = ele.val();
				
				// TODO Non-US zip codes?
				if(zipValid.us.test(zip)) {
					jQuery('#spin').show(); 
					$("#zip_warn").hide();
					setTimeout(function(){ 
						jQuery('#spin').hide();
						$("#zip_warn").show();
						
					}, 10000);
					
					
					$.ziptastic(zip, function(country, state, state_short, city) {
						// Trigger the updated information
						 
						jQuery('#spin').hide(); 
						
						ele.trigger('zipChange', [country, state, state_short, city, zip]);
						
						$('#savelive').attr('disabled',false);
						$('#savelive').css("cursor", "pointer");
						$("#zip_warn").html("");
					});
					
				}else{
					$("#zip_warn").hide();
					 var elements = {
		                        country: $('#country'),
		                        state: $('#state'),
		                        state_short: $('#state-short'),
		                        city: $('#city'),
		                        zip: $('#zip')
		                    }
					 
					 $('#city').val(null);
					 $('#state').val(null);
					 $('#country').val(null);	
					 if($("#zip").val()!=null && $("#zip").val()!=""){
					 $("#zip_warn").html("Sorry, Zipcode is not valid");
					 
					 }
					 else{
						 jQuery('#spin').hide(); 
						
					 }
					 $('#savelive').attr('disabled',true);
					 $('#savelive').css("cursor", "not-allowed");
		                    // Initially hide the city/state/zip
		                  elements.country.parent().hide();
		                    elements.state.parent().hide();
		                    elements.state_short.parent().hide();
		                    elements.city.parent().hide();
				}
			});
		});
	};
})( jQuery );
