package aziz.decomp_projet_algo;

import java.io.*;
public class CreateFile {
	    public  File Creation() {
	        try {
	            File file = new File("C:\\Users\\hp\\OneDrive\\Bureau\\projet algorithmique 2\\exemple_decomp.txt");
	            if (file.createNewFile()) {
	                System.out.println("File created: " + file.getName());
	            } else {
	                System.out.println("File already exists.");
	            }
	            
	            return(file);
	        } 
	        catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
			return null;
	        
	    }
	}


