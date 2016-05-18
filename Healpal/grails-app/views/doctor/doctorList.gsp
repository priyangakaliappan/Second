<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: doctors list
 *
 * #      Name         Version      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga      1.0          	Initial Creation
 * 2   Priyanga      2.0            Modification
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="demo"/>
<title>Find Doctor</title>

</head>
<body>
  <section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
				<div id="header-links">
				<g:if test="${doctorList}">
				<g:link controller="home" action="index" class="logo">Home</g:link><span> > </span>
				<a href="../home/findDoctor">Find a Doctor</a><span> > </span>
				<a href="doctorState?location=${state}"> ${state } </a><span> > </span>
				<a href="doctorCity?city=${city}">${city }</a><span> > </span>
				<a href="">${keyword }</a>
				</g:if>
				</div>
				<g:if test="${doctorList}">
					<h2 id="headline">${city} ${keyword} <span>${doctorList.size()} results</span></h2>
				</g:if>
				<g:else>
					<h2 id="headline">${city} ${keyword} <span>0 results</span></h2>
				</g:else>
				
					<div class="search-box-bg">
					<g:form controller="doctor" action="searchDoctors">
						<div class="col-sm-5 col-xs-12"><input type="text" placeholder="Search for a doctor or treatment" class="search-text-box" id="keyword" value="${keyword}"></div>
						<div class="col-sm-5 col-xs-12"><input type="text" placeholder="Near You" class="location-text-box" id="location" value="${location}"></div>
						<div class="col-sm-2 col-xs-12"><span class="search-btn-s search-docs" style="cursor: pointer;">Search</span></div>
						</g:form>
					</div>
				<div class="search-box-bg"><select id="distance">
									<option value="">Please choose distance</option>
									<option value="2">2 miles</option>
									<option value="5">5 miles</option>
									<option value="10">10 miles</option>
									<option value="50">50 miles</option>
									<option value="100">100 miles</option>
								</select></div>
					<span id="load-img"></span>
				<div id="doctor-list">
				<g:if test="${doctorList}">
					<div class="col-md-4 col-sm-4 find-doctors-sidebar">
						<h3>Recommended Cancer Experts</h3>
						<ul id="experts">
						<g:each in="${doctorList}" var="record">
							<li id="${record?.street1}, ${record?.address?.city}, ${record?.address?.state} ${record?.zipcode}" class="${record?.doctorName}+${record?.id}">
								<div class="doctors-list-left"><img class="img-responsive" src="../assets/new-design/img/doc-img1.jpg"></div>
								<div class="doctors-list-right">
									<div>
									<g:link controller="doctor" action="doctorDetails" params="[doctorId:record?.id]"><span class="orange-text">${record?.doctorName}</span></g:link>
									<div>
										<g:doctorSpecialty doctorId="${record?.id}" />
									</div>
									<div>
										<div class="star-icon pull-left">
											<%--<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="orange-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
											<a class="gray-star" href="JavaScript:void(0)"></a>
										--%></div>
										<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
									</div>
								</div></div>
							</li>
							</g:each>
						</ul>
					</div>	
					</g:if><g:else>
					<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 find-doctors">
					<div style="font-size:18px;margin:15px 0px 15px;padding:25px;background-color:#e7e1dd;width:500px;">We didn't find ${keyword} near ${location}</div>
						<h4>Find ${city} Doctors By Specialty</h4>
						<g:if test="${specialty}">
							<div class="col-sm-3 col-xs-12 pad-lr-0">
								<ul>
									<g:each in="${specialty}" var="records" status="i">
										<li><g:link controller="doctor" action="doctorSpecialty" params="[specialty:records,location:location]">${records}</g:link></li>
									</g:each>
								</ul>
							</div>
							
						</g:if>
						<div class="clearfix"></div></div>
						</g:else>
						
					</div>	
					<div class="col-md-4 col-sm-4 find-doctors-sidebar" style="margin-top: 20px;">
							<label>LOCATION</label>
						<div id="map_canvas" style="width:100%; height:50%;"></div>
				</div>
				</div>
			</div>
		</div>
	</section>
<script type="text/javascript" src="${resource(dir:'js/doctor',file:'jquery.easy-autocomplete.min.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/doctor',file:'autocomplete.js')}"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
var name;
var doctorId;
var addr=[];
var geocoder;
var map;
var markersArray = [];
var bounds;
var infowindow =  new google.maps.InfoWindow({content: ''});
//plot initial point using geocode instead of coordinates (works just fine)
function initialize() {
	addr=[];
	$('#experts li').map(function(i,n) {
		var profile  = $(n).attr('class');
		var index = addr.indexOf($(n).attr('id'));
	   if(addr.length>0 && index != -1){
		 }
	   else{ 
		   addr.push([profile,$(n).attr('id')]);
		   }
	});
    geocoder = new google.maps.Geocoder();
    bounds = new google.maps.LatLngBounds ();
    var myOptions = {
        zoom: 14, 
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        navigationControlOptions: {
            style: google.maps.NavigationControlStyle.SMALL
        }
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    plotMarkers();
}
function plotMarkers(){
    var i;
   if(addr.length>0){
    	for(i = 0; i < addr.length; i++){
        	codeAddresses(addr[i]);
    	}
   }else{
	   codeAddresses(['US','US']);
	   }
}
function codeAddresses(address){
    geocoder.geocode( { 'address': address[1]}, function(results, status) { 
        if (status == google.maps.GeocoderStatus.OK) {
        	if(address[1]!="US"){
	            marker = new google.maps.Marker({
	                map: map,
	                position: results[0].geometry.location
	            });
            google.maps.event.addListener(marker, 'click', function() {
                if(address[0].indexOf("+") >-1)
                {
					var splitId = address[0].split("+");
					doctorId = splitId[1];           
	                infowindow.setContent('<a href="../doctor/doctorDetails" class="map-marker" onclick="changeUrl(this)">'+splitId[0]+'</a>');
	                infowindow.open(map, this);
	            }
            });
        }
            bounds.extend(results[0].geometry.location);
            //markersArray.push(marker); 
        }
        else{
          //  alert("Geocode was not successful for the following reason: " + status);
        }
        map.fitBounds(bounds);
    });
}
google.maps.event.addDomListener(window, 'load', initialize);
function changeUrl(e){
	e.href =e.href+'?doctorId='+doctorId;
}
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".search-docs").click(function(){
			$("#header-links").hide();
			var keyword = $("#keyword").val();
			var location = $("#location").val();
			var city
			if(location.indexOf(",")> -1){
					var address = location.split(",");
					city = address[0]
				}else city=location;
			if(keyword !="" && location!="")
				{
				$("#doctor-list").hide();
				 $('#load-img').html('<img src="../assets/image/spinner.gif" width="50" height="50" style="margin:100px 500px;"/>');
				$.ajax({
					async : true,
					type : 'POST',
					url : '../doctor/searchDoctors',
					data : {
						keyword : keyword,
						location : location,
					},
					success : function(res) {
						$('#load-img').html('');
						$("#doctor-list").html(res);
						$("#doctor-list").show();
						$("#headline").text(city+" "+keyword+" "+$('#experts li').length+" results");
						initialize();
					}
				});
				}
			else{
				if(keyword==""){$("#keyword").focus();}else if(location==""){
					$("#location").focus();}
				return false;
				}
			});
	});
	$("#distance").change(function(){
		var miles = $(this).val();
		$("#doctor-list").hide();
		$('#load-img').html('<img src="../assets/image/spinner.gif" width="50" height="50" style="margin:100px 500px;"/>');
	
		$.ajax({
			async : true,
			//type : 'POST',
			url : '../doctor/filterByDistance',
			data : {
				miles : miles,
				keyword: $("#keyword").val(),
				location : $("#location").val()
			},
			success : function(res) {
				$('#load-img').html('');
				$("#doctor-list").html(res);
				$("#doctor-list").show();
				initialize();
			}
		});
			});
</script>
</body>
</html>