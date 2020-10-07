import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SoapClient {
	
	public static void main(String[] args) {
		
		String url;
		String request;
		String soapAction = "";
		
		int[] ACCEPTED_RESPONSES = {HttpURLConnection.HTTP_OK};
		
		if(args.length != 2) {
			System.out.println("The sintax in wrong. You must provide [url] and [request].");
		}
		else {
			
			try {
				
				url = args[0];
				request = args[1];
				
				//load content request...
				File requestFile = new File(request);
				
				if(!requestFile.exists())
					throw new FileNotFoundException();
				
				
				BufferedReader bReader = new BufferedReader(new FileReader(requestFile));
				
				StringBuilder requestContent = new StringBuilder();			
				String line;
				
				while((line = bReader.readLine()) != null) {
					requestContent.append(line);
				}
				
				bReader.close();
				
				
				URL url_ = new URL(url);
				
				HttpURLConnection con = (HttpURLConnection) url_.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("SOAPAction", soapAction);
				
				System.out.println("REQUEST:");
				System.out.println("URL: " + url);
				System.out.println("SOAPAction: " + soapAction);
				System.out.println("Body: \n" + requestContent.toString());
				// For POST only - START
				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
				os.write(requestContent.toString().getBytes());
				os.flush();
				os.close();
				// For POST only - END
				
				int responseCode = con.getResponseCode();
				
				System.out.println("\nRESPONSE:");
				System.out.println("POST Response Code :: " + responseCode);
				
				InputStream inputStream;
				
				if (responseCode == HttpURLConnection.HTTP_OK) inputStream = con.getInputStream();
				else inputStream = con.getErrorStream();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
				
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				in.close();

				// print result
				System.out.println(response.toString());
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
		}
	
		
		
	}

}
