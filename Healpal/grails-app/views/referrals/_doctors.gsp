<br/><g:if test="${msg}"><span class="alert alert-danger">${msg}</span></g:if>
<g:select name="doctor" from="${doctors}" optionValue="doctorName" id="doctorsId" optionKey="id"  noSelection="['':'Choose a doctor']"
onChange="${remoteFunction(controller:'referrals',action:'viewDoctor',
				  update:[success:'viewDoctorDiv',failure:'ohno'],
			 	  params:'\'patientId=\'+this.value')}"/>


																							
<script>
$("#myModal").modal('hide');
</script>