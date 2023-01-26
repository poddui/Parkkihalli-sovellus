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


@WebServlet("/admin") 
public class ListaaParkkihalliServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParkkihalliDao halliDAO = new ParkkihalliJdbcDao();
		List<Parkkihalli> hallit = halliDAO.findAll();
	
		request.setAttribute("hallit", hallit); 
		
		request.getRequestDispatcher("/WEB-INF/hallilista.jsp").forward(request, response);

	}
}
