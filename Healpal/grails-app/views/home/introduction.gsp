<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="demo" />
<title>Learn</title>
</head>
<body>
	<div class="fixed-header"></div>
	<section class="inner-cont">
		<div class="col-md-5 inner-left-cont">
			<div class="inner-left-box-cont introduction-cont">
				<div class="text-center">
					<h1>Introduction</h1>
				</div>
				<p>Being diagnosed with cancer can be overwhelming. But knowing
					what to expect can make things easier.</p>
			</div>
		</div>
		<div class="col-md-7 inner-right-cont login-bss tab-right">
			<g:form controller="breastCancer" action="index">
				
				<div class="badge2-terms-text">
					<h4 style="font-size:22px">
						<input type="checkbox" class="agree" value="AgreeWithHealapl" name="agree" id="checkbox1"><label
							for="checkbox1"><span></span>I agree to the terms of use
							stated below</label>
					</h4>
				</div>
				<div class="clearfix"></div>
				<div class="text-14">
					<p>We have gathered relevant information from the web to help you learn more about breast cancer. 
					The information is NOT intended to be a substitute for professional medical advice, diagnosis or 
					treatment and serves for informational purposes only. Always seek the advice of a qualified health 
					provider with any questions you may have regarding a medical condition. Never disregard professional 
					medical advice or delay in seeking it because of something you have read or seen in any video on 
					HealPal.me. </p>
					<p>Human error does occur, and it is your responsibility to double check all facts provided. 
					To the fullest extent of the law, HealPal Inc. assumes no responsibility for any injury and or damage to
					persons or property arising out or related to any use of this material.</p>
				</div>
				<div class="text-center">
					<g:hiddenField name="userSession" value="${session.user?.userName}"
						id="userSessionId" />
					<g:submitButton class="btn btn-orange" id="submit" value="Submit" name="submit"/>
				</div>
			</g:form>
		</div>
	</section>
	
	<div id="agree" class="modal fade agree-popup" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal"></button>
				<div class="clearfix"></div>
				<div class="modal-body">
					<p class="text-center" style="margin-top:35px; padding:0px 0px 11px; font-size:16px;">Please Agree To Our Terms Of Use.</p>
					<div class="col-md-4"></div>
					<div class="text-center"><div class="col-md-4 col-sm-4 col-xs-12 pad-lr-0"><button type="submit" id="ok" class="orange-btn" style="background:#f37021; height:38px; line-height:38px;  font-family:opensans semibold; font-size:18px;">Ok</button></div></div>
					<div class="col-md-4"></div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>

	<!--end here-->
	<!--end here-->
	<script type="text/javascript">
	$("#ok").click(function(){
		$("#agree").modal('hide');
		});
	
	
		$("#submit").on("click", function() {
			//var relationship = $('.relationship').is(':checked');
			//var breastCancerJourney = $('.breastCancerJourney').is(':checked');
			var agree = $('.agree').is(':checked');
			/*if ($("#userSessionId").val() == "") {
				alert("Please Signin or Create a new account");
				return false;
			}  if (!relationship) {
				alert("Please choose your Relationship");
				return false;
			} else if ($(".relationship:checked").length > 1) {
				alert("Please choose only one of the Relationship");
				return false;
			} else if (!breastCancerJourney) {
				alert("Please choose your Breast Cancer Journey");
				return false;
			} else if ($(".breastCancerJourney:checked").length > 1) {
				alert("Please choose only one of the Journey");
				return false;
			}else*/ if (!agree) {
				$("#agree").modal('show');
				return false;
			}
			else {

				return true;
			}

		});
	</script>

</body>
</html>