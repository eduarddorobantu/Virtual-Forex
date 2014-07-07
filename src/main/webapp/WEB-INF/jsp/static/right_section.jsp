<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function getRate(currency_pair) {
		var script = document.createElement('script');
	    script.setAttribute('src', "http://query.yahooapis.com/v1/public/yql?q=select%20name%2Crate%2Cask%2Cbid%2Cdate%2Ctime%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes%3Fs%3D"+currency_pair+"%253DX"+"%26f%3Dnl1abd1t1'%20and%20columns%3D'name%2Crate%2Cask%2Cbid%2Cdate%2Ctime'%0A&format=json&callback=updateFieldsCallback");
	    document.body.appendChild(script);
	}
	
	function updateFieldsCallback(data) {
	  	var results = data.query.results.row;
		//render the result
	  	var name = results.name;
	  	var currency1 = name.substring(0, 3);
	  	var currency2 = name.substring(7, 10);
	  	var rate = results.rate;
	  	var exchange_rate = document.getElementById("buy_ccy_exchange_rate");
	  	exchange_rate.innerHTML = '1 ' + currency1 + ' = ' + "<span id='span_rate'>" + rate + " </span> " + currency2; 
	
	  	setTimeout(function() {
	  	    getRate(currency1 + currency2);
	  	}, refreshTimeout);
	
	}

	function refresh() {
		 
		var select_currency1 = document.getElementById("sell_ccy");
		var select_currency2 = document.getElementById("buy_ccy");
		var select1_value = select_currency1[select_currency1.selectedIndex].value;
		var select2_value = select_currency2[select_currency2.selectedIndex].value;
		var span_currency1 = document.getElementById("span_currency1");
		var span_currency2 = document.getElementById("span_currency2");
		var input_currency1 = document.getElementById("input_currency1");
		var input_currency2 = document.getElementById("input_currency2");
		var rate = document.getElementById("span_rate");
		span_currency1.innerHTML = select1_value;
		span_currency2.innerHTML = select2_value;
		input_currency1.value = 0;
		input_currency2.value = 0;
		
		getRate(select1_value + select2_value);
		
	}
	
	function animate() {
		var exchange_values_div = document.getElementById("move_exchange_values");	
		var child = exchange_values_div.children[0];

		exchange_values_div.removeChild(exchange_values_div.children[0]);
		exchange_values_div.style.left = "0px";
		exchange_values_div.appendChild(child);

		$('#move_exchange_values').animate({left:'-250px'}, 8000, 'linear', function(){
			setTimeout(animate, 1);
		});
	}
	
	$(document).ready(function(e) {
	    $('#input_currency1').on('input', function(){
	    	refresh_input();
	    });
	    
	    $('#move_exchange_values').animate({left:'-250px'}, 8000, 'linear', function(){
	    	animate();
		});
	});
	
	function refresh_input() {
		var input_currency1 = document.getElementById("input_currency1");
		var input_currency2 = document.getElementById("input_currency2");
		var rate = document.getElementById("span_rate");
		
		input_currency2.value = parseFloat(input_currency1.value) * parseFloat(rate.innerHTML);
	}
	
	function buy_currency() {
		//get ids of the currencies
		var select_currency1 = document.getElementById("sell_ccy");
		var select_currency2 = document.getElementById("buy_ccy");
		var select1_id = select_currency1[select_currency1.selectedIndex].id;
		var select2_id = select_currency2[select_currency2.selectedIndex].id;
		
		//get values of the currencies
		var amount_from_currency = document.getElementById("input_currency1").value;
		var amount_to_currency = document.getElementById("input_currency2").value;
		
		if (amount_from_currency == "0") {
			alert ("Error! Please select an amount different from 0!");
			return;
		}	
		
		var form = document.createElement("form");
		form.setAttribute('method', "post");
		
		var input1 = document.createElement("input"); 
		input1.setAttribute('type',"hidden");
		input1.name = "buy_currency";
		input1.value = "buy_currency";
		
		var input2 = document.createElement("input"); 
		input2.setAttribute('type',"hidden");
		input2.name = "from_currency";
		input2.value = select1_id;
		
		var input3 = document.createElement("input"); 
		input3.setAttribute('type',"hidden");
		input3.name = "to_currency";
		input3.value = select2_id;
		
		var input4 = document.createElement("input"); 
		input4.setAttribute('type',"hidden");
		input4.name = "amount_from_currency";
		input4.value = amount_from_currency;
		
		var input5 = document.createElement("input"); 
		input5.setAttribute('type',"hidden");
		input5.name = "amount_to_currency";
		input5.value = amount_to_currency;
		
		form.appendChild(input1);
		form.appendChild(input2);
		form.appendChild(input3);
		form.appendChild(input4);
		form.appendChild(input5);		

		form.submit();
	}

</script>

<div id="right_section">
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<div id="login_div">
				<form method="post">
					<table>
						<thead>
							<tr><td colspan="2">LOGIN</td></tr>
						</thead>
							<tr>
								<td></td>
								<td class="label_login">Username:</td>
							</tr>
							<tr>
								<td><img src="/forex/images/usr2.png" width=15px height=18px/></td>
								<td><input type="text" name="username"/></td>
							</tr>
							<tr>
								<td></td>
								<td id="pass_label">Password:</td>
							</tr>
							<tr>
								<td><img src="/forex/images/pass1.png" width=17px height=18px/></td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td></td>
								<td id="buttons">
									<input type="submit" name="login" value="Login"/>
								</td>
							</tr>
					</table>
				</form>
			</div>
			<div>
				<a href="register.html">
					<img id="register_button" src="/forex/images/register2.jpg"/>
				</a>
			</div>
		</c:when>
		<c:otherwise>
			<div id="buy_ccy_div">
				<div class="buy_ccy_header">
					Buy Currency Now
				</div>
				<div id="buy_ccy_body">
					<div class="buy_ccy_section" id="first_buy_ccy_section">
						<div class="buy_ccy_label">What currency do you sell?</div>
						<div class="buy_ccy_select">
							<select name="sell_ccy" id="sell_ccy" onchange="refresh();">
								<c:forEach items="${availableCurrencies}" var="currency">   
							       <c:choose>
										<c:when test="${currency.code.equals('USD')}">
											<option id="${currency.id}" selected="selected">${currency.code}</option>
										</c:when>
										 <c:otherwise>
								        	<option id="${currency.id}">${currency.code}</option>
								        </c:otherwise>
									</c:choose>  		
							    </c:forEach> 
							</select>	
						</div>
					</div>
					<div class="buy_ccy_section">
						<div class="buy_ccy_label">What currency do you buy?</div>
						<div class="buy_ccy_select">
							<select name="buy_ccy" id="buy_ccy" onchange="refresh();">
								<c:forEach items="${availableCurrencies}" var="currency"> 
									<c:choose>
										<c:when test="${currency.code.equals('EUR')}">
											<option id="${currency.id}" selected="selected">${currency.code}</option>
										</c:when>
										 <c:otherwise>
								        	<option id="${currency.id}">${currency.code}</option>
								        </c:otherwise>
									</c:choose>  							       
							    </c:forEach> 
							</select>	
						</div>
					</div>		
					<div class="buy_ccy_last_section">
						<div class="buy_ccy_label">Amount</div>
						<div class="buy_ccy_input">
							<input id="input_currency1" type="text" value="0"  />
							<span id="span_currency1">USD</span>
							buys
							<input id="input_currency2" type="text" value="0" readonly/>
							<span id="span_currency2">EUR</span>
						</div>
						<div id="buy_ccy_exchange_rate">
							
						</div>
						<div id="buy_ccy_submit" onclick="buy_currency()" >
							<span >Buy Currency</span>
						</div>
					</div>			
				</div>
			</div>
			<script>
				getRate('USDEUR');
			</script>
		</c:otherwise>
	</c:choose>
	<div class="subtitle right_section_container">
		<span>
			News
		</span>
	</div>
	<div class="news right_section_container">
		<div class="news_item">
			<a href="/forex/news/${availableNews.get(0).title}.html" class="news_link">
				<div><b>${availableNews.get(0).date.toString().replaceAll("-", "/").substring(0, availableNews.get(0).date.toString().length() - 2)}</b></div>
				<div>${availableNews.get(0).title}</div>
			</a>			
		</div>
		<a href="/forex/news/${availableNews.get(1).title}.html" class="news_link">
			<div class="news_item">
				<div><b>${availableNews.get(1).date.toString().replaceAll("-", "/").substring(0, availableNews.get(1).date.toString().length() - 2)}</b></div>
				<div>${availableNews.get(1).title}</div>
			</div>
		</a>	
	</div>
	<div class="right_section_container">
		<img src="/forex/images/more.png"/>
		<a class="read_more" href="/forex/news.html">
			GET MORE NEWS
		</a>
	</div>
</div>