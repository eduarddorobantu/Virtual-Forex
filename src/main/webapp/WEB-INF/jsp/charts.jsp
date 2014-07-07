<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="/forex/css/chart.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script src="js/externaldata.js"></script>
		
		<script type="text/javascript">
			function refresh() {
				var select1 = document.getElementsByTagName("select")[0];
				var select2 = document.getElementsByTagName("select")[1];
				var select1_id = select1[select1.selectedIndex].id.toLowerCase();
				var select2_id = select2[select2.selectedIndex].id.toLowerCase();
				var link = '/forex/charts/' + select1_id + select2_id + ".html";
				
				window.location.href = link;
			}
		</script>
	</head>
	<body>
		<jsp:include page="static/header.jsp"></jsp:include>
		<jsp:include page="static/nav.jsp"></jsp:include>
		
		<section>
			<jsp:include page="static/exchange_values.jsp"></jsp:include>
			
			<div id="left_section">
				<div class="subtitle">
					<span>
						Charts
					</span>
				</div>
				<div id="currency_selector1">
					<select onchange="refresh()">
						<c:forEach items="${currencies}" var="currency">   
							<c:choose>
								<c:when test="${currency.code.equalsIgnoreCase(currency1)}">
									<option id="${currency.code}" selected="selected">${currency.name}</option>
								</c:when>
								<c:otherwise>
									<option id="${currency.code}">${currency.name}</option>
								</c:otherwise>
							</c:choose>
					    </c:forEach> 
					</select>					
				</div>
				<div id="currency_selector2">
					<select onchange="refresh()">
						<c:forEach items="${currencies}" var="currency">   
							<c:choose>
								<c:when test="${currency.code.equalsIgnoreCase(currency2)}">
									<option id="${currency.code}" selected="selected">${currency.name}</option>
								</c:when>
								<c:otherwise>
									<option id="${currency.code}">${currency.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>					
				</div>
				<div id="chart">
					<object type="application/x-shockwave-flash" id="yfi_chart_swf" data="https://s.yimg.com/bm/lib/fi/common/p/d/static/swf/2.0.343511/2.0.0/en-US/largechart.swf" width="680" height="450" style="visibility: visible; ">
						<param name="allowscriptaccess" value="always">
						<param name="wmode" value="opaque">
						<param name="flashvars" value="${embed_address}">
					</object>
				</div>
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
			
		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
		
	</body>
</html>