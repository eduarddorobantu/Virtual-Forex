<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="css/faq.css">
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
						FAQ
					</span>
				</div>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> What is Forex?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> Forex and 'FX' are shortened terms used for 'foreign exchange'. Foreign exchange or 'currency trading' is the exchange of money from different countries. The value of one country's currency is constantly changing against the value of another country's currency. Forex traders make money through buying and selling currencies on the foreign exchange market.
				</div>
				<hr>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> What are your commissions and fees on trading?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> Being an online simulator, our site does not charge any type of commission.
				</div>
				<hr>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> What currencies can I trade with Virtual Forex?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> Virtual Forex offers some of the most important currencies: Euro Member Countries (EUR), United States Dollar (USD), United Kingdom Pound (GBP), Switzerland Franc (CHF), Denmark Krone (DKK), Japan Yen (JPY) and Canada Dollar (CAD)
				</div>
				<hr>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> Is forex risky?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> Yes, we advise all our clients that real foreign exchange trading does involve substantial amount of risk. On the other hand, trading in our online simulator is completely free.
				</div>
				<hr>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> What hours can I trade?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> The Virtual Forex online platform gives you 24 hour access to your account. Normal trading hours are 06:00 Monday Sydney time until 17:00 Friday New York time. Trading outside of these hours usually involves larger spreads.
				</div>
				<hr>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> Why cannot I view the charts?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> To view the charts you will need to install Javascript.
				</div>
				<hr>
				<div class="faq_question">
					<span class="faq_initial">Q:</span> How can I close my account?
				</div>
				<div class="faq_answer">
					<span class="faq_initial">A:</span> Please send us a message through the Contact page to close your account.
				</div>
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>