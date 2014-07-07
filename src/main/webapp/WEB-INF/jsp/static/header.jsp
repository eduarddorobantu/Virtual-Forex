<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
	<div id="header_body">
		<div id="left">
			<a href="">
				<img src="/forex/images/logo.png"/>
				<h1>VirtualForex</h1>
			</a>			
		</div>		
		<div id="right">
			<c:choose>
				<c:when test="${sessionScope.user == null}">
					<div>
						<span>Not a member yet?</span>&nbsp;&nbsp; <a href="register.html">Sign Up Now</a>
						&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
						Currencies:&nbsp;&nbsp;
						<a class="flag" href="/forex/chart/eurusd.html">
							<img alt="USD" width="23px" height="16px" src="/forex/images/currencies/usd.png"/>
						</a>
						&nbsp;
						<a class="flag" href="/forex/chart/usdeur.html">
							<img alt="EUR" width="23px" height="16px" src="/forex/images/currencies/eur.png"/>						
						</a>
						&nbsp;
						<a class="flag" href="/forex/chart/usdjpy.html">
							<img alt="JPY" width="23px" height="16px" src="/forex/images/currencies/jpy.png"/>
						</a>	
						&nbsp;
						<a class="flag" href="/forex/chart/usdgbp.html">
							<img alt="GBP" width="23px" height="16px" src="/forex/images/currencies/gbp.png"/>
						</a>
						&nbsp;
						<a class="flag" href="/forex/chart/usdchf.html">
							<img alt="CHF" width="23px" height="16px" src="/forex/images/currencies/chf.png"/>
						</a>
						&nbsp;
						<a class="flag" href="/forex/chart/usddkk.html">
							<img alt="DKK" width="23px" height="16px" src="/forex/images/currencies/dkk.png"/>
						</a>
						&nbsp;
						<a class="flag" href="/forex/chart/usdcad.html">
							<img alt="CAD" width="23px" height="16px" src="/forex/images/currencies/cad.png"/>
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<a href="/forex/my_silos.html">My silos</a>
						&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
						<a href="/forex/edit_account.html">Edit account</a>
						&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
						<span id="logout" onclick="logout()">Logout</span>					
						&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
						<span id="balance_label">Current balance: </span><span id="balance">100,000$</span>
					</div>
				</c:otherwise>
			</c:choose>
			
			<div id="right_bottom">
				<img src="/forex/images/banner2.jpg" />
				<div class="right_bottom_item" id="twitter"></div>
				<div class="right_bottom_item" id="facebook"></div>
				<!-- <div class="right_bottom_item">
					<span id="balance_label">Your current balance: </span><span id="balance">1500$</span>
				</div> -->
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function logout() {
			var form = document.createElement("form");
			form.setAttribute('method', "post");
			
			var input = document.createElement("input"); 
			input.setAttribute('type',"hidden");
			input.name = "logout";
			input.value = "Logout";
			
			form.appendChild(input);

			form.submit();
		}
	</script>
		
</header>