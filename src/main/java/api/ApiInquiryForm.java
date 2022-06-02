package api;

public enum ApiInquiryForm {
    SEARCH("/search?q=track:%s+artist:%s&type=%s");

    private final String value;

    ApiInquiryForm(String value) {
        this.value  = value;
    }

    public String getValue() {
        return value;
    }
}
