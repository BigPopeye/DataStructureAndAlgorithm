package com.olview.dayone.lineartable.array;

import java.util.*;

public class ArrayTry {
    public static void main(String[] args) {
        /*int[] testFindMaxNum = new int[]{1,5,3,9,5};
        int maxNum = new ArrayTry().findMaxNum(testFindMaxNum);
        System.out.println(maxNum);*/

        /*String*/
        String s = "hello"+"!";
        StringBuilder sb = new StringBuilder();

        String ss = s.substring(0,3);
        s = s +ss;
        System.out.println("Substring: "+ss);
        System.out.println("String: "+s);
        Stack<String> sts = new Stack<>();
        sts.push(ss);
        sts.push(s);
        String s1 = sts.pop();
        System.out.println(s1+sts.pop());
//        System.out.println("Char at Index: "+s.charAt(2));
//
//        System.out.println("Index of char: "+s.indexOf('l'));
//        System.out.println("Index of String: "+s.indexOf("x"));
//        System.out.println("Index of char at index: "+s.indexOf('l',3));
//        System.out.println("Last index of char: "+s.lastIndexOf('l'));
//        System.out.println("Substing at index: "+s.substring(3));
//        System.out.println("To charArray: "+s.toCharArray().length);
//
//        System.out.println("CodePointAt: "+s.codePointAt(4));
//        System.out.println("chars: "+s.chars().min());/*TBD*/
//        System.out.println("GetBytes: "+s.getBytes());/*TBD*/
//
//        /*StringBuilder*/
//        StringBuilder sb = new StringBuilder();
//        sb.insert(0,"Heihei");
//        System.out.println("insert String: "+sb);
//        sb.append("?");
//        System.out.println("insert String: "+sb);

        /*List*/
        List<Integer> la = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add("hello");
//        ls.add("world");
//        System.out.println(ls.size());
//        String st = ls.toString();
//        st = st +"2";
//        System.out.println(st);
//        la.add(2);
//        la.set(0,1);
//        ll.addFirst(3);
//        System.out.println("Arraylist: "+la);
//        System.out.println("LinkedList: "+ll);
//        System.out.println("Arraylist IndexOf: "+la.indexOf(2));
//        System.out.println("Arraylist getByIndex: "+la.get(0));
//        System.out.println("Linkedlist IndexOf: "+ll.indexOf(3));
//        System.out.println("Linkedlist getByIndex: "+ll.get(0));

        /*Array*/
        int[] a = new int[]{4,1,2,3,5};
        a[2] = 3;
//        Arrays.sort(a);
        System.out.println(a[2]);
        /*List*/
        List<Integer> list = new LinkedList<>();
        System.out.println("LinkedList size : "+list.size());

        /*Stack*/

//        int intnum = '4'-'0';
//        System.out.println(intnum);
//        char numchar = (char)(intnum + '0');
//        System.out.println(numchar);
//        String s = numchar+"!";
//        System.out.println(s);
//        int[] a = new int[]{1,2};
//        int[] b = new int[]{3,4};
//        int[] c = new int[5];
//        System.arraycopy(a,0,c,1,2);
//        System.arraycopy(b,0,c,3,2);
//        System.out.println(c[3]);
//        int[][] matrix = new int[3][5];
//        System.out.println(matrix[0].length);
//        List<Integer> x = new ArrayList<>();
//        List<List<Integer>> l = new ArrayList<>();
//        List<Integer> sl = new ArrayList<>();
//        List<Integer> sl2 = new ArrayList<>();
//        sl.add(1);
//        sl.add(2);
//        sl2.add(3);
//        l.add(sl);
//        l.add(sl2);
//        System.out.println(l.size());
//        System.out.println(sl2.size());
//        System.out.println(l.indexOf(sl));
//        l.add(2,sl);
//        System.out.println(l.size());
//        System.out.println(l.indexOf(sl));
//        System.out.println(l.get(1).get(0));
//        StringBuilder sb = new StringBuilder();
//        String s ="123";
//        char c = '3';
//
//        char[] c = s.toCharArray();
//        System.out.print(c[0]);
//        sb.append(c[0]);
//        String s = sb.toString();
//        System.out.println(s.chars());

        /*HashSet*/
        Set<Integer> hashset = new HashSet<>();
        Set<Integer> hashmap = new HashMap<>();
        Set<Integer> hashtable = new Hashtable<>();
        hashset.add(a)

    }

    public int findMaxNum(int[] array) {
        int maxNum = 0;
        for(int value: array){
            if(maxNum < value){
                maxNum = value;
            }
        }
        return maxNum;
    }

}
