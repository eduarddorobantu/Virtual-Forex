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
				//getOpenRatesUSD();
			</script>
			<div id="left_section">
				<div id="carousel" class="carousel slide" data-interval="7000" data-ride="carousel">
			    	<!-- Carousel indicators -->
			        <ol class="carousel-indicators">
			            <li data-target="#carousel" data-slide-to="0" class="active"></li>
			            <li data-target="#carousel" data-slide-to="1"></li>
			            <li data-target="#carousel" data-slide-to="2"></li>
			        </ol>   
			       <!-- Carousel items -->
			        <div class="carousel-inner">
			            <div class="active item">
			                <h2>Slide 1</h2>
			                <div class="carousel-caption">
			                  <h3>First slide label</h3>
			                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
			                </div>
			            </div>
			            <div class="item">
			                <h2>Slide 2</h2>
			                <div class="carousel-caption">
			                  <h3>Second slide label</h3>
			                  <p>Aliquam sit amet gravida nibh, facilisis gravida odio.</p>
			                </div>
			            </div>
			            <div class="item">
			                <h2>Slide 3</h2>
			                <div class="carousel-caption">
			                  <h3>Third slide label</h3>
			                  <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
			                </div>
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
				<div style="float:left; padding-left: 20px; width: 670px;">Welcome to Exchange Rates UK - Exchange Rates UK is a site devoted to bringing you the latest currency news, historical data, currency conversion and exchange rates, using mid-market rates updated minutely (22:00 Sun - 22:00 Fri)Welcome to Exchange Rates UK - Exchange Rates UK is a site devoted to bringing you the latest currency news, historical data, currency conversion and exchange rates, using mid-market rates updated minutely (22:00 Sun - 22:00 Fri)Welcome to Exchange Rates UK - Exchange Rates UK is a site devoted to bringing you the latest currency news, historical data, currency conversion and exchange rates, using mid-market rates updated minutely (22:00 Sun - 22:00 Fri)Welcome to Exchange Rates UK - Exchange Rates UK is a site devoted to bringing you the latest currency news, historical data, currency conversion and exchange rates, using mid-market rates updated minutely (22:00 Sun - 22:00 Fri)Welcome to Exchange Rates UK - Exchange Rates UK is a site devoted to bringing you the latest currency news, historical data, currency conversion and exchange rates, using mid-market rates updated minutely (22:00 Sun - 22:00 Fri)Welcome to Exchange Rates UK - Exchange Rates UK is a site devoted to bringing you the latest currency news, historical data, currency conversion and exchange rates, using mid-market rates updated minutely (22:00 Sun - 22:00 Fri)</div>
				<table id="currency_table">
				<thead>
					<tr class="table_title">
						<td colspan="7">Currencies</td>
					</tr>
					<tr class="table_header">
						<td>Name</td>
						<td>Rate</td>
						<td>Ask</td>
						<td>Bid</td>
						<td>Open</td>
						<td>Variation</td>
						<td>Time</td>						
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
			
		
			<!-- <div style="float:left; "><img style="width:310px" src="images/login.png"/></div> -->
			<!-- <img src="images/mock4.png" style="padding-left: 20px;"/>
			<img src="images/log.png" style="width: 277px; float: right; padding-right: 45px;"> -->
			<!-- <img src="images/img1.jpg" id="img"/> -->
			
			<img src="images/mock3.png"/>
		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>