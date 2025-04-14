package com.keyin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keyin.model.TreeNode;
import com.keyin.model.TreeRecord;
import com.keyin.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")


@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping("/process-numbers")
    public ResponseEntity<?> processNumbers(@RequestBody int[] numbers) throws JsonProcessingException {
        if (numbers == null || numbers.length == 0) {
            return ResponseEntity.badRequest().body("Input array cannot be empty.");
        }
        TreeNode result = treeService.buildAndSaveTree(numbers);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/previous-trees")
    public List<TreeRecord> getPreviousTrees() {
        return treeService.getAllTrees();
    }
}