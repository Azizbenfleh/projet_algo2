package aziz.decomp_projet_algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreationArbre {
    // On récupère la liste des fréquences depuis la méthode Donnee() de la classe extraire_donnee
    char[][] freq_list = extraire_donnee.Donnee();

    public static HuffmanNode CreerArbre(char[][] freq_list) {
        // On crée une liste de nœuds HuffmanNode à partir de la liste de fréquences
        List<HuffmanNode> nodes = new ArrayList<>();
        for (int i = 0; i < freq_list.length; i++) {
            char character = (char) freq_list[i][0];
            int frequency = freq_list[i][1];
            nodes.add(new HuffmanNode(frequency, character));
        }

        // On itère sur la liste des nœuds HuffmanNode jusqu'à ce qu'il n'en reste qu'un
        while (nodes.size() > 1) {
            // On récupère les deux nœuds avec les fréquences les plus basses
            HuffmanNode node1 = Collections.min(nodes);
            nodes.remove(node1);
            HuffmanNode node2 = Collections.min(nodes, Comparator.comparing(node -> node.getfreq()));
            nodes.remove(node2);

            // On crée un nouveau nœud avec une fréquence égale à la somme des fréquences des deux nœuds précédents
            // et comme caractère le caractère du premier nœud
            HuffmanNode newNode = new HuffmanNode(node1.getfreq() + node2.getfreq(), node1.getCh());

            // On ajoute les deux nœuds précédents comme fils du nouveau nœud
            newNode.setLeft(node1);
            newNode.setRight(node2);

            // On ajoute le nouveau nœud à la liste des nœuds HuffmanNode
            nodes.add(newNode);
        }

        // On retourne le dernier nœud restant dans la liste des nœuds HuffmanNode
        return nodes.get(0);
    }
}

