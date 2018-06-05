package arithmetic;

/**
 * 二叉树（B树）
 * 1、所有非叶子节点至多拥有两个儿子
 * 2、所有节点存储一个关键字
 * 3、非叶子节点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树
 * @author mc
 * @date 2018/6/5
 */
public class BinaryTree {
    /**
     * 左子树
     */
    private BinaryTree leftTree;
    /**
     * 右子树
     */
    private BinaryTree rightTree;
    /**
     * 关键字
     */
    private int keyData;

    private BinaryTree(int keyData) {
        this.leftTree = null;
        this.rightTree = null;
        this.keyData = keyData;
    }

    /**
     * 创建二叉树
     * @param root 根节点
     * @param data 关键字
     */
    private void insert(BinaryTree root, int data) {
        // 如果将要插入的关键字大于根节点的关键字
        if(data > root.keyData) {
            if(root.rightTree == null) {
                root.rightTree = new BinaryTree(data);
            } else {
                insert(root.rightTree, data);
            }
        } else {
            if(root.leftTree == null) {
                root.leftTree = new BinaryTree(data);
            } else {
                insert(root.leftTree, data);
            }
        }
    }

    /**
     * 先序遍历(根，左，右)
     * @param root root
     */
    private static void preOrder(BinaryTree root) {
        if(root == null) {
            return;
        }
        System.out.print(root.keyData + " ");
        preOrder(root.leftTree);
        preOrder(root.rightTree);
    }

    /**
     * 中序遍历(左，根，右)
     * @param root root
     */
    private static void inOrder(BinaryTree root) {
        if(root == null) {
            return;
        }
        inOrder(root.leftTree);
        System.out.print(root.keyData + " ");
        inOrder(root.rightTree);
    }

    /**
     * 后序遍历(左，右，根)
     * @param root root
     */
    private static void postOrder(BinaryTree root) {
        if(root == null) {
            return;
        }
        postOrder(root.leftTree);
        postOrder(root.rightTree);
        System.out.print(root.keyData + " ");
    }

    public static void main(String[] args) {
        int[] array = {35, 17, 39, 9, 28, 65, 56, 87};
        // 创建根节点
        BinaryTree root = new BinaryTree(array[0]);
        for(int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);
        }
        System.out.println("先序遍历：");
        BinaryTree.preOrder(root);

        System.out.println("\n中序遍历：");
        BinaryTree.inOrder(root);

        System.out.println("\n后序遍历：");
        BinaryTree.postOrder(root);
    }
}
