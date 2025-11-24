<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<div class="main">
	<div class="container">
		<!-- BEGIN CONTENT -->
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">

						<!-- Hiển thị thông báo -->
						<c:if test="${not empty alert}">
							<div class="alert">${alert}</div>
						</c:if>

						<form action="${pageContext.request.contextPath}/signup"
							method="post" class="form-horizontal" role="form">

							<!-- PERSONAL DETAILS -->
							<fieldset>
								<legend>Your personal details</legend>

								<!-- Username -->
								<div class="form-group">
									<label for="uname" class="col-lg-4 control-label">
										Username <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="uname"
											name="username" value="${param.username}" required>
									</div>
								</div>

								<!-- Fullname -->
								<div class="form-group">
									<label for="lastname" class="col-lg-4 control-label">
										Full Name <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="lastname"
											name="fullname" value="${param.fullname}" required>
									</div>
								</div>

								<!-- Email -->
								<div class="form-group">
									<label for="email" class="col-lg-4 control-label">
										Email <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="email" class="form-control" id="email"
											name="email" value="${param.email}" required>
									</div>
								</div>
							</fieldset>

							<!-- PASSWORD -->
							<fieldset>
								<legend>Your password</legend>

								<!-- Password -->
								<div class="form-group">
									<label for="password" class="col-lg-4 control-label">
										Password <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="password" class="form-control" id="password"
											name="password" required>
									</div>
								</div>

								<!-- Confirm -->
								<div class="form-group">
									<label for="confirm-password" class="col-lg-4 control-label">
										Confirm password <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="password" class="form-control"
											id="confirm-password" name="confirmPassword" required>
									</div>
								</div>
							</fieldset>

							<!-- PHONE -->
							<fieldset>
								<legend>Your phone number</legend>

								<!-- Phone -->
								<div class="form-group">
									<label for="phone" class="col-lg-4 control-label">
										Phone Number <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="phone"
											name="phone" required>
									</div>
								</div>

							</fieldset>

							<!-- BUTTON -->
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Create
										an account</button>
									<button type="button" class="btn btn-default"
										onclick="window.location='${pageContext.request.contextPath}/home'">
										Cancel</button>
								</div>
							</div>

						</form>
					</div>

					<!-- RIGHT INFO -->
					<div class="col-md-4 col-sm-4 pull-right">
						<div class="form-info">
							<h2>
								<em>Important</em> Information
							</h2>

							<p>Lorem ipsum dolor sit amet...</p>
							<p>Duis autem vel eum iriure dolor...</p>

							<button type="button" class="btn btn-default">More
								details</button>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
</div>
