package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sqlite.SQLiteException;

import database.ParkkihalliDao;
import database.ParkkihalliJdbcDao;
import model.Parkkihalli;

@WebServlet("/home") 
public class UusiRekkariServlet extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/rekkarilisayslomake.jsp").forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		
		// tässä kohtaa ohjelma vastaanottaa syötetyn rekisterinumero ja luo timestampin ajasta milloin se syötetään
		//ohjelma myös tarkistaa regexin avulla, että käyttäjä syöttää rekisterinumeron oikeassa muodossa
				try {
					Timestamp pysakointiAika = new Timestamp(System.currentTimeMillis());
					String rekkari = request.getParameter("registrationNumber");
					if(rekkari.matches("[A-ZÅÖÄa-zåöä]{2,3}-[0-9]{1,3}")) {
						Parkkihalli halli = new Parkkihalli(rekkari.toUpperCase(), pysakointiAika);
						ParkkihalliDao halliDAO = new ParkkihalliJdbcDao();
						List<Parkkihalli> auto = halliDAO.findOne(rekkari.toUpperCase());
						if(auto.isEmpty()) {
							
							boolean lisays = halliDAO.addParkkihalli(halli);
							if (lisays) {
								request.setAttribute("rekkari", halli.getRekkari());
								request.setAttribute("pysAika", halli.getPysAika());
								request.getRequestDispatcher("/WEB-INF/lisaysraportti.jsp").forward(request, response);
							}
							else {
								request.setAttribute("viesti", "Rekkarin lisäyksessä tapahtui virhe.");
								request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
							}
						}
						else {
							request.setAttribute("hinta", auto.get(0).getHinta());
							request.setAttribute("rekkari", auto.get(0).getRekkari());
							request.setAttribute("pysAika", auto.get(0).getPysAika());
							request.getRequestDispatcher("/WEB-INF/poistoVarmistusraportti.jsp").forward(request, response);
						}
					}
					else {
						request.setAttribute("viesti", "Syötä rekkari muodossa: 'XXX-123'");
						request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
					}
			
				} catch (NumberFormatException e) {
					request.setAttribute("viesti", "Syötetty tieto ei kelvannut.");
					request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
				}	
				catch (Exception e) {
					 request.setAttribute("viesti", "Auto annetulla rekisterinumerolla löytyy jo parkkihallista.");
					request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
				}
	}
}
