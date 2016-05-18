					var searchKeyword = {
						url : function(phrase) {
							return "../doctor/getdoctors?keyword=" + phrase;
						},
						list : {
							match : {
								enabled : true
							},
							maxNumberOfElements : 10
						},
						template : {
							type : "custom",
							method : function(value, item) {
								return "<img src='../assets/patient-photo/noimage.jpg' width='50' height='50' />"
										+ " " + value;
							}
						}
					// theme: "square"
					};
					var searchLocation = {
						url : function(phrase) {
							return '../doctor/getLocation?location=' + phrase;
						},
						list : {
							match : {
								enabled : true
							},
							maxNumberOfElements : 10
						}
					};
					$("#keyword").easyAutocomplete(searchKeyword);
					$("#location").easyAutocomplete(searchLocation);