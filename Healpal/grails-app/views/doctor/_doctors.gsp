<div id="doctor-list">
	<g:if test="${doctorList}">
		<div class="col-md-4 col-sm-4 find-doctors-sidebar">
			<h3>Recommended Cancer Experts</h3>
			<ul id="experts">
				<g:each in="${doctorList}" var="record">
					<li id="${record?.street1}, ${record?.address?.city}, ${record?.address?.state} ${record?.zipcode}" class="${record?.doctorName}+${record?.id}">
						<div class="doctors-list-left">
							<img class="img-responsive" src="../assets/new-design/img/doc-img1.jpg">
						</div>
						<div class="doctors-list-right">
							<div>
								<g:link controller="doctor" action="doctorDetails" params="[doctorId:record?.id]">
									<span class="orange-text"> ${record?.doctorName}</span>
								</g:link>
								<div>
									<g:doctorSpecialty doctorId="${record?.id}" />
								</div>
								<div>
									<div class="star-icon pull-left">
										<%--<a class="orange-star" href="JavaScript:void(0)"></a> <a
											class="orange-star" href="JavaScript:void(0)"></a> <a
											class="orange-star" href="JavaScript:void(0)"></a> <a
											class="gray-star" href="JavaScript:void(0)"></a> <a
											class="gray-star" href="JavaScript:void(0)"></a>
									--%>
									</div>
									<a class="pull-left" href="JavaScript:void(0)">14 reviews</a>
								</div>
							</div>
						</div>
					</li>
				</g:each>
			</ul>
		</div>
	</g:if>
	<g:else>
		<div class="col-md-8 col-sm-8 col-xs-12 pad-lr-0 find-doctors">
			<div style="font-size: 18px; margin: 15px 0px 15px; padding: 25px; background-color: #e7e1dd; width: 500px;">
				We didn't find ${keyword} near ${location}
			</div>
			<h4> Find ${city} Doctors By Specialty </h4>
			<g:if test="${specialty}">
				<div class="col-sm-3 col-xs-12 pad-lr-0">
					<ul>
						<g:each in="${specialty}" var="record" status="i">
							<li>
								<g:link controller="doctor" action="doctorSpecialty" params="[specialty:record,location:location]"> ${record} </g:link>
							</li>
						</g:each>
					</ul>
				</div>
			</g:if>
			<div class="clearfix"></div>
		</div>
	</g:else>
</div>