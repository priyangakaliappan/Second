function doSave() {
		$("#err").html("");
	
		var source = $("#drug,#aboutYour,#aboutyou,#cancerStage,#cancerStatus,#chemotherapyDrugs,#DiagnosisName,#questionTextId,#questionLabelId,#ethinicityName,#educationType,#ethnicityName,#healthInsurance,#hormoneTherapyName,#medicalCondition,#metastaticName,#molecularForCancerName,#TumorTypes,#personalInterest,#raceName,#role,#sideEffectsType,#surgeryType").val();
		if ($.trim(source) == "" || source == undefined) {
			$("#err").css({
				color : 'red'
			});
			$("#err").html("Please fill out this field");
			$("#drug,#aboutYour,#aboutyou,#cancerStage,#cancerStatus,#chemotherapyDrugs,#DiagnosisName,#questionTextId,#questionLabelId,#educationType,#ethinicityName,#healthInsurance,#hormoneTherapyName,#medicalCondition,#metastaticName,#molecularForCancerName,#TumorTypes,#personalInterest,#raceName,#role,#sideEffectsType,#surgeryType").focus();
			return false;
		}
		return true;
	}