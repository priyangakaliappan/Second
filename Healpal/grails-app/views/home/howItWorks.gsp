<%--
 *
 * Author  		: Priyanga K
 * Project 		: HealPal
 * Date    		: 11/03/2015
 * FileName 	: how It Works
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Priyanga K     1.0       11/03/2015      Initial Creation
 * 
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="demo" />
<title>Match</title>
</head>
<body>
	<div class="fixed-header"></div>
	<section id="how-works">
		<div id="together">
			<!-- together section start here--->
			<div class="container">
				<div class="col-md-12 text-center heading">
					<h1>How it Works</h1>
					<div class="row">
						<div class="col-sm-4">
							<h3>Learn</h3>
							<img
								src="${resource(dir:'assets/images',file:'new-icon-large-1.png')}"
								class="img-responsive" />
							<p>Know more about your condition.</p>
						</div>
						<!--sm-4-->

						<div class="col-sm-4">
							<h3>Match</h3>
							<img
								src="${resource(dir:'assets/images',file:'new-icon-large-2.png')}"
								class="img-responsive" />
							<p>You are matched with patients who are most similar to you.
							</p>
						</div>
						<!--sm-4-->

						<div class="col-sm-4">
							<h3>Connect</h3>
							<img
								src="${resource(dir:'assets/images',file:'new-icon-large-3.png')}"
								class="img-responsive" />
							<p>Connect with matched patients and learn from their
								experiences.</p>
						</div>
						<!--sm-4-->
						<div class="clearfix"></div>
					</div>
					<!--row-->
				</div>
			</div>
		</div>
		<!-- end here-->
	</section>

</body>
</html>