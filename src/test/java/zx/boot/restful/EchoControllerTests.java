package zx.boot.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EchoControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getterPattern10() throws Exception {

        this.mockMvc.perform(get("/echo/getter/pattern1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getterPattern11() throws Exception {

        this.mockMvc.perform(get("/echo/getter/pattern1").param("content", "hello"))
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void getterPattern2() throws Exception {

        this.mockMvc.perform(get("/echo/getter/pattern1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getterPattern3() throws Exception {

        this.mockMvc.perform(get("/echo/getter/pattern1/123").param("content", "hello"))
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void setterMessage1() throws Exception {

        this.mockMvc.perform(get("/echo/getter/pattern1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void setterMessage2() throws Exception {

        this.mockMvc.perform(get("/echo/getter/pattern1").param("content", "hello"))
                .andDo(print()).andExpect(status().isOk());
    }
}
