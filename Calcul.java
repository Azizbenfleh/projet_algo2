package aziz.decomp_projet_algo;

public class Calcul {
	public double determiner_taux_de_compression(double volume_texte_initial, double volume_text_cmp) {
	    double taux_de_compression = 1 - volume_text_cmp / volume_texte_initial;
	    return taux_de_compression;
	    
	}
	public double determiner_nbr_moy_de_bits(String text, String text_compresse) {
	    int total_bits = text_compresse.length() * 8;
	    int total_chars = text.length();
	    double nbr_moy_bits = (double) total_bits / total_chars;
	    return nbr_moy_bits;
	}
	
	

}
