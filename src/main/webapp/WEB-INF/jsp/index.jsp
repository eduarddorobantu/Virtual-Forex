<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script src="js/externaldata.js"></script>
	</head>
	<body>
		<jsp:include page="static/header.jsp"></jsp:include>
		<jsp:include page="static/nav.jsp"></jsp:include>
		
		<section>
			<jsp:include page="static/exchange_values.jsp"></jsp:include>
			
			<script type="text/javascript"> 
				getOpenRatesUSD();
			</script>
			<div id="left_section">
				<div id="carousel" class="carousel slide" data-interval="70000" data-ride="carousel">
			    	<!-- Carousel indicators -->
			        <ol class="carousel-indicators">
			            <li data-target="#carousel" data-slide-to="0" class="active"></li>
			            <li data-target="#carousel" data-slide-to="1"></li>
			            <li data-target="#carousel" data-slide-to="2"></li>
			        </ol>   
			       <!-- Carousel items -->
			        <div class="carousel-inner">
			            <div class="active item" id="item1">

			            </div>
			            <div class="item" id="item2">
			                <h2 class="item2_text" id="first_item2_text">REAL-TIME</h2>
			                <h2 class="item2_text"> CHARTS</h2>
			            </div>
			            <div class="item" id="item3">
			            </div>
			        </div>
			        <!-- Carousel nav -->
			        <a class="carousel-control left" href="#carousel" data-slide="prev">
			            <span class="glyphicon glyphicon-chevron-left"></span>
			        </a>
			        <a class="carousel-control right" href="#carousel" data-slide="next">
			            <span class="glyphicon glyphicon-chevron-right"></span>
			        </a>
			    </div>
				<div style="margin-bottom: 20px; height: 305px;">
					
				</div> 
				<div class="subtitle">
					<span>
						Currencies
					</span>
				</div>
				<table id="currency_table">
					<thead>
						<tr class="table_header">
							<td class="cell0_header">Name</td>
							<td class="cell1_header">Rate</td>
							<td class="cell2_header">Ask</td>
							<td class="cell3_header">Bid</td>
							<td class="cell4_header">Open</td>
							<td class="cell5_header">Variation</td>
							<td class="cell6_header">Time</td>						
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
			<img src="images/horizontal_line.png" style="margin-left: 11px;"/>
			<img src="images/mock3.png"/>
			
		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>