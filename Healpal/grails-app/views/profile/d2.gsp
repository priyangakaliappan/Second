<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="createProfile" />
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
		<div class="profile-box-bg">

			<div class="col-md-10 col-xs-12 center-align text-center">
				<g:form controller="Profile" name="diagnosisSave"
					class="form-horizontal">
					<div class="icon-box-top">
						<img src="../assets/icon/d2-icon.jpg" />
					</div>
					<h1>State your diagnosis</h1>
					<div class="col-md-12 text-center center-align">
						<g:select name="diagnosis" from="${diagnosisList}"  id="diagnosis" 
							noSelection="['':'Please Select your Condition']" optionKey="id"
							optionValue="diagnosisName"
							class="select-condition select-condition1" onchange="getCancer();" ></g:select>
					</div>
					<div class="clearfix"></div>
					<g:actionSubmit value="Save and Continue" action="diagnosisSave" class="blue-btn  mar-top-30" id="saveDiagnosis"/>
					<%--<a href="d3.html" class="pink-btn  mar-top-30" id="save">Save
					and Continue</a>
					--%>
				</g:form>
				<div class="clearfix">&nbsp;</div>
				<div class="clearfix">&nbsp;</div>
			</div>
			<br/>
			
			<g:link controller="profile" action="d1" class="back-link">
				<i class="back-arrow"></i>Back</g:link>
		</div>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">1/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>11 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
	</div>
	</div></div>
</section>
<%--<section>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">1/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>11 more questions for 20% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
		--%><div id="cancer-type" class="modal fade coming-soon-popup" role="dialog">
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
	
	<script type="text/javascript" src="../assets/new-design/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	function getCancer(){

		 name = $("#diagnosis").val();
		 if (name != 1 && name !="") {
			 $('#cancer-type').modal('show');
                }


		 $('#submit-date').click(function() {
				var process = $('#emailVal').val();
				$.ajax({
			        async  : false,
			        type   : "POST",
			        url    : "../groupMail/create",
			        data   : {name:name,process:process},
			        success : function(res){
			       window.location.replace("../home");
			        }
			       
			    });
			   return false;
				
				});
		    
	};
	

	</script>
<%--<script type="text/javascript">

		    $('#submit-date').click(function() {
				var process = $('#emailVal').val();
				$.ajax({
			        async  : false,
			        type   : "POST",
			        url    : "../groupMail/create",
			        data   : {name:name,process:process},
			        success : function(res){
			       window.location.replace("../profile/d2");
			        }
			       
			    });
			   return false;
				
				});
		    
	

	</script>

--%></body>
</html>