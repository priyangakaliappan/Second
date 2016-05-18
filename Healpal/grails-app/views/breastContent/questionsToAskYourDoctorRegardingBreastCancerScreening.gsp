<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="demo"/>
<title>Insert title here</title>
</head>
<body>
<div class="fixed-header"></div>
  <section class="inner-cont inner-breast">
<div class="container">
<div class="col-lg-4 col-md-5 col-sm-5 col-xs-12 inner-left-cont left-gray-bg inner-breast-pad">
			<div class="left-gray-box-cont">
				<h1 class="text-center">PREVENTION AND EARLY DETECTION</h1>
				<div class="right">
				<ul class="mytimeline mytimeline-2">
					<li>
						<g:link action="mammorgam" controller="breastContent"><div class="badge2"><i class="prevention-early-1"></i> </div>
						<div class="badge2-name"><div class="badge2-table"><span class="badge2-cell">mammogram</span></div></div></g:link>
						<div class="clearfix"></div>
					</li>
					<li>
						<g:link action="additionalScreeningTest" controller="breastContent"> <div class="badge2"><i class="prevention-early-2"></i> </div>
						<div class="badge2-name"><div class="badge2-table"><span class="badge2-cell">Additional screening tests</span></div></div></g:link>
						<div class="clearfix"></div>
					</li>
					<%--<li>
						<g:link action="payingForBreastCancerScreening" controller="breastContent"> <div class="badge2"><i class="prevention-early-3"></i> </div>
						<div class="badge2-name"><div class="badge2-table"><span class="badge2-cell">Paying for breast cancer screening</span></div></div></g:link>
						<div class="clearfix"></div>
					</li>
					<li>
						<g:link action="medicinesToReduceBreast" controller="breastContent"><div class="badge2"><i class="prevention-early-4"></i> </div>
						<div class="badge2-name"><div class="badge2-table"><span class="badge2-cell">Medicines to reduce breast cancer risk</span></div></div></g:link>
						<div class="clearfix"></div>
					</li>
					--%><li>
						<g:link action="ammericanCancerSocietyRecommendationFor" controller="breastContent"><div class="badge2"><i class="prevention-early-5"></i> </div>
						<div class="badge2-name"><div class="badge2-table"><span class="badge2-cell">American cancer society recommendations for early breast cancer detection in women without breast symptoms</span></div></div></g:link>
						<div class="clearfix"></div>
					</li>
					<li class="selected">
						<g:link action="questionsToAskYourDoctorRegardingBreastCancerScreening" controller="breastContent"> <div class="badge2"><i class="bre-about-right-icon-6"></i> </div>
						<div class="badge2-name"><div class="badge2-table"><span class="badge2-cell">questions to ask your doctor regarding breast cancer screening</span></div></div></g:link>
						<div class="clearfix"></div>
					</li>
				</ul>
			</div>
			</div>
			<g:render template="sections"></g:render>
		</div>
		<div class="col-lg-8 col-md-7 col-sm-7 col-xs-12 inner-right-cont right-gray-cont pad-rt-0">
			<h2> QUESTIONS TO ASK YOUR DOCTOR REGARDING BREAST CANCER <br>SCREENING  </h2>
			<p>It is important to ask your doctor about the details of breast cancer screening. The following section serves as a guideline for the questions that you may ask your doctor regarding your breast cancer screening procedure.</p>
			<div class="row">
				<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li ><img src="${resource(dir:'assets/image/prevention/question',file:'a.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span><span class="caption-text">Questions to ask your doctor regarding breast cancer screening.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/prevention/question',file:'b.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Questions regarding the procedure.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/prevention/question',file:'c.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Questions regarding the procedure.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/prevention/question',file:'d.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Questions regarding the procedure.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/prevention/question',file:'e.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Questions regarding specific situations.
</span></span></p>
						</li>
						<li> 
							<g:render template="rate"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" class="event"/>
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text"></span></span></p>
						</li>
					</ul>
					<!-- end Basic jQuery Slider -->
				</div>
			</div>
			<div class="clearfix"></div>
<div class="clearfix visible-xs">&nbsp;</div>
<div class="clearfix visible-xs">&nbsp;</div>
<div class="col-sm-2 center-empty-box"></div>
<div class="text-center center-box col-sm-12 pad-lr-0">
				<div class="col-sm-12 col-xs-12 pad-lr-0">
					<g:render template="enterComment"></g:render>
					</div>
			<div class="col-sm-12 col-xs-12 pad-lt-0">
					<div class="pull-left">
						<i class="fa fa-comment pull-left"></i>
						<p class="pull-left"><strong>Comment</strong></p>
					</div>	
					<div class="pull-right orange-text-rt">(You need to be signed in to comment)</div>
					<div class="clearfix"></div>
					<div class="comment-cont" id="comments">
						<g:render template="comment"></g:render> 
					</div>
				</div>	
			</div>	
		</div>
		</div>
		</div>
	</section>	
	<!--end here-->
	<!--end here-->      
	<script src="${resource(dir:'assets/js',file:'bjqs-1.3.min.js')}"></script>
	<script src="${resource(dir:'js',file:'slider.js')}"></script>
	 <!-- End outer wrapper -->
	 <script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script src="${resource(dir:'js',file:'sliderButt.js')}"></script>  
</body>
</html>