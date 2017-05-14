package pl.tarko.software.finder.google.maps.config;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleMapsConfig {

    @Value("${googlemaps.http.client.timeout?:1000}")
    private int googlemapsHttpClientTimeout;

    @Bean(name = "GeocoderHttpClient")
    public HttpClient createGeocoderHttpClient() {
        final HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
        httpClient.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, googlemapsHttpClientTimeout);
        return httpClient;
    }
}
