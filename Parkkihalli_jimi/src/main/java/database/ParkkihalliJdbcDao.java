package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Parkkihalli;


public class ParkkihalliJdbcDao implements ParkkihalliDao {

	public List<Parkkihalli> findAll() {	
		Connection connection = null;  
		PreparedStatement statement = null; 
		ResultSet resultset = null;   
		List<Parkkihalli> rekkarit = new ArrayList<Parkkihalli>(); 
		Parkkihalli parkkihalli = null; 
		try {
			connection = Database.getDBConnection();
			String sqlSelect = 
					"SELECT * FROM parkkihalli;";
			statement = connection.prepareStatement(sqlSelect);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				parkkihalli = createParkkihalliObjectFromRow(resultset);
				rekkarit.add(parkkihalli);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(resultset, statement, connection); 
		}
	
		return rekkarit;
	}
	
	
	private Parkkihalli createParkkihalliObjectFromRow(ResultSet resultset) {	
		try {
			String rekkari = resultset.getString("rekkari");
			Timestamp pys_aika = resultset.getTimestamp("pysakointi_aika");

			return new Parkkihalli(rekkari, pys_aika);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
			
	public boolean addParkkihalli(Parkkihalli halli)  {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		boolean updateSuccessed = false; 

		try {
			connection = Database.getDBConnection();
			String sqlInsert = 
					"INSERT INTO Parkkihalli (rekkari) VALUES (?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, halli.getRekkari());
			int rowAffected = stmtInsert.executeUpdate();
			if (rowAffected == 1) updateSuccessed = true;
			
		} catch (SQLException e) {
			e.printStackTrace(); 
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtInsert, connection); 
		}
		return updateSuccessed;
	}
	
	public boolean removeParkkihalli(String rekkari) {
		Connection connection = null;
		PreparedStatement stmtDelete = null;
		boolean updateSuccessed = false;

		try {
			connection = Database.getDBConnection();
			String sql = "DELETE FROM parkkihalli WHERE rekkari = ?";
			stmtDelete = connection.prepareStatement(sql);
			stmtDelete.setString(1, rekkari);
			int rowAffected = stmtDelete.executeUpdate();
			if (rowAffected == 1) updateSuccessed = true;
			
		} catch (SQLException e) {
			e.printStackTrace(); 
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtDelete, connection); 
		}
		return updateSuccessed;
	}
	
	//tämä metodi etsii yhden rekkarin tietokannasta sillä sitä tarvitaan poistaessa tietoa.
	
	public List<Parkkihalli> findOne(String rekkari) {	
		Connection connection = null;  
		PreparedStatement statement = null; 
		ResultSet resultset = null;   
		List<Parkkihalli> rekkarit = new ArrayList<Parkkihalli>(); 
		Parkkihalli parkkihalli = null; 
		try {
			connection = Database.getDBConnection();
			String sqlSelect = 
					"SELECT * FROM parkkihalli WHERE rekkari = ?";
			statement = connection.prepareStatement(sqlSelect);
			statement.setString(1, rekkari);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				parkkihalli = createParkkihalliObjectFromRow(resultset);
				rekkarit.add(parkkihalli);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(resultset, statement, connection); 
		}
	
		return rekkarit;
	}
	
}

