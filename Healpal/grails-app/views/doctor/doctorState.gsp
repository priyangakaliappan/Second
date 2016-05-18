<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: doctors city of state
 *
 * #      Name         Version      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga      1.0          	Initial Creation
 * 2   Priyanga      2.0            Modification
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="demo"/>
<title>Find Doctor</title>
</head>
<body>
  <section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div id="header-links">
						<g:link controller="home" action="index" class="logo">Home</g:link><span> > </span><a href="../home/findDoctor">Find a Doctor</a><span> > </span><a href="">${location } doctors</a>
					</div>
					<h2>${city} Doctors</h2>
					<div class="search-box-bg">
					<g:form controller="doctor" action="searchDoctors">
						<div class="col-sm-5 col-xs-12"><input type="text" placeholder="Search for a doctor or treatment" class="search-text-box" id="keyword" ></div>
						<div class="col-sm-5 col-xs-12"><input type="text" placeholder="Near You" class="location-text-box" id="location" value="${location}"></div>
						<div class="col-sm-2 col-xs-12">
						<a href="../doctor/searchDoctors" class="search-doctor search-btn-s">Search</a>
						</div>
					</g:form>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 find-doctors">
						<h4>Choose a city to view doctors:</h4>
							<div class="col-sm-3 col-xs-12 pad-lr-0">
						<g:if test="${cityList}">
							<ul>
							<g:each in="${cityList}" var="record" status="i">
								<g:if test="${i<=10 }">
								<li><a href="../doctor/doctorCity" class="city">${record?.city}</a></li>
								</g:if>
							</g:each>
							</ul>
							</g:if>
						</div>
							</div>
					<div class="col-md-4 col-sm-4 find-doctors-sidebar">
						<h3>NEARBY SPECIAL OFFERS</h3>
						<ul>
							<li>
								<div class="doctors-list-left"><img class="img-responsive" src="../assets/new-design/img/doc-img1.jpg"></div>
								<div class="doctors-list-right">
									<div><span class="orange-text">John Slater,</span> MD</div>
									<div>Medical Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left"><img class="img-responsive" src="../assets/new-design/img/doc-img2.jpg"></div>
								<div class="doctors-list-right">
									<div><span class="orange-text">John Slater,</span> MD</div>
									<div>Breast Cancer Surgeon</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left"><img class="img-responsive" src="../assets/new-design/img/doc-img3.jpg"></div>
								<div class="doctors-list-right">
									<div><span class="orange-text">John Slater,</span> MD</div>
									<div>Medical Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left"><img class="img-responsive" src="../assets/new-design/img/doc-img4.jpg"></div>
								<div class="doctors-list-right">
									<div><span class="orange-text">John Slater,</span> MD</div>
									<div>Radiation Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
										</div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div>
							</li>
							<li>
								<div class="doctors-list-left"><img class="img-responsive" src="../assets/new-design/img/doc-img-sml5.jpg"></div>
								<div class="doctors-list-right">
									<div><span class="orange-text">John Slater,</span> MD</div>
									<div>Medical Oncologist</div>
									<div>
										<div class="star-icon pull-left">
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
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
<script type="text/javascript" src="${resource(dir:'js/doctor',file:'jquery.easy-autocomplete.min.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/doctor',file:'autocomplete.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/doctor',file:'find_doctors.js')}"></script>
</body>
</html>