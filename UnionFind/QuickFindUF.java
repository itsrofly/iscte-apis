public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        if(N < 0)
            throw new IllegalArgumentException("Must be positive:" + N);

        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        if (p >= id.length || q >= id.length )
            throw new IllegalArgumentException("Out of bounds");

        return id[p] == id[q];
    }

    public void union(int p, int q) {
        if (p >= id.length || q >= id.length )
            throw new IllegalArgumentException("Out of bounds");
            
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p])
                id[i] = id[q];
        }
    }
}
