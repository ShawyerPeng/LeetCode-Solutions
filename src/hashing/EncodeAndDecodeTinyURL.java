package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl
 * 问题：
 * 思路：
 */
public class EncodeAndDecodeTinyURL {
    private static Map<String, String> dict = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        String tinyUrl = "http://tinyurl.com/" + longUrl.hashCode();
        dict.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return dict.get(shortUrl);
    }

    public static void main(String[] args) {
        System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(decode(encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
