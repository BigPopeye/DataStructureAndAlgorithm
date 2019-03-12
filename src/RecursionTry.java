public class RecursionTry {
    public static void main(String[] args) {
        int testRecursion =Integer.valueOf(10);
        int sum = new RecursionTry().sumByWhileLoop(testRecursion);
        System.out.println(sum);
    }

    public int sumByRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return sumByRecursion(n - 1) + n;
        }
    }

    public int sumByForLoop(int n){
        int sum = 0;
        for(int i = 1;i<=n;i++){
            sum +=i;
        }
        return sum;
    }
    public int sumByForLoopSpecial(int n){
        int sum = 0;
        int i = 1;
        for(;i<=n;){
            sum +=i;
            i++;
        }
        return sum;
    }

    public int sumByForLoopSpecial2(int n){
        int sum = 0;
        int i = 1;
        for(;;){
            sum +=i;
            i++;
            if(i>n){
                break;
            }
        }
        return sum;
    }

    public int sumByWhileLoop(int n){
        int sum = 0;
        int i = 1;
        while(i<=n){
            sum +=i;
            i++;
        }
        return sum;
    }
}
