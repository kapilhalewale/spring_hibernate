<jsp:directive.include file="generic.jsp" />
<!DOCTYPE html>
<html>
	<head>
		<jsp:include  page="cssImport.jsp"  />
	    <title>KK</title>
   	</head>
	<body class="flat-blue">
		<div class="app-container expanded">
			<div class="row content-container">
				<nav class="navbar navbar-default navbar-fixed-top navbar-top">
					<jsp:include  page="header.jsp"  />
				</nav>
					<div class="side-menu sidebar-inverse">
						<nav class="navbar navbar-default" role="navigation">
							<jsp:include  page="leftNavigator.jsp"  />
						</nav>
					</div>
					<div class="container-fluid">
						<div class="side-body">
							<div class="page-title">
								<span class="title" style="font-size: 23px;"><span class="icon fa fa-users"></span> Entitiess</span>
		                          <div class="pull-right">
									<a href="add-employee">
									 	<button class="btn btn-primary" type="button"><span class="icon fa fa-plus-square"></span> Add Entity</button>
									</a>									
		                          </div>                                    
							</div> 
							<div class="row">
		                        <div class="col-md-12">
		                            <div class="card">
		                                <div class="card-body" style="min-height:500px;">  
												<table class="table table-bordered">
													<thead>
														<tr  bgcolor="#ccc">
															<th width="3%">SNO</th>
															<th width="90%">Name</th>
															<th  width="7%"></th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="li" items="${entities}" varStatus="st">
																	<tr class="pointer">
																		<td class="" align="center">${st.count}</td>
																		<td class="">${li.name}</td>
																		<td class="last" align="right">
																			<a href="${basePath }/employee/edit-employee/${li.id}" style="margin-bottom:0px;" class="btn btn-dark btn-xs"><i class="fa fa-pencil fa-lg"></i> </a>
																			<a href="${basePath }/employee/drop-employee/${li.id}" style="margin-bottom:0px;" class="btn btn-dark btn-xs"><i class="fa fa-trash fa-lg"></i> </a>
																		</td>
																	</tr>
														</c:forEach>
													</tbody>
												</table>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
						</div>
					</div>
				</div>
		</div>
		<footer class="app-footer">
			<jsp:include  page="footer.jsp"  />
		</footer>
	</body>
</html>