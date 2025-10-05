package necessary.class035;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *ClassName: class035_4_leetcode_381
 *Package: necessary.class035
 *Description:创建于 2025/10/5 20:09
 * https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *@Author lyl
 *@Version 1.0
 */
public class class035_4_leetcode_381 {
    public static void main (String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(4));
        System.out.println(collection.insert(3));
        System.out.println(collection.insert(4));
        System.out.println(collection.insert(2));
        System.out.println(collection.insert(4));
        System.out.println(collection.remove(4));
        System.out.println(collection.remove(3));
        System.out.println(collection.remove(4));
        System.out.println(collection.remove(4));
    }
}

class RandomizedCollection {
    private HashMap<Integer, HashSet<Integer>> map;
    private ArrayList<Integer> list;

    public RandomizedCollection () {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert (int val) {
        if (! map.containsKey(val)) {
            HashSet<Integer> set = new HashSet<>();
            set.add(list.size());
            map.put(val , set);
            list.add(val);
            return true;
        } else {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
    }

    public boolean remove (int val) {
        if (! map.containsKey(val)) {
            return false;
        }
//        int index = map.get(val).iterator().next();
//        int value = list.getLast();
//        list.set(index , value);
//        list.removeLast();
//
//        if (map.get(val).size() == 1) {
//            map.remove(val);
//        } else {
//            map.get(val).remove(index);
//        }
//        if (map.get(value) != null) {
//            map.get(value).add(index);
//            map.get(value).remove(list.size());
//        }
//        return true;

        HashSet<Integer> set = map.get(val);
        int index = set.iterator().next();
        int endValue = list.getLast();
        HashSet<Integer> endValueSet = map.get(endValue);
        if (val == endValue) {  //包含同一个（只有一个）的情况
            list.removeLast();
        } else {
            list.removeLast();
            list.set(index , endValue);
            set.remove(index);
            endValueSet.add(index);
        }
        endValueSet.remove(list.size());
        if (set.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    public int getRandom () {
        int randomNum = (int) (Math.random() * list.size());
        return list.get(randomNum);
    }
}

