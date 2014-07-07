package converter;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.stereotype.Service;

@Service
public class YahooCurrencyConverter {
	public Double convert(String currencyFrom, String currencyTo) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv");
        BasicResponseHandler responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpGet, responseHandler);
        httpclient.getConnectionManager().shutdown();
        return Double.parseDouble(responseBody);
    }
}
