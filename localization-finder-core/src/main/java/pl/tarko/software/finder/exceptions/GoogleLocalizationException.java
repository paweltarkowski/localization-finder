package pl.tarko.software.finder.exceptions;

/**
 * Created by Paweł Tarkowski on 09.12.2016.
 */
public class GoogleLocalizationException extends LocalizationException {

    public GoogleLocalizationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
