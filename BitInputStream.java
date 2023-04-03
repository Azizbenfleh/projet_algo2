package aziz.decomp_projet_algo;

import java.io.*;

//Définition de la classe BitInputStream qui hérite de la classe FilterInputStream
public class BitInputStream extends FilterInputStream {
	// Déclaration des variables bitBuffer et bitBufferSize
	private int bitBuffer;
	private int bitBufferSize;

	// Constructeur de la classe BitInputStream prenant en entrée un InputStream
	public BitInputStream(InputStream in) {
	    // Appel du constructeur de la classe parent FilterInputStream
	    super(in);
	    // Initialisation de bitBuffer à 0 et de bitBufferSize à 0
	    bitBuffer = 0;
	    bitBufferSize = 0;
	}

	// Méthode read qui lit un octet entier (8 bits) depuis le flux d'entrée
	public int read() throws IOException {
	    // Si bitBufferSize est égal à 0, on peut appeler la méthode read() de la classe parent pour lire un octet entier
	    if (bitBufferSize == 0) {
	        return super.read();
	    } else {
	        // Sinon, on lève une exception indiquant qu'on ne peut pas lire un octet entier
	        throw new IllegalStateException("Cannot read a full byte.");
	    }
	}

	// Méthode readBit qui lit un seul bit depuis le flux d'entrée
	public int readBit() throws IOException {
	    // Si bitBufferSize est égal à 0, on lit un octet entier depuis le flux d'entrée
	    if (bitBufferSize == 0) {
	        bitBuffer = super.read();
	        // Si l'octet lu est égal à -1, cela signifie qu'on a atteint la fin du flux d'entrée, on renvoie donc -1
	        if (bitBuffer == -1) {
	            return -1;
	        }
	        // On met bitBufferSize à 8 pour indiquer qu'il y a maintenant 8 bits dans bitBuffer
	        bitBufferSize = 8;
	    }
	    // On récupère le bit le plus à gauche dans bitBuffer
	    int bit = bitBuffer >> (bitBufferSize - 1);
	    // On décrémente bitBufferSize pour indiquer qu'on a lu un bit
	    bitBufferSize--;
	    // On renvoie le bit récupéré
	    return bit;
	}

	// Méthode readBits qui lit un nombre spécifié de bits depuis le flux d'entrée
	public int readBits(int numBits) throws IOException {
	    // Initialisation de la variable bits à 0
	    int bits = 0;
	    // Boucle pour lire chaque bit un par un
	    for (int i = 0; i < numBits; i++) {
	        // On appelle la méthode readBit pour lire un bit
	        int bit = readBit();
	        // Si le bit lu est égal à -1, cela signifie qu'on a atteint la fin du flux d'entrée, on renvoie donc -1
	        if (bit == -1) {
	            return -1;
	        }
	        // On décale bits d'une position vers la gauche et on y ajoute le bit lu à droite
	        bits = (bits << 1) | bit;
	    }
	    // On renvoie les bits lus
	    return bits;
	}
}
    


