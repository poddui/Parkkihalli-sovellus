package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.ParkkihalliDao;
import database.ParkkihalliJdbcDao;

class rekkariTestit {
	
	private Parkkihalli halli;
	
	@BeforeEach
	 public void setUp() throws Exception {
	 halli = new Parkkihalli("ZKG-175", null);
	 }

	@Test
	public void palauttaakoGetRekkariOikeanRekkarin() {
		assertEquals("ZKG-175", halli.getRekkari());
	}
	
	@Test
	public void loytyykoTietokannasta14KplTietoriveja() {
		ParkkihalliDao tiitii = new ParkkihalliJdbcDao();
		assertEquals(14, tiitii.findAll().size());
	}
	@Test
	public void toimiikoNykyinenAika() {
		assertEquals("16:35", halli.getNykyHetki());
	}
	

}
