
import com.keyin.BinarySearchTreeApplication;
import com.keyin.model.TreeRecord;
import com.keyin.service.TreeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BinarySearchTreeApplication.class)
@AutoConfigureMockMvc
public class PreviousTreeTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TreeService treeService;

    @Test
    public void testGetPreviousTreesReturnsData() throws Exception {
        TreeRecord record1 = new TreeRecord("10,5,15", "{\"value\":10,\"left\":{\"value\":5},\"right\":{\"value\":15}}");
        TreeRecord record2 = new TreeRecord("20,10,30", "{\"value\":20,\"left\":{\"value\":10},\"right\":{\"value\":30}}");

        List<TreeRecord> mockRecords = Arrays.asList(record1, record2);

        Mockito.when(treeService.getAllTrees()).thenReturn(mockRecords);

        mockMvc.perform(get("/previous-trees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].inputNumbers", is("10,5,15")))
                .andExpect(jsonPath("$[0].treeStructureJson", is("{\"value\":10,\"left\":{\"value\":5},\"right\":{\"value\":15}}")))
                .andExpect(jsonPath("$[1].inputNumbers", is("20,10,30")))
                .andExpect(jsonPath("$[1].treeStructureJson", is("{\"value\":20,\"left\":{\"value\":10},\"right\":{\"value\":30}}")));
    }
}

