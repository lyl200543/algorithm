package necessary.class059;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *ClassName: _2_210
 *Package: necessary.class059
 *Description:创建于 2025/11/9 15:52
 * https://leetcode.cn/problems/course-schedule-ii/
 * 拓扑排序模板
 *@Author lyl
 *@Version 1.0
 */
public class _2_210 {
}

class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree=new int[numCourses];
        for (int[] e:prerequisites){
            graph.get(e[1]).add(e[0]);
            inDegree[e[0]]++;
        }
        //使用队列
        int[] queue=new int[numCourses];
        int l=0, r=0, count=0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue[r++] = i;
                count++;
            }
        }
        while(l<r){
            int node=queue[l++];
            for(int neighbor:graph.get(node)){
                if(--inDegree[neighbor]==0) {
                    queue[r++] = neighbor;
                    count++;
                }
            }
        }
        return count==numCourses?queue:new int[0];
    }
}

//时间超过限制
//class Solution2 {
//    private int[] inDegree;
//    private List<List<Integer>> graph;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        createGraph(numCourses,prerequisites);
//        int[] ans=new int[numCourses];
//        sort(ans);
//        return ans;
//    }
//
//    private void createGraph(int n,int[][] edges){
//        inDegree=new int[n];
//        graph=new ArrayList<List<Integer>>(n);
//        for(int i=0;i<n;i++){
//            graph.set(i,new ArrayList<Integer>());
//            inDegree[i]=0;
//        }
//        for(int[] e:edges){
//            inDegree[e[0]]++;
//            graph.get(e[1]).add(e[0]);
//        }
//    }
//
//    private void sort(int[] ans){
//        int count=0;
//        while(count<ans.length){
//            List<Integer> zero = findZero();
//            for (int i = 0; i < zero.size(); i++) {
//                int node=zero.get(i);
//                ans[count++]= node;
//                inDegree[node]--;
//                for(int e:graph.get(node)){
//                    inDegree[e]--;
//                }
//            }
//        }
//    }
//
//    private List<Integer> findZero(){
//        List<Integer> ans=new ArrayList<>();
//        for(int i=0;i<inDegree.length;i++){
//            if(inDegree[i]==0){
//                ans.add(i);
//            }
//        }
//        return ans;
//    }
//}