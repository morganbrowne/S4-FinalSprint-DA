package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.TreeNode;
import model.TreeRecord;
import repository.TreeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TreeService {

    private TreeNode root;

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public TreeNode buildAndSaveTree(int[] numbers) throws JsonProcessingException {
        root = null;
        for (int number : numbers) {
            root = insert(root, number);
        }

        // Save this to DB....
        String inputNumbers = arrayToString(numbers);
        String treeJson = objectMapper.writeValueAsString(root);
        TreeRecord record = new TreeRecord(inputNumbers, treeJson);
        treeRecordRepository.save(record);

        return root;
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.getValue()) node.setLeft(insert(node.getLeft(), value));
        else node.setRight(insert(node.getRight(), value));
        return node;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(",");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    public List<TreeRecord> getAllTrees() {
        return treeRecordRepository.findAll();
    }
}