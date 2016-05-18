<%--
 *
 * Author  		: Karthigeyan
 * Project 		: PatientPortal
 * Date    		: 08/28/2013
 * Description	: admin screens layout
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0        08/27/2013        Initial Creation
 *
 *
--%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
     <title>  Healpal</title>
     <asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico" type="image/x-icon"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="${resource(dir:'admin/css',file:'bootstrap.min.css')}" rel="stylesheet">
    <link href="${resource(dir:'admin/css',file:'fontello.css')}" rel="stylesheet">
    <link href="${resource(dir:'admin/css',file:'style.css')}" rel="stylesheet">
	
    <link href="${resource(dir:'admin/css',file:'datepicker.css') }" rel="stylesheet">
    <link href="${resource(dir:'admin/css',file:'colorpicker.css')}" rel="stylesheet">
    <link href="${resource(dir:'admin/css',file:'timepicker.css') }" rel="stylesheet">
	<link href="${resource(dir:'admin/css',file:'tinyeditor.css') }" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Crete+Round|Pathway+Gothic+One|Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
<script src="../assets/js/logout.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
  </head>

  <body>
    <div id="bg-pp-img">
    <img src="${resource(dir:'admin/image/backgrounds',file:'bg.jpg')}" alt="Healpal Background Image">
    </div>
    <div id="wrap">
      <!-- Main window -->
      <div class="container-fluid">
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
        <div id="">
          <div id="logocontainer">
					<a href="index.html" class="logo">
						<img class="img-responsive" src="${resource(dir:'assets/image',file:'logo.png')}">
					</a>
		  </div>
        </div>
        <!-- Side menu -->
        <!-- The colors are defined in the css around line 555 with nth-child, which means the colors are dynamic -->
        <div class="navbar themebgcolor">
          <div class="sidebar-nav nav-collapse collapse themebgcolor">
            <div class="navbar-inner themebgcolor" >
              <div class="accordion" id="main-accordion">
 				<div class="accordion-group">
                  <div class="accordion-heading">
                   <g:link controller="SurgicalProcedure" action="view"  class="accordion-toggle" href="index.html"><div class="menubg" id="dashboard"></div><i class="icon-home-1"></i><span>Surgical Procedure</span></g:link>
                  </div>
                </div>
				<div class="accordion-group">
                  <div class="accordion-heading">
                     <g:link controller="ChemotherapyDrugs" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Chemotherapy Drugs</span></g:link>
                  </div>
                </div>
                <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="HormoneTherapy" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Hormone Therapy</span></g:link>
                  </div>  
                  </div>
                   <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="MetastaticBreastCancer" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Metastatic Cancer</span></g:link>
                  </div>  
                  </div>     
                   <div class="accordion-group">
                 <div class="accordion-heading">
                     <g:link controller="Drugs" action="view" class="accordion-toggle" ><div class="menubg" id="profile"></div><i class="icon-user-3"></i><span>Drugs</span></g:link>
                  </div>  
                  </div>                    
              </div>
            </div>
          </div>
        </div>
   <g:layoutBody />
        
    </div><!-- /wrap -->
	</div>
	<%--<jawr:script src="/i18n/messages.js"/>--%>
	    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
  </body>
</html>
