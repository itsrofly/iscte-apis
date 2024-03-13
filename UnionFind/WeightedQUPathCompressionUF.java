package UnionFind;

public class WeightedQUPathCompressionUF {
    private int[] id;

    public WeightedQUPathCompressionUF(int N) {
        if(N < 0)
            throw new IllegalArgumentException("Must be positive:" + N);
            
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int root(int p) {
        if (p >= id.length)
            throw new IllegalArgumentException("Out of bounds");

        if (id[p] == p)
            return p;
        int r = root(id[p]);
        id[p] = r;
        return r;
    }

    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }

    public void union(int p, int q) {
        int pr = root(p);
        int qr = root(q);
        if (rootSize(pr) < rootSize(qr))
            id[pr] = qr;
        else
            id[qr] = pr;
    }

    private int rootSize(int r) { // I could use an extra array sizeroot[i] instead but oky...
        int size = 0;
        for (int i = 0; i < id.length; i++) {
            if (root(i) == r)
                size++;
        }
        return size;
    }

}
