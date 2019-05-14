package Find;

/** implement the DisjointSet*/

public class QuickFindDS implements DisjointSet {
    public static void main(String[] args) {
        DisjointSet ds = new QuickFindDS(8);
        ds.connect(1,2);
        ds.connect(3,5);
        System.out.println(ds.isConnected(2,3));
        ds.connect(2,3);
        System.out.println(ds.isConnected(2,3));

    }


    private int[] ids;

    // Θ(N)
    public QuickFindDS(int n){
        ids = new int[n];
        for(int i = 0; i< n;i++){
            ids[i] = i;
        }
    }

    // Θ(Ν)
    @Override
    public void connect(int x, int y) {
        if(isConnected(x,y)){
            return;
        }
        for (int i = 0;i<ids.length;i++) {
            if(ids[i] == ids[y]){
                ids[i] = ids[x];
            }
        }
    }
    // Θ(1)
    @Override
    public boolean isConnected(int x, int y) {
        return ids[x] == ids[y];
    }
}
