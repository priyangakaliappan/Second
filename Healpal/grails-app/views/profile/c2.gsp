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
			<g:form controller="profile" name="">
				<div class="text-center">
					<div class="icon-box-top">
						<img src="../assets/icon/c2-icon.jpg" />
					</div>
					<h1>Select your Date of Birth</h1>
					
					<div class="dob-box">
						<input type="text" name="dob" placeholder="mm/dd/yyyy" class="datepicker date_picker" value="${session.getDOB}"  id="example1" onKeyPress="return checkOnlyDate(event);">
						 
						 <%--<ul>
							<g:each
								in="['jan','feb','mar','apr','may','jun','jul','aug','sep','oct','nov','dec']"
								var="month" status="i">
								<li><a id="${i}" class="month" onClick="call(${i})"> ${month}
								</a></li>
							</g:each>
							
						</ul>
						<g:hiddenField name="month" id="selectedMonth" value="" />
						 <select class="select" name="date" id="date" > <option value="">Day</option> </select>
						  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select class="select" name="year" id="year" onchange="call()"> <option value="">Year</option> </select> </div> </div> 
						
					--%><%--	
						<div style="float: right;">
                        <select name="month" id="month" class="select" onchange="call()" >
                         <option value="">Month</option>
                         <option value="1">Jan</option>
                         <option value="2">Feb</option>
                         <option value="3">Mar</option>
                         <option value="4">Apr</option>
                         <option value="5">May</option>
                         <option value="6">Jun</option>
                         <option value="7">Jul</option>
                         <option value="8">Aug</option>
                         <option value="9">Sep</option>
                         <option value="10">Oct</option>
                         <option value="11">Nov</option>
                         <option value="12">Dec</option>
                         </select> 
                                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select class="select" name="date" id="date" > <option value="">Day</option> </select>
						  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select class="select" name="year" id="year" onchange="call()"> <option value="">Year</option> </select> </div> </div> 
							
							
					--%>
					
					
					
					
					
					
					
					
					<p id="timer" style="color:#ff7170;"></p>
					<g:if test="${backToD4}">
					<g:hiddenField name="goToD4" value="TRUE"/>
					<g:actionSubmit value="Next" action="c2" class="blue-btn" id="saveDate"/>
					</g:if>
					<g:else>
					<g:actionSubmit value="Save and Continue" action="c2" class="blue-btn" id="saveDate"/>
					</g:else>
				</div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
				
					</div> 
				</g:form>
			<br/>
			
			
			<g:link controller="profile" action="c1" class="back-link">
				<i class="back-arrow"></i>Back</g:link><%--
			<g:link action="c3" class="skip-text">Skip</g:link>
		--%></div>
		<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">3/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>9 more questions for 20% profile completion</p>				
				
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
				<div class="bar-text">3/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>9 more questions for 20% profile completion</p>				
				
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
                $("#example1").datepicker({
                	endDate: '+0d',
                    autoclose: true
                });  
            
            });
        </script>
        <script type="text/javascript">
       
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