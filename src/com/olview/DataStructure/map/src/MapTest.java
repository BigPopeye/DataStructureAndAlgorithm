import java.lang.reflect.Array;
import java.util.*;


public class MapTest {
    public List<List<String>> groupAnagrams(String[] strs) {
        // key = sorted char string; value = str in strs
        if(strs == null || strs.length == 0){
            List<List<String>> list = new LinkedList<>();
            return list;
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String strch = Arrays.toString(ch);
            if(map.containsKey(strch)){
                map.get(strch).add(str);
                //System.out.println(map.get(strch));
            }else{
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(strch,list);
            }
        }

        List<List<String>> outlist = new LinkedList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            outlist.add(entry.getValue());
        }
        map.values();
        return outlist;
    }


    public static void main(String[] args) {
        String[] strs =new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 =new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String str1 = "haah,ll hh";
        String str2 = "haah,ll hh";
        char[] c1 = new char[]{'a','b'};
        char[] c2 = new char[]{'a','b'};

        System.out.println(str1.equals(str2));
//        MapTest mt = new MapTest();
//        System.out.println(mt.groupAnagrams(strs));

        /*Map<char[], List<String>> hashMap = new HashMap<>();
        char[] ch = new char[]{'a','b','c'};
        List<List<String>> out = new ArrayList<>();
        List<String> list= new ArrayList<>();
        list.add("hello");
        list.add("heihei");
        hashMap.put(ch,list);
        //list.add("haha");

        System.out.println(hashMap.get(ch).add("haha"));
        System.out.println(hashMap.get(ch));
        for(Map.Entry<char[],List<String>> entry : hashMap.entrySet()) {
            //String key = entry.getKey();
            out.add(entry.getValue());
        }
        System.out.println(out);*/

//        StringBuilder sb = new StringBuilder();
//        String strs = Arrays.toString(x);
//        String strl = Arrays.toString(y);
//        String test = "haha";
//        String[] teststr = strs.split(",");
//        //System.out.println(Arrays.toString(x).length());
//        System.out.println(teststr[0]);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();

//        String b = "gaddto";
//        String s = a.subSequence(0,3).toString();
//        System.out.println(s);
//        System.out.println(b.contains(a.subSequence(0,3)));
//        char[] ch = b.toCharArray();
//        Arrays.sort(ch);
//        System.out.println(ch);
//        String ss = Arrays.toString(ch);
//        System.out.println(ss);



//        System.out.println(a.charAt(1) - 'a');
//        hashMap.putIfAbsent(0,0);
//        hashMap.putIfAbsent(1,9);
//        System.out.println("The value of key 1 is: " + hashMap.get(1));
//        hashMap.put('a',);
//        System.out.println("Test put return value: " + hashMap.put(1,1));
//        System.out.println("Test put return value: " + hashMap.put(2,5));
//        hashMap.putIfAbsent(2,4);
//        System.out.println("The value of key 1 is: " + hashMap.get(1));
//        hashMap.remove(0);
//        System.out.println("The value of key 0 is: " + hashMap.get(0));
//        hashMap.remove(2,3);
//        System.out.println("The value of key 2 is: " + hashMap.get(2));
//        if(hashMap.containsKey(2)){
//            System.out.println("The map containsKey: " + 2);
//        }
//        if(hashMap.containsValue(2)){
//            System.out.println("The map containsValue: " + 2);
//        }
//        System.out.println("The map size is: " + hashMap.size());
//        for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()) {
//            System.out.println("The Entry <" + entry + "> key is: " + entry.getKey() + "; Value is: " + entry.getValue());
//        }
//        //hashMap.clear();
//        if(hashMap.isEmpty()){
//            System.out.println("The map is empty now!");
//        }
//        System.out.println(hashMap.equals(hashMap));
//        hashMap.put(1,2);

    }


}
