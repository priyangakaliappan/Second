<%@ page contentType="text/html;charset=UTF-8"%>
<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<section>
<div class="container container-950">
<div class="row">
  <div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form controller="updateProfile" action="surgeryDate" name="">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/icon/e1-icon.jpg" /></div>
								<h1>Date of surgery</h1>
								<div class="dob-box">
								<input  type="text" name="surgery" id="e4" placeholder="mm/dd/yyyy" class="datepicker date_picker"  value="${dateOfSurgery}" onKeyPress="return checkOnlyDate(event);">
									<%--<ul>
										<g:each in="['jan','feb','mar','apr','may','jun','jul','aug','sep','oct','nov','dec']" var="month">
										<li><a id="${month}" class="month">${month}</a></li>
										</g:each>
									</ul>
									<g:hiddenField name="month" id="selectedMonth"/>
								--%></div>
								<%--<div class="col-xs-12">
									<div class="col-sm-6 colxs-12">
										<g:select class="select pull-left" id="date" name="date" from="${01..31}" value="" noSelection="['':'Select Date']"/>
									</div>
									<div class="col-sm-6 colxs-12">
										<g:select class="select pull-right" id="year" name="year" from="${1920..2016}" value="" noSelection="['':'Select Year']"/>
									</div>
								</div>
								--%>
								<div class="mar-bot-20"></div>
								<g:submitButton name="Save and Continue" class="blue-btn" id="saveDateOfSurgery"/>
							</div>
							</g:form>
						</div>
					</div>
  </div></div></section>
<script type="text/javascript"
	src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>
	<script src="../js/profile/profile.js"></script>
<script type="text/javascript">
	// Disable future date when the document is ready
	$(document).ready(function() {
		$("#e4").datepicker({
			endDate: '+0d',
            autoclose: true
			});

	});
</script>
