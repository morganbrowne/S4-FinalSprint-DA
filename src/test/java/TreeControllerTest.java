import com.keyin.BinarySearchTreeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = BinarySearchTreeApplication.class)
@AutoConfigureMockMvc
public class TreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProcessNumbersEndpoint() throws Exception {
        String inputJson = "[5, 3, 7, 2, 4]";

        mockMvc.perform(post("/process-numbers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(5)) // root value should be 5
                .andExpect(jsonPath("$.left.value").value(3)) // left child of root
                .andExpect(jsonPath("$.right.value").value(7)); // right child of root
    }
}
