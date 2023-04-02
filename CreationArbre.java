package aziz.decomp_projet_algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreationArbre {
	char[][] freq_list= extraire_donnee.Donnee();
	public static HuffmanNode CreerArbre(char[][] freq_list  ) {
		 List<HuffmanNode> nodes = new ArrayList<>();
		    for (int i = 0; i < freq_list.length; i++) {
		        char character = (char) freq_list[i][0];
		        int frequency = freq_list[i][1];
		        nodes.add(new HuffmanNode(frequency, character));
		    }
		 while (nodes.size() > 1) {
	        HuffmanNode node1 = Collections.min(nodes);
	        nodes.remove(node1);
	        HuffmanNode node2 = Collections.min(nodes, Comparator.comparing(node -> node.getfreq()));
	        nodes.remove(node2);
	        HuffmanNode newNode = new HuffmanNode(node1.getfreq() + node2.getfreq(),node1.getCh());
	        newNode.setLeft(node1);
	        newNode.setRight(node2) ;
	        nodes.add(newNode);
	    }
	    return nodes.get(0);	
	}

}
