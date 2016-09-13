package edu.softserveinc.healthbody.webclient.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.CompetitionDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.utils.RequestParamUtils;

/**
 * Servlet implementation class CompetitionsViewServlet
 */
@WebServlet("/competition")
public class CompetitionsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Gson gson;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompetitionsViewServlet() {
		super();
		this.gson = new Gson();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int partNumber = getPartNumber(request);
		int partSize = getPartSize(request);
		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		List<CompetitionDTO> competitions = healthBody.getHealthBodyServiceImplPort().
		getAllCompetitions(partNumber, partSize);
		writeResponse(competitions, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void writeResponse(Object object, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(object));
		out.flush();

	}

	private int getPartNumber(HttpServletRequest request) {
		String partNumberString = request.getParameter("partNumber");
		if (RequestParamUtils.isEmptyParam(partNumberString)) {
			return 1;
		}
		return RequestParamUtils.getIntegerParam(partNumberString);
	}

	private int getPartSize(HttpServletRequest request) {
		String partSizeString = request.getParameter("partSize");
		if (RequestParamUtils.isEmptyParam(partSizeString)) {
			return 5;
		}
		return RequestParamUtils.getIntegerParam(partSizeString);
	}

}
