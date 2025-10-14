package necessary.class036;

/**
 *ClassName: _6_297
 *Package: necessary.class036
 *Description:创建于 2025/10/14 19:42
 *  https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * 先序遍历的序列化和反序列化
 *@Author lyl
 *@Version 1.0
 */
public class _6_297 {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root!=null)
            serial(root,sb);
        return sb.toString();
    }

    private void serial (TreeNode root , StringBuilder sb) {
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val+",");
        serial(root.left,sb);
        serial(root.right,sb);
    }

    private int index;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] tokens = data.split(",");
        index=0;
        return deserial(tokens);
    }

    private TreeNode deserial (String[] tokens) {
        String token=tokens[index++];
        if(token.equals("#"))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.parseInt(token));
            node.left=deserial(tokens);
            node.right=deserial(tokens);
            return node;
        }
    }
}