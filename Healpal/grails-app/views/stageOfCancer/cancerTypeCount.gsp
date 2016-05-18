<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.healpal.care.Diagnosis"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="admin" />
<script src="../assets/js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="tables_page" class="main_container glass ">
		<div class="row-fluid title orange-topstripe">
			<%--<h1>
				Dashboard <small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Dashboard</small>
			</h1>
			--%><h1>
				Dashboard
				</h1>
				<div class="pull-right"><small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Dashboard  </small>
			</h1></div>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="StageOfCancer" action="breastCountList">
								<div class="blue-dashboard-content">
									<p class="box-content" style="left:13%;">
										Breast Cancer<br>
										${breastCount}
									</p>
									<div class="clearfix"></div>
								</div>
					</g:link>



							<g:link controller="stageOfCancer" action="lungCancerList">
								<div class="green-dashboard-content">
									<p class="box-content" style="left:18%;">
										Lung Cancer<br>
										${lungCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="yellow-dashboard-content">
									<p class="box-content" style="left:18%;">
										Colon Cancer<br>
										${colonCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="red-dashboard-content">
									<p class="box-content" style="left:24%;">
										Prostate<br> Cancer<br>
										${prostateCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<div class="clearfix mar-bot-15"></div>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="blue-dashboard-content">
									<p class="box-content" style="left:18%;">
										Skin Cancer<br>
										${skinCount }
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="green-dashboard-content">
									<p class="box-content" style="left:12%;">
										Kidney Cancer<br>
										${kidneyCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="yellow-dashboard-content">
									<p class="box-content" style="left:26%;">
										Bladder<br> Cancer<br>
										${bladderCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="red-dashboard-content">
									<p class="box-content" style="left:18%;">
										NHL Cancer<br>
										${nHLCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<div class="clearfix mar-bot-15"></div>


							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="blue-dashboard-content">
									<p class="box-content" style="left:18%;">
										Endometrial<br> Cancer<br>
										${endometrialCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>

							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="green-dashboard-content">
									<p class="box-content" style="left:18%;">
										Leukemia<br>Cancer<br>
										${leukemiaCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>

							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="yellow-dashboard-content">
									<p class="box-content" style="left:25%;">
										Stomach<br> Cancer<br>
										${stomachCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>

							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="red-dashboard-content">
									<p class="box-content" style="left:18%;">
										Brain Cancer<br>
										${brainCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<div class="clearfix mar-bot-15"></div>

							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="blue-dashboard-content">
									<p class="box-content" style="left:18%;">
										Ovary Cancer<br>
										${ovaryCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>



							<g:link controller="stageOfCancer" action="cancerTypeCount">
								<div class="green-dashboard-content">
									<p class="box-content" style="left:18%;">
										Other Cancer<br>
										${otherCount}
									</p>
									<div class="clearfix"></div>
								</div>
							</g:link>
							<%--<a href="#">
								<div class="yellow-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="red-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<div class="clearfix mar-bot-15"></div>
							<a href="#">
								<div class="blue-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="green-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="yellow-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="red-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<div class="clearfix mar-bot-15"></div>
							<a href="#">
								<div class="blue-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="green-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="yellow-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
							<a href="#">
								<div class="red-dashboard-content">
									<p class="box-content">Content</p>
									<div class="clearfix"></div>
								</div>
							</a>
						--%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">


alert("hai");

	

</script>
</html>