<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/03/2015
 * FileName 	: learn
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/03/2015      Initial Creation
 * 
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />

<title>Learn</title>
</head>
<body>
	<section class="learn-banner learn-height" id="top">
	<div class="m-learn-banner" style="background:url(../assets/new-design/img/learn-banner.jpg) no-repeat center top; background-size:cover; max-width:100%; height:534px;">
		<div class="container">
			<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="learn-banner-content">
						<div class="learn-strip">
							<h1>Select cancer type and start learning.</h1>
						</div>
					<div class="clearfix"></div>
					<div class="col-lg-12 pad-lr-0">
						<div class="cancer-type">
							<ul id="cancerType">
							
								<li id="getColor" onclick="callIntro()"><a>Breast</a></li>
								<li class="border-rt" data-toggle="modal" data-target="#cancer-type" value="lung" name="lung" id="lung" ><a href="#">Lung</a></li>
								<li class="border-rt" data-toggle="modal" data-target="#cancer-type" name="colon" id="colon" ><a href="#">Colon</a></li>
								<li data-toggle="modal" data-target="#cancer-type" name="prostate" id="prostate" ><a href="#">Prostate</a></li>
								<li class="border-rt" data-toggle="modal" data-target="#cancer-type" name="skin" id="skin" ><a href="#">Skin</a></li>
								<li class="border-rt" data-toggle="modal" data-target="#cancer-type" name="kidney" id="kidney"><a href="#">Kidney</a></li>
								<li data-toggle="modal" data-target="#cancer-type" name="bladder" id="bladder" ><a href="#">Bladder</a></li>
								<li class="border-down" data-toggle="modal" data-target="#cancer-type" name="nhl" id="nhl"><a href="#">NHL</a></li>
								<li class="border-down border-rt" data-toggle="modal" data-target="#cancer-type" name="leukemia" id="leukemia" ><a href="#">Leukemia</a></li>
								<li class="border-down border-rt" data-toggle="modal" data-target="#cancer-type" name="endometrial" id="endometrial" ><a href="#">Endometrial </a></li>
								<li class="border-down" data-toggle="modal" data-target="#cancer-type" name="stomach" id="stomach" ><a href="#">Stomach</a></li>
								<li class="border-down border-rt" data-toggle="modal" data-target="#cancer-type" name="brain" id="brain" ><a href="#">Brain</a></li>
								<li class="border-down border-rt" data-toggle="modal" data-target="#cancer-type" name="ovary" id="ovary" ><a href="#">Ovary</a></li>
								<li class="border-down" data-toggle="modal" data-target="#cancer-type"  name="other" id="other" ><a href="#">Other</a></li>
							</ul>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			</div>
		</div>
		</div>
	</section>
	<!--Inner banner end here-->
	<!--Inner page content start here-->
	<section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center learn-text">
					<h2 class="mar-top-70">Knowledge is Power</h2>
					<div class="learn-image">
						<img src="../assets/new-design/img/learn-image.png" alt="image"/>
					</div>
					<div class="clearfix mar-bot-10"></div>
					<p>Learn about your cancer with easy to understand infographics and videos.</p> 
					<p>Skip the medical jargon with precise and need to know information about your cancer.</p>
					<div class="clearfix mar-bot-30"></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<a href="#top" class="btn-default  inner-orange-btn learn-btn">Start Learning</a>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
				</div>
			</div>
		</div>
	</section>
	<!--end here-->
	
	<div id="cancer-type" class="modal fade coming-soon-popup" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal"></button>
				<div class="clearfix"></div>
				
				<div class="modal-body">
				
					<g:form >
					<h1 class="text-center">Coming soon</h1>
					
					<p>Enter your email address and we will let you know as soon as it is ready.</p>
					<div class="col-md-7 pad-lr-0"><input class="textbox" type="email" name="email" id="emailVal" required=""  placeholder="Your email address" /></div>
					<div class="col-md-4 pad-lr-0">
					<%--<button type="submit" class="orange-btn">Submit</button>
					--%>
					<g:actionSubmit	value="Submit" id="submit-date" class="btn btn-default btn-lg orange-btn submit-btn" />
					
					</div>
					</g:form>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${resource(dir:'assets/new-design/js',file:'custom.js')}"></script>
	<script type="text/javascript">

	 $("#getColor").hover(function(){
	        $(this).css("background-color", "#f37021");
	        });
	
	function callIntro()
	{
		window.location.href="${createLink(controller:'home',action:'introduction')}"
		}

	</script>
	
	<%--<script type="text/javascript">
	//for choose cancer "class active"
	$('li > a').click(function() {
	    $('li').removeClass();
	    $(this).parent().addClass('active');
	});
	</script>
	--%><%--<script type="text/javascript">

function validation(val){
	if(val=="Breast Cancer"){
		window.location.href="introduction";
	}else{
		alert("Please select your condition");
	}	
}
</script>


--%>


<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
<script type="text/javascript">

	$(document).ready(function(){
		


		$("#cancerType li").click(function(){
		    //Some code
		    //alert("name");
		   var name = this.id;
		    $('#submit-date').click(function() {
				var process = $('#emailVal').val();
				$.ajax({
			        async  : false,
			        type   : "POST",
			        url    : "../groupMail/create",
			        data   : {name:name,process:process},
			        success : function(res){
			       window.location.replace("../home/learn");
			        }
			       
			    });
			   return false;
				
				});
		    
		});

		
	});

	</script>
</body>
</html>

