package necessary;

import java.util.Arrays;

/**
 *ClassName: class032_leetcode_2166
 *Package: necessary
 *Description:创建于 2025/9/24 19:53
 * 位集 Bitset 是一种能以紧凑形式存储位的数据结构
 * 通过1 0表示对应下标数字的有无
 * 一个int可以表示32位
 *
 * 请你实现 Bitset 类
 * Bitset(int size) 用 size 个位初始化 Bitset ，所有位都是 0 。
 * void fix(int idx) 将下标为 idx 的位上的值更新为 1 。如果值已经是 1 ，则不会发生任何改变。
 * void unfix(int idx) 将下标为 idx 的位上的值更新为 0 。如果值已经是 0 ，则不会发生任何改变。
 * void flip() 翻转 Bitset 中每一位上的值。换句话说，所有值为 0 的位将会变成 1 ，反之亦然。
 * boolean all() 检查 Bitset 中 每一位 的值是否都是 1 。如果满足此条件，返回 true ；否则，返回 false 。
 * boolean one() 检查 Bitset 中 是否 至少一位 的值是 1 。如果满足此条件，返回 true ；否则，返回 false 。
 * int count() 返回 Bitset 中值为 1 的位的 总数 。
 * String toString() 返回 Bitset 的当前组成情况。注意，在结果字符串中，第 i 个下标处的字符应该与 Bitset 中的第 i 位一致。
 *
 * 注意：reverse函数的设计：
 * 1.不修改 set 数组中的任何位，只通过 reverse = !reverse 切换状态，提高效率
 * 2.与其他方法（fix/unfix/toString 等）形成了完整的逻辑闭环
 * 3.从外部调用者的视角看，无论 reverse 如何变化，最终结果与 “真实翻转所有位” 完全一致
 * 4.bitset数组底层一直是没有反转过的
 *@Author lyl
 *@Version 1.0
 */
public class class032_leetcode_2166 {
}

class Bitset {
    public static int[] bitset;
    public static int size;
    public static int ones;
    public static int zeors;
    public static boolean is_reverse;


    public Bitset(int size) {
        this.size=size;
        int n=(size+31)/32;
        bitset=new int[n];
        zeors=size;
        ones=0;
        is_reverse=false;
    }

    public void fix(int idx) {
        int index=idx/32;
        int bit=idx%32;
        if(!is_reverse){
            //0->1
            if((bitset[index]&(1<<bit))==0){
                bitset[index]|=(1<<bit);
                zeors--;
                ones++;
            }
        }else {
            //1->0
            if((bitset[index]&(1<<bit))!=0){
                bitset[index]^=(1<<bit);
                zeors--;
                ones++;
            }
        }
    }

    public void unfix(int idx) {
        int index=idx/32;
        int bit=idx%32;
        if(!is_reverse){
            //1->0
            if((bitset[index]&(1<<bit))!=0){
                bitset[index]^=(1<<bit);
                zeors++;
                ones--;
            }
        }else {
            //0->1
            if((bitset[index]&(1<<bit))==0){
                bitset[index]|=(1<<bit);
                zeors++;
                ones--;
            }
        }
    }

    public void flip() {
        is_reverse=!is_reverse;
        int tmp=ones;
        ones=zeors;
        zeors=tmp;
    }

    public boolean all() {
        return ones==size;
    }

    public boolean one() {
        return ones>0;
    }

    public int count() {
        return ones;
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        int len=0;
        int bit=is_reverse?1:0;
        for (int i = 0 ; i < bitset.length ; i++) {
            for (int j = 0 ; j < 32 && len<size ; j++,len++) {
                sb.append(((bitset[i]>>j)&1)^bit);
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */