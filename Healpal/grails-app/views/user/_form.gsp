<%@page import="com.healpal.care.ProfilePhoto"%>
<%@page import="com.healpal.authentication.UserController"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<g:if test="${action == 'create'}">
	<g:set var="req" value="required"></g:set>
</g:if>
<g:form controller="user" action="${action}" method="post"
	class="form-horizontal" enctype="multipart/form-data">
    <g:if test="${action == 'create'}">
	<h4 class="blue-text">Add User</h4>
	</g:if>
	<g:if test="${action == 'edit'}">
	<h4 class="blue-text">Edit User</h4>
	</g:if>
	<div class="clearfix">&nbsp;&nbsp;</div>
	<%--<div class="control-group">
		<label class="control-label"><b>FirstName:</b></label>
		<div class="controls">
			<input type="text" name="firstName"
				placeholder="Please type your first name" required maxlength="60"
				class="form-control" autocomplete="off"
				value="${user?.person?.firstName}" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label"><b>LastName:</b></label>
		<div class="controls">
			<input class="form-control" name="lastName" autocomplete="off"
				required="" placeholder="Please type your last name" type="text"
				maxlength="60" value="${user?.person?.lastName}" />
		</div>
	</div>

	--%>
	
	
	
	<div class="control-group">
		<label class="control-label"><b>Email:</b></label>
		<div class="controls">
			<input class="form-control" id="email" name="email" autocomplete="off"
				required="" placeholder="Please provide a valid email id" 
				type="email" maxlength="128" value="${user?.userName}" />
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label"><b>Username:</b></label>
		<div class="controls">
			<input class="form-control" name="username" autocomplete="off" id="username"
				required="" placeholder="Please type your Username" type="text"
				maxlength="60" value="${user?.person?.fullName}" />
		</div>
	</div>
   <g:if test="${action == 'create'}">
   <input type="hidden" name="create" value="hiddenValidation" id="hiddenValidation"/>
	<div class="control-group">
		<label class="control-label"><b>Password:</b></label>
		<div class="controls">
			<input class="form-control" name="password" autocomplete="off"
				id="pwd" ${req}
				placeholder="Should be atleast 6 characters long and must contain a Caps and a number"
				type="password" maxlength="100" value="${user?.password}"/>
		</div>
	</div>
</g:if>
 <g:if test="${action == 'edit'}">
	<div class="control-group">
		<label class="control-label"><b>Password:</b></label>
		<div class="controls">
			<input class="form-control" name="password" autocomplete="off"
				id="pwd" ${req}
				placeholder="Should be atleast 6 characters long and must contain a Caps and a number"
				type="password" maxlength="100" value="${user?.password}" readonly="readonly"/>
		</div>
	</div>
</g:if>


	<%--<div class="control-group">
		<label class="control-label"><b>Confirm Password:</b></label>
		<div class="controls">
			<input class="form-control" name="confirmPassword" id="cpwd"
				autocomplete="off" ${req} placeholder="Confirm your password"
				type="password" maxlength="100" />
		</div>
	</div>
	--%><div class="control-group">
		<g:if test="${action == 'edit'}">
			<label class="control-label"><b>Status:</b></label>
			<div class="controls">
			<g:if test="${user?.enabled == true}">
					<g:set var="ch" value="checked"></g:set>
				</g:if>
				<g:else>
					<g:set var="ch1" value="checked"></g:set>
				</g:else> 
				    Active   <input type="radio" name="enabled" ${ch} value="1" /> 
	                InActive <input type="radio" name="enabled" ${ch1} value="0" />
	               
	            </div>
		</g:if>
		</div>
		<div class="control-group">
		
			<g:if test="${action == 'edit'}">
				<label class="control-label"><b>AccountLock</b></label>
				<div class="controls">
				<g:if test="${user?.accountLocked==true}">
					<g:set var="loc" value="checked"></g:set>
				</g:if>
				<g:else>
					<g:set var="loc1" value="checked"></g:set>
				</g:else> 

                     Yes  <input type="radio" name="accountLocked" ${loc} value="1" />
                     No   <input type="radio" name="accountLocked" ${loc1} value="0" />
                     </div>
			</g:if>
		</div>
	
	
	
	

	<div class="control-group">
		<div class="controls">
			<g:hiddenField name="hiddenUserId" value="${params.userId}" />
			<g:hiddenField name="hiddenPersonId" value="${params.personId}" />
			<g:submitButton name="submit" value="Save" class="btn btn-info"
				onclick="return validate();" />
			&nbsp;&nbsp;
			<g:link controller="user" action="view" class="btn btn-info">Cancel</g:link>
		</div>
	</div>
	<div id="createResult"></div>
</g:form>
<g:if test="${action == 'edit'}">
<g:if test="${user?.enabled==true}">
	<label class="control-label"><b>photo:</b></label>
				<div class="col-sm-3 col-xs-12 dashboard-sidebar-right">
							<div class="dark-graybox profile-img">
						<%
		UserController user=new UserController();
		def currentPhoto=user?.edit()?.profilePhoto
		def photoPath=currentPhoto?.profilePhotoPath
		 %>
							<g:if test="${photoPath}">
							
							
										<a class="modal_link"  data-toggle="modal" data-target="#myModal" href="">
										
									<img  class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photoPath)}" width="180px">
									
										</a>
										
										</g:if>
										<g:else>
										<a class="modal_link"  data-toggle="modal" data-target="#myModal" href="">
										<img  class="img-responsive" src="${resource(dir:'assets/images',file:'profile-img.jpg')}" width="180px">
										</a>
										</g:else>
										
										<h4>Change Picture</h4>
									</div>
						</div>
						</g:if>
						</g:if>
<div class="modal fade profile_popup" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="col-sm-12">
    <g:form name="myUpload" controller="user" action="photo" class="patient-sign-up form-horizontal" id="patient_login_form" enctype="multipart/form-data">
	<%--
    <g:formRemote name="myUpload" url="[controller:'user', action:'photo']" update="subtraction" enctype="multipart/form-data">
    --%><g:hiddenField name="profilePhoto" value="${profilePhoto?.profilePhotoPath}" />
    <g:hiddenField name="hiddenUserId" value="${params.userId}" />
			<g:hiddenField name="hiddenPersonId" value="${params.personId}" />
						<div class="profile-box-bg">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/user-icon1.jpg" /></div>
								<div class="col-md-12 col-xs-12 pad-lr-0">
									<input type="file" name="uploadPhoto" maxlength="255"
									value="Upload your photo"
									accept="image/*" id="upload_photo" onchange="pressed()" class="upload-photo-btn upload-browse-btn"/>
									<label id="err_field"></label>
					<h3 class="col-md-12 col-xs-12 center-align browse-text" style="font-family: 'Opensans Light'; font-size:18px;">(Only JPG, JPEG, PNG & GIF files are allowed)</h3>
					<br>
									<g:submitButton name="Save and Continue" class="blue-btn" id="submitPhoto" onclick="return check()"/>
								</div>
								<div class="clearfix"></div>
							</div>
							</div>
							</g:form>
						</div>
</div>

	
<div id="res" class="err"></div>

	<g:hasErrors bean="${user}">
		<span class="err"><g:renderErrors bean="${user}" as="list" /></span>
	</g:hasErrors>
<div id="res1"></div>


