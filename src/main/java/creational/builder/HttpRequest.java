package creational.builder;

import java.util.HashMap;
import java.util.Map;

public record HttpRequest(
        String url,
        String method,
        String body,
        Map<String, String> headers,
        int timeout
) {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String url;
        private String method = "GET";
        private String body="";
        private Map<String, String> headers = new HashMap<>();
        private int timeout = 5000;

        private Builder() {}

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException("url is required");
            }

            return new HttpRequest(url, method, body, headers, timeout);
        }
    }

}
