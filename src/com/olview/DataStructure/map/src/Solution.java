import java.util.Arrays;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] points =new int[][]{{0,0},{2,0},{0,2}};

        System.out.println(sl.isBoomerang(points));
    }
    public boolean isBoomerang(int[][] points) {
        double[] side = new double[]{distans(points[0],points[1]),distans(points[0],points[2]),distans(points[2],points[1])};
        Arrays.sort(side);
        if(side[0]+side[1] == side[2]){
            return false;
        }else{
            return true;
        }

    }

    public double distans(int[] p1,int[] p2){
        return Math.sqrt(Math.pow(p1[0] - p2[0],2) + Math.pow(p1[1]-p2[1],2));
    }
}