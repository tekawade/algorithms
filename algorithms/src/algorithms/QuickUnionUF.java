/**
 * 
 */
package algorithms;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * @author tekawade
 *
 */
public class QuickUnionUF {
	
	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		for(int i = 0; i < id.length; i++)
			id[i] = i;
	}
	
	private int root(int i) {
		while(id[i] != i)
		{
//			id[i] = id[id[i]];			// Path compression
			id[i] = root(id[i]);			// My path compression
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q)
	{
		return( root(p) == root(q) );
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		id[rootP] = rootQ;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
		QuickFindUF qf = new QuickFindUF(N);
		while(!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!qf.connected(p, q))
			{
				qf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}

	}
	
}
