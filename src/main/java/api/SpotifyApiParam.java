package api;

public enum SpotifyApiParam {
    GRANT_TYPE("grant_type"),
    CLIENT_ID("client_id"),
    CLIENT_SECRET("client_secret"),
    ALBUM_TYPE("album"),
    TRACK_TYPE("track");

    private final String value;

    SpotifyApiParam(String value) {
        this.value  = value;
    }

    public String getValue() {
        return value;
    }
}
