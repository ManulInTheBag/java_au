+ [Binary Search Tree Iterator](#binary-search-tree-iterator)
<!-----solution----->
##Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/
```java
class BSTIterator {
    TreeNode curr;
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        curr = root;

        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode node = st.pop();
        TreeNode temp = node.right;

        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
```