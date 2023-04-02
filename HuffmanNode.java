package aziz.decomp_projet_algo;

public    class HuffmanNode implements Comparable<HuffmanNode> {
	private int freq;
	private char ch;
	private HuffmanNode left;
	private HuffmanNode right;
	
	
	public HuffmanNode ( int freq, char ch ) {
		this.freq=freq;
		this.setCh(ch);
		this.left= null;
		this.right=null;
		
	}
	
	public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }
    
    public boolean hasLeftChild() {
        return (this.left != null);
    }
    
    public boolean hasRightChild() {
        return (this.right != null);
    }
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	} 
	public int getfreq() {
		return freq;
	}
	public HuffmanNode getLeft() {
		return left;
	}
	public HuffmanNode getRight() {
		return right;
	}
	public void setRight(HuffmanNode right) {
        this.right = right;
    }
	public void setLeft(HuffmanNode left) {
        this.left = left;
    }
	@Override
	public int compareTo(HuffmanNode other) {
		return Integer.compare(this.freq, other.freq);
	}
	
	
	
	
	
}
