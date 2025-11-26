package structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class Exercise {
    
    interface Downloader {
        String download(String url);
    }
    
    static class RealDownloader implements Downloader {
        @Override
        public String download(String url) {
            try {
                Thread.sleep(2000);
                System.out.println("Downloading from " + url);
                return "Value from " + url;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    
    static class CachingProxy implements Downloader {

        RealDownloader realDownloader = new RealDownloader();
        Map<String, String> cache = new HashMap<>();
        
        @Override
        public String download(String url) {
            if (cache.containsKey(url)) {
                return cache.get(url);
            } else {
                String val = realDownloader.download(url);
                cache.put(url, val);
                return val;
            }
        }
    }

    public static void main(String[] args) {
        CachingProxy cachingProxy = new CachingProxy();
        System.out.println(cachingProxy.download("https://www.google.com"));
        System.out.println(cachingProxy.download("https://www.facebook.com"));
        System.out.println(cachingProxy.download("https://www.google.com"));
        System.out.println(cachingProxy.download("https://www.instagram.com"));
    }
    
}
