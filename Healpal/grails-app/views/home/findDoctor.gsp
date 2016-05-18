<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: find a doctor
 *
 * #      Name         Version      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga      1.0          	Initial Creation
 * 2   Priyanga      2.0            Modification
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>Find Doctor</title>
</head>
<body>
	<section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div id="header-links">
						<g:link controller="home" action="index" class="logo">Home</g:link>
						<span> > </span><a href="findDoctor">Find a Doctor</a>
					</div>
					<h2>Find the Right Doctor for Your Cancer Treatment</h2>
					<div class="search-box-bg">
						<g:form controller="doctor" action="searchDoctors">
							<div class="col-sm-5 col-xs-12">
								<input type="text" placeholder="Search for a doctor or treatment" class="search-text-box okok" id="keyword">
							</div>
							<div class="col-sm-5 col-xs-12">
								<input type="text" placeholder="Near You" class="location-text-box" id="location">
							</div>
							<div class="col-sm-2 col-xs-12">
								<a href="#" class="search-btn-s search-doctor">Search</a>
							</div>
						</g:form>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 find-doctors">
						<h4>Find Doctors by City</h4>
						<div class="col-sm-3 col-xs-12 pad-lr-0">
							<g:if test="${city}">
								<ul>
									<g:each in="${city}" var="record" status="i">
										<li><a href="../doctor/doctorCity" class="city">${record}</a></li>
									</g:each>
								</ul>
							</g:if>
						</div>
						<%--<div class="col-sm-3 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="JavaScript:void(0)">Columbus</a></li>
								<li><a href="JavaScript:void(0)">Dallas</a></li>
								<li><a href="JavaScript:void(0)">Denver</a></li>
								<li><a href="JavaScript:void(0)">Detroit</a></li>
								<li><a href="JavaScript:void(0)">Eugene</a></li>
							</ul>
						</div>
						<div class="col-sm-3 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="JavaScript:void(0)">Fort Myers</a></li>
								<li><a href="JavaScript:void(0)">Greensboro</a></li>
								<li><a href="JavaScript:void(0)">Hartford</a></li>
								<li><a href="JavaScript:void(0)">Houston</a></li>
								<li><a href="JavaScript:void(0)">Indianapolis</a></li>
							</ul>
						</div>--%>
						<div class="clearfix"></div>
						<h4>Find Doctors by State</h4>
						<div class="col-sm-3 col-xs-12 pad-lr-0">
							<g:if test="${state}">
								<ul>
									<g:each in="${state}" var="record" status="i">
										<g:if test="${i<=10 }">
											<li><a href="../doctor/doctorState" class="state">${record}</a></li>
										</g:if>
									</g:each>
								</ul>
							</g:if>
						</div>
						<%--<li><a href="JavaScript:void(0)">Arizona</a></li>
								<li><a href="JavaScript:void(0)">Arkansas</a></li>
								<li><a href="JavaScript:void(0)">California</a></li>
								<li><a href="JavaScript:void(0)">Colorado</a></li>
								<li><a href="JavaScript:void(0)">Connecticut</a></li>
								<li><a href="JavaScript:void(0)">Delaware</a></li>
								<li><a href="JavaScript:void(0)">Florida</a></li>
								<li><a href="JavaScript:void(0)">Georgia</a></li>
								<li><a href="JavaScript:void(0)">Hawaii</a></li>
								<li><a href="JavaScript:void(0)">Idaho</a></li>
								<li><a href="JavaScript:void(0)">Illinois</a></li>
							</ul>
						</div>
						<div class="col-sm-3 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="JavaScript:void(0)">Indiana</a></li>
								<li><a href="JavaScript:void(0)">Iowa</a></li>
								<li><a href="JavaScript:void(0)">Kansas</a></li>
								<li><a href="JavaScript:void(0)">Kentucky</a></li>
								<li><a href="JavaScript:void(0)">Louisiana</a></li>
								<li><a href="JavaScript:void(0)">Maine</a></li>
								<li><a href="JavaScript:void(0)">Maryland</a></li>
								<li><a href="JavaScript:void(0)">Massachusetts</a></li>
								<li><a href="JavaScript:void(0)">Michigan</a></li>
								<li><a href="JavaScript:void(0)">Minnesota</a></li>
								<li><a href="JavaScript:void(0)">Mississippi</a></li>
								<li><a href="JavaScript:void(0)">Missouri</a></li>
								<li><a href="JavaScript:void(0)">Montana</a></li>
							</ul>
						</div>
						<div class="col-sm-3 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="JavaScript:void(0)">Nebraska</a></li>
								<li><a href="JavaScript:void(0)">Nevada</a></li>
								<li><a href="JavaScript:void(0)">New Hampshire</a></li>
								<li><a href="JavaScript:void(0)">New Jersey</a></li>
								<li><a href="JavaScript:void(0)">New Mexico</a></li>
								<li><a href="JavaScript:void(0)">New York</a></li>
								<li><a href="JavaScript:void(0)&nbsp">North Carolina</a></li>
								<li><a href="JavaScript:void(0)">North Dakota</a></li>
								<li><a href="JavaScript:void(0)">Ohio</a></li>
								<li><a href="JavaScript:void(0)">Oklahoma</a></li>
								<li><a href="JavaScript:void(0)">Oregon</a></li>
								<li><a href="JavaScript:void(0)">Pennsylvania</a></li>
								<li><a href="JavaScript:void(0)">Puerto Rico</a></li>
							</ul>
						</div>
						<div class="col-sm-3 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="JavaScript:void(0)">Rhode Island</a></li>
								<li><a href="JavaScript:void(0)">South Carolina</a></li>
								<li><a href="JavaScript:void(0)">South Dakota</a></li>
								<li><a href="JavaScript:void(0)">Tennessee</a></li>
								<li><a href="JavaScript:void(0)">Texas</a></li>
								<li><a href="JavaScript:void(0)">Utah</a></li>
								<li><a href="JavaScript:void(0)">Vermont</a></li>
								<li><a href="JavaScript:void(0)">Virginia</a></li>
								<li><a href="JavaScript:void(0)">Washington</a></li>
								<li><a href="JavaScript:void(0)">Washington DC</a></li>
								<li><a href="JavaScript:void(0)">West Virginia</a></li>
								<li><a href="JavaScript:void(0)">Wisconsin</a></li>
								<li><a href="JavaScript:void(0)">Wyoming</a></li>
								<li><a href="JavaScript:void(0)">Indianapolis</a></li>
							</ul>
						</div>					
					--%>
					</div>
					<div class="col-md-4 col-sm-4 find-doctors-sidebar">
						<h3>Recommended Cancer Experts</h3>
						<ul>
							<li>
								<div class="doctors-list-left">
									<img class="img-responsive" src="../assets/new-design/img/doc-img1.jpg">
								</div>
								<div class="doctors-list-right">
									<div>
										<span class="orange-text">John Slater,</span> MD
									</div>
									<div>Medical Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left">
									<img class="img-responsive" src="../assets/new-design/img/doc-img2.jpg">
								</div>
								<div class="doctors-list-right">
									<div>
										<span class="orange-text">John Slater,</span> MD
									</div>
									<div>Breast Cancer Surgeon</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left">
									<img class="img-responsive" src="../assets/new-design/img/doc-img3.jpg">
								</div>
								<div class="doctors-list-right">
									<div>
										<span class="orange-text">John Slater,</span> MD
									</div>
									<div>Medical Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left">
									<img class="img-responsive" src="../assets/new-design/img/doc-img4.jpg">
								</div>
								<div class="doctors-list-right">
									<div>
										<span class="orange-text">John Slater,</span> MD
									</div>
									<div>Radiation Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left">
									<img class="img-responsive" src="../assets/new-design/img/doc-img-sml5.jpg">
								</div>
								<div class="doctors-list-right">
									<div>
										<span class="orange-text">John Slater,</span> MD
									</div>
									<div>Medical Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="orange-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a> <a
												class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript"
		src="${resource(dir:'js/doctor',file:'jquery.easy-autocomplete.min.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/doctor',file:'autocomplete.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/doctor',file:'find_doctors.js')}"></script>
<script type="text/javascript">
$("document").ready(function(){
	$(".city").click(function(){
		var city = $(this).text();
		$(this).attr('href','../doctor/doctorCity?city='+city);
	});
	$(".state").click(function(){
		var state = $(this).text();
		$(this).attr('href','../doctor/doctorState?location='+state);
	});
});
</script>
</body>
</html>