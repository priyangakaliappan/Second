<g:each in="${questionsList}" var="questions" status="i">

&nbsp;
<g:hiddenField name="question${i}" value="${questions.id}"/>
<div class="clearfix"></div>

<div id="divRad${i}" class="clearfix">
<span class="review_ques">${questions.questions}</span>
</div>

<g:if test="${questions.optionType=='radio'}">
<g:hiddenField name="radio" value="radio" id="radio"/>
<div class="review-subradio">
<g:each in="${options}" var="option">
<input id="${option}" class="sub-review radios" type="radio" name="reviewAnswer_radio" value="${option}"><label for="${option}"><span><span></span></span>${option}</label>
</g:each>
</div>
</g:if>

<g:elseif test="${questions.optionType=='drop-down'}">
<g:hiddenField name="drop-down" value="drop-down" id="drop-down"/>
<div class="col-md-6 col-sm-8 col-xs-12 pad-lr-0 col-select">
<g:select class="diagno-select" id="treatment" name="treatment" noSelection="${['':'Please Select One']}" from="${treatments}" optionKey="treatmentName" optionValue="treatmentName"></g:select>
</div>
<div class="clearfix"></div>
</g:elseif>

<g:else>
<g:hiddenField name="text" value="text" id="text"/>
<input type="text" class="text-box review-text1 review-text" name="reviewAnswer_text${i}" id="reviewAnswer_text" placeholder="">
</g:else>

</g:each>

<input type="text" class="text-box review-text1 review-text" name="otherOption" id="otherOption" placeholder="Please specify">
	<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#otherOption").hide();	
$('#treatment').on('change', function() {
if(this.value == 'other'){
$("#otherOption").show();

}
else{
$('#otherOption').val('');
$("#otherOption").hide();
}
});
});
		</script>


