package io.cscode.algorithms.strings;

import java.util.HashMap;
import java.util.Objects;

public class EncodeDecodeTinyURL {

    static String tinyURL = "http://tinyurl.com/";
    static final HashMap<String, String> encodedMap = new HashMap<>();
    static final HashMap<String, String> decodedMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String alreadyExists  = encodedMap.get(longUrl);
        if(!Objects.isNull(alreadyExists)) { // if the longUrl is already encoded, then return that
            return alreadyExists;
        }
        String encodedURL = tinyURL + (encodedMap.size()+1);
        encodedMap.put(longUrl, encodedURL);
        decodedMap.put(encodedURL, longUrl);
        return encodedURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodedMap.get(shortUrl);
    }

    public static void main(String[] args) {

        String longUrl = "https://cscode.io/algo/strings/EncodeDecodeTinyURL/";
        String encoded = new EncodeDecodeTinyURL().encode(longUrl);
        String decoded = new EncodeDecodeTinyURL().decode(encoded);
        System.out.println("Encoded : " +encoded +" , Decoded : "+decoded);
        assert longUrl.equals(decoded);


    }
}
