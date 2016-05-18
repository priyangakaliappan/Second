<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="createProfile"/>
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
  <div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form controller="profile" action="e4" name="">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/icon/e1-icon.jpg" /></div>
								<h1>Date of surgery</h1>
								<div class="dob-box">
								<input  type="text" name="surgery" placeholder="mm/dd/yyyy" class="datepicker date_picker"  id="e4" onKeyPress="return checkOnlyDate(event);">
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
								<g:submitButton name="Save and Continue" class="blue-btn" id="saveDateOfSurgery"/>
							</div>
							</g:form>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
							<g:link controller="Profile" action="e3" class="back-link"><i class="back-arrow"></i>Back</g:link>
						</div>
						<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">15/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>4 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
					</div>
  </div></div></section>
  <%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">15/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>4 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
   --%><script type="text/javascript" src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>  
  
  <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                $("#e4").datepicker({
                });  
            
            });
        </script>
</body>
</html>