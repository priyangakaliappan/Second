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
				<h1>TREATMENT OPTIONS</h1>
				<div class="right">
				<g:render template="/template/treatment"></g:render>
			</div>
			</div>
			<g:render template="sections"></g:render>
		</div>
		<div class="col-lg-8 col-md-7 col-sm-7 col-xs-12 inner-right-cont right-gray-cont pad-rt-0">
			<h2>TREATMENT BASED ON STAGING</h2>
			<p>Treatment for breast cancer usually depends on the stage and type of of cancer. It  usually involves some combination of surgery, radiation therapy, chemotherapy, hormone therapy and/or targeted therapy
</p>
			<div class="row">
				<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs" style="text-align: left;">
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'1.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span> <span class="caption-text">Treatment based on staging</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'2.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text" >Stage 0 or Ductal Carcinoma In Situ :<br></span></span><span class="no-bold treat-4" style="line-height: 22px!important">Surgery (with or without radiation therapy) is recommended for the treatment of DCIS. After surgery and radiation therapy, some women may take hormone therapy. Chemotherapy is not needed.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'3.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text" >Stage 1 Breast Cancer :<br></span></span><span class="no-bold treat-4" style="line-height: 22px!important">Surgery (with or without radiation therapy) is recommended for treatment of DCIS. After surgery and radiation therapy, some women may take hormone therapy. Chemotherapy is not needed.</span ></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'4.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Stage 2 and stage 3A treatments.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'5.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Stage 3B and stage 3C treatment.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'6.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Stage 4 and recurrent breast cancer 
treatments.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'7.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">5- year Survival Rates for breast cancer 
according to Stage.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/treatment/staging',file:'8.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text">References</span></span></p>
						</li>
						<li> 
							<g:render template="rate"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" class="event"/>
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">9</span> <span class="caption-text"></span></span></p>
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