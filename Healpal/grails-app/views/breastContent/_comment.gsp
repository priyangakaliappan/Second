

<g:each in="${list}" var="i">

	<h5>${i?.healpalUser?.person?.firstName}<small><g:formatDate date="${i?.rowCreated}" type="datetime" style="MEDIUM" /></small></h5>
	<p>${i?.comment}</p>

</g:each>