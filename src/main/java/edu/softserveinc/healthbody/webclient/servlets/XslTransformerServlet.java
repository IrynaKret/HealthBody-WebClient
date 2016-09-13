package edu.softserveinc.healthbody.webclient.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Servlet implementation class PdfGiverServlet
 */
@WebServlet(urlPatterns = { "/html" })
public class XslTransformerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XslTransformerServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		transform(response.getOutputStream());
	}

	public void transform(OutputStream outStream) {
		TransformerFactory factory = TransformerFactory.newInstance();
		StreamSource xslStream = new StreamSource(getClass().getClassLoader().getResourceAsStream("Competitions.xsl"));
		Transformer transformer;
		try {
			transformer = factory.newTransformer(xslStream);
		} catch (TransformerConfigurationException e) {
			new PrintWriter(outStream).print("TransformerConfigurationException catched. " + e);
			return;
		}
		StreamSource in = new StreamSource(getClass().getClassLoader().getResourceAsStream("CompetitionsTest.xml"));
		StreamResult out = new StreamResult(outStream);
		try {
			transformer.transform(in, out);
		} catch (TransformerException e) {
			new PrintWriter(outStream).print("TransformerException catched. " + e);
		}
	}
}
