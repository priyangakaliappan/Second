<!DOCTYPE html>
<%@ page import="com.healpal.care.Role"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>  Healpal</title>
     <asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico" type="image/x-icon"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="${resource(dir:'admin/css',file:'bootstrap.min.css')}" rel="stylesheet">
    <link href="${resource(dir:'admin/css',file:'fontello.css')}" rel="stylesheet">
    <link href="${resource(dir:'admin/css',file:'style.css')}" rel="stylesheet">
	<link href="${resource(dir:'admin/css',file:'tinyeditor.css') }" rel="stylesheet">
	<link href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.css')}" rel="stylesheet">
<link href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}" rel="stylesheet">
<link href="${resource(dir:'assets/css',file:'colorbox.css')}" rel="stylesheet" type="text/css">
<script src="../assets/js/jquery-1.11.1.js"></script>

    <link href='https://fonts.googleapis.com/css?family=Crete+Round|Pathway+Gothic+One|Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
  </head>

  <body class="admin-pad">
    <div id="bg-pp-img">
   </div>
    <div id="wrap">
      <!-- Main window -->
      <div class="">
	  <!-- Top menu -->
        <div id="topmenu">
          <div class="container-fluid">
            <a class="btn btn-navbar slide_menu_left boxshadow visible-tablet">
              <span class="icon-menu-1"></span>
            </a>
            <a class="btn btn-navbar slide_menu_down boxshadow visible-phone" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-menu-1"></span>
            </a>
          </div>
        </div>
        <!-- Header -->
        <header class="main-header">
          <div id="logocontainer">
			<g:link controller="dashboard" action="adminDashboard" class="logo dashboard-logo">
     			 <img class="img-responsive" src="../assets/new-design/img/logo.png">
     		</g:link>
		  </div>
		  <nav role="navigation" class="navbar navbar-static-top">
		  	<a role="button" data-toggle="offcanvas" class="sidebar-toggle" href="#">
            <span class="sr-only"></span>
          </a>
            <div class="navbar-custom-menu">
            	 <ul class="nav navbar-nav">
            	 
            		 <li class="dropdown user user-menu">
                	 <g:link class="dropdown-toggle" controller="Dashboard" action="quickMail">Quick Mail</g:link></li>
            	 	<li class="dropdown user user-menu">
                	  <a id="change_pwd" data-toggle="modal" data-target="#forgotpassword" class="dropdown-toggle" href="#">Change Password</a></li>
	            	<li class="dropdown user user-menu">
	                <g:link controller="Auth" action="doLogout" class="dropdown-toggle">Sign Out</g:link></li>
            	 </ul>
            </div>
		  </nav>
        </header>
        <!-- Side menu -->
        <!-- The colors are defined in the css around line 555 with nth-child, which means the colors are dynamic -->
        <div class="navbar themebgcolor theme-color">
          <div class="sidebar-nav nav-collapse collapse themebgcolor">
            <div class="navbar-inner themebgcolor" >
            <g:if test="${session.authority?.equalsIgnoreCase(Role.admin)}">
              <div class="accordion" id="main-accordion">
              
               <div class="accordion-group">
                 <div class="accordion-heading">
                  <a href="javascript:void(0);" class="staticqus"><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Static Questions <i class="admin-plus-icon"></i></span></a>
                 	<div id="demo">
					    <ul>
					    
					    	<li> <div class="accordion-group">
                 <div class="accordion-heading">
                  <g:link controller="aboutYou" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>About You</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li><div class="accordion-group">
                 <div class="accordion-heading">
                  <g:link controller="aboutPassionate" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>About/Passionate</span></g:link>
                  </div>  
                  </div></li>
                  
                  
					    	<li><div class="accordion-group">
                   <div class="accordion-heading">
                     <g:link controller="cancerStage" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Cancer Stage</span></g:link>
                   </div>  
                  </div></li>
                  
					    	<li> <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="CancerStatus" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Cancer Status</span></g:link>
                  </div>  
                  </div></li>
                
					    	<li><div class="accordion-group">
                   <div class="accordion-heading">
                     <g:link controller="diagnosis" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Diagnosis</span></g:link>
                   </div>  
                  </div></li>
                  
					    	<li> <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Education" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Education</span></g:link>
                  </div>  
                  </div></li>
                  
					    	<li> <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Ethinicity" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Ethnicity</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li> <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="HealthInsurance" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Health Insurance</span></g:link>
                  </div>  
                  </div></li>
                  
                  
                  <li><div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Race" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Race</span></g:link>
                  </div>  
                  </div></li>
                
                  </ul>
					 </div>
                  </div>  
                  </div>
                  
                 <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="auditEvent" action="view"  class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Audit Logs</span></g:link>
                  </div>
                </div>
              
              
              <div class="accordion-group">
                 <div class="accordion-heading">
                  <a  class="auth"><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Authentication <i class="admin-plus-icon"></i></span></a>
                 	<div id="demo1">
					    <ul>
					    	
					    	<li><div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="role" action="view"  class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Role</span></g:link>
                  </div>
                </div></li>
                
					    	<li><div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="user" action="view" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>User</span></g:link>
                  </div>
                </div></li>
					    	<li><div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="userRole" action="view"  class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>User Role</span></g:link>
                  </div>
                </div> </li>
                
					    </ul>
					 </div>
                  </div>  
                  </div>
 				
                 
 				
                 <%--<div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Demographic" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Demographic</span></g:link>
                  </div>  
                  </div>
                 --%>
           
                    
                  <div class="accordion-group">
 					<div class="accordion-heading">
                   		 <%--<g:link controller="PatientUpload" action="fileUpload" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Patient Upload</span></g:link>
                 	 --%></div>
                </div>
 				  
 				<div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="dynamicProfileQues" action="view"  class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Profile Questions</span></g:link>
                  </div> 
                </div> 
                  
                  <%--  
                 <div class="accordion-group">
                  <div class="accordion-heading">
                     <g:link controller="radiationTreatment" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Radiation Treatment</span></g:link>
                  </div>
                 </div>
 				 --%>
 				  
 				
 				<%--<div class="accordion-group">
                  <div class="accordion-heading">
                     <g:link controller="targettedTheraphy" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Targetted Theraphy</span></g:link>
                  </div>
                </div>
 				--%>
                <div class="accordion-group">
                 <div class="accordion-heading">
                  <a class="breastCancer"><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Breast Cancer <i class="admin-plus-icon"></i></span></a>
                 	<div id="breast">
					    <ul>
                  
					    	<li><div class="accordion-group">
                  <div class="accordion-heading">
                     <g:link controller="ChemotherapyDrugs" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Chemotherapy Drugs</span></g:link>
                  </div>
                </div></li>
                
					    	<li><div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Drugs" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Drugs</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li> <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="HormoneTherapy" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Hormone Therapy</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li><div class="accordion-group">
                  <div class="accordion-heading">
                     <g:link controller="medicalCondition" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Medical Condition</span></g:link>
                  </div>
                </div></li>
                
                  <li> <div class="accordion-group">
                	 <div class="accordion-heading">
                     <g:link controller="MetastaticBreastCancer" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Metastatic Cancer</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li><div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="molecularTesting" action="list" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Molecular Testing</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li> <div class="accordion-group">
                   <div class="accordion-heading">
                     <g:link controller="pathology" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Pathology</span></g:link>
                   </div>  
                  </div></li><%--
                  
                  <li><div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="PersonalInterest" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Personal Interest</span></g:link>
                  </div>  
                  </div></li>
                  
                  
                  --%><li><div class="accordion-group">
                  <div class="accordion-heading">
                     <g:link controller="sideEffects" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Side Effects</span></g:link>
                  </div>
                </div> </li>
                
                  <li><div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Surgery" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Surgery</span></g:link>
                  </div>  
                  </div></li>
                  
                  <li><div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="SurgicalProcedure" action="view"  class="accordion-toggle" href="index.html"><div class="menubg" id="profile"></div><i class="icon-home-1"></i><span>Surgical Procedure</span></g:link>
                  </div>
                </div></li>
                
                  </ul>
					 </div>
                  </div>  
                  </div>
                
                 <div class="accordion-group">
 					<div class="accordion-heading">
                   		 <g:link controller="dashboard" action="adminEmail" class="accordion-toggle"><div class="menubg" id=""></div><i class="icon-home-1"></i><span>View Mail</span></g:link>
                 	 </div>
                </div>
                
                
                <div class="accordion-group">
 					<div class="accordion-heading">
                   		 <g:link controller="Auth" action="doLogout" class="accordion-toggle"><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Logout</span></g:link>
                 	 </div>
                </div>
                </div>
                
                 </g:if>
                 <g:elseif test="${session.authority?.equalsIgnoreCase(Role.SuperAdmin)}">
                 <div class="accordion" id="main-accordion">
     		<div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="user" action="view" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>User</span></g:link>
                  </div>
                </div>
                
                
                 <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="GroupMail" action="view" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Future Requestors</span></g:link>
                  </div>
                </div>
                
                 <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="BreastCancer" action="view" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>FeedBack Count</span></g:link>
                  </div>
                </div>
                
                <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="role" action="view"  class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Role</span></g:link>
                  </div>
                </div>
                
               
                
                
                <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="userRole" action="view"  class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>User Role</span></g:link>
                  </div>
                </div> 
                <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="userDetails" action="list" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Registered Details</span></g:link>
                  </div>
                </div>
                <%--<div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="userDetails" action="loginCount" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Hit Count Details</span></g:link>
                  </div>
                </div>
                --%>
                <div class="accordion-group">
 					<div class="accordion-heading">
                   		 <g:link controller="CancerTreatment" action="view" class="accordion-toggle"><div class="menubg" id=""></div><i class="icon-home-1"></i><span>CancerType Count</span></g:link>
                 	 </div>
                </div>
                
                <div class="accordion-group">
 					<div class="accordion-heading">
                   		 <g:link controller="GetAnswers" action="view" class="accordion-toggle"><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Get Answers</span></g:link>
                 	 </div>
                </div>
               <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="ShareYourStory" action="view" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Share your Story</span></g:link>
                  </div>
                </div>
                
                 <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="StageOfCancer" action="patientCount" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>StageOF Cancer</span></g:link>
                  </div>
                </div>
                
                 <div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="WriteAReview" action="view" class="accordion-toggle" ><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Write A Review</span></g:link>
                  </div>
                </div>
              <div class="accordion-group">
 					<div class="accordion-heading">
                   		 <g:link controller="Auth" action="doLogout" class="accordion-toggle"><div class="menubg" id=""></div><i class="icon-home-1"></i><span>Logout</span></g:link>
                 	 </div>
                </div>
                </div>
                 </g:elseif>
                 
              </div>
              </div>
              </div>
        
        
   <g:layoutBody />
        
    </div><!-- /wrap -->
	</div>
	<div id="forgotpassword" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<button type="button" class="close" data-dismiss="modal"></button>
			<div class="clearfix"></div>
			<div class="modal-body">
				<g:formRemote name="forgotForm"
					url="[controller: 'forgotPassword', action: 'changeAdminPassword']"
					update="reset" id="resett">
						<input class="textbox" type="password" name="oldPassword" id="oldPassword" autocomplete="on"
						required="" placeholder="Enter your Password" maxlength="128"><br><br>
						<input class="textbox" type="password" name="newPassword" id="newPassword" autocomplete="on"
						required="" placeholder="Enter new Password" maxlength="128"><br><br>
						<input class="textbox" type="password" id="confirmPassword" name="confirmPassword" autocomplete="on"
						required="" placeholder="Confirm new Password" maxlength="128"><br>
						<input type="hidden" name="resetUserId" value="${session.user?.id}">
					<div>
					<span id="reset"></span><br><br>
						<g:submitButton value="Submit"
							class="submit-btn-s" name="send" id="changePassword"></g:submitButton>
						<input type="button" value="Cancel"
							class="cancel-btn-s" data-dismiss="modal" name="cancel"/>
					</div>
				</g:formRemote>
			</div>
		</div>
	</div>
</div>
	<%--<jawr:script src="/i18n/messages.js"/>--%>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/bootstrap/js',file:'bootstrap.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'logout.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'signup.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'trim.js')}"></script>
<script type="text/javascript" src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery.colorbox.js')}"></script>
  <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                $("#searchUser").datepicker({
                	endDate: '+0d',
                    autoclose: true
                    
                });  
            
            });
        </script>
         <script type="text/javascript">
            // When the document is ready
            function categoryChanged(cancerId){
                

<g:remoteFunction controller="userDetails" action="cancelist" update="cancerDetail" params="'cancerId='+cancerId"/>
                }
        </script>
        
         <script type="text/javascript">
         $("#demo").hide();
         $("#demo1").hide();
         $("#breast").hide();
$("#search").click(function(){
	var searchValue = $.trim($("#searchUser").val());
	 $.ajax({
		    async : false,
		    type  : "POST",
		    url   : "../userDetails/list",
		    data  : {searchValue:searchValue},
		    success : function(res){
		        $("#userDetail").html(res); 	 
		    }
		  })
});

$(".staticqus").click(function(){
	if($(this).hasClass("admin-icon"))
	{
		$(this).removeClass("admin-icon");
	}else{
		$(this).addClass("admin-icon");
	}
	$("#demo").toggle(function(){
        $(this).css('background-color', '#D3D3D3');
    });
});

$(".breastCancer").click(function(){
	if($(this).hasClass("admin-icon"))
	{
		$(this).removeClass("admin-icon");
	}else{
		$(this).addClass("admin-icon");
	}
	$("#breast").toggle(function(){
        $(this).css('background-color', '#D3D3D3');
    });
	
});

$(".auth").click(function(){
	if($(this).hasClass("admin-icon"))
	{
		$(this).removeClass("admin-icon");
	}else{
		$(this).addClass("admin-icon");
	}
	$("#demo1").toggle(function(){
        $(this).css('background-color', '#D3D3D3');
    });
})
</script>

<script type="text/javascript">
$("document").ready(function(){
	var url = window.location.href;
	var page = url.substring(url.indexOf("Healpal/")+8,url.lastIndexOf("/"));
	//alert(page);
	$(".textbox").keyup(function(){
	var searchValue = $(this).val();		
		$.ajax({
			async : true,
			type : 'POST',
			url : '../'+page+'/searchValues',
			data : {
				searchValue : searchValue,
			},
			success : function(res) {
				$(".searchList").html(res);
				
				///select all checkboxes///
				$("#alertHide").hide();
				$("#selectall").click(function(){
			        if(this.checked){
			            $('.checkboxall').each(function(){
			                this.checked = true;
			            })
			        }else{
			            $('.checkboxall').each(function(){
			                this.checked = false;
			            })
			        }
			    });
			}
		});
	});
})
</script>
<script type="text/javascript">
     $("document").ready(function(){
         $("#change_pwd").click(function(){
        	 $("#newPassword").val() ==  ""
        		 $("#confirmPassword").val() == ""
            		 $("#oldPassword").val() == ""
             });
$("#changePassword").click(function(){
	if($("#newPassword").val() != $("#confirmPassword").val()){
alert("NewPassword and ConfirmPassword should be same")
return false;
		}
	else{
		return true;}
});
     });
     </script>  	       
  </body>
</html>
