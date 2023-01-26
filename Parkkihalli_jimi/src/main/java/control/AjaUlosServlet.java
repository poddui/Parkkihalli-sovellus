package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ParkkihalliDao;
import database.ParkkihalliJdbcDao;
import model.Parkkihalli;


@WebServlet("/poista") 
public class AjaUlosServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				request.getRequestDispatcher("/WEB-INF/poistoVarmistusraportti.jsp").forward(request, response);
				}
		
}
