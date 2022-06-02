package api;

public enum ApiEndPoints {
    TRACK("/tracks/"),
    ALBUM("/albums/"),
    ME("/me");

    private final String value;

    ApiEndPoints(String value) {
        this.value  = value;
    }

    public String getValue() {
        return value;
    }
}
