package Find;

public class QuickUnionDS implements DisjointSet {
    public static void main(String[] args) {
        QuickUnionDS qu = new QuickUnionDS(8);
        qu.connect(1,2);
        qu.connect(3,5);
        System.out.println(qu.isConnected(2,3));
        qu.connect(2,3);
        System.out.println(qu.isConnected(2,3));

    }

    // store the parent of the item
    private int[] pid;

    public QuickUnionDS(int n){
        pid = new int[n];
        for(int i = 0;i < n; i++){
            pid[i] = -1;
        }
    }


    @Override
    public void connect(int x, int y) {
        if(isConnected(x,y)){
            return;
        }
        pid[find(y)] = find(x);
    }

    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // returns the parent of the item
    private int find(int x){
        int parent = x;
        while(pid[parent] > 0){
            parent = pid[parent];
        }
        return parent;
    }
}
