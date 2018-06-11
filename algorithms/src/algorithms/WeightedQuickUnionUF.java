/**
 * 
 */
package algorithms;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * @author rtekawade
 *
 */
public class WeightedQuickUnionUF {
	
	private int[] id;
	private int[] size;
	private int count;
	
	public WeightedQuickUnionUF(int n) {
		count = n;
		id = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public int count() {
		return count;
	}

	private int root(int i ) {
		while(id[i] != i) {
//			id[i] = id[id[i]];
			id[i] = root(id[i]);
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if( rootP == rootQ) return;
		if( size[rootP] > size[rootQ]) { id[rootQ] = rootP; size[rootP] += size[rootQ]; }
		else { id[rootP] = rootQ; size[rootQ] += size[rootP]; }
		count--;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = StdIn.readInt();
		WeightedQuickUnionUF wqUF = new WeightedQuickUnionUF(n);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!wqUF.connected(p, q)) {
				wqUF.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
		StdOut.println(wqUF.count + "components");
		
	}

}
