<%@ page contentType="text/html;charset=UTF-8" %>


<g:formRemote url="[controller:'referrals',action:'doctor']" name="requestForm" update="doctorsDiv" method="post">
								<div class="clearfix mar-bot-20"></div>
								<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
										<div class="col-sm-6 col-xs-12">
											<g:textField name="firstName" maxlength="150"  id="dd1" placeholder="firstname" required="" placeholder="First Name" class="form-control desktop"/>
										</div>
										<div class="col-sm-6 col-xs-12">
											<g:textField name="lastName" maxlength="150" id="dd2" placeholder="Last Name" class="form-control desktop" required=""/>
										</div>
										
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs" >
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="firstName" maxlength="150" id="dd3" placeholder="firstname" required="" placeholder="First Name" class="form-control mobile"/>
										</div>
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="lastName" maxlength="150" id="dd4" placeholder="Last Name" class="form-control mobile" required=""/>
										</div>
										
									</div>
									
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
										<div class="col-sm-6 col-xs-12">
											<g:textField name="phoneNumber" maxlength="15" id="dd13" placeholder="Contact number" class="form-control desktop" required=""/>
										</div>
										<div class="col-sm-6 col-xs-12">
											<g:textField name="specialty" maxlength="150" id="dd6" placeholder="Specialty" class="form-control desktop" required=""/>
										</div>
										<div class="col-sm-6 col-xs-12"></div>
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs">
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="phoneNumber" maxlength="15" id="dd14" placeholder="Contact number" class="form-control mobile" required=""/>
										</div>
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="specialty" maxlength="150" id="dd8" placeholder="Specialty" class="form-control mobile" required=""/>
										</div>
									</div>
									
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
										<div class="col-sm-6 col-xs-12">
											<g:textField name="zipcode" maxlength="10" id="dd9" placeholder="Zip code or postal" class="form-control desktop" required=""/>
										</div>
										<div class="col-sm-6 col-xs-12">
											<g:textField name="state" id="dd10" maxlength="50" class="form-control desktop" placeholder="State" required=""/>
										</div>
									</div>
									<div class="col-sm-12 col-xs-12  visible-xs">
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="zipcode" maxlength="10" id="dd11" placeholder="Zip code or postal" class="form-control mobile" required=""/>
										</div>
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="state" id="dd12" maxlength="50" class="form-control mobile" placeholder="State" required=""/>
										</div>
									</div>
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs pad-lr-0">
										<div class="col-sm-6 col-xs-12">
											<g:textField name="county" id="dd5" maxlength="50" class="form-control desktop" placeholder="Country" required=""/>
										</div>
									</div>
									
									<div class="col-sm-12 col-xs-12 visible-xs">
										<div class="col-sm-4 col-xs-12 mar-bot-10">
											<g:textField name="county" id="dd7" maxlength="50" class="form-control mobile" placeholder="Country" required=""/>
										</div>
									</div>
									
									<div class="clearfix mar-bot-20"></div>
									<div class="col-sm-12 col-xs-12 text-center">
									<g:submitButton name="save" value="Send" class="btn btn-brand-f btn-orange"/>
									<a class="btn btn-brand-f btn-orange" data-dismiss="modal" href="#">Cancel</a>
									</div>
</g:formRemote>									