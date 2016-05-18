
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
	<div id="tables_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				FeedBack Count <small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>FeedBack Count </small>
			</h1>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<g:if test="${flash.msg}">
								<h6 class="red-text">${flash.msg}</h6>
							</g:if>
							<div>Cancer Content Section</div>
									<div class="col-sm-12 col-xs-6 pad-lt-0 mar-bot-10">
										<div class="col-sm-8 col-xs-12 pad-lr-0">
										<select  name="matches" id="matches" onchange="getMatchedCancer();">
										<option value=""> Select </option>
									    <option value="AboutBreastCancer" >About BreastCancer</option>
										<option value="DiagnosisOfBreastCancer">Diagnosis</option>
										<option value="TreatmentOptions" >Treatment Options</option>
										<option value="PreventionAndEarlyDetection">Prevention and Early Detection</option>
										<option value="ClinicalTrials">Clinical Trails</option>
										<option value="CopyingAndLifeStyleIssues" >Copying Lifestyle</option>
										</select>
										</div>
									</div>
								<g:render template="count"></g:render>
						</div>
					</div>
				</div>
			</div>
			<!-- /widget-body -->
		</div>
		<!-- /widget -->
		<div class="clearfix">&nbsp;</div>
	</div>
	</div>
	<!-- /row-fluid -->
	
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript">
	function getMatchedCancer(){
	
		var matches = $("#matches").val();
		//alert(matches)
		$.ajax({
             async  : false,
             type   : "POST",
             url    : "../breastCancer/cancerContentPage",
             data   : {matches:matches},
             success : function(res){
               $("#matchList").html(res);
                
             }
         });
        return false;
	}
	
	</script>
</body>
</html>

