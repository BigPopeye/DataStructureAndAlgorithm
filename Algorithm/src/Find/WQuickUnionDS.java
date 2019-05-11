package Find;

public class WQuickUnionDS implements DisjointSet {

    public static void main(String[] args) {
        WQuickUnionDS wqu = new WQuickUnionDS(8);
        wqu.connect(1,2);
        wqu.connect(3,5);
        wqu.connect(5,6);
        wqu.connect(5,7);
        System.out.println(wqu.isConnected(2,3));
        System.out.println(wqu.pid[1]);
        System.out.println(wqu.pid[3]);
        wqu.connect(2,3);
        System.out.println(wqu.isConnected(2,3));
        System.out.println(wqu.pid[1]);
        System.out.println(wqu.pid[3]);

    }

    private int[] pid;

    public WQuickUnionDS(int n){
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
        if(Math.abs(pid[find(x)]) < Math.abs(pid[find(y)])){
            pid[find(y)] +=pid[find(x)];
            pid[find(x)] = find(y);
        }else{
            pid[find(x)] += pid[find(y)];
            pid[find(y)] = find(x);
        }

    }

    @Override
    public boolean isConnected(int x, int y) {

        return find(x) == find(y);
    }

    private int find(int x){
        int parent = x;
        while(pid[parent] > 0){
            parent = pid[parent];
        }
        return parent;
    }
}
