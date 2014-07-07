<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="css/contact.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script src="js/externaldata.js"></script>
	</head>
	<body>
		<jsp:include page="static/header.jsp"></jsp:include>
		<jsp:include page="static/nav.jsp"></jsp:include>
		
		<section>
			<jsp:include page="static/exchange_values.jsp"></jsp:include>
			
			<div id="left_section">
				<div class="subtitle">
					<span>
						Contact
					</span>
				</div>
				<c:choose>
					<c:when test="${message == null}">
						<div id="info_div">
							<b>Info:</b> Both fields below are required!
						</div>
						<form id="contact_form" method="POST">
							<div class="contact_field">
								<label>Title</label>
								<br>
								<input name="title" />
							</div>
							<div class="contact_field">
								<label>Content</label>
								<br>
								<textarea rows="5" cols="60" name="content"></textarea>
							</div>
							<input id="contact_sbmt_btn" name="contact" type="submit" value="Submit"/>
							
						</form>
					</c:when>
					<c:otherwise>
						<div id="success_div">
							<b>Success:</b> Your message has been successfully sent!
						</div>
						<form id="contact_form" method="POST">
							<div class="contact_field">
								<label path="title">Title</label>
								<br>
								${message.getTitle()}
							</div>
							<div class="contact_field">
								<label path="content">Content</label>
								<br>
								${message.getContent()}
							</div>							
						</form>
					</c:otherwise>
				</c:choose>
				
				
			</div>
			
			<jsp:include page="static/right_section.jsp"></jsp:include>

		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>