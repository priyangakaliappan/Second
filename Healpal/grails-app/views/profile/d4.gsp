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
						
						<g:form controller="profile" action="d4" name=""> 
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/icon/d4-icon.jpg" /></div>
								<h1>Date of cancer diagnosis</h1>
								<div class="dob-box">
								<input  type="text" name="diagnosis" placeholder="mm/dd/yyyy" class="datepicker date_picker" value="${session.getDateOfDiagnosis}"  id="d4" onKeyPress="return checkOnlyDate(event);">
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
								<g:if test="${flash.msg}">
								<div id="err" class="alert alert-danger" style="text-align: center;margin:10px;font-size: 14px;margin-left:213px;padding-top: 0px; padding-bottom: 55px;height: 10px;width: 60%">${flash.msg}</div>
								 </g:if>
								
								<g:if test="${goToD5}">
								<g:submitButton name="Next" class="blue-btn" id="saveDate"/>
								</g:if>
								<g:else>
								<g:submitButton name="Save and Continue" class="blue-btn" id="saveDateOfDiagnosis"/>
								</g:else>
							</div>
							</g:form>
							
							<br/>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>						
							
							<g:link controller="profile" action="d3" class="back-link"><i class="back-arrow"></i>Back</g:link>
						</div>
						<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">3/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>16 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
					</div>
  </div>
  </div></section>
 <%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">3/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>16 more questions for 50% profile completion</p>				
				
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
                $("#d4").datepicker({
                	endDate: '+0d',
                    autoclose: true
                });  
            
            });
        </script>
        <script type="text/javascript">
	          function call(i){
		          
		        
		        
		          var kcyear = document.getElementsByName("year")[0],
				  kcmonth = document.getElementsById("month")[0],
				  kcday = document.getElementsByName("date")[0];
		          alert(kcyear)
				  var d = new Date();
				  var n = d.getFullYear();
				  for (var i = n; i >= 1920; i--)
					    { 
					    var opt = new Option(); opt.value = opt.text = i; kcyear.add(opt);

					     }
				        kcyear.addEventListener("change", validate_date);
				        kcmonth.addEventListener("change", validate_date);
				         
				 function validate_date() { 
					    var y = +kcyear.value,
					     m = kcmonth.value,
					     d = kcday.value;
					    if (m === "1") 
						    var mlength = 28 + (!(y & 3) && ((y % 100) !== 0 || !(y & 15)));
					     else var mlength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][m - 1]; kcday.length = 0;
					      for (var i = 1; i <= mlength; i++) { 
						            var opt = new Option(); 
						            opt.value = opt.text = i;
						            if (i == d) opt.selected = true;
						             kcday.add(opt);
						              }
					               } 
			               validate_date(); 
		          
				               } 
    </script> 
</body>
</html>