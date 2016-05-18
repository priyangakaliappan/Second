<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" 
type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" 
type="text/css">--%>

<g:form controller="updateProfile" action="combinationChemotherapy"
	method="post">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/profile/img/f1-icon.jpg" /></div>
								<h3 class="pad-bot-0" style="font-family:'Opensans Light';">Please choose the combination chemotherapy administered to you</h3>
								<div class="list-content">
									<ul>
									<g:if test="${combinationChemotheraphy }">
								<input type="hidden" value="Please choose the combination chemotherapy administered to you" name="question">
								<g:each in="${combinationChemotheraphy}" var="patient">
										<g:if
									test="${value != null && value.contains(patient?.combinationChemotherapyDrugsName) }">
									<li class="active"><input type="checkbox"
										value="${patient?.combinationChemotherapyDrugsName}"
										id="${patient?.id}" name="combinechemotherapy"
										class="checkboxSelect" checked="checked" />
								</g:if>
								<g:else>
									<li><input type="checkbox"
										value="${patient?.combinationChemotherapyDrugsName}"
										id="${patient?.id}" name="combinechemotherapy"
										class="checkboxSelect" />
								</g:else>
											<label for="${patient?.id}"  class="selectedLabels"> ${patient?.combinationChemotherapyDrugsName	} </label>
										</li>
										</g:each></g:if>
									</ul>
									<div class="clearfix mar-bot-20"></div>
									<p>( You can select one or multiple choices )</p>
								</div>
								</div>
					<g:hiddenField name="selectedDrugs" id="selectedDrugs"/>
					<g:link class="skip-text"><g:submitButton name="NEXT" /></g:link>
							</div>
						</div>
</g:form>
<script src="../js/profile/profile.js"></script>
<script>
	/*
	 * get count of checked check box includes already checked
	 */

	$("document").ready(function() {
		var count = $("[type='checkbox']:checked").length;
		$("#selectedDrugs").val(count);
		$(".checkboxSelect").on('click', function() {
			if (count != 0) {
				var c = this.checked ? count++ : count--;
			} else {
				var c = this.checked ? count++ : count;
			}
			$("#selectedDrugs").val(count);
		});

	});
</script>