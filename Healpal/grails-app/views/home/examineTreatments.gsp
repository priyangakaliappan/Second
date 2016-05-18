<%--
 *
 * Author  		: Subhapriya M
 * Project 		: HealPal
 * Date    		: 29/01/2016
 * FileName 	: learn
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Subhapriya M     1.0    29/01/2016      Initial Creation
 * 
 *
 */
--%>
<%@page import="com.healpal.care.Diagnosis"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>Learn</title>
</head>
<body>
	
	<section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 find-doctors">
						<h2>Examine Treatments</h2>
						<div class="txt-15">Find cancer treatments reviewed by patients in the HealPal community. You can also share your personal experience regarding your cancer treatment. <g:link controller="home" action="writeAReview">Write a review &gt;</g:link></div>
						<div class="col-md-9 col-xs-12 pad-lr-0">
							<g:select class="gray-select" id="diagnosis" name="diagnosis"
   							 noSelection="${['null':'Please Select One']}"
    						from='${Diagnosis?.list()}'
    						optionKey="id" optionValue="diagnosisName"></g:select>
						</div>
						<div class="clearfix"></div>
						<%--<div class="category-txt"><strong>Sort by:</strong> <a href="JavaScript:void(0)">Type</a> | <a href="JavaScript:void(0)">Location</a> | <a href="JavaScript:void(0)">Number of reviews</a> | <a href="JavaScript:void(0)">Rating</a></div>
						--%><div class="clearfix"></div>
						<div class="col-sm-6 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="#">Hormone therapy</a></li>
								<li><a href="#">Immunotherapy</a></li>
							</ul>
						</div>
						<div class="col-sm-6 col-xs-12 pad-lr-0">
							<ul>
								<li><a href="#">Radiation therapy</a></li>
								<li><a href="#">Targeted therapy</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 find-doctors-sidebar">
						<h3>Choose a Cancer Experts </h3>
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
	
	


</body>
</html>

