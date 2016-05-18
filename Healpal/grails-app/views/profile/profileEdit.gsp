<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 10/25/2015 
 * FileName 	: profileEdit
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       10/25/2015      Initial Creation
 * 
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript"
	src="${resource(dir:'js',file:'jquery-1.10.2.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/profile',file:'profile.js')}"></script>
<title>Profile</title>
</head>
<body>
	<g:form class="form-horizontal" controller="profile"
		action="profileEdit" onsubmit="return profileValidation();"
		method="post">
		<div class="body">
			<div>
				FirstName <input type="text" name="firstname" id="firstname"
					value="${person.firstName}">
			</div>
			<br>
			<div>
				LastName <input type="text" name="lastName" id="lastName"
					value="${person.lastName}">
			</div>
			<br>
			<div>
				<label>Status:</label>
				<div>
					<g:radio name="status" value="active"
						checked="${person?.isActive==1}" />
					Active
					<g:radio name="status" value="inactive"
						checked="${person?.isActive==0}" />
					InActive
				</div>
			</div>
			<div>
				<br> Email <input type="email" name="email" placeholder="email"
					disabled="disabled" id="email" value="${person.emailAddress}">
			</div>
			<br>
			<div id="err1" style="padding-left: 0px">
				<g:if test="${flash.msg}">
					<span style="color: red" id="errorMsg"> ${flash.msg}
					</span>
				</g:if>
			</div>
			<div>
				<input type="submit" value="update" controller="profile"
					action="profileEdit" />
			</div>
		</div>
	</g:form>
</body>
</html>