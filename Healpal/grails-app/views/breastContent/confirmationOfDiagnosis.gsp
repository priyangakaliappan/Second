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
				<h1>DIAGNOSIS OF BREAST CANCER</h1>
				<div class="right">
				<g:render template="/template/diagnosis"></g:render>
			</div>
			</div>
			<g:render template="sections"></g:render>
		</div>
		<div class="col-lg-8 col-md-7 col-sm-7 col-xs-12 inner-right-cont right-gray-cont pad-rt-0">
			<h2> CONFIRMATION OF DIAGNOSIS </h2>
			<p>A breast biopsy is a procedure to remove a small sample of breast tissue for laboratory testing. Breast biopsy is a way to evaluate a suspicious area in your breast to determine if it is breast cancer.
</p>
			<div class="row">
				<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'a.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span><span class="caption-text">Confirmation of diagnosis of Breast Cancer</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'b.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Fine needle aspiration.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'c.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Core needle biopsy.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'d.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Excisional (Surgical Biopsy).</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'e.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Vaccum Biopsy.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'f.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Punch Biopsy.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'g.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">What happens after the biopsy.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'h.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text">Are pathologists doctors ?</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'i.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">9</span> <span class="caption-text">Can a needle biopsy miss breast cancer ?</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/confirmation',file:'j.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">10</span> <span class="caption-text">Breast biopsy : Fact VS Myth.</span></span></p>
						</li>
						<li><g:render template="rate"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">11</span> <span class="caption-text"></span></span></p>
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
					</div></div>	
			</div>	
		</div>
		</div>
		</div>
	</section>
	
	
	<script src="${resource(dir:'assets/js',file:'bjqs-1.3.min.js')}"></script>
	<script src="${resource(dir:'js',file:'slider.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script src="${resource(dir:'js',file:'sliderButt.js')}"></script> 
		
</body>
</html>