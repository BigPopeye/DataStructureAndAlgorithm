package Find;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/** improve the Weighted Quick Union algorithm with path compression*/
public class WPCQuickUnionDS implements DisjointSet{
    public static void main(String[] args) {

        DisjointSet ds = new WPCQuickUnionDS(10);
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
    public WPCQuickUnionDS(int n){
        idps = new int[n];
        for(int i = 0; i< n; i++){
            idps[i] = -1;
        }
    }

    //
    @Override
    public void connect(int x, int y) {
        // weighted connect : connect the smaller tree to the larger one
        // and change the weight of tree y
        int newparent = Math.abs(idps[find(x)]) < Math.abs(idps[find(y)])?find(y):find(x);
        int oldparent = find(x) + find(y) - newparent;

        idps[newparent] += idps[oldparent];
        idps[oldparent] = newparent;

//        for (int i = 0; i < idps.length; i++) {
//            if (find(i) == newparent && i != newparent) { // do not erase the parent value;
//                idps[i] = newparent;
//            }
//
//            //change all the parent of y to directly to y
//
//        }
    }


    @Override
    public boolean isConnected(int x, int y) {
        int newxp = find(x);
        int newyp = find(y);
        int tempx = x;
        int tempy = y;
        while(idps[tempx]>0){
            int tempp = idps[tempx];
            idps[tempx] = newxp;
            tempx = tempp;
        }
        while (idps[tempy]>0){
            int tempp = idps[tempy];
            idps[tempy] = newyp;
            tempy = tempp;
        }
        return newxp == newyp;
    }

    //returns the parent index of node
    private int find(int x){
        int p = x;
        while(idps[p] > 0 ){
            p = idps[p];
        }
        return p;
    }
}
