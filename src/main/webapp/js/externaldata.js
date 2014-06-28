var openRatesFromUSD = {};
var availableCurrencies = {};
var openRatesCurrencies = [];
var currencies = ['EURUSD', 'USDJPY', 'GBPUSD', 'USDCHF', 'EURDKK', 'EURCAD'];
var refreshTimeout = 70000;

function getOpenRatesUSD() {
	var dDate = new Date();
	dDate.setDate(dDate.getDate() - 7);
	
	for (var i = 0; i < currencies.length; i++) {
		var currency1 = currencies[i].substring(0, 3);
		var currency2 = currencies[i].substring(3, currencies[i].length);
		availableCurrencies[currency1] = 0;
		availableCurrencies[currency2] = 0;
	}
	availableCurrencies['USD'] = 1;
	
	for (var i = 0; i < currencies.length; i++) {
		var currency1 = currencies[i].substring(0, 3);
		var currency2 = currencies[i].substring(3, currencies[i].length);
		console.log(currency1 + " " + currency2);
		if (currency1 != 'USD')
			getOpenRatesFromUSD(dDate.getDate(), dDate.getMonth(), dDate.getFullYear(), currency1);
		if (currency2 != 'USD') 
			getOpenRatesFromUSD(dDate.getDate(), dDate.getMonth(), dDate.getFullYear(), currency2);
	}
}

//get open rates from day, month, year for currency
function getOpenRatesFromUSD(day, month, year, currency) {
	var script = document.createElement('script');
    script.setAttribute('src', "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D'http%3A%2F%2Fichart.yahoo.com%2Ftable.csv%3Fs%3D"+currency+"%3Dx%26a%3D"+month+"%26b%3D"+day+"%26c%3D"+year+"%26g%3Dd'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys'&format=json&callback=getOpenRateUSD"+currency+"Callback");
    document.body.appendChild(script);
}

function getOpenRateUSDEURCallback(data) {
	var results = data.query.results.row;
	openRatesFromUSD['EUR'] = parseFloat(results[1].col4);
	verifyFinishGettingRatesFromUSD();
}

function getOpenRateUSDJPYCallback(data) {
	var results = data.query.results.row;
	openRatesFromUSD['JPY'] = parseFloat(results[1].col4);
	verifyFinishGettingRatesFromUSD();
}

function getOpenRateUSDGBPCallback(data) {
	var results = data.query.results.row;
	openRatesFromUSD['GBP'] = parseFloat(results[1].col4);
	verifyFinishGettingRatesFromUSD();
}

function getOpenRateUSDCHFCallback(data) {
	var results = data.query.results.row;
	openRatesFromUSD['CHF'] = parseFloat(results[1].col4);
	verifyFinishGettingRatesFromUSD();
}

function getOpenRateUSDDKKCallback(data) {
	var results = data.query.results.row;
	openRatesFromUSD['DKK'] = parseFloat(results[1].col4);
	verifyFinishGettingRatesFromUSD();
}

function getOpenRateUSDCADCallback(data) {
	var results = data.query.results.row;	
	openRatesFromUSD['CAD'] = parseFloat(results[1].col4);
	verifyFinishGettingRatesFromUSD();
}

function verifyFinishGettingRatesFromUSD() {
	if (Object.keys(availableCurrencies).length == Object.keys(openRatesFromUSD).length + 1) {
		openRatesFromUSD['USD'] = 1;
		calculateOpenRates();		
	}		
}

function calculateOpenRates() {
	for (var i = 0; i < currencies.length; i++) {
		var currency1 = currencies[i].substring(0, 3);
		var currency2 = currencies[i].substring(3, currencies[i].length);
		
		openRatesCurrencies.push(calculateOpenRate(currency1, currency2));
	}
	
	getRates();
}

function calculateOpenRate(currency1, currency2) {
	if (currency1 == 'USD')
		return openRatesFromUSD[currency2];
	else if (currency2 == 'USD') 
		return Math.round(parseFloat(1/openRatesFromUSD[currency1])*100)/100;
	else {
		var rate1 = openRatesFromUSD[currency1];
		var rate2 = openRatesFromUSD[currency2];
		return Math.round(parseFloat(rate2/rate1)*100)/100;
	}
}

function getRates() {
    var script = document.createElement('script');
    script.setAttribute('src', "http://query.yahooapis.com/v1/public/yql?q=select%20name%2Crate%2Cask%2Cbid%2Cdate%2Ctime%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes%3Fs%3D"+currencies[0]+"%253DX,"+currencies[1]+"%253DX,"+currencies[2]+"%253DX,"+currencies[3]+"%253DX,"+currencies[4]+"%253DX,"+currencies[5]+"%253DX,"+"%26f%3Dnl1abd1t1'%20and%20columns%3D'name%2Crate%2Cask%2Cbid%2Cdate%2Ctime'%0A&format=json&callback=getRatesCallback");
    document.body.appendChild(script);
}

function getRatesCallback(data) {
  	var results = data.query.results.row;
  	var table_body = document.getElementById("currency_table").getElementsByTagName("tbody")[0];
  	for (var i = 0; i < results.length; i++) {
  		var row = table_body.insertRow(i);
  		var name = results[i].name;
  		name = name.replace(" to ", "/");
  		var link = '/forex/chart/' + name.replace("/", "").toLowerCase() + ".html";
  		row.setAttribute("onclick", "window.document.location='" + link + "'");
  			
  		insertColouredCell(row, 0, name, results[i].rate, openRatesCurrencies[i]);
  		insertCellForRate(row, 1, results[i].rate, openRatesCurrencies[i]);
  		insertCell(row, 2, results[i].ask);
  		insertCell(row, 3, results[i].bid);
  		insertCell(row, 4, openRatesCurrencies[i]);
  		var variation = calculateVariation(openRatesCurrencies[i], results[i].rate);
  		insertColouredCell(row, 5, variation, results[i].rate, openRatesCurrencies[i]);
  		insertCell(row, 6, results[i].time);
  	}
  	
  	setTimeout(updateRates, refreshTimeout);
}

//insert in a normal cell
function insertCell(row, position, insertResult) {
	var cell = row.insertCell(position);
	cell.innerHTML = insertResult;
	var cellNr = "cell" + position;
	cell.className = cellNr;	
}

//insert in rate cell
function insertCellForRate(row, position, insertResult, open) {
	var cell = row.insertCell(position);
	cell.innerHTML = insertResult;
	if (insertResult > open) {
		cell.innerHTML += "<img src='images/up.png' width='12' height='12'>";
		cell.style.color = "green";
	}
	else if (insertResult < open) {
		cell.innerHTML += "<img src='images/down.png' width='12' height='12'>";
		cell.style.color = "red";
	}		
	
	var cellNr = "cell" + position;
	cell.className = cellNr;	
}

//insert in name and variation cell
function insertColouredCell(row, position, insertResult, rate, open) {
	var cell = row.insertCell(position);
	cell.innerHTML = insertResult;
	if (position == 5)
		cell.innerHTML += "%";
	
	if (rate > open)
		cell.style.color = "green";
	else if (rate < open)
		cell.style.color = "red";
	
	var cellNr = "cell" + position;
	cell.className = cellNr;	
}

function calculateVariation(last, actual) {
	var result = actual/last;
	if (result > 1)
		return ((result - 1) * 100).toFixed(3);
	else
		return ((1 - result) * 100).toFixed(3);
}

function updateRates() {
	var script = document.createElement('script');
    script.setAttribute('src', "http://query.yahooapis.com/v1/public/yql?q=select%20name%2Crate%2Cask%2Cbid%2Cdate%2Ctime%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes%3Fs%3D"+currencies[0]+"%253DX,"+currencies[1]+"%253DX,"+currencies[2]+"%253DX,"+currencies[3]+"%253DX,"+currencies[4]+"%253DX,"+currencies[5]+"%253DX,"+"%26f%3Dnl1abd1t1'%20and%20columns%3D'name%2Crate%2Cask%2Cbid%2Cdate%2Ctime'%0A&format=json&callback=updateRatesCallback");
    document.body.appendChild(script);
}

function updateRatesCallback(data) {
  	var results = data.query.results.row;
  	var table_body = document.getElementById("currency_table").getElementsByTagName("tbody")[0];
  	console.log(data);
  	
  	for (var i = 0; i < results.length; i++) {
  		var row = table_body.getElementsByTagName("tr")[i];
  		var cellAux = row.getElementsByClassName("cell1")[0];
  		var content = cellAux.innerHTML;
  		var lastRate = parseFloat(content.split('<img')[0]);
  		
  		var name = results[i].name;
  		name = name.replace(" to ", "/");
  			
  		updateColouredCell(row, 0, name, results[i].rate, lastRate);
  		updateCellForRate(row, 1, results[i].rate, lastRate);
  		updateCell(row, 2, results[i].ask);
  		updateCell(row, 3, results[i].bid);
  		updateCell(row, 4, openRatesCurrencies[i]);
  		
  		var variation = calculateVariation(lastRate, results[i].rate);
  		updateColouredCell(row, 5, variation, results[i].rate, lastRate);
  		updateCell(row, 6, results[i].time);
  	}
  	
  	setTimeout(updateRates, refreshTimeout);
}

//update in a normal cell
function updateCell(row, position, insertResult) {
	
	var cellClass = "cell" + position;
	var cell = row.getElementsByClassName(cellClass)[0];
	cell.innerHTML = insertResult;
	
}

//update in rate cell
function updateCellForRate(row, position, rate, lastRate) {
	var cell = row.getElementsByClassName("cell1")[0];
	
	if (rate > lastRate) {
		cell.innerHTML = rate + "<img src='images/up.png' width='12' height='12'>";
		cell.style.color = "green";
	}
	else if (rate < lastRate) {
		cell.innerHTML = rate + "<img src='images/down.png' width='12' height='12'>";
		cell.style.color = "red";
	}	
	else {
		cell.innerHTML = rate;
		cell.style.color = "black";
	}
	
}

//update in name and variation cell
function updateColouredCell(row, position, insertResult, rate, lastRate) {
	
	var cellClass = "cell" + position;
	var cell = row.getElementsByClassName(cellClass)[0];
	cell.innerHTML = insertResult;
	if (position == 5)
		cell.innerHTML += "%";
	if (rate > lastRate)
		cell.style.color = "green";
	else if (rate < lastRate)
		cell.style.color = "red";
	else
		cell.style.color = "black";
}





