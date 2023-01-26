package database;

import java.util.List;

import model.Parkkihalli;

public interface ParkkihalliDao{

	public List<Parkkihalli> findAll();
	
	public boolean addParkkihalli(Parkkihalli halli);
	
	public boolean removeParkkihalli(String rekkari);
	
	public List<Parkkihalli> findOne(String rekkari); 
}

