package pl.tarko.software.finder;

import java.util.Optional;

/**
 * Created by Paweł Tarkowski on 09.12.2016.
 */
public class CustomAssert {

    public interface CustomAssertRunnable{
        void run() throws Throwable;
    }

    public static Optional<Throwable> assertThrown(CustomAssertRunnable command) {
        try {
            command.run();
            return Optional.empty();
        } catch (Throwable t) {
            return Optional.of(t);
        }
    }
}
