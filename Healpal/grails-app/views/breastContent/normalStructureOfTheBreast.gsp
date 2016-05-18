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
			<h2>NORMAL STRUCTURE OF THE BREASTS</h2>
			<p>Knowing  the different parts and functions of your breasts, will help you better understand the details of breast cancer. It will also enable you to be aware of anything unusual. Any of these parts of the breast can undergo changes that cause symptoms.

</p>
			<div class="row">
				
				<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li><img src="${resource(dir:'assets/image/structure',file:'a.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span><span class="caption-text">Normal Structure of the Breast</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'b.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Structure of the breast</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'c.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Normal parts of the breast
							<br/></span></span><span class="no-bold treat-6">Fatty (Adipose) Tissue</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'d.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Normal parts of the breast
							<br/>
							</span></span><span class="no-bold treat-6">Lobes, Lobules and Ducts</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'e.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Normal parts of the breast<br>
							 </span></span><span class="no-bold normal-struct1">Lobes, Lobules and Ducts : The type of breast cancer is determined by the original location of the  growth of cancer cells which is almost always in the lobes, lobules, or ducts.
							</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'f.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Structure of the breast: The lymphatic<br> system
						<br/>
						</span></span><span class="no-bold normal-struct2">When cancer cells are found in the  lymph nodes, it helps doctors identify just how far the cancer has spread.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'g.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">Structure of the breast: The lymphatic <br>system
							</span></span><span class="no-bold normal-struct2">When cancer cells are found in the  lymph nodes, it helps doctors identify just how far the cancer has spread.
						</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/structure',file:'h.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text">References</span></span></p>
						</li>
						<li>
							<g:render template="rate"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" />
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
	
	<script src="${resource(dir:'assets/js',file:'bjqs-1.3.min.js')}"></script>
	<script src="${resource(dir:'js',file:'slider.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script src="${resource(dir:'js',file:'sliderButt.js')}"></script> 
</body>
</html>