package aziz.decomp_projet_algo;

public    class HuffmanNode implements Comparable<HuffmanNode> {
	private int freq;
	private char ch;
	private HuffmanNode left;
	private HuffmanNode right;
	
	
	// Constructeur de la classe HuffmanNode
	public HuffmanNode ( int freq, char ch ) {
	    this.freq=freq;
	    this.setCh(ch);
	    this.left= null;
	    this.right=null;
	}

	// Vérifie si le noeud est une feuille de l'arbre
	public boolean isLeaf() {
	    return (this.left == null && this.right == null);
	}

	// Vérifie si le noeud a un fils gauche
	public boolean hasLeftChild() {
	    return (this.left != null);
	}

	// Vérifie si le noeud a un fils droit
	public boolean hasRightChild() {
	    return (this.right != null);
	}

	// Accesseur pour le caractere
	public char getCh() {
	    return ch;
	}

	// Modificateur pour le caractere
	public void setCh(char ch) {
	    this.ch = ch;
	}

	// Accesseur pour la frequence
	public int getfreq() {
	    return freq;
	}

	// Accesseur pour le champ left
	public HuffmanNode getLeft() {
	    return left;
	}

	// Accesseur pour le champ right
	public HuffmanNode getRight() {
	    return right;
	}

	// Modificateur pour le champ right
	public void setRight(HuffmanNode right) {
	    this.right = right;
	}

	// Modificateur pour le champ left
	public void setLeft(HuffmanNode left) {
	    this.left = left;
	}

	// Compare la fréquence de ce noeud à celle d'un autre noeud pour les trier
	@Override
	public int compareTo(HuffmanNode other) {
	    return Integer.compare(this.freq, other.freq);
	}
}