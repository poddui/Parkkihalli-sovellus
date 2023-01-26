package model;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Parkkihalli {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm - dd/MM/YYYY");
	LocalTime kelloNyt = LocalTime.now();
	
	private String rekkari;
	private Timestamp pysakointiAika;
	private String nykyHetki = kelloNyt.format(dtf);
	private String hinta;
	private String pysAika;
	
	public String getRekkari() {
		return rekkari;
	}
	public String getPysAika() {
		pysAika = pysakointiAika.toLocalDateTime().format(dtf2);
		return pysAika;
	}
	public String getNykyHetki() {
		return nykyHetki;
	}
	
	
	//tämä laskee pysäköinti hinnan automaattisesti perustuen aikaan mikä on kulutettu pysäköitynä
	public String getHinta() {
		DecimalFormat haye = new DecimalFormat("#.00");
		long minuutit = (System.currentTimeMillis() - pysakointiAika.getTime()) / 60000;
		Double temphinta = minuutit * 0.05;
		hinta = haye.format(temphinta);
		return hinta;
	}
	public Parkkihalli(String rekkari,Timestamp pys_aika) {
		super();
		this.rekkari = rekkari;
		this.pysakointiAika = pys_aika;
		
	}
	

}
