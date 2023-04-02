package aziz.decomp_projet_algo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public  class extraire_donnee {
	static File file = new File ("C:\\Users\\hp\\OneDrive\\Bureau\\projet algorithmique 2\\exemple_freq.txt");


	public static char[][] Donnee() {
	
		try {

			BufferedReader reader = new BufferedReader (new InputStreamReader (new FileInputStream(file), "UTF-8"));
			//String[] line = reader.readLine();
			
            
			char [][] tableau = new char[8][2] ;
			String line= reader.readLine();
			int row = 0;
			
			
			
			while (line != null) {
				char[] k = line.toCharArray();	
				if (line.length()==1){
					   
			           tableau[0][1]=k[0];
				       tableau[0][0]= '*';
				       System.out.println(tableau[0][0] + " " + tableau[0][1]);
				}
				else {	
			       
					tableau[row][0]= k[0];
				    tableau[row][1] =  k[2]; 
				    row ++;
			    }
				
				
			   line= reader.readLine();
			}
			reader.close();
			
			for(int i=0; i<8; i++) {
			    for(int j=0; j<2; j++) {
			        System.out.print(tableau[i][j] + " ");
			    }
			    System.out.println(); 
			}
			return(tableau);
		}
	  catch(IOException e) {
			e.printStackTrace();
		} 
	
		return(null);
		
	}
	
}




