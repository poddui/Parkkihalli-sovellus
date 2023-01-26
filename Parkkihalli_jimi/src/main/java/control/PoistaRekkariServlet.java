package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ParkkihalliDao;
import database.ParkkihalliJdbcDao;
import model.Parkkihalli;

@WebServlet("/poista-rekkari") 
public class PoistaRekkariServlet extends HttpServlet{

	// tämä servlet huolehtii asioiden poistosta
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
				try {
					String rekkari = request.getParameter("rekkari");
					ParkkihalliDao halliDao = new ParkkihalliJdbcDao();
					boolean poisto = halliDao.removeParkkihalli(rekkari);
					
					//tässä ohjelma katsoo onnistuuko poisto vai ei
					
					if (poisto) {
						request.setAttribute("rekkari", rekkari);
						request.getRequestDispatcher("/WEB-INF/ulosajaraportti.jsp").forward(request, response);
					} else {
						request.setAttribute("viesti", "Rekisterinumeron poistossa tapahtui virhe");
						request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
					}
					
				} catch (NumberFormatException e) {
					e.printStackTrace();	
					request.setAttribute("viesti", "Sovelluksessa tapahtui virhe,");
					request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
				}
	}
}
