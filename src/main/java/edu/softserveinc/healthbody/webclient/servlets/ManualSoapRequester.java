package edu.softserveinc.healthbody.webclient.servlets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class ManualSoapRequester
 */
@WebServlet("/soap")
//@Slf4j
public class ManualSoapRequester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManualSoapRequester() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String urlStr = "http://localhost:8080/lv185/HealthBodyService";

	    String partNumber = request.getParameter("partNumber");
		String partSize = request.getParameter("partSize");
		
		URL url = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();                
	    con.setRequestMethod("POST");
	    con.setRequestProperty("Accept-Encoding", "gzip,deflate");
	    con.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	    con.setRequestProperty("SOAPAction", "");
	    con.setRequestProperty("Host", "localhost:8080");
	    con.setRequestProperty("Connection", "Keep-Alive");
	    con.setRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.8)");
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
	    		+ "xmlns:web=\"http://webservice.healthbody.softserveinc.edu/\">")
	    	.append("<soapenv:Header/>")
	    	.append("<soapenv:Body>")
	    	.append("<web:getAllCompetitions>")
	    	.append("<arg0>").append(partNumber).append("</arg0>")
	    	.append("<arg1>").append(partSize).append("</arg1>")
	    	.append("</web:getAllCompetitions>")
	    	.append("</soapenv:Body>")
	    	.append("</soapenv:Envelope>");
	    con.setRequestProperty("Content-Length", "" + sb.length());
	    
	    

        // Get target URL
// 	        String strURL = args[0];
// 	        // Get file to be posted
// 	        String strXMLFilename = args[1];
// 	        File input = new File(strXMLFilename);
// 	        // Prepare HTTP post
//	    
// 	        PostMethod post = new PostMethod(strURL);
// 	        // Request content will be retrieved directly
// 	        // from the input stream
// 	        RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
// 	        post.setRequestEntity(entity);
// 	        // Get HTTP client
// 	        HttpClient httpclient = new HttpClient();
// 	        // Execute request
// 	        try {
// 	            int result = httpclient.executeMethod(post);
// 	            // Display status code
// 	            log.info("Response status code: " + result);
// 	            // Display response
// 	            log.info("Response body: ");
// 	            log.info(post.getResponseBodyAsString());
// 	        } finally {
// 	            // Release current connection to the connection pool once you are done
// 	            post.releaseConnection();
// 	        }
		response.getWriter().append("ManualSoapRequester. Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
