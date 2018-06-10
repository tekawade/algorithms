/**
 * 
 */
package algorithms;

/**
 * @author tekawade
 *
 */
public class QuickFindUF {
	
	private int[] id;
	
	public QuickFindUF(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public boolean connected (int p, int q)
	{
		return( id[p] == id[q]);
	}
	
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++)
		{
			if( id[i] == pid )
				id[i] = qid;
		}
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
