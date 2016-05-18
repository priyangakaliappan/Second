<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="care"/>
<title>::.. Healpal | Received ..::</title>
</head>
<body>
  <g:render template="../template/careMenu"></g:render>
  
  <section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<g:render template="menu"></g:render>
				
				<div class="col-sm-8 col-xs-12" style="width:100%;">
					<div class="box-content9">
						 	 <g:render template="received"></g:render>  					
					</div>
  				</div>
				
			</div>
		</div>
  </section>
  
  
  
  <!-- POP up -->
   <div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog" style="width:500px;">
			<div class="modal-content" style="width:500px;">
				<a href="#" class="close-icon" data-dismiss="modal"></a>
				<div class="login-bss">
					<div class="modal-header">
						<h2>View</h2>
					</div>
					<div class="login-bss-cont">
						
						<div class="col-sm-8 pad-lt-0 login-right-cont">
							<div class="right" id="messageId">
								
								
								
							</div> <!--right-->
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
  
  
  <script type="text/javascript">
		$(document).ready(function(){
			$(".header-search-box").hide();
					});

		</script>
  
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
  
  
</body>
</html>