package aziz.decomp_projet_algo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LectureBIN {
    
    // Méthode de décompression de fichier compressé avec Huffman
    public static void decompressFile(File file, File myFile, HuffmanNode root) throws IOException {
        
        // Création d'un flux d'entrée pour lire le fichier compressé
        FileInputStream inputFile = new FileInputStream(myFile);
        // Création d'un flux de sortie pour écrire les données décompressées
        FileOutputStream outputFile = new FileOutputStream(file);

        // Création d'un objet BitInputStream pour lire les bits du fichier compressé
        BitInputStream inputBitStream = new BitInputStream(inputFile);
        // Création d'un BufferedWriter pour écrire les caractères décompressés dans le fichier de sortie
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(outputFile, "UTF-8"));

        // Initialisation de la racine de l'arbre Huffman avec le nœud racine passé en argument
        HuffmanNode racine = root;

        // Lecture des bits du fichier compressé jusqu'à la fin du fichier
        int bit;
        while ((bit = inputBitStream.readBit()) != -1) {
            // Si le bit est 0, descendre dans le sous-arbre gauche de la racine
            if (bit == 0) {
                racine = racine.getLeft();
            } else { // Sinon, descendre dans le sous-arbre droit de la racine
                racine = racine.getRight();
            }

            // Si on atteint une feuille de l'arbre, écrire le caractère correspondant dans le fichier de sortie
            if (racine.isLeaf()) {
                outputWriter.write(racine.getCh());
                // Revenir à la racine de l'arbre pour continuer la décompression
                racine = root;
            }
        }

        // Fermeture des flux de lecture et d'écriture
        inputBitStream.close();
        outputWriter.close();
    }
}




