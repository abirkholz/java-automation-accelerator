package api;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import utility.Utility;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class Http {
	private static RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(30 * 1000)
					.setConnectionRequestTimeout(30 * 1000)
					.setSocketTimeout(30 * 1000)
					.build();
	
	private static CloseableHttpClient getHttpsClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		return HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLSocketFactory(sslsf).build();
	}
	
	public static CloseableHttpResponse httpsDelete(String url) throws Exception {
		HttpDelete httpDelete = new HttpDelete(url);
		return getHttpsClient().execute(httpDelete);
	}
	
	public static HttpResponse httpDelete(String url) throws Exception {
		HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpDelete httpDelete = new HttpDelete(url);
		return client.execute(httpDelete);
	}
	
	public static CloseableHttpResponse httpsGet(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		return getHttpsClient().execute(httpGet);
	}
	
	public static HttpResponse httpGet(String url) throws Exception {
		HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpGet httpGet = new HttpGet(url);
		return client.execute(httpGet);
	}
	
	public static <T> CloseableHttpResponse httpsPut(String url, T json) throws Exception {
		Utility.toJson(json);
		HttpPut httpPut = new HttpPut(url);
		return getHttpsClient().execute(httpPut);
	}
	
	public static <T> HttpResponse httpPut(String url, T json) throws Exception {
		HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpPut httpPut = new HttpPut(url);
		return client.execute(httpPut);
	}
	
	
	
}
