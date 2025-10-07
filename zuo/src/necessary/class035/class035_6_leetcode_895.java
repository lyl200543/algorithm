package necessary.class035;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *ClassName: class035_6_leetcode_895
 *Package: necessary.class035
 *Description:创建于 2025/10/7 20:11
 * https://leetcode.cn/problems/maximum-frequency-stack/description/
 *@Author lyl
 *@Version 1.0
 */
public class class035_6_leetcode_895 {
}

class FreqStack {
    private int topFrequency;
    private HashMap<Integer, ArrayList<Integer>> mapList; //key是出现的次数,value是出现次数为key的元素（按出现顺序）
    private HashMap<Integer, Integer> map;  //key是元素,value是出现次数

    public FreqStack () {
        topFrequency = 0;
        mapList = new HashMap<>();
        map = new HashMap<>();
    }

    public void push (int val) {
        int num;
        if (! map.containsKey(val)) {
            num = 1;
        } else {
            num = map.get(val) + 1;
        }
        map.put(val , num);
        if (! mapList.containsKey(num)) {
            mapList.put(num , new ArrayList<>());
        }
        mapList.get(num).add(val);
        topFrequency = map.get(val) > topFrequency ? map.get(val) : topFrequency;
    }

    public int pop () {
        Integer ret = mapList.get(topFrequency).removeLast();
        if (mapList.get(topFrequency).isEmpty()) {
            mapList.remove(topFrequency);
            topFrequency--;
        }
        if (map.get(ret) == 1) {
            map.remove(ret);
        } else {
            Integer i = map.get(ret);
            map.put(ret , i - 1);
        }
        return ret;
    }
}
