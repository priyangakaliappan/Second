<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: chemotherapyDrugsView
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga      1.0        10/10/2015      Initial Creation
 * 2   Priyanga      2.0        10/20/2015       Modification
 *
 */
--%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
 <link href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.min.css')}" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="tables_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Medical Documents<small><g:link class="blue-text">Home</g:link><i class="icon-angle-double-right"></i>Medical Documents</small>
			</h1>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:select name="person" from="${patients?.person}" optionKey="id" optionValue="fullName" noSelection="['': 'Select']" id="selectValue"/>
						</div>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<g:render template="viewDocument"></g:render>
						</div>
					</div>
				</div>
			</div>
			<!-- /widget-body -->
		</div>
		<!-- /widget -->
		<div class="clearfix">&nbsp;</div>
	</div>
	<!-- /row-fluid -->
	<!-- Modal -->
	<div class="modal fade" id="viewdoc" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<a href="#" class="close-icon" data-dismiss="modal"></a>
				<div class="modal-body"></div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script type="text/javascript">
	$(document).on('click','.modal_link',function(){
		var url="../connection/createGroup";
		$("#createGroup .modal-body").load(url);
	});
	$(document).ready(function(){
		$("#selectValue").change(function() {
	var selectValue = $.trim($("#selectValue").val());
	$.ajax({
		async : true,
		type : 'POST',
		url : '../patientDocument/selectPatient',
		data : {
			selectValue : selectValue
		},
		success : function(res) {
			$("#tab1").html(res);
		}
	});
		});
	});
	$(document).on('click','.modal_link',function(){
		var url="../patientDocument/viewDoc";
		$("#viewdoc .modal-body").load(url);
	});
	</script>
</body>
</html>

