<!DOCTYPE html>
<%@ page import="com.healpal.care.Diagnosis"%>
<html lang="en">
<head>
<meta name="layout" content="admin">

</head>

<body>
	<div id="tables_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Cancer User Details <small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Cancer User Details</small>
			</h1>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
						<%--<g:select id="diagnosis" name="diagnosis.id" from="${diagnosis}" optionKey="diagnosisName" optionValue="diagnosisName" noSelection="['':'Choose your Cancer Type']"/>
						<a href="JavaScript:void(0)" id="search"  class="btn btn-info btn-medium">Search</a>
						--%>
						<%--<g:select  optionKey="diagnosisName"  name="diagnosis.id" id="diagnosis" from="${diagnosis}" optionKey="diagnosisName" optionValue="diagnosisName"
        onchange="${remoteFunction(controller:'userDetails', action:'cancerAjaxPaginate', params:'\'id=\' + this.value', onComplete:'cancerDetail(e)')}"></g:select>
						
						
						--%><%--<g:select id="diagnosis" name="diagnosis.id" from="${diagnosis}" optionKey="diagnosisName" optionValue="diagnosisName"
                      noSelection="[null:' ']"
                      onchange="categoryChanged(this.value);" />
						--%>
						 <g:select id="diagnosis" name="diagnosis.id" from="${diagnosis}" optionKey="id" optionKey="diagnosisName" optionValue="diagnosisName"
                      noSelection="[null:' Select Cancer type']"
                      onchange="categoryChanged(this.value);" />
						
						</div>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
									<div class="clearfix">&nbsp;</div>
							<g:render template="cancerView"></g:render>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix">&nbsp;</div>
	</div>
</body>
</html>

