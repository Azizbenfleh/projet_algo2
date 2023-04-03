package aziz.decomp_projet_algo;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		//extraire_donnee ed = new extraire_donnee();
		
		char[][] tab= extraire_donnee.Donnee();
		HuffmanNode node =  CreationArbre.CreerArbre(tab);
		CreateFile myObject = new CreateFile();
		File myFile = myObject.Creation();
		File file = new File("C:\\Users\\hp\\OneDrive\\Bureau\\projet algorithmique 2\\exemple_comp.bin");
        LectureBIN.decompressFile(myFile,file,node);
        File filetxt = new File("C:\\Users\\hp\\OneDrive\\Bureau\\projet algorithmique 2\\exemple_decomp.txt");
        long fileSize = filetxt.length();
        long fileSize1 = file.length();
        Calcul cal= new Calcul();
        cal.determiner_taux_de_compression(fileSize,fileSize1);
       
        
	}
	
}


