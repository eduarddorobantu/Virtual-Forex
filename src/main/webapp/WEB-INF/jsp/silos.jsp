<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%!
public String getFlag(String code)
{
		
 	return "Hello";
}
%>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Virtual Forex</title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<link rel="stylesheet" type="text/css" href="css/silos.css">
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
				var numbers = document.getElementsByClassName("cell3");
				for(var i=0; i<numbers.length; i++)
                    numbers[i].innerHTML = numberWithCommas(numbers[i].innerHTML);
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
						My silos
					</span>
				</div>
				<table id="silo_table">
					<thead>
						<tr class="table_header">
							<td class="cell0_header">Flag</td>
							<td class="cell1_header">Currency code</td>
							<td class="cell2_header">Currency name</td>		
							<td class="cell3_header">Amount</td>				
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${silos}" var="silo">   
								<c:choose>
									<c:when test="${currencies.get(silo.id).code.toLowerCase().equals('usd')}">
										<tr onclick="window.document.location='/forex/chart/usdeur.html'">
									</c:when>
									<c:otherwise>
										<tr onclick="window.document.location='/forex/chart/usd${currencies.get(silo.id).code.toLowerCase()}.html'">
									</c:otherwise>
								</c:choose>
						            <td class="cell0">						        	
							        		<img alt="${currencies.get(silo.id).code}" width="23px" height="16px" src="/forex/images/currencies/${currencies.get(silo.id).code.toLowerCase()}.png"/>
							        </td>
							        <td class="cell1">${currencies.get(silo.id).code}</td>
							        <td class="cell2">${currencies.get(silo.id).name}</td>
							        <td class="cell3">${silo.amount}</td>
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