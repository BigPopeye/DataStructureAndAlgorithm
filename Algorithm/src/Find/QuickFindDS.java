package Find;

/** implement the DisjointSet*/

public class QuickFindDS implements DisjointSet {
    public static void main(String[] args) {
        QuickFindDS qf = new QuickFindDS(8);
        qf.connect(1,2);
        qf.connect(3,5);
        System.out.println(qf.isConnected(2,3));
        qf.connect(2,3);
        System.out.println(qf.isConnected(2,3));

    }


    private int[] ids;

    public QuickFindDS(int n){
        ids = new int[n];
        for(int i = 0; i< n;i++){
            ids[i] = i;
        }
    }


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

    @Override
    public boolean isConnected(int x, int y) {
        return ids[x] == ids[y];
    }
}
