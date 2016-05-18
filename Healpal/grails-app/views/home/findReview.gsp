<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>Write a Review</title>
<link
	href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}"
	rel="stylesheet">
</head>
<body>
	<!--Search Start here-->
	<section class="search-review-bg">
		<div class="container container-1330">
			<div class="row">
				<div class="col-lg-1 col-md-1"></div>
				<div class="col-lg-3 col-md-5 col-sm-4 col-xs-12 find-text">
					<h1>Find Reviews</h1>
				</div>
				<div class="col-lg-7 col-md-6 col-sm-4 col-xs-12 pad-lr-0">
					<%--<input type="text" name="textbox" class="review-textbox" placeholder="Search for reviews"/>
				--%></div>
			</div>
		</div>
	</section>
	<!--Search End here-->
	
	<section class="inner-white-bg find-review-bg">
		<div class="container container-1330">
			<div class="row">
				<div class="col-lg-1 col-md-1"></div>
				<div class="col-lg-3 col-md-5 col-sm-4 col-xs-12  pad-rt-0">
					<div class="review-leftside-bar">
						<h4>Filter by:</h4>
						<h5>Diagnosis</h5>
						<g:select class="select-condition" id="diagnosis" name="diagnosis"
									noSelection="${['':'Select your Diagnosis']}"
									from='${diagnosisList}' optionKey="id"
									optionValue="diagnosisName" onChange="submission();"/>
						<div class="clearfix mar-bot-10">&nbsp;</div>
						<label class="diagnosis-text"><h5>Category</h5></label>
						
						<g:each in="${reviewAboutList}" var="reviewList" status="i">
						<div>
						<input id="${reviewList.id}" type="radio" class="category" name="category" value="${reviewList.id}" onClick="submission();"><label
						for="${reviewList.id}"><span><span></span></span>${reviewList.reviewAbout}</label></div>
						</g:each>
						
						<div class="clearfix mar-bot-20"></div>
						<h5>Location</h5>
						<input type="text" id="location" name="textbox" class="review-textbox loc-box" placeholder="Enter your location" readonly="readonly"/>
						<div class="clearfix mar-bot-10">&nbsp;</div>
						<label class="diagnosis-text"><h5>Submitted</h5></label>
						<div><input id="radio6" type="radio" class="rad" name="submitTime" value="6" onClick="submission();"><label for="radio6"><span><span></span></span>Within 1 week </label></div>
						<div><input id="radio7" type="radio" class="rad" name="submitTime" value="7" onClick="submission();"><label for="radio7"><span><span></span></span>Within 1 month</label></div>
						<div><input id="radio8" type="radio" class="rad" name="submitTime" value="8" onClick="submission();"><label for="radio8"><span><span></span></span>Within 6 month</label></div>
						<div><input id="radio9" type="radio" class="rad" name="submitTime" value="9" onClick="submission();"><label for="radio9"><span><span></span></span>Within 1 year</label></div>
						<div class="clearfix mar-bot-20"></div>
					</div>
				</div>
				<div id="results">
			<g:render template="searchReviews"></g:render>
			</div>
			</div>
		</div>
	</section>
	
	<script type="text/javascript">
function check(e){
	var newClass=e.id;//$(this).attr('id');
	var test=$('#review'+newClass).val();
	if($(e).text() == 'view less'){
		$('.'+newClass).text(test.substr(0,230)+"... ");
		$(e).text('read more');
		}
	
	else{	
	$('.'+newClass).text($('#review'+newClass).val()+" ");
	$(e).text('view less');	
	}
	};
	</script>
	
	<script type="text/javascript">
	function submission(){
		//alert("function call");
		var diagnosis="";
		var category="";
		var Submitted="";
		var Location="";	
		
		diagnosis=$("#diagnosis").val();
//alert($('input[name="submitTime"]:checked').val())
			
		if($('input[name="category"]:checked').length > 0){
			category=$('input[name=category]:checked').val();
			
			}
		if($('input[name="submitTime"]:checked').length > 0){
			Submitted=$('input[name="submitTime"]:checked').val();
		}
			
		Location=$("#location").val();
		//alert("hai");
		$.ajax({
			async : false,
			type : 'GET',
			url : '../home/searchReviews',
			data : {
				diagnosis : diagnosis,
				category : category,
				Submitted : Submitted,
				Location : Location,
				size : $("#size").val(),
				max : $("#max").val(),
				offset : 0
			},
			success : function(res) {
				//alert("hello");
				$("#results").html(res);
			}
		});
		



		
		}


	

	</script>
	
	
	
	
	</body></html>
	
	