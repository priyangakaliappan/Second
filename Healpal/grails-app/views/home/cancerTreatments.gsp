<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="demo"/>
<title>Insert title here</title>
</head>
<body>
<div class="fixed-header"></div>
 <section class="inner-cont inner-cancer-treatment">
 	<div class="container">
	 	<div class="row">
	 	<div class="col-md-1"></div>
	 		<div class="col-md-11">
			 	<g:if test="${title == 'Angiogenesis inhibitors' }"><g:render template="angiogenesis"></g:render></g:if>
			 	<g:if test="${title == 'Biological agents' }"><g:render template="biologicalAgents"></g:render></g:if>
				<g:if test="${title == 'Chemotherapy' }"><g:render template="chemotherapy"></g:render></g:if>
				<g:if test="${title == 'Hormone therapy' }"><g:render template="hormoneTherapy"></g:render></g:if>
				<g:if test="${title == 'Immunotherapy' }"><g:render template="immunotherapy"></g:render></g:if>
				<g:if test="${title == 'Radiation therapy' }"><g:render template="radiationTherapy"></g:render></g:if>
				<g:if test="${title == 'Stereoactive ablative body radiotherapy (SABR)' }"><g:render template="stereoactiveAblativeBodyRadiotherapy"></g:render></g:if>
				<g:if test="${title == 'Surgery' }"><g:render template="surgery"></g:render></g:if>
				<g:if test="${title == 'Targeted therapy' }"><g:render template="targetedTherapy"></g:render></g:if>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</section>
	<section class="light-gray-bg gray-pad">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<h2 class="text-center">Browse Cancer Treatments</h2>
					<ul class="list-view">
					<div class="col-md-12">
						<div class="col-md-4 col-sm-4">
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Angiogenesis inhibitors']">Angiogenesis inhibitors</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Biological agents']">Biological agents</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Chemotherapy']">Chemotherapy</g:link></li>
							<%--<li><a href="JavaScript:void(0)">Biopsy</a></li>
							<li><a href="JavaScript:void(0)">Cancer surgery</a></li>--%>
						</div>
						<div class="col-md-4 col-sm-4">							
							<%--<li><a href="JavaScript:void(0)">Central venous access catheter</a></li>--%>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Hormone therapy']">Hormone therapy</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Immunotherapy']">Immunotherapy</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Radiation therapy']">Radiation therapy</g:link></li>						
						</div>
						<%--<div class="col-md-2 col-sm-5 t-browse-cont pad-lr-0">	
							
							<li><a href="JavaScript:void(0)">Radiosurgery</a></li>							
							<li><a href="JavaScript:void(0)">Sentinel lymph node biopsy</a></li>
							
						</div>
					--%><div class="col-md-4 col-sm-4 pad-lr-0 t-browse-cont">							
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Stereoactive ablative body radiotherapy (SABR)']">Stereoactive ablative body radiotherapy (SABR)</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Surgery']">Surgery</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Targeted therapy']">Targeted therapy</g:link></li>
							</div>
						</div>
					</ul>
					<div class="clearfix mar-bot-30"></div>
					
				</div>
			</div>
		</div>
		
	</section>
	
	 <!-- End outer wrapper -->
	<script src="${resource(dir:'assets/js',file:'bjqs-1.3.min.js')}"></script>
	<script src="${resource(dir:'js',file:'slider.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
   
<script type="text/javascript">
	var treatment = $("#title").text().trim();
	$('.list-view li').each(function(i){
	   var value = $(this).text().trim(); // This is your li value
	   if(value ==treatment){
		   $(this).addClass('active'); // active class for li
		  }else{
			  //do nothing
			  }
	});
   </script>
   <script type="text/javascript">



   function rateMe(title,type){
   	$.ajax({
   		async : false,
   		type : 'POST',
   		url : '../CancerTreatment/saveRate',
   		data :{
   			
   			title : title,
   			type : type
   		},
   		success : function(res) {
   			alert(res);
   		}
   	});
   }




   </script>
</body>
</html>