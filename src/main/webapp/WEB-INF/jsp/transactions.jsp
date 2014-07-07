<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="/forex/css/transactions.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script src="/forex/js/externaldata.js"></script>
		
		<script type="text/javascript">
			function numberWithCommas(x) {
			    var parts = x.toString().split(".");
			    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			    return parts.join(".");
			}
			
			function setNumberFormat() {
				var amountsFrom = document.getElementsByClassName("cell2");
				var amountsTo = document.getElementsByClassName("cell4");
				for(var i=0; i<amountsFrom.length; i++) {
					amountsFrom[i].innerHTML = numberWithCommas(amountsFrom[i].innerHTML);
					amountsTo[i].innerHTML = numberWithCommas(amountsTo[i].innerHTML);
				}
			}
			
			function refresh_transactions() {
				var select = document.getElementById("select_user");
				var select_val = select[select.selectedIndex].value;
				var link = '/forex/transactions/' + select_val + ".html";
				if (select_val == 'All')
					link = '/forex/transactions.html';				
				
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
						Transactions
					</span>
				</div>
				<div id="user_selector_label">
					Select user:
				</div>
				<div id="user_selector">
					<select id="select_user" onchange="refresh_transactions()">
						<option id="0">All</option>
						<c:forEach items="${allUsers}" var="user">   
							<c:choose>
								<c:when test="${selectedUser != null && selectedUser.id == user.id}">
									<option id="${user.id}" selected="selected">${user.username}</option>
								</c:when>
								<c:otherwise>
									<option id="${user.id}">${user.username}</option>
								</c:otherwise>
							</c:choose>
					    </c:forEach> 
					</select>					
				</div>
				<table id="transactions_table">
					<thead>
						<tr class="table_header">
							<td class="cell0_header">User</td>
							<td class="cell1_header">From</td>
							<td class="cell2_header">Amount From</td>		
							<td class="cell3_header">To</td>		
							<td class="cell4_header">Amount To</td>		
							<td class="cell5_header">Date</td>	
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${transactions}" var="transaction">   
							<tr onclick="window.document.location='/forex/chart/${currenciesFrom.get(transaction.id).code.toLowerCase()}${currenciesTo.get(transaction.id).code.toLowerCase()}.html'">
							    <td class="cell0">						        	
						        	${users.get(transaction.id).username}
						        </td>
						        <td class="cell1"><img src="/forex/images/currencies/${currenciesFrom.get(transaction.id).code.toLowerCase()}.png"/>${currenciesFrom.get(transaction.id).code}</td>
						        <td class="cell2">${transaction.amountFromCurrency}</td>
						        <td class="cell3"><img src="/forex/images/currencies/${currenciesTo.get(transaction.id).code.toLowerCase()}.png"/>${currenciesTo.get(transaction.id).code}</td>
						        <td class="cell4">${transaction.amountToCurrency}</td>
						        <td class="cell5">${transaction.date}</td>
					       </tr>
					    </c:forEach>					
					</tbody>
				</table>
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
		</section>
		<script>
			setNumberFormat();
		</script>
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>