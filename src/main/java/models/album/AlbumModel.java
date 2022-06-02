package models.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "album_type",
        "artists",
        "available_markets",
        "copyrights",
        "external_ids",
        "external_urls",
        "genres",
        "href",
        "id",
        "images",
        "label",
        "name",
        "popularity",
        "release_date",
        "release_date_precision",
        "total_tracks",
        "tracks",
        "type",
        "uri"
})
public class AlbumModel {

    @JsonProperty("album_type")
    private String albumType;
    @JsonProperty("artists")
    private List<Artist> artists = null;
    @JsonProperty("available_markets")
    private List<String> availableMarkets = null;
    @JsonProperty("copyrights")
    private List<Copyright> copyrights = null;
    @JsonProperty("external_ids")
    private ExternalIds externalIds;
    @JsonProperty("external_urls")
    private ExternalUrls__1 externalUrls;
    @JsonProperty("genres")
    private List<Object> genres = null;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("label")
    private String label;
    @JsonProperty("name")
    private String name;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

    public static Map<String, String> getMapTracks(List<Item> list) {
        Map<String, String> temp = new HashMap<>();
        for(Item item : list) {
            temp.put(item.getName(), item.getId());
        }
        return temp;
    }

}
