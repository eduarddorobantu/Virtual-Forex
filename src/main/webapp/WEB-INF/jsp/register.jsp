<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script src="js/externaldata.js"></script>
		<link rel="stylesheet" type="text/css" href="css/register.css">
		<title>Register</title>		
	</head>
	<body>
		<jsp:include page="static/header.jsp"></jsp:include>
		<jsp:include page="static/nav.jsp"></jsp:include>
		
		<section>
			<jsp:include page="static/exchange_values.jsp"></jsp:include>
			<div id="left_section">
				<div class="subtitle">
					<span>
						Register
					</span>
				</div>
				<c:if test="${register_fail == null && register_success == null}">
	   				<div id="info_register">
						<b>Info:</b> All the fields below are required!
					</div>
				</c:if>
				<c:if test="${register_fail != null}">
	   				<div id="error_register">
						<b>Error:</b> Username or email already exists in our database! Please fill in the form again!
					</div>
				</c:if>
				<c:if test="${register_success != null}">
	   				<div id="success_register">
						<b>Success:</b> You have successfully registered! Please login to play Virtual Forex!
					</div>
				</c:if>
				
				<form method="POST">					
					<div class="register_field">
						<label>
							Username
						</label>
						<br>
						<input type="text" name="username" required/>					
					</div>
					<div class="register_field">
						<label>
							Password
						</label>
						<br>
						<input type="password" name="password" required/>		
					</div>
					<div class="register_field">
						<label>
							Name
						</label>
						<br>
						<input type="text" name="name" required/>		
					</div>
					<div class="register_field">
						<label>
							Email
						</label>
						<br>
						<input type="email" name="email" required/>		
					</div>
					<div class="register_field">
						<label>
							Country
						</label>
						<br>
						<select name="country" required>
							<c:forEach items="${countries}" var="country">   
						        <option id="${country.id}">${country.name}</option>
						    </c:forEach> 
						</select>	
					</div>
					<div class="register_field">
						<label>
							Security question
						</label>
						<br>
						<select name="security_question" required>
							<c:forEach items="${securityQuestions}" var="securityQuestion">   
						        <option id="${securityQuestion.id}">${securityQuestion.question}</option>
						    </c:forEach> 
						</select>	
					</div>
					<div class="register_field">
						<label>
							Security answer
						</label>
						<br>
						<textarea rows="3" cols="40" name="security_answer" required></textarea>
					</div>
					<div id="register_btn">
						<input type="submit" name="register" value="Register" />
						<input type="reset" value="Clear" />
					</div>
				</form>
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
		<script type="text/javascript">
			document.getElementsByTagName("form")[0].onsubmit = function() {
				var form = document.getElementsByTagName("form")[0];
				
				var country_id = document.createElement("input");
				country_id.setAttribute("type", "hidden");
				country_id.name = "country_id";
				country_id.value = document.getElementsByName("country")[0].selectedIndex + 1;
				form.appendChild(country_id);
				
				var security_question_id = document.createElement("input");
				security_question_id.setAttribute("type", "hidden");
				security_question_id.name = "security_question_id";
				security_question_id.value = document.getElementsByName("security_question")[0].selectedIndex + 1;
				form.appendChild(security_question_id);
				
				form.submit();
			};
		</script>

	</body>
</html>

