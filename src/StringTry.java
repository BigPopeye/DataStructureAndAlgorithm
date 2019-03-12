public class StringTry {
    public static void main(String[] args) {
        String str1 = "AbA";
        String str2 = "abDdbA";
        String str3 = "abcdefg";
        boolean result = new StringTry().isPalindrome(str1);
        System.out.println(result);
    }

    public boolean isPalindrome(String str){
        for(int i=0;i < str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
