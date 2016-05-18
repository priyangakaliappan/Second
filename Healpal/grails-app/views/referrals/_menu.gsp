<%@ page contentType="text/html;charset=UTF-8" %>


<div class="col-sm-12 col-xs-12">
					<div class="box-content8">
						<h2>Recommendations</h2>                             
						<ul>
							<li class="${reActive?:''}"><g:link controller="Referrals" action="received">Received</g:link></li>
							<li class="${proActive?:''}"><g:link controller="Referrals" action="provided">Provided</g:link></li>
							<li class="${reqActive?:''}"><g:link controller="Referrals" action="request">Request a recommendation</g:link></li>
							<li class="${provActive?:''}"><g:link controller="Referrals" action="provide">Provide a recommendation</g:link></li>
						</ul>
					</div>
				</div>





