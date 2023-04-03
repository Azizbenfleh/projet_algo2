package aziz.decomp_projet_algo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class extraire_donnee {
    // Définition du chemin du fichier à lire
    static File file = new File ("C:\\Users\\hp\\OneDrive\\Bureau\\projet algorithmique 2\\exemple_freq.txt");

    public static char[][] Donnee() {
        try {
            // Création d'un BufferedReader pour lire le contenu du fichier en UTF-8
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            // Initialisation d'un tableau 2D pour stocker les données lues
            char[][] tableau = new char[8][2];
            // Lecture de la première ligne du fichier
            String line = reader.readLine();
            int row = 0;

            // Tant que le fichier contient des lignes à lire
            while (line != null) {
                // Conversion de la ligne en tableau de caractères
                char[] k = line.toCharArray();

                // Si la ligne ne contient qu'un seul caractère, ajouter une entrée dans le tableau avec '*' pour la fréquence
                if (line.length() == 1) {
                    tableau[0][1] = k[0];
                    tableau[0][0] = '*';
                    System.out.println(tableau[0][0] + " " + tableau[0][1]);
                } else { // Sinon, ajouter une entrée dans le tableau avec le caractère et sa fréquence
                    tableau[row][0] = k[0];
                    tableau[row][1] = k[2];
                    row++;
                }

                // Lire la prochaine ligne du fichier
                line = reader.readLine();
            }

            // Fermer le BufferedReader
            reader.close();

            // Afficher le contenu du tableau
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(tableau[i][j] + " ");
                }
                System.out.println();
            }

            // Retourner le tableau
            return (tableau);
        } catch (IOException e) {
            // En cas d'erreur lors de la lecture du fichier, afficher l'erreur
            e.printStackTrace();
        }

        // Si une erreur est survenue, retourner null
        return (null);
    }
}




