package necessary.class060;

/**
 *ClassName: _4_2127
 *Package: necessary.class060
 *Description:创建于 2025/11/16 20:27
 * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/
 * favorite数组本身构成图，每个结点只有一个出边，一定会构成【奇环内向树】，即每个连通分量中有且仅有一个环
 * 环分两种情况：
 * 1）环中的结点数==2：则圆桌上的人的数量为所有环加左右两边最长的链的个数
 * 2)环中结点数>2:则数量为最大的环的结点的数量
 *@Author lyl
 *@Version 1.0
 */
public class _4_2127 {
}

class Solution4 {
    public int maximumInvitations(int[] favorite) {
        //通过去除入度为0的结点获得环
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        int[] deep = new int[n];
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue[r++] = i;
            }
        }
        while (l < r) {
            int cur = queue[l++];
            int target = favorite[cur];
            deep[target] = Math.max(deep[cur] + 1, deep[target]);
            if (--inDegree[target] == 0) {
                queue[r++] = target;
            }
        }
        //找环
        int smallring = 0, bigring = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] > 0) {
                int size = 1;
                //防止下次找环时进入同一个环
                inDegree[i] = 0;
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    size++;
                    inDegree[j] = 0;
                }
                if (size == 2) {
                    smallring += 2 + deep[i] + deep[favorite[i]];
                } else {
                    bigring = Math.max(bigring, size);
                }
            }
        }
        return Math.max(smallring, bigring);
    }
}