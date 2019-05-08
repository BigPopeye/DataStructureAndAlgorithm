package com.olview.dayone.lineartable.array;

import java.util.Stack;

public class ReverseWords {


    public String reverseWords(String s) {
        //create a temp substring,get every word in the string

        //put subString into stack

        // pop stack and form a new string
        if(s==null){return null;}
        int wstart = 0;
        int wend = s.length();
        Stack<String> sts = new Stack();
        String reverse = "";
        for(int i=0;i<s.length();i++){
            if(wstart == 0 &&s.charAt(i) !=' '){
                wstart = i;
            }
            if(wstart != 0 &&(s.charAt(i) ==' ' || i==s.length()-1) ){
                wend = (i==s.length()-1)?i+1:i;
                String subs =s.substring(wstart,wend);
                sts.push(subs);
                wstart = 0;
            }
        }
        while(!sts.isEmpty()){
            reverse = reverse+(reverse.length()==0?"":" ")+sts.pop();
        }
        return reverse;
    }
}
