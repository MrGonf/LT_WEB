<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/commons/taglib.jsp"%>

<div class="main">
	<div class="container">

		<!-- BEGIN CONTENT -->
		<div class="col-md-12 col-sm-12">
			<!-- 			<h1>Login</h1> -->
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
						<c:if test="${alert != null}">
							<div class="alert">${alert}</div>
						</c:if>
						<form action="${pageContext.request.contextPath}/login"
							method="post" class="form-horizontal" role="form">
							<!-- ACCOUNT -->
							<fieldset>
								<legend>Your account</legend>
								<div class="form-group">
									<label for="uname" class="col-lg-4 control-label">Username
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="uanme"
											name="uname">
									</div>
								</div>
								<div class="form-group">
									<label for="psw" class="col-lg-4 control-label">Password
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="psw" name="psw">
										<input type="checkbox" name="remember" checked>
										Remember me
									</div>
								</div>
								<div class="row">
									<div class="col-lg-8 col-md-offset-4 padding-left-0">
										<a href="${pageContext.request.contextPath}/forgetpassword">Forget
											Password?</a>
									</div>
								</div>
							</fieldset>

							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Login</button>
								</div>
							</div>
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
									<hr>
									<div class="login-socio">
										<p class="text-muted">or login using:</p>
										<ul class="social-icons">
											<li><a href="#" data-original-title="facebook"
												class="facebook" title="facebook"></a></li>
											<li><a href="#" data-original-title="Twitter"
												class="twitter" title="Twitter"></a></li>
											<li><a href="#" data-original-title="Google Plus"
												class="googleplus" title="Google Plus"></a></li>
											<li><a href="#" data-original-title="Linkedin"
												class="linkedin" title="LinkedIn"></a></li>
										</ul>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-4 col-sm-4 pull-right">
						<div class="form-info">
							<h2>
								<em>Important</em> Information
							</h2>
							<p>Duis autem vel eum iriure at dolor vulputate velit esse
								vel molestie at dolore.</p>

							<button type="button" class="btn btn-default">More
								details</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->


<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <body> -->
<!-- 	<div class="login-box"> -->



<!-- 		<h2>Welcome Back</h2> -->



<!-- 		<div class="input-group"> -->
<!-- 			<label for="uname">Username</label> <input type="text" id="uname" -->
<!-- 				name="uname" placeholder="Enter Username" required> -->
<!-- 		</div> -->

<!-- 		<div class="input-group"> -->
<!-- 			<label for="psw">Password</label> <input type="password" id="psw" -->
<!-- 				name="psw" placeholder="Enter Password" required> -->
<!-- 		</div> -->

<!-- 		<button type="submit" class="btn-login">Login</button> -->

<!-- 		<div class="options"> -->
<!-- 			<label><input type="checkbox" name="remember" checked> -->
<!-- 				Remember me</label> <a href="#">Forgot password?</a> -->
<!-- 		</div> -->

<!-- 		<button type="button" class="btn-register" -->
<%-- 			onclick="window.location='${pageContext.request.contextPath}/signup'">Register</button> --%>

<!-- 		</form> -->
<!-- 	</div> -->
<!-- </body> -->
<!-- </html> -->
