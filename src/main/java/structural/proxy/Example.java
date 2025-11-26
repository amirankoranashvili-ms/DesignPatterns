package structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class Example {

    static interface Internet {
        void connect(String url);
    }

    static class DefaultInternet implements Internet {
        @Override
        public void connect(String url) {
            System.out.println("Connecting to " + url + "...");
        }
    }

    static class ProxyInternet implements Internet {

        DefaultInternet defaultInternet;
        List<String> blockedUrls;

        public ProxyInternet(DefaultInternet defaultInternet) {
            this.defaultInternet = defaultInternet;
            blockedUrls = new ArrayList<>();
        }

        public ProxyInternet(DefaultInternet defaultInternet, List<String> blockedUrls) {
            this.defaultInternet = defaultInternet;
            this.blockedUrls = blockedUrls;
        }

        public List<String> getBlockedUrls() {
            return blockedUrls;
        }

        public void blockUrl(String url) {
            blockedUrls.add(url);
        }

        @Override
        public void connect(String url) {
            if (blockedUrls.contains(url)) {
                System.out.println("Blocked url: " + url);
            } else {
                defaultInternet.connect(url);
            }
        }
    }
}
