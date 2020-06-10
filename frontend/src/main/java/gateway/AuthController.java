package gateway;

import gateway.oauth.OAuth2Token;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<?> oauth() {

        try {
            // request url
            String url = "http://localhost:8443/oauth/token";

            // create auth credentials
            String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary(("talk2amareswaran:talk2amareswaran@123").getBytes());

            //setting up the request headers
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            requestHeaders.add("Authorization", authorizationHeader);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("username", "john@gmail.com");
            map.add("password", "admin1234");
            map.add("grant_type", "password");

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, requestHeaders);

            // make a request
            ResponseEntity<OAuth2Token> oauth2Token = new RestTemplate().exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    OAuth2Token.class);

            // get JSON response

            return ResponseEntity.ok().body(oauth2Token.getBody());

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/post-login", method = RequestMethod.POST)
    public ResponseEntity<?> postAuth() {

        try {
            // request url
            String url = "http://localhost:8443/oauth/token";

            // create auth credentials
            String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary(("talk2amareswaran:talk2amareswaran@123").getBytes());

            //setting up the request headers
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            requestHeaders.add("Authorization", authorizationHeader);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("username", "john@gmail.com");
            map.add("password", "admin1234");
            map.add("grant_type", "password");

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, requestHeaders);

            // make a request
            ResponseEntity<OAuth2Token> oauth2Token = new RestTemplate().exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    OAuth2Token.class);

            // get JSON response

            return ResponseEntity.ok().body(oauth2Token.getBody());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
