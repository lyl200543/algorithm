package necessary.class036;

import com.sun.source.tree.Tree;

/**
 *ClassName: _7_297
 *Package: necessary.class036
 *Description:创建于 2025/10/14 20:09
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * 层序遍历的序列化和反序列化
 *@Author lyl
 *@Version 1.0
 */
public class _7_297 {
}
class Codec2 {
    private int MAX_SIZE=10001;
    private TreeNode[] queue=new TreeNode[MAX_SIZE];
    private int l,r;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root!=null){
            l=r=0;
            sb.append(root.val+",");
            queue[r++]=root;
            while(l<r){
                TreeNode node = queue[l++];
                if(node.left!=null){
                    sb.append(node.left.val+",");
                    queue[r++]=node.left;
                }else {
                    sb.append("#,");
                }
                if(node.right!=null){
                    sb.append(node.right.val+",");
                    queue[r++]=node.right;
                }else {
                    sb.append("#,");
                }
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] tokens = data.split(",");
        l=r=0;
        int k=0;
        TreeNode root=new TreeNode(Integer.parseInt(tokens[k++]));
        queue[r++]=root;
        while(l<r){
            TreeNode cur=queue[l++];
            if(tokens[k++].equals("#")){
                cur.left=null;
            }else {
                cur.left=new TreeNode(Integer.parseInt(tokens[k-1]));
                queue[r++]=cur.left;
            }
            if(tokens[k++].equals("#")){
                cur.right=null;
            }else {
                cur.right=new TreeNode(Integer.parseInt(tokens[k-1]));
                queue[r++]=cur.right;
            }
        }
        return root;
    }
}