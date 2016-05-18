<%@ page contentType="text/html;charset=UTF-8" %>
<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs">
									<div class="col-sm-1 col-xs-1"></div> 
										<div class="col-sm-4 col-xs-12">
											<g:textField name="firstName" value="${doctor?.firstName}" id="d1" maxlength="150" placeholder="firstname" placeholder="First Name" class="refferal-textbox desktop"/>
										</div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="lastName" value="${doctor?.lastName}" id="d2" maxlength="150" placeholder="Last Name" class="refferal-textbox desktop"/>
										</div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs" >
									<div class="col-sm-1 col-xs-1"></div>  
										<div class="col-sm-4 col-xs-12">
											<g:textField name="firstName"  value="${doctor?.firstName}" id="d3" maxlength="150" placeholder="firstname"  placeholder="First Name" class="refferal-textbox mobile"/>
										</div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="lastName" value="${doctor?.lastName}" id="d4" maxlength="150" placeholder="Last Name" class="refferal-textbox mobile" />
										</div>
										<div class="col-sm-3 col-xs-3"></div>
									</div> 
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="phoneNumber" maxlength="15" id="d13" value="${doctor?.phoneNumber}" placeholder="Contact number" class="refferal-textbox desktop" /><br/>
										</div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="specialty" id="d6" value="${doctor?.specialty}"  maxlength="150" placeholder="Specialty" class="refferal-textbox desktop" />
										</div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="phoneNumber" maxlength="15" id="d14" value="${doctor?.phoneNumber}" placeholder="Contact number" class="refferal-textbox mobile" /><br/>
										</div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="specialty" id="d8" value="${doctor?.specialty}" maxlength="150" placeholder="Specialty" class="refferal-textbox mobile" />
										</div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="zipcode" maxlength="10" id="d9" value="${doctor?.address?.zipcode}" placeholder="Zip code or postal" class="refferal-textbox desktop" /><br/>
										</div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="state" maxlength="50" id="d10" value="${doctor?.address?.state}"  placeholder="State" class="refferal-textbox desktop" /><br/>
										</div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									<div class="col-sm-12 col-xs-12  visible-xs">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="zipcode" maxlength="10" id="d11" value="${doctor?.address?.zipcode}" placeholder="Zip code or postal" class="refferal-textbox mobile" /><br/>
										</div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="state" maxlength="50" id="d12" value="${doctor?.address?.state}"  placeholder="State" class="refferal-textbox mobile" /><br/>
										</div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									<div class="col-sm-12 col-xs-12 mar-bot-20 hidden-xs">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-4 col-xs-12">
										<g:textField name="county" id="d5" maxlength="50" class="refferal-textbox desktop" value="${doctor?.address?.county}" placeholder="Country"/>	
										</div>
										<div class="col-sm-4 col-xs-12"></div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									<div class="col-sm-12 col-xs-12 visible-xs">
									<div class="col-sm-1 col-xs-1"></div>
										<div class="col-sm-4 col-xs-12">
											<g:textField name="county" id="d7" maxlength="50" class="refferal-textbox mobile" value="${doctor?.address?.county}" placeholder="Country"/>
										</div>
										<div class="col-sm-4 col-xs-12"></div>
										<div class="col-sm-3 col-xs-3"></div>
									</div>
									
									