<!--  
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : create group
 * Date      : 5-01-2016
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               5-01-2016         Initial Creation
 *
 */-->
<div class="container">
	<span id="groupErr1" style="color: red"></span>
	<h3>Create Group</h3>
	<g:form class="form-horizontal popup-form" controller="Connection" enctype="multipart/form-data">
		<div class="form-group">
			<label class="control-label col-sm-3">Group Name:</label>
			<div class="col-sm-9">
				<g:textField class="form-control" name="groupName" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3">Members: </label>
			<div class="col-sm-9">
				<g:select name="members" from="${connectionList?.person}" optionKey="id" optionValue="fullName" id="tokenize" multiple="multiple" class="tokenize-sample" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3 hidden-xs">&nbsp;</label>
			<div class="col-sm-9 text-right">
				<g:actionSubmit class="btn btn-orange cancel_text" value="Cancel" action="cancel" />
				<g:actionSubmit class="btn btn-orange" value="Create" action="createGroup" id="creategrp" />
			</div>
		</div>
	</g:form>
</div>

<script type="text/javascript">
	$("document").ready(function() {
		var selectboxValues = new Array();
		$('#tokenize').tokenize(); // design for selecting members
		$("#tokenize>option").map(function() {
			selectboxValues.push($(this).val());
		});
		/* create group by passing group name and member to controller */
		$("#creategrp").click(function() {
			$("#groupErr1").html("");
			var temp = "false";
			var groupName = $.trim($("#groupName").val());
			var members = $('#tokenize').val();
			if (groupName != null && groupName != "") {
				$.ajax({
					async : false,
					type : 'POST',
					url : '../connection/isGroupNameExist',
					data : {
						groupName : groupName
					},
					success : function(res) {
						if (res == "true" || res == true) {
							temp = "true";
						}
					}
				});
				if (temp == "true") {
					$("#groupErr1").html("Groupname already exist");
					$("#groupName1").focus();
					return false;
				}
			} else {
				$("#groupErr1").html("Please enter Group Name");
				$("#groupName1").focus();
				return false;
			}
			if (members == null || members == "" || members.length < 2) {
				$("#groupErr1").html("Please choose two or more connections");
				$("#tokenize").focus();
				return false;
			}
			if (members == null || members == "" || members.length >= 2) {
				var count = 0;
				for ( var i = 0; i < members.length; i++) {
					if (jQuery.inArray(members[i], selectboxValues) == -1) {
						count++;
					}
				}
				if (count > 0) {
					$("#groupErr1").html("Invalid Members");
					return false;
				}
			}
		});
	});
</script>
