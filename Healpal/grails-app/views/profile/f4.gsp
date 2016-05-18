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
		<g:form action="f4" method="post">
			<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/profile/img/f1-icon.jpg" /></div>
								<h3 class="pad-bot-0">Did you undergo treatment for metastatic  breast cancer. <br> if yes, please choose the treatment administered to you</h3>
								<div class="list-content">
								<g:if test="${metastaticBreastCancer }">
								<input type="hidden" value="Did you undergo treatment for metastatic breast cancer.if yes, please choose the treatment administered to you" name="question">
								<g:each in="${metastaticBreastCancer}" var="patient">
									<div class="col-md-6 col-xs-12 pad-lt-0 t-pad-rt">
										<ul>
										
											<li>
												<input type="checkbox" value="${patient?.metastaticName}" id="${patient?.id}" name="metastaticBreastCancer" class="checkboxSelect" />
												<label for="${patient?.id}" class="selectedLabels"> ${patient?.metastaticName} </label>
											</li>
											
										</ul>
									</div>
									</g:each></g:if>
									<%--<div class="col-md-6 col-xs-12 pad-rt-0 t-pad-lr">
										<ul>
											<li><a href="g1.html">Capecitabine or Xeloda </a></li>
											<li><a href="g1.html">Carboplatin or Paraplatin</a></li>
											<li  class="active"><a href="g1.html">Cyclophosphamide or Cytoxan</a></li>
											<li><a href="g1.html">Doxorubicin or Adriamycin</a></li>
											<li><a href="g1.html">Erubulin or Halaven</a></li>
											<li><a href="g1.html">Cyclophosphamide or Cytoxan</a></li>
											<li><a href="g1.html">Gemcitabine or Gemzar</a></li>
											<li><a href="g1.html">Liposomal doxorubicin or Doxil</a></li>
											<li><a href="g1.html">Paclitaxel or Taxol</a></li>
										</ul>
									</div>
								--%></div>
								<p>( You can select one or multiple choices )</p>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:if test="${BackTof1}">
						<g:link controller="Profile" action="f1" class="back-link"><i class="back-arrow"></i>Back</g:link>
					</g:if>
					<g:else>
					<g:link controller="Profile" action="f3" class="back-link"><i class="back-arrow"></i>Back</g:link>
					</g:else>
					<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">19/19</div>
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
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>					
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>0 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
			
		</g:form></div></div></section>
		<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">19/19</div>
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
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>					
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>0 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
--%></body>
</html>