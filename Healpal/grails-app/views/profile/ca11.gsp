<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="createProfile"/>
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
 <div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form controller="profile" action="ca11" name="treating">
							<div class="col-md-10 col-xs-12 center-align  text-center m-pad-lr">
							<div class="icon-box-top"><img src="../assets/profile/img/ca11-icon.jpg" /></div>
								<h1>Details of your treating doctor </h1>
								<div class="col-md-9 col-xs-12 center-align text-center m-pad-lr"><input class="textbox text-box1 mar-top-0" type="text" id="treatingDoctor" type="text" name="treatingDoctor"  
								placeholder="Please enter your Treating Doctor Name" onKeyPress="return onlyAlphabets(event);"/></div>
								<div
								class="col-md-12 col-xs-12 center-align text-center mar-top-30">
								<g:hiddenField name="doctorId" value="${treatingDoctor}" />
								<div class="col-md-6 pad-rt-0">
									<input class="textbox text-box1" id="zipcode" type="text" name="zipcode"
										placeholder="Zip code of Physician" maxlength="5"
										onKeyPress="return checkOnlyNumber(event);" />
								</div>
								<div class="col-md-6 pad-rt-0">
									<input class="textbox text-box1" id="contactNumber" type="text"
										name="contactNumber"
										onKeyPress="return checkOnlyNumber(event);"
										placeholder="Contact number of doctor" maxlength="10" />
								</div>
							</div>
								<div class="box-content2">
									<div class="box-content2-bg"><g:link controller="profile" action="ca13"><h3><span>I do not have a treating physician yet</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg"><g:link controller="profile" action="ca13"><h3><span>I prefer not to answer</span></h3></g:link></div>
								</div>
								<div class="clearfix"></div>
								<g:submitButton name="Save and Continue" class="blue-btn" id="saveTreatingDoctor"/>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:hiddenField name="hidden_val" id="hidden_val"/>
								<g:link action="ca10" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:form>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">12/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>0 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
							</div>
							</div></div></section>
							<%--<section>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">12/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>0 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
					--%><script type="text/javascript">
					(function( $ ) {
						
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
									callback(zip);
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
									$("#hidden_val").val("");
									// TODO Non-US zip codes?
									if(zipValid.us.test(zip)) {
										$("#hidden_val").val("");
										$.ziptastic(zip, function() {
											// Trigger the updated information
											$("#hidden_val").val("correct");
											ele.trigger('zipChange', [zip]);
										});
									}
								});
							});
						};
					})( jQuery );



					</script>
					
					<script type="text/javascript">

					(function($) {
		                $(function() {
		                   
		                    var elements = {
		                        zip: $('#zipcode')
		                    }
		                    elements.zip.ziptastic()
		                        .on('zipChange', function(evt,zip) {
		                        });
		                });
		            }(jQuery));

					</script>
</body>
</html>