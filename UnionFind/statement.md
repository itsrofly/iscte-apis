
Implement the following API.

### public class QuickFindUF
* public QuickFindUF(int N) // constructor (N is the number of points)
* public boolean connected(int p, int q)  //  are p and q connected?
* public void union(int p, int q)     //  connect p and q

### public class QuickUnionUF
* public QuickUnionUF(int N)    //              constructor (N is the number of points)
* public int root(int p)               //       root of p
* public boolean connected(int p, int q) //     are p and q connected?
* public void union(int p, int q)       //   connect p and q

### public class WeightedQUPathCompressionUF
* public WeightedQUPathCompressionUF(int N)  // constructor (N is the number of points)
* public int root(int p)          //        root of p with PathCompression
* public boolean connected(int p, int q)   //   are p and q connected?
* public void union(int p, int q)     //   connect p and q with WeightedQU
