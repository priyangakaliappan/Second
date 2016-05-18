<%@ page contentType="text/html;charset=UTF-8" %>


	<g:form controller="dynamicProfileQues" action="${action}" name="questionForm" method="post"  class="form-horizontal" onSubmit="return doSave();">
	<div class="clearfix">&nbsp;&nbsp;</div>
	<div class="control-group">
	        <g:hiddenField name="actionType" id="actionTypeId" value="${action}"/>
			<g:hiddenField name="diagnosisHave" id="diagnosisHaveId" value="${profileQuestion?.diagnosis?.id}"/>
		<label class="control-label"><b>Question Category :</b></label>
		<div class="controls">
			<g:select name="questionCategory" from="${quesCategorys}" optionKey="id" optionValue="questionCategory" noSelection="['':'Choose']" required="" id="questionCategoryId" 
			 onchange="changeCategory()" value="${profileQuestion?.questionCategory?.id}"/>
  
  <a href="#" data-toggle="tooltip" title="Please choose any Category your question is referring to"><img class="img-responsive" src="${resource(dir:'assets/image',file:'help.png')}"></a>
		</div>
	</div>

	<div class="control-group" id="diagnosisDiv">
		<label class="control-label"><b><span>Diagnosis:</span></b></label>
		<div class="controls">
			<g:select  name="diagnosis"  value="${profileQuestion?.diagnosis?.id}" from="${diagnosisList}" 
			optionKey="id" optionValue="diagnosisName" noSelection="['':'Choose']" id="diagnosisId" required="" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label"><b>Question Label/Icon:</b></label>
		<div class="controls">
			<g:textField name="questionLabel" required="" 
			id="questionLabelId" value="${profileQuestion?.questionLabel?.questionLabel}"/>
			<a href="#" data-toggle="tooltip" title="This icon will appear in the top of the Profile Page(question page)"><img class="img-responsive" src="${resource(dir:'assets/image',file:'help.png')}"></a>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label"><b>Question Text:</b></label>
		<div class="controls">
			<g:textField name="questionText" required="" 
			id="questionTextId" value="${profileQuestion?.questionText?.questionText}"/>
			<a href="#" data-toggle="tooltip" title="Please enter the question"><img class="img-responsive" src="${resource(dir:'assets/image',file:'help.png')}"></a>
		</div>
	</div>


    <div class="control-group">
		<label class="control-label"><b>Options Format:</b></label>
		<div class="controls">
			 <g:select name="questionOptionsFormat" value="${profileQuestion?.questionOptionsFormat?.id}" from="${optionsFormat}" optionKey="id" 
			  optionValue="questionOptionsFormat" noSelection="['':'Choose']" required="" id="optionsformatId"/>
			  <a href="#" data-toggle="tooltip" title="Select the type of Input/ Selction Boxes-where the options for each question appear"><img class="img-responsive" src="${resource(dir:'assets/image',file:'help.png')}"></a>
			  
		</div>
	</div>

	<div class="control-group">
		<label class="control-label"><b>Options:</b></label>
		<div class="controls">
			 <g:remoteLink url="[controller:'dynamicProfileQues' ,action:'optionCreate']" update="optionFormId" method="GET">New Option</g:remoteLink> 
			<div id="optionsListId">  
				<g:render template="optionList"></g:render>
			</div>
		</div>
	</div>
	

	
	<div class="control-group">
		<label class="control-label"><b>Gender:</b></label>
		<div class="controls">
		<g:if test="${profileQuestion?.gender?.genderCode?.toString()?.equalsIgnoreCase("m")}">
						<g:set var="g1" value="checked"></g:set>
					</g:if><g:else>
						<g:set var="g2" value="checked"></g:set>
					</g:else>
			         <input type="radio" name="gender" value="m" ${g1}/> Male 
			         <input type="radio" name="gender" value="f" ${g2}/> FeMale
		</div>
	</div>
	<g:if test="${profileQuestion != null && profileQuestion?.skip == 1}">
						<g:set var="s1" value="checked"></g:set>
			</g:if><g:else>
				<g:set var="s2" value="checked"></g:set>
			</g:else>
			
		<div class="control-group">
		<label class="control-label"><b>Skip:</b></label>
		<div class="controls">
		<input type="radio" name="skip" value="1" ${s1} required=""/>Yes 
		<input type="radio" name="skip" value="0" ${s2} required=""/>No
		</div>
	</div>	
	<div class="control-group">
		<label class="control-label"><b>Match Points:</b></label>
		<div class="controls">
		<g:textField name="patientMatchPoints" value="${profileQuestion?.patientMatchPoints}" id="patientMatchPointsId"/>
		<a href="#" data-toggle="tooltip" title="These points are used to generate the Match percentages with other Connects"><img class="img-responsive" src="${resource(dir:'assets/image',file:'help.png')}"></a>
		</div>
	</div>	
		
	   <div class="control-group">
		<g:if test="${action == 'edit'}">
			<label class="control-label"><b>Status:</b></label>
			<div class="controls">
			<g:if test="${profileQuestion?.isActive==1}">
						<g:set var="ch" value="checked"></g:set>
					</g:if><g:else>
						<g:set var="ch1" value="checked"></g:set>
					</g:else>
				    Active<input type="radio" name="isActive" ${ch} value="1"/>
				    InActive<input type="radio" name="isActive" ${ch1} value="0"/>
	                </div>
		</g:if>
		</div>
		
		
	

	<div class="control-group">
		<div class="controls">
			<g:hiddenField name="quesHiddenid" value="${params.quesId}"/>
			<g:link controller="dynamicProfileQues" action="view" class="btn btn-info">Cancel</g:link>
			<g:submitButton name="save" value="Save" class="btn btn-info"/>
			
		</div>
	</div>
</g:form>
<div id="optionFormId">	
</div>
		<div id="res" class="red-text">
			<g:hasErrors bean="${profileQuestion}">
				<span class="err"><g:renderErrors bean="${profileQuestion}"
						as="list" /></span>
			</g:hasErrors>
		</div>

<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/question',file:'adminQuestion.js')}"></script>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
