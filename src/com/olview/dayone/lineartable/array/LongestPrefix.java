package com.olview.dayone.lineartable.array;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","","fly"};
        LongestPrefix l = new LongestPrefix();
        String str = l.longestCommonPrefix(strs);
        System.out.print("result : "+str);

    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){return "";}
        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++){
            while (prefix.length()>0){
                if (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
                else {break;}
            }

        }
        return prefix;
    }

}
