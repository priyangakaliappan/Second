(function($) {
                $(function() {
                    var duration = 10;
                    var elements = {
                        country: $('#country'),
                        state: $('#state'),
                        state_short: $('#state-short'),
                        city: $('#city'),
                        zip: $('#zip')
                    }
                    // Initially hide the city/state/zip
                  elements.country.parent().hide();
                    elements.state.parent().hide();
                    elements.state_short.parent().hide();
                    elements.city.parent().hide();
                    // Initialize the ziptastic and bind to the change of zip code
                    elements.zip.ziptastic()
                        .on('zipChange', function(evt, country, state, state_short, city, zip) {
                            // Country
                            elements.country.val(country).parent().show(duration);
                            // State
                            elements.state_short.val(state_short).parent().show(duration);
                            elements.state.val(state).parent().show(duration);
                            // City
                            elements.city.val(city).parent().show(duration);
                        });
                });
            }(jQuery));