<%--/**
 * Author    : Thirumal R
 * Project   : HealPal
 * Date      : 11/02/2015
 * FileName  : PatientMatch
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Thirumal R     1.0       11/02/2015      Initial Creation
 *
 *
 **/
--%>

<%@page import="com.healpal.care.PatientMatchController"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <meta name="layout" content="care"> 
    <title>Healpal</title>
</head>
<body>
	<g:render template="../template/careMenu"></g:render>
	
	<g:form name="patientMatch">
	<section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="box-content7 match-box-cont">
						<div class="col-sm-12">
							<div class="pull-right">
							 <g:if test="${patientMatchMapTotal}">
								<span class="match-btn col-sm-12"><div id="count">Matches (${patientMatchMapTotal})</div></span>
								</g:if><g:else>
								<span class="match-btn col-sm-12"><div id="count">Matches (0)</div></span>
								</g:else>
							</div>	
						</div>	
						<div class="col-md-3 col-sm-6 col-xs-12 dashboard-sidebar1-left center-align">
						  
							<ul>
								<li>Refine your search</li>
								<li><input type="checkbox" name="text" value=""> Match Percentage</li>
								
								<li>
									<div>Match</div>
									<div class="col-sm-12 col-xs-6 pad-lt-0 mar-bot-10">
										<div class="col-sm-8 col-xs-12 pad-lr-0">
										<select  name="matches" id="matches" onchange="getMatchedPatient();">
										<option value=""> Select </option>
									    <option value="0-20" >0-20 %</option>
										<option value="20-40">20-40 %</option>
										<option value="40-60">40-60 %</option>
										<option value="60-80">60-80 %</option>
										<option value="80-100">80-100 %</option>
										</select>
										</div>
									</div>
								</li>
								<li>
								
									<div>Age</div>
									<div class="col-sm-8 col-xs-12 pad-lt-0 mar-bot-10">
										<div class="col-sm-6 col-xs-12 pad-lr-0" style="font-size: 15px"><input type="textbox" class="age-textbox pull-left"  name ="fromAge" id="fromAge" maxlength="3" value="${fromAge}" placeholder=""/></div>
										<div class="col-sm-2 col-xs-12 pad-lr-0 text-center">to</div>
										<div class="col-sm-4 col-xs-12 pad-lr-0" style="font-size: 15px"><input type="textbox" class="age-textbox age-box" name ="toAge" id="toAge" value="${toAge}" maxlength="3" placeholder=""/></div>
									
									</div>
									<div class="col-sm-4 col-xs-12 pad-lr-0 mar-bot-10"><a class="filter-btn" onclick="getMatchedPatient();" style="cursor: pointer;">Filter</a></div>
								</li>
								
								<li>
									<div>Location</div>
									<div class="col-sm-12 col-xs-12 pad-lt-0">
										<div class="col-sm-6 col-xs-12 pad-lr-0">
											within
											<select name="miles" id="miles">
												<option value = "10">10 Miles</option>
											    <option value = "20">20 Miles</option>
												<option value = "30">30 Miles</option>
											    <option value = "40">40 Miles</option>
											</select>
										</div>
										<div class="col-sm-2 col-xs-12 pad-lr-0 text-center mar-top-30">of</div>
										<div class="col-sm-4 col-xs-12 pad-lr-0">
											of zip
											<input type="textbox" class="zip-textbox" placeholder="" name ="zipcode" id="zipcode" value="${zipcode}" maxlength="6"/>
										</div>
									</div>
									<div class="col-sm-6 col-xs-12 pad-lr-0 pull-right text-right"><a class="filter-btn1" onclick="getMatchedPatient();" style="cursor: pointer;">Filter</a></div>
								</li>
								<g:if test="${cancerStageList}">
								   <li>
									<div>Stage of Cancer</div>
									<div id="scroll" style="font-size: 15px">
									<g:each in="${cancerStageList}" var="cancerStage" status="i">
									<g:if test="${cancerStage?.cancerStageLevel == selectedCancerStage}">
									<input type="checkbox" checked="checked" name="cancerStage" id="cancerStage" value="${cancerStage?.cancerStageLevel}" onclick="getMatchedPatient();"> ${cancerStage?.cancerStageLevel}<br/>
									</g:if><g:else>
									<input type="checkbox"  name="cancerStage" id="cancerStage" value="${cancerStage?.cancerStageLevel}" onclick="getMatchedPatient();"> ${cancerStage?.cancerStageLevel}<br/>
									</g:else>
									</g:each>
									</div>
								   </li>
								</g:if>
								
								<g:if test="${cancerStatusList}">
								<li>
									<div>Status</div>
									<div id="scroll" style="font-size: 15px">
									<g:each in="${cancerStatusList}" var="cancerStatus" status="i">
									<g:if test="${cancerStatus?.aboutYouName == selectedCancerStatusList}">
									<input type="checkbox" checked="checked"  name="cancerStatus" id="cancerStatus" value=" ${cancerStatus?.aboutYouName}"  onclick="getMatchedPatient();"> ${cancerStatus?.aboutYouName}<br/>
									</g:if><g:else>
									<input type="checkbox"  name="cancerStatus" id="cancerStatus" value=" ${cancerStatus?.aboutYouName}"  onclick="getMatchedPatient();"> ${cancerStatus?.aboutYouName}<br/>
									</g:else>
									</g:each>
									</div>
								</li>
								</g:if>
								</ul>
						</div>
						<div class="col-md-9 col-sm-7 col-xs-12 dashboard-sidebar-right">                
						<%--<div class="right-sidebar-nav">	
							<ul>
								<li>Sort by:</li>
								<li><a href="#">Age</a></li>
								<li><a href="#">Match Percentage</a></li>
								<li><a href="#">Location</a></li>
							</ul>
						</div>						 
						--%><g:render template="patientMatchList"></g:render>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	</g:form>	
<script type="text/javascript">
	function getMatchedPatient(){
		var fromAge = $("#fromAge").val();
		var toAge = $("#toAge").val();
		var zipcode = $("#zipcode").val();
		var cancerStage = "";
       // var cancerStatus = "";
        var cancerStage = "";
        $.each($("input[name='cancerStage']:checked"), function(i){ 
            if(i == 0){          
        	  cancerStage  = cancerStage + $(this).val();
            }else{
              cancerStage  = cancerStage + ","+$(this).val();
            }
        });
        

        var cancerStatus ="";
        $.each($("input[name='cancerStatus']:checked"), function(i){ 
        	if(i == 0){             
        	    cancerStatus = cancerStatus + $(this).val();
        	}else{
        		cancerStatus = cancerStatus + ","+$(this).val();
             }
        });      
		var miles = $("#miles").val();
		var matches = $("#matches").val();
		$.ajax({
             async  : true,
             type   : "POST",
             url    : "../patientMatch/filterMatchPatientList",
             data   : {fromAge:fromAge,toAge:toAge,zipcode:zipcode,cancerStage:cancerStage,cancerStatus:cancerStatus,matches:matches},
             success : function(res){
               $("#patientmatchList").html(res);
                var searchValTotal = $("#searchValueTotal").val();
             	 if(searchValTotal!=null && searchValTotal!="" && searchValTotal != 'undefined'){
             	    $("#count").html("Matches ("+searchValTotal+")");
             	 }else{
             		 $("#count").html("Matches (0)");
                 	 }
             }
         })
	}
	function isConnected(patientId,toAge,fromAge,zipcode,selectedCancerStage,selectedCancerStatusList,patientMatchSearch){
			   if(patientId !=null && patientId != ''){
	                $.ajax({
	                    async  : true,
	                    type   : "POST",
	                    url    : "../patientMatch/sendRequest",
	                    data   : {patientId:patientId,toAge:toAge,fromAge:fromAge,zipcode:zipcode,selectedCancerStage:selectedCancerStage,selectedCancerStatusList:selectedCancerStatusList,patientMatchSearch:patientMatchSearch},
	                    success : function(res){
	                    $("#patientmatchList").html(res);
	                    }
	                })
				}else{
	               return false;
				}
	    }
		function getNextRecords(patientMatchMapTotal,toAge,fromAge,zipcode,selectedCancerStage,selectedCancerStatusList,patientMatchSearch,offset){
               $.ajax({
                  async : false,
                  type  : 'Post',
                  url   : '../patientMatch/ajaxPaginatePatientMatch',
                  data  : {size:patientMatchMapTotal,toAge:toAge,fromAge:fromAge,zipcode:zipcode,selectedCancerStage:selectedCancerStage,patientMatchSearch:patientMatchSearch,selectedCancerStatusList:selectedCancerStatusList,offset:offset},
                  success : function(res){
                	  $("#patientmatchList").html(res);
                  }

               })
		}
		$("#fromAge ,#toAge").keydown(function (event) {

		    if (event.shiftKey == true) {
		        event.preventDefault();
		    }

		    if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105) || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 190) {

		    } else {
		        event.preventDefault();
		    }

		});

		    
		    $("#matchSearch").keyup(function(){ 
		    	var searchValue = $.trim($("#matchSearch").val());
		    	var matches = $.trim($("#matches").val());
		    	var fromAge = $.trim($("#fromAge").val());
		    	var toAge = $.trim($("#toAge").val());
		    	var zipcode = $.trim($("#zipcode").val());
		    	var cancerStage = "false";
		    	var cancerStatus = "false";
		    	$('input:checkbox[name=cancerStage]').each(function() 
	    			{    
	    			    if($(this).is(':checked'))
	    			    	cancerStage = "true";
	    			});
		    	$('input:checkbox[name=cancerStatus]').each(function() 
		    			{    
		    			    if($(this).is(':checked'))
		    			    	cancerStatus = "true";
		    			});
    			
	            $.ajax({
	                async : true,
	                type  : "POST",
	                url   : "../patientMatch/searchPatientMatch",
	                data  : {searchValue:searchValue,matches:matches,fromAge:fromAge,toAge:toAge,zipcode:zipcode,cancerStage:cancerStage,cancerStatus:cancerStatus},
	                success : function(res){
	                     $("#patientmatchList").html(res);
	                	 var searchValTotal = $("#searchValueTotal").val();
	                	 if(searchValTotal!=null && searchValTotal!="" && searchValTotal != 'undefined'){
	                	    $("#count").html("Matches ("+searchValTotal+")");
	                	 }else{
	                		 $("#count").html("Matches (0)");
	                    	 }
	                }
	              })

			   });
		 <%-- function sortPatientMatch(sort){
		    	if(sort !=null && sort != ''){
			    	 $.ajax({
	                    async  : false,
	                    type   : "POST",
	                    url    : "../patientMatch/sortPatientMatch",
	                    data   : {sort:sort},
	                    success : function(res){
	                      $("#patientmatchList").html(res);
	                    }
	                })
				}else{
	               return false;
				}
			}
	--%></script>
	
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'assets/bootstrap/js',file:'bootstrap.min.js')}"></script>
</body>
</html>

