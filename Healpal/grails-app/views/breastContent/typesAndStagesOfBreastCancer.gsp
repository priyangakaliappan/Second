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
			<h2> TYPES AND STAGES OF BREAST CANCER </h2>
			<p>Not all breast cancers are the same. The cancer develops in or from specific tissues and parts of the breast. Breast cancer can arise from the milk ducts, milk -producing lobules and connective tissue. The pathology report and  imaging tests will determine the specific type of breast cancer. This also determines the likely behavior and response to treatment.</p>
			<div class="row">
				<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'a.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span> <span class="caption-text">Types of Breast Cancer</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'b.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Normal anatomy of breast.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'c.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Ductal Carcinoma In Situ (DCIS) <br/>
								</span></span><span class="no-bold treat-1">Cells inside some of the ducts of your breast have started to turn
								into cancer cells.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'d.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Lobular Carcinoma In Situ (DCIS).<br/>
							</span></span><span class="no-bold treat-1">Cells inside some of the breast lobules have started to become abnormal.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'e.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Invasive Ductal Cancer.<br/>
							</span></span><span class="no-bold treat-1">The most common type of breast cancer.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'f.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Invasive lobular breast cancer.<br/>
							</span></span><span class="no-bold treat-1">About 10% to 15% of breast cancers diagnosed as invasive lobular carcinoma.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'g.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">Inflammatory breast cancer.<br/>
							 </span></span><span class="no-bold treat-1">A rare type of breast cancer.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'h.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text">Paget's disease.<br/>
							</span></span><span class="no-bold treat-1">A rare disease that is associated with breast cancer.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'i.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">9</span> <span class="caption-text">Very rare breast cancers.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'j.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">10</span> <span class="caption-text">Very rare breast cancers.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'k.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">11</span><span class="caption-text">Very rare breast cancers.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/type',file:'l.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">12</span> <span class="caption-text">References</span></span></p>
						</li>
						<li><g:render template="rate"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">13</span> <span class="caption-text"></span></span></p>
						</li>
						
					</ul>
					<!-- end Basic jQuery Slider -->
				</div>
			</div>
			
			</div>
			
			<br/><br/>	
			<div class="row">
			
			<!-- slider start -->	
			<g:render template="socialIcons"></g:render>
			<div class="slider-right slider_rightbar">
				<div id="banner-fade1">
					<!-- start Basic Jquery Slider -->
					<ul class="bjqs">
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'a.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">1</span> <span class="caption-text">Stages of Breast Cancer.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'b.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">2</span> <span class="caption-text">Stages of breast cance.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'d.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">3</span> <span class="caption-text">Importance of staging.</span></span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'e.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">4</span> <span class="caption-text">Stage 0 :
							</span></span><span class="no-bold treat-1">DCIS (ductal carcinoma in situ) is a non-invasive breast cancer. In DCIS, the abnormal cells are contained in the milk ducts. It is called “in situ” (which means "in place") because the cells have not left the milk ducts to invade nearby breast tissue. 
							</span> </p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'f.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">5</span> <span class="caption-text">Breast cancer : stage 1A <br/>
							</span></span><span class="no-bold treat-1">The tumor is 2 cm or smaller and the cancer has NOT spread to the lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'g.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">6</span> <span class="caption-text">Stage 1B.<br/>
							</span></span><span class="no-bold treat-1">Small cluster of cancer cells in the lymph nodes WITH no actual  tumor in the breast OR the tumor in the breast is 2 cm or smaller.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'h.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">7</span> <span class="caption-text">Stage 2A.
							<br/></span></span><span class="no-bold treat-1">No tumor in the breast and the cancer has spread to less than 4 axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'i.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">8</span> <span class="caption-text">Stage 2A.<br/>
							</span></span><span class="no-bold treat-1">Tumor is less than 2 cm in size and the cancer has spread to less than 4 axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'j.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">9</span> <span class="caption-text">Stage 2A.<br/>
							</span></span><span class="no-bold treat-1">Tumor is 2 to 5 cm in size and the cancer has not spread to the axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'k.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">10</span> <span class="caption-text">Stage 2B.
							<br/> </span></span><span class="no-bold treat-1">Tumor is 2 to 5 cm in size and the cancer has spread to less than 4 axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'l.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">11</span> <span class="caption-text">Stage 2B.<br/>
							</span></span><span class="no-bold treat-1">Tumor is larger than 5cm in size and the cancer has not spread to the axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'m.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">12</span> <span class="caption-text">Stage 2B.
							<br/> </span></span><span class="no-bold treat-1">Tumor is 2 to 5 cm in size and the cancer has spread to less than 4 axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'n.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">13</span> <span class="caption-text">Stage 3A.<br/>
							</span></span><span class="no-bold treat-1">Tumor is less than 2 cm in size and the cancer has spread to 4 to 9 axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'o.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">14</span> <span class="caption-text">Stage 3A.<br/>
							</span></span><span class="no-bold treat-1">Tumor is larger than 5cm in size and cancer clusters are found in the axillary lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'p.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">15</span> <span class="caption-text">Stage 3A.<br/>
							</span></span><span class="no-bold treat-1">Tumor is larger than 5cm in size and cancer has spread to the lymph nodes near the breast bone and/or the underarm lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'q.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">16</span> <span class="caption-text">Stage 3B.<br/>
							</span></span><span class="no-bold treat-1">Tumor can be of any size and cancer has spread upto 9 lymph nodes and the cancer has invaded the chest wall or breast skin.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'r.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">17</span> <span class="caption-text">Stage 3C.<br/>
							</span></span><span class="no-bold treat-1">No tumor or tumor can be of any size and cancer has spread to 10 or more lymph nodes.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'s.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">18</span> <span class="caption-text">Stage 3C.<br/>
							</span></span><span class="no-bold treat-1">No tumor or tumor can be of any size and cancer has spread to the lymph nodes near the collar bone.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'t.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">19</span> <span class="caption-text">Stage 3C.<br/>
							</span></span><span class="no-bold treat-1">No tumor or tumor can be of any size and cancer has spread to the lymph nodes near the collar bone and to the lymph nodes near the underarms or breast bone.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'u.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">20</span> <span class="caption-text">Breast cancer : stage 4.
							<br/> </span></span><span class="no-bold treat-1">Cancer has spread to other parts of the body such as the brain, lungs, liver and the bones.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'v.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">21</span> <span class="caption-text">Breast cancer by stage : white vs black women.<br/>
							</span></span><span class="no-bold treat-1">Lower rates of stage 1 cancer in black women than  white women. </span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'w.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">22</span> <span class="caption-text">Prognosis & survival.<br/>
							</span></span><span class="no-bold treat-1">Prognosis becomes progressively worse as stage of breast cancer becomes more advanced and disease spreads.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'x.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">23</span> <span class="caption-text">5 - year survival rate of early breast cancer.<br/>
							</span></span><span class="no-bold treat-1">Approximately 98% of patients will survive for 5 years if they have early stage Breast Cancer.</span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'y.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">24</span> <span class="caption-text">5 - year survival rate of locally advanced breast cancer.<br/>
							</span></span><span class="no-bold treat-1">Around 84% of patients with locally advanced breast cancer will survive for 5 years. </span></p>
						</li>
						<li><img src="${resource(dir:'assets/image/diagnosis/typeStage/stage',file:'z.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">25</span> <span class="caption-text">5 - year survival rate of metastatic breast cancer.<br/>
							</span></span><span class="no-bold treat-1">Roughly 24% of metastatic breast cancer patients will survive for 5 years.</span></p>
						</li>
						<li><input type="button" value="Satisfactory" id="satis"/>
							<input type="button" value="Perfect" id="perfect"/>
							<input type="button" value="Not Clear" id="clear"/>
							<input type="button" value="Now what i wanted" id="wanted"/>
							<img src="${resource(dir:'assets/image',file:'rate.jpg')}" alt="bammer Image" />
							<p class="bjqs-caption"><span class="slider-caption"><span class="slider-no">26</span> <span class="caption-text"></span></span></p>
						</li>
					</ul>
					<!-- end Basic jQuery Slider -->
				</div>
			</div>
			<br/>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
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
	<!--end here-->
	<!--end here-->      
	
	<script src="${resource(dir:'assets/js',file:'bjqs-1.3.min.js')}"></script>
	<script src="${resource(dir:'js',file:'slider.js')}"></script> 
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script src="${resource(dir:'js',file:'sliderButt.js')}"></script> 
</body>
</html>