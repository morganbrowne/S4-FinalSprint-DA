package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.TreeNode;
import model.TreeRecord;
import service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping("/process-numbers")
    public TreeNode processNumbers(@RequestBody int[] numbers) throws JsonProcessingException {
        return treeService.buildAndSaveTree(numbers);
    }

    @GetMapping("/previous-trees")
    public List<TreeRecord> getPreviousTrees() {
        return treeService.getAllTrees();
    }
}