package 总结一.BFS和DFS精通的题.单词接龙2;

import java.util.*;

public class 复习 {


    /**
     * todo  常规 bfs : 1.只能搜索出一条最短路径；  2.只需要点级去重
     * todo 而这道题要求的是： 搜索出所有的最短路径； 多个点可能同时做一条路径； 所以需要 行级去重；
     * todo 利用 双向BFS更加高效；
     *
     *
     *
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result =new ArrayList<>();
        Set<String> words =new HashSet<>(wordList);
        if (!words.contains(endWord))
            return result;

        Set<String> start =new HashSet<>();
        start.add(beginWord);
        words.remove(beginWord);
        Set<String> end =new HashSet<>();
        end.add(endWord);
        Map<String,List<String>> map_tree=new HashMap<>();
        if (!DoubleBuild_bfs(start,end,map_tree,true,words))
            return result;
        DFS0(map_tree,result,beginWord,new LinkedList<String>(),endWord);
        return result;

    }


    /**
     *todo 核心 ： bfs 双向搜索建树；
     */
    private boolean DoubleBuild_bfs(Set<String> start, Set<String> end, Map<String, List<String>> map_tree, boolean b,Set<String> words) {

        boolean success=false;
        words.removeAll(start);
        if (start.size()==0)
            return false;

        Set<String> nextCeng =new HashSet<>();
        //向下一层搜索
        for (String str: start) {
            char[] c=str.toCharArray();
            for (int j = 0; j <c.length ; j++) {
                char c0=c[j];
                for (char i = 'a'; i <='z'; i++) {
                    c[j]=i;
                    String s=String.valueOf(c);
                    if (words.contains(s)){
                        nextCeng.add(s);

                        String  key= b? str : s;
                        String value=b? s : str;

                        if (!map_tree.containsKey(key))
                            map_tree.put(key,new ArrayList<>());
                        map_tree.get(key).add(value);
                        if (end.contains(s))
                            success=true;
                    }
                }
                c[j]=c0;
            }
        }
        if (success)
            return true;
        else{
            if (nextCeng.size()>end.size())
                return DoubleBuild_bfs(end,nextCeng,map_tree,!b,words);
            else
                return DoubleBuild_bfs(nextCeng,end,map_tree,b,words);
        }

    }



    private void DFS0(Map<String, List<String>> map_tree, List<List<String>> result,String begin,LinkedList<String> list,String end) {

        list.addLast(begin);
        if (begin.equals(end)){
            result.add(new ArrayList<>(list));
        }
        if (!map_tree.containsKey(begin)){
            list.removeLast();
            return;
        }
        List<String> next=map_tree.get(begin);
        for (String str : next) {
            DFS0(map_tree,result,str,list,end);
        }
        list.removeLast();
    }

}
