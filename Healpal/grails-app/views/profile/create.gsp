<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Insert title here</title>
</head>
<body>
 <g:form class="form-horizontal" controller="profile"  action="create" >
	<div class="body">

		<div>
			FirstName <input type="text" name="firstname">
		</div>
		<br>
		<div>
			LastName <input type="text" name="lastName">
		</div>
		<br>
		
		<div>
			LastName <input type="text" name="phoneNumber">
		</div>
		
		<div>
			Gender male<input type="radio" name="male" /> Female<input
				type="radio" name="male" />
		</div>
		<br>
		<div>
			DOB
			<g:datePicker name="myDate" value="${new Date()}" precision="day"
				years="[1930, 1940, 1950, 1960, 1970]" />
		</div>
		<br>


		<div>
			Email <input type="text" name="email">
		</div>
		<br>
		<div>
			I am Currently living in <input type="text" name="address1"
				placeholder="Street address no 1"> <input type="text"
				name="address2" placeholder="Street address no 2">
		</div>
		<div>
			<br> Country
			<g:countrySelect name="user.country" value="${country}"
				noSelection="['':'-Choose your country-']" />
		</div>
		<br>
		<div>
			State <input type="text" name="state">
		</div>
		<br>

		<div>
			City <input type="text" name="city">
		</div>
		<br>

		<div>
			ZipCode <input type="text" name="zipcode">
		</div>
		
		<br>
		<div>
			Language <input type="text" name="language">
		</div>
		
		<div>
			Time Zone <input type="text" name="timezone">
		</div>
<div>
<g:actionSubmit value="submit" controller="Profile"  action="create"/>
</div>
	</div>
	</g:form>
</body>
</html>