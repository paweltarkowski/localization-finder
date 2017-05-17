package pl.tarko.software.finder;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public abstract class PreConfiguredControllerTest {

    protected MockMvc mockMvc;

    public void initSetup(Object controller) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}
