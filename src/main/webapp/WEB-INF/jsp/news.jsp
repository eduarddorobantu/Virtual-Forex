<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="/forex/css/news.css">
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
						News
					</span>
				</div>
				<c:choose>
					<c:when test="${allNews != null}">
						<c:forEach items="${availableNews}" var="news">  
							<a href="/forex/news/${news.title}.html" class="news_link"> 
								<div class="news_field">
									<div class="news_field_title">${news.date.toString().replaceAll("-", "/").substring(0, news.date.toString().length() - 2)}</div>
									<div class="news_field_content">${news.title}</div>
									<br>
								</div>		
							</a>		
						</c:forEach>	
					</c:when>
					<c:otherwise>
						<div class="news_field">
							<div class="news_field_title">${news.title}</div>
							<br>
							<div class="news_field_content">${news.content}</div>
						</div>
					</c:otherwise>
				</c:choose>					
			</div>
			
			<jsp:include page="static/right_section.jsp"></jsp:include>

		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>