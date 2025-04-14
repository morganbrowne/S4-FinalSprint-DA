
import com.keyin.model.TreeNode;
import com.keyin.service.BinarySearchTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTreeTest {
    @Test
    public void testInsertSingleNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);

        TreeNode root = bst.getRoot();
        assertNotNull(root);
        assertEquals(10, root.getValue());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }

    @Test
    public void testInsertMultipleNodes() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        TreeNode root = bst.getRoot();
        assertEquals(10, root.getValue());
        assertEquals(5, root.getLeft().getValue());
        assertEquals(15, root.getRight().getValue());
    }
}

