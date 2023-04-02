package aziz.decomp_projet_algo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class LectureBIN {
    
        
      
	public static void decompressFile(File file, File myFile, HuffmanNode root) throws IOException {
	    FileInputStream inputFile = new FileInputStream(myFile);
	    FileOutputStream outputFile = new FileOutputStream(file);

	    BitInputStream inputBitStream = new BitInputStream(inputFile);
	    BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(outputFile, "UTF-8"));

	    HuffmanNode racine = root;

	    int bit;
	    while ((bit = inputBitStream.readBit()) != -1) {
	        if (bit == 0) {
	            racine = racine.getLeft();
	        } else {
	            racine = racine.getRight();
	        }

	        if (racine.isLeaf()) {
	            outputWriter.write(racine.getCh());
	            racine = root;
	        }
	    }

	    inputBitStream.close();
	    outputWriter.close();
	}

    		


}




