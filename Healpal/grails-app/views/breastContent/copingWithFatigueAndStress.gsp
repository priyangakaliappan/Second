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
				<h1>COPING AND LIFESTYLE</h1>
				<div class="right">
				<g:render template="/template/lifeStyle"></g:render>
			</div>
			</div>
			<g:render template="sections"></g:render>
		</div>
		<div class="col-lg-8 col-md-7 col-sm-7 col-xs-12 inner-right-cont right-gray-cont pad-rt-0">
			<h2> COPING WITH FATIGUE AND STRESS </h2>
			<p>While focussing on your physical health, it is equally important to address your emotional, psychological and spiritual health. They can affect your physical health and play an important part in your recovery.</p>
			<div class="row">
				<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
		<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'1.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span> <span class="caption-text">Coping With Fatique And Stress</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'2.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Cancer Related Fatigue.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'3.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Cancer Related Fatigue.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'4.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Treatments That Cause CRF.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'5.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Causes of cancer related  fatigue. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'6.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Assessment of cancer related fatigue. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'7.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">Management of cancer related fatigue. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'8.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text">Role of exercise. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'9.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">9</span> <span class="caption-text">Nutrition </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'10.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">10</span> <span class="caption-text">Managing your stress during cancer<br> treatment. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'11.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">11</span> <span class="caption-text">Managing your stress during cancer<br> treatment. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'12.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">12</span> <span class="caption-text">Managing your stress during cancer<br> treatment. </span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/lifeStyle/fatique',file:'13.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">13</span> <span class="caption-text">References </span></span></p>
						</li>
						<li><g:render template="rate"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">14</span> <span class="caption-text"></span></span></p>
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
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script src="${resource(dir:'js',file:'sliderButt.js')}"></script>        
</body>
</html>