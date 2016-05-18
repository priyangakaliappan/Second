<%--/**
 *
 * Author  		: L.Ramesh
 * Project 		: HealPal
 * Date    		: 09/01/2013
 * Description	: profileEdit
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   L.Ramesh   1.0        09/11/2015       Initial Creation
 *
 */
--%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Add Patient Profile
				<small><g:link 
						class="blue-text">
					Home
					</g:link> <i class="icon-angle-double-right"></i> Add MePatient Profile</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if><%--
									<g:formRemote name="signupForm" url="[controller: 'Patient', action: 'save']" update="res" class="form-horizontal">--%>
							<g:form controller="Patient" name="" class="form-horizontal">
								<h4 class="blue-text">
									Add Patient Profile
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
									<div class="control-group">
										<label class="control-label"><b>First Name</b><span style="color: red">*</span></label>
										<div class="controls">
											 <g:textField name="firstName" id="firstName" class="span7" required="required"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Last Name</b><span style="color: red">*</span></label>
										<div class="controls">
											 <g:textField name="lastName" id="lastName" class="span7" required="required"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Full Name</b></label>
										<div class="controls">
											 <g:textField name="fullName" id="fullName" class="span7"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Gender</b></label>
										<div class="controls">
											<g:select id="gender" class="span7" from="${gender}"
											optionKey="id" name="gender" optionValue="genderName"
											noSelection="['': 'Select']"/>
										</div>
									</div>	
									<div class="control-group">
										<label class="control-label"><b>Date of Birth</b></label>
										<div class="controls">
											<g:textField name="dob" id="dob" class="span7"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Language</b></label>
										<div class="controls">
											<g:select id="language" class="span7" from="${language}"
											optionKey="id" name="language" optionValue="languageName"
											noSelection="['': 'Select']"/>
										</div>
									</div>	
									<div class="control-group">
										<label class="control-label"><b>Email Address</b><span style="color: red">*</span></label>
										<div class="controls">
											 <g:textField name="email" id="email" class="span7" required="required"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Phone Number</b><span style="color: red">*</span></label>
										<div class="controls">
											 <g:textField name="phoneNumber" id="phoneNumber" class="span7" required="required"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Ethnicity</b><span style="color: red">*</span></label>
										<div class="controls">
											<g:select name="ethnicity" id="ethnicity" class="span7" from="${ethnicity}"
											optionKey="id" name="ethnicity" optionValue="ethnicityName"
											noSelection="['': 'Select']" required="required"/>
										</div>
									</div>	
									<div class="control-group">
										<label class="control-label"><b>Race</b><span style="color: red">*</span></label>
										<div class="controls">
											<g:select name="race" id="race" class="span7" from="${race}"
											optionKey="id" name="race" optionValue="raceName"
											noSelection="['': 'Select']" required="required"/>
										</div>
									</div>	
									<div class="control-group">
										<label class="control-label"><b>Timezone</b></label>
										<div class="controls">
											<g:select name="timezone" id="timezone" class="span7" from="${timezone}"
											optionKey="id" name="timezone" optionValue="timezoneName"
											noSelection="['': 'Select']"/>
										</div>
									</div>	
									<div class="control-group">
										<label class="control-label"><b>Company Name</b></label>
										<div class="controls">
											 <g:textField name="companyName" id="companyName" class="span7"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Describe About Yourself</b></label>
										<div class="controls">
											 <g:textArea name="describe" id="describe" class="span7"/>
										</div>
									</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Save" action="save"class="btn btn-info" />&nbsp;&nbsp;
											<g:link controller="Patient" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
									</div>
									<div id="res"></div>
										<%--</g:formRemote>--%>
										</g:form>
									</div></div></div></div></div>
		
		
		
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>
