<%--/**
 *
 * Author  		: Ramesh
 * Project 		: Healpal
 * Date    		: 09/02/2016 
 * Description	: Share Your Story Edit
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0        09/02/2016     Initial Creation
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
				Edit Share Your Story <small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Share Your Story</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
								<g:form controller="ShareYourStory" action="edit" method="post" class="form-horizontal">
									<input type="hidden" name="shareYourStoryId" value="${shareYourStoryId}">
									<h4 class="blue-text">Edit Share Your Story</h4>
									<g:if test="${flash.msg}">
										<h6 class="red-text">${flash.msg}</h6>
									</g:if>
									<div id="err"></div>
									<%--<div class="control-group">
										<label class="control-label"><b>Name${shareYourStoryId}</b></label>
										<div class="controls">
											<input type="text" class="span7" name="patientName"
												id="shareYourStoryPatientName" required=""
												placeholder="Enter Name"
												value="${shareYourStory?.patientFk?.person?.fullName}">
												
										</div>
									</div>
									--%><div class="control-group">
										<label class="control-label"><b>Story Title</b></label>
										<div class="controls">
											<input type="text" class="span7" name="storyTitle"
												id="shareYourStoryPatientName" required=""
												placeholder="Enter Story Title"
												value="${shareYourStory?.storyTitle}">
												
										</div>
									</div>
									
									
									<div class="control-group">
										<label class="control-label"><b>Share Your Story</b></label>
										<div class="controls">
											<textarea class="span7" name="yourStory"
												id="shareYourStoryPatientName" required=""
												placeholder="Enter Your Story description"
												>${shareYourStory?.yourStory}</textarea>
										</div>
									</div>
									
									
									<div class="control-group">
										<label class="control-label"><b>Status</b></label>
										<div class="controls">
											<g:radio name="status" value="active" checked="${shareYourStory?.isActive==1}" />
											Active
											<g:radio name="status" value="inactive" checked="${shareYourStory?.isActive==0}" />
											InActive
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<input type="submit" value="Update" class="btn btn-info" />&nbsp;&nbsp;
											<g:link controller="ShareYourStory" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
									</div>
								</g:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
