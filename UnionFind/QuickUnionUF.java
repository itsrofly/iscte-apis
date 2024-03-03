public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
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
        return root(id[p]);
    }

    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }

    public void union(int p, int q) {
        id[root(p)] = root(q);
    }
}
