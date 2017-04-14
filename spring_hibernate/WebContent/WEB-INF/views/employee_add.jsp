<jsp:directive.include file="generic.jsp" />
<!DOCTYPE html>
<html>
<head>
		<jsp:include  page="cssImport.jsp"  />
    <title>Employee Add/Edit</title>
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
						<span class="title" style="font-size: 23px;"><span class="icon fa fa-user"></span> User Add/Edit
                          <div class="pull-right">
						 	<button class="btn btn-default" type="button" onclick="history.back()"><span class="icon fa fa-arrow-circle-left">&nbsp;</span>Back</button>
                          </div>                                    
					</div> 
					<div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="height:450px;">  
									<div class="clear-both"></div>
										<form:form action="${basePath }/employee/save-employee" method="post" modelAttribute="employee" ccsClass="form-horizontal" >
											<div class="form-group">
												<label class="col-md-2 control-label">Name<span class="mandatory">*</span></label>
												<div class="col-md-4">
													<form:input path="name" class="form-control"/>
												</div>
												<label class="col-md-2 control-label">Code<span class="mandatory">*</span></label>
												<div class="col-md-4">
													<form:input path="code" class="form-control"/>
												</div>                                            
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Salary<span class="mandatory">*</span></label>
												<div class="col-md-4">
													<form:input path="salary" class="form-control"/>
												</div>                                            
												<label class="col-md-2 control-label">Date Of Joining</label>
												<div class="col-md-4">
													<form:input path="dateOfJoining" id="date" class="form-control"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Entity<span class="mandatory">*</span></label>
												<div class="col-md-4">
													<form:select path="entity.id"  items="${entities}" itemValue="id"  itemLabel="name"  cssClass="form-control"> </form:select> 
												</div>                                            
											</div>
											<div class="form-group">
												<div class="col-md-offset-2 col-md-10">
													<button type="submit" class="btn btn-primary"><span class="icon fa fa-save"></span>&nbsp;Save</button>
												</div>
											</div>
											</form:form>
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