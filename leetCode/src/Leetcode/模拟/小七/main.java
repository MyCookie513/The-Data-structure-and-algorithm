package Leetcode.模拟.小七;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class main {


    public static void main(String[] args) {

    }
    public List<String> commonChars(String[] A) {

        Map<Character,Integer> result=null ;

        for (int i = 0; i < A.length; i++) {
            char[] c =A[i].toCharArray();
            Map<Character,Integer> map =new HashMap();
            for (int j = 0; j < c.length; j++) {
                if (map.containsKey(c[j]))
                    map.put(c[j],map.get(c[j])+1);
                else{
                    map.put(c[j],1);
                }
            }
            if (result==null){
                result=map;
                continue;
            }
            Iterator<Character> iterator = result.keySet().iterator();
            for (Iterator<Character> it = iterator; it.hasNext(); ) {
                char c0 = it.next();
                if (map.containsKey(c0)){
                    int a=result.get(c0);
                    if (a>map.get(c0)){
                        result.put(c0,map.get(c0));
                    }
                }else{
                    it.remove();
                }
            }
        }
        List<String> list =new ArrayList<>();
        for (char c0: result.keySet()) {
            int a1=result.get(c0);

            while (a1!=0){
                list.add(c0+"");
                a1--;
            }


        }
        return list;

    }
}












