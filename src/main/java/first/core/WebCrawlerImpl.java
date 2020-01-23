package first.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import first.StringDividerException;


public class WebCrawlerImpl implements WebCrawler {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public WebCrawlerImpl(){}
	
	public String getRawText(final String url) throws Exception {	
		HttpURLConnection conn = null;
		BufferedReader br = null;
		String line="";
		StringBuilder sb = new StringBuilder();
		try {		
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (Exception e){
			logger.error(e.getMessage());
			throw new StringDividerException("Getting the url's content failed.");
		} finally {
			try {
				br.close();
			} catch (IOException e) {				
			}
			conn.disconnect();
		}
		return sb.toString();	
	}
}
