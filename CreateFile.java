package aziz.decomp_projet_algo;

import java.io.*;
public class CreateFile {
	// Définition de la méthode Creation qui retourne un objet File
	public File Creation() {
	    try {
	    	// Création d'un objet File correspondant au chemin du fichier à créer
	        File file = new File("C:\\Users\\hp\\OneDrive\\Bureau\\projet algorithmique 2\\exemple_decomp.txt");
	        
	        // Vérification si le fichier n'existe pas encore et le créer le cas échéant
	        if (file.createNewFile()) {
	            System.out.println("File created: " + file.getName());
	        } else {
	            System.out.println("File already exists.");
	        }
	        
	        // Retourne l'objet File créé ou existant
	        return(file);
	    } 
	    // Gestion de l'exception d'entrée/sortie et affichage de la trace d'erreur
	    catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		// Retourne null en cas d'erreur
		return null;
	}

	}

