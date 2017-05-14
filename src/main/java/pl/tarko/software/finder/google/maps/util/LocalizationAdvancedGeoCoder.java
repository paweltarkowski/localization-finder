package pl.tarko.software.finder.google.maps.util;

import com.google.code.geocoder.AdvancedGeoCoder;
import org.apache.commons.httpclient.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;

@Component
public class LocalizationAdvancedGeoCoder extends AdvancedGeoCoder {

    private Logger logger = LoggerFactory.getLogger(LocalizationAdvancedGeoCoder.class);

    private final String clientKey;

    @Autowired
    public LocalizationAdvancedGeoCoder(@Qualifier("GeocoderHttpClient") HttpClient httpClient,
                                        @Value("googlemaps.geocoder.client.key") String clientNewKey) throws InvalidKeyException {
        super(httpClient);
        logger.debug("Create google client key name = "+clientNewKey);
        clientKey = clientNewKey;
    }

    @Override
    protected void addClientIdAndSignURL(StringBuilder url) throws UnsupportedEncodingException {
        url.append("&key=").append(URLEncoder.encode(clientKey, "UTF-8"));
    }

}
