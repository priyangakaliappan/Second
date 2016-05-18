
<div id="signin" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<button type="button" class="close" data-dismiss="modal"></button>
			<div class="clearfix"></div>
			<div class="modal-body">
				<form id="patient_login_form">
					<g:hiddenField name="hidden" id="loginPath" />
					<h1 class="text-center">Welcome Back!</h1>
					<input class="textbox" type="email" name="username" id="usernameId"
						autocomplete="off" required="" placeholder="Email" /> <i
						class="email_error text-danger"> </i> <input class="textbox"
						type="password" name="password" id="passwordId" required=""
						placeholder="Password" /> <i class="password_error text-danger"></i>
					<p class="text-right">
						<a href="#" data-toggle="modal" data-target="#forgotpassword"
							class="orange-text" id="forgotPassword">Forgot password?</a>
					</p>
					<input name="flag" value="" type="hidden"> <input
						type="submit" class="orange-btn" name="submit"
						id="patientLoginbuttid" value="Sign In" />
					<div id="loginMsg" class="alert"
						style="font-size: 14px !important;"></div>
						<div class="clearfix"> &nbsp;</div>
					<p class="text-center">
						Not a member yet? <a class="orange-text" href="#"
							data-toggle="modal" data-target="#join" id="join-acc">Join
							today.</a>
					</p>

				</form>

			</div>
		</div>
	</div>
</div>

<div id="join" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<button type="button" class="close" data-dismiss="modal"></button>
			<div class="clearfix"></div>
			<div class="modal-body">
				<g:formRemote name="signupForm"
					url="[controller: 'profile', action: 'ajaxSignup']" update="res"
					class="patient-sign-up form-horizontal" id="patient_login_form"
					onComplete="hideSpinner();" onLoading="showSpinner()">
					<g:hiddenField name="hiddenValues" id="create-account" />
					<h1 class="text-center">Join HealPal</h1>
					<h6>Find the right cancer treatment and a cancer expert you
						can trust.</h6>
					<input class="textbox" type="email" name="email" autocomplete="off"
						required="" id="email" placeholder="Email" maxlength="128" />
					<input class="textbox" type="text" name="username"
						autocomplete="off" id="username" required="" placeholder="Username"
						maxlength="60" />
					<input class="textbox" type="password" name="password"
						autocomplete="off" id="pwd" required=""
						placeholder="Minimum six characters" maxlength="100" />
					<div id="res"></div>

					<div id="spinner" align="center">
						<img src="${resource(dir:'assets/image',file:'spinner.gif')}"
							alt="Loading..." style="display: none;" id="gif">
					</div>
					<button type="submit" class="orange-btn join-now-btn join-btn"
						onclick="return validate();" id="spin">Join Now</button>
					<p class="text-center">
						<small>By creating an account, you are indicating that you
							have read and accept the <g:link controller="footer" action="termsOfService">HealPal
								Terms of Service.</g:link>
						</small>
					</p>
				</g:formRemote>

				<div class="clearfix"></div>

				<div class="already-text">
					Already a member? <a class="orange-text" href="#"
						data-toggle="modal" data-target="#signin" id="sign-in">Sign In</a>.
				</div>
			</div>
		</div>
	</div>
</div>



<div id="forgotpassword" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<button type="button" class="close" data-dismiss="modal"></button>
			<div class="clearfix"></div>
			<div class="modal-body">
				<g:formRemote name="forgotForm"
					url="[controller: 'forgotPassword', action: 'forgot']"
					update="reset" id="reset">
					<h1 align="left">Forgot your password</h1>
					<h6 style="margin: -3px;">
						Enter your email address and we will send you
						a link to login
					</h6>
					
					<input class="textbox" type="email" name="email" autocomplete="on"
						required="" placeholder="Email" maxlength="128"><br><br>
					<div>
						<g:submitButton value="Send me a link"
							class="search-btn-s" name="send"></g:submitButton>
						<g:link controller="home" action="index"
							class="orange-text">Cancel</g:link>
					</div>
				</g:formRemote>
			</div>
		</div>
	</div>
</div>





