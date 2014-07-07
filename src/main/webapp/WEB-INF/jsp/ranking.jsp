<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="css/ranking.css">
		<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script src="js/externaldata.js"></script>
		
		<script type="text/javascript">
			function numberWithCommas(x) {
			    var parts = x.toString().split(".");
			    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			    return parts.join(".");
			}
			function setNumberFormat() {
				var numbers = document.getElementsByClassName("cell1");
				for(var i=0; i<numbers.length; i++) {
                    numbers[i].innerHTML = numberWithCommas(numbers[i].innerHTML).substring(0,9);
				}
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
						Ranking
					</span>
				</div>
				<table id="ranking_table">
					<thead>
						<tr class="table_header">
							<td class="cell0_header">Username</td>
							<td class="cell1_header">USD<img src="/forex/images/currencies/usd.png"></td>
							<td class="cell2_header">EUR<img src="/forex/images/currencies/eur.png"></td>		
							<td class="cell3_header">JPY<img src="/forex/images/currencies/jpy.png"></td>		
							<td class="cell4_header">GBP<img src="/forex/images/currencies/gbp.png"></td>		
							<td class="cell5_header">CHF<img src="/forex/images/currencies/chf.png"></td>	
							<td class="cell6_header">DKK<img src="/forex/images/currencies/dkk.png"></td>	
							<td class="cell7_header">CAD<img src="/forex/images/currencies/cad.png"></td>	
							<td class="cell8_header">Total<img src="/forex/images/currencies/usd.png"></td>	
						</tr>
					</thead>
					<tbody>					
						<c:forEach items="${usersRankingSorted}" var="userSorted">   
							<tr>
							    <td class="cell0">${userSorted.key}</td>
						        <c:forEach items="${usersRankingAll.get(userSorted.key)}" var="userValue"> 
							        <td class="cell1">${userValue}</td>
							    </c:forEach>
						        <td class="cell1 cell8">${userSorted.value}</td>
					       </tr>
					    </c:forEach>	
					</tbody>
				</table>
				
				
			</div>
			<jsp:include page="static/right_section.jsp"></jsp:include>
			<script>
				setNumberFormat();
			</script>
		</section>
		
		<jsp:include page="static/footer.jsp"></jsp:include>
	
	</body>
</html>