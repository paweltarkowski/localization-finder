package pl.tarko.software.finder;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.tarko.software.LocalizationAppApplication;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = { LocalizationAppApplication.class })
public abstract class MainPreConfiguredContextTest {
}
