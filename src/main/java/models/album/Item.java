package models.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artists",
    "available_markets",
    "disc_number",
    "duration_ms",
    "explicit",
    "external_urls",
    "href",
    "id",
    "is_local",
    "name",
    "preview_url",
    "track_number",
    "type",
    "uri"
})
public class Item {

    @JsonProperty("artists")
    public List<Artist__1> artists = null;
    @JsonProperty("available_markets")
    public List<String> availableMarkets = null;
    @JsonProperty("disc_number")
    public Integer discNumber;
    @JsonProperty("duration_ms")
    public Integer durationMs;
    @JsonProperty("explicit")
    public Boolean explicit;
    @JsonProperty("external_urls")
    public ExternalUrls__3 externalUrls;
    @JsonProperty("href")
    public String href;
    @JsonProperty("id")
    public String id;
    @JsonProperty("is_local")
    public Boolean isLocal;
    @JsonProperty("name")
    public String name;
    @JsonProperty("preview_url")
    public String previewUrl;
    @JsonProperty("track_number")
    public Integer trackNumber;
    @JsonProperty("type")
    public String type;
    @JsonProperty("uri")
    public String uri;

}
