package model;

import jakarta.persistence.*;

@Entity
public class TreeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String inputNumbers;

    @Column(length = 5000)
    private String treeStructureJson;


    public TreeRecord() {}

    public TreeRecord(String inputNumbers, String treeStructureJson) {
        this.inputNumbers = inputNumbers;
        this.treeStructureJson = treeStructureJson;
    }


    public Long getId() {
        return id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructureJson() {
        return treeStructureJson;
    }

    public void setTreeStructureJson(String treeStructureJson) {
        this.treeStructureJson = treeStructureJson;
    }
}