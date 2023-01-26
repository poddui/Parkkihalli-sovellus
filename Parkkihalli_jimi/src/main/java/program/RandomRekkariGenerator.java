package program;

public class RandomRekkariGenerator {

	public static void main(String[] args) {
		
		//tämä ohjelma ei liity tehtävänantoon mutta käytin sitä testauksessa
		//sain tehtyä nopeasti monta eri rekisterinumeroa ja lisättyä ne tietokantaa.
		
		char[] kirjaimet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		for(int i = 0; i < 28; i++) {
			double i1 = Math.random() * 25;	
			double i2 = Math.random() * 25;	
			double i3 = Math.random() * 25;	
			double numerot = Math.random() * 998 + 1;
			String rekkari = "('" + kirjaimet[(int)i1] + kirjaimet[(int)i2] + kirjaimet[(int)i3] + "-" + (int)numerot + "'),";
			System.out.println(rekkari);
	
		}

	}
}
