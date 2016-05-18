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
				<h1>ABOUT BREAST CANCER</h1>
				<div class="right">
				<g:render template="/template/about"></g:render>
			</div>
			</div>
			<g:render template="sections"></g:render>
		</div>
		<div class="col-lg-8 col-md-7 col-sm-7 col-xs-12 inner-right-cont right-gray-cont pad-rt-0">
			<h2>METASTATIC BREAST CANCER</h2>
			<p>Metastatic breast cancer occurs when breast cancer cells spread from the first (primary) cancer in the breast through the lymphatic or blood system to other parts of the body.</p>
			<div class="row">
				<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li><img src="${resource(dir:'assets/image/metastatic',file:'a.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span><span class="caption-text">Metastatic Breast Cancer</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'b.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Most advanced stage of breast cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'c.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Approximately one-third of women with breast 
							cancer deveop metastatic breast cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'d.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Metastatic breast cancer numbers.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'e.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Lack of knowledge.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'f.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Metastatic breast cancer</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'g.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">Symptoms of metastatic breast cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'h.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text"></span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'i.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">9</span> <span class="caption-text"></span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'j.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">10</span> <span class="caption-text">Types of metastatic breast cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'k.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">11</span> <span class="caption-text"></span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'l.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">12</span> <span class="caption-text">Greatest fears of women with metastatic 
							breast cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'m.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">13</span> <span class="caption-text">Improving quality of life in metastatic 
							breast cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/metastatic',file:'n.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">14</span> <span class="caption-text">References</span></span></p>
						</li>
						<li>
						<g:render template="rate"/>
						<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">15</span> <span class="caption-text"></span></span></p>
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
	
	
	<script src="${resource(dir:'assets/js',file:'bjqs-1.3.min.js')}"></script>
	<script src="${resource(dir:'js',file:'slider.js')}"></script>
		<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script src="${resource(dir:'js',file:'sliderButt.js')}"></script> 
</body>
</html>