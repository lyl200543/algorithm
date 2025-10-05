package necessary.class035;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *ClassName: class035_3_leetcode_380
 *Package: necessary.class035
 *Description:创建于 2025/10/5 19:26
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/
 *@Author lyl
 *@Version 1.0
 */
public class class035_3_leetcode_380 {
    public static void main (String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.remove(0));
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
    }
}

class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;

    public RandomizedSet () {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert (int val) {
        if (! map.containsKey(val)) {
            map.put(val , list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove (int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int value = list.get(list.size() - 1);
            list.set(index , value);
            map.put(value , index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom () {
        int randomNum = (int) (Math.random() * list.size());
        return list.get(randomNum);
    }
}