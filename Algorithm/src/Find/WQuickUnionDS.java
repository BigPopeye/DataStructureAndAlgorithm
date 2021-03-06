package Find;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

public class WQuickUnionDS implements DisjointSet {

    public static void main(String[] args) {
        DisjointSet ds = new WQuickUnionDS(10);
        int count = Integer.parseInt(args[0]);
        ds.connect(1,2);
        ds.connect(3,5);

        ds.connect(6,7);
        ds.connect(7,8);
        ds.connect(5,6);
//        ds.isConnected(2,3);
//        ds.connect(2,3);
//        ds.isConnected(2,3);
//        System.out.println(ds.isConnected(2,3));
//        System.out.println(ds.idps[1]);
//        System.out.println(ds.idps[3]);

//        System.out.println(ds.isConnected(2,3));
//        System.out.println(ds.isConnected(2,3));
//        System.out.println(ds.idps[1]);
//        System.out.println(ds.idps[3]);
        long start = System.currentTimeMillis();
        while (count >0){
            ds.isConnected(2,3);
            ds.connect(2,3);
            ds.isConnected(2,3);
            count --;
        }

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    private int[] idps;

    // Θ(Ν)
    public WQuickUnionDS(int n){
        idps = new int[n];
        for(int i = 0;i < n; i++){
            idps[i] = -1;
        }
    }

    // O(logN)
    @Override
    public void connect(int x, int y) {
        if(isConnected(x,y)){
            return;
        }
        if(Math.abs(idps[find(x)]) < Math.abs(idps[find(y)])){
            idps[find(y)] +=idps[find(x)];
            idps[find(x)] = find(y);
        }else{
            idps[find(x)] += idps[find(y)];
            idps[find(y)] = find(x);
        }

    }

    // Ο(logN)
    @Override
    public boolean isConnected(int x, int y) {

        return find(x) == find(y);
    }

    //
    private int find(int x){
        int parent = x;
        while(idps[parent] > 0){
            parent = idps[parent];
        }
        return parent;
    }
}
