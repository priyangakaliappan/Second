<g:if test="${params.state=='approve'}">
Accepted
<g:checkBox name="accept" value="accepted" checked="true" />
<div class="right_div" id="spinner">
			<img class="img-responsive" src="../assets/new-design/img/spinner.gif">
			</div>
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
<script>
	$("document").ready(function() { 
		 	$.ajax({
				async : false,
				type : 'POST',
				url : '../dashboard/getConnectionCount',
				success : function(res) {
					$("#connectCountid").html(res);
				}
			});
	});
</script>
</g:if>


<g:if test="${params.state=='ignore'}">
<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
<script>
	$("document").ready(function() { 
		 	$.ajax({
				async : false,
				type : 'POST',
				url : '../dashboard/getConnectionCount',
				success : function(res) {
					$("#connectCountid").html(res);
				}
			});
	});
</script>
</g:if>
<script>
if (typeof jQuery !== 'undefined') {
	
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}
</script>