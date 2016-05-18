$(document).ready(function(){
	var $tokenInput = $('#stripeToken'),
		$cardNumberInput = $('#cc_number'),
		$cardCvcInput = $('#cvc'),
		$cardExpMonth = $('#exp_month'),
		$cardExpYear = $('#exp_year'),
		$checkoutForm = $('#checkout_form');

	Stripe.setPublishableKey("pk_test_cvBDWPkGrUzf8GN9bkzcOwhv");

	$('#submit').click(checkCreditCardValues);
	
	function checkout(){
		console.info('submit form, process payment, create transaction', $checkoutForm);
		$checkoutForm.submit();
	}

	function setStripeTokenInput(code, token){
		console.info("retrieved token : ", token)
		//set hidden stripe token input
		$tokenInput.val(token.id)
		checkout();
	}

	 /**
	 	* IMPORTANT *
	    This is the somewhat tricky part, you will receive a token object in 
	    the callback function arguments.  You want to take this token and set
	    a hidden form input that later will get passed to the server side
	**/
	
	function getStripeToken(){
		console.info('get stripe token')
		Stripe.card.createToken({
		    number    : $cardNumberInput.val(),
		    cvc       : $cardCvcInput.val(),
		    exp_month : $cardExpMonth.val(),
		    exp_year  : $cardExpYear.val()
		}, setStripeTokenInput);
	}


	function checkCreditCardValues(){
		if($cardNumberInput.val() != "" &&
				$cardCvcInput.val() != "" &&
				$cardExpMonth.val() != "" &&
				$cardExpYear.val() != ""){
			getStripeToken();
		}else{
			alert('Please make sure all credit card information is provided')
		}
	}
	
})