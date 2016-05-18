<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: doctor details
 *
 * #      Name         Version      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga      1.0          	Initial Creation
 * 2   Priyanga      2.0            Modification
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="demo" />
<title>Find Doctor</title>
</head>
<body>
	<section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<g:if test="${doctorProfile}">
						<g:each in="${doctorProfile}" var="profile">
							<h2>
								${profile?.doctorName}
							</h2>
							<div>
								<div class="star-icon pull-left">
									<a class="orange-star" href="JavaScript:void(0)"></a> <a
										class="orange-star" href="JavaScript:void(0)"></a> <a
										class="orange-star" href="JavaScript:void(0)"></a> <a
										class="gray-star" href="JavaScript:void(0)"></a> <a
										class="gray-star" href="JavaScript:void(0)"></a>
								</div>
								<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
							</div>
							<br>
							<div>
								${profile?.specialty}
							</div>
							<div>
								${profile?.street1},
								${profile?.address?.city},
								${profile?.address?.state }-${profile?.zipcode}
							</div>
						</g:each>
					</g:if>
				</div>

			</div>
		</div>
	</section>
</body>
</html>