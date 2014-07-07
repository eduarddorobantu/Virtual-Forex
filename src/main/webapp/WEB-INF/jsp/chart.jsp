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
	</head>
	<body>
		<jsp:include page="static/header.jsp"></jsp:include>
		<jsp:include page="static/nav.jsp"></jsp:include>
		
		<section>
			<jsp:include page="static/exchange_values.jsp"></jsp:include>
			
			<div id="left_section">
				<div class="subtitle">
					<span>
						${currencies}
					</span>
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