package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Biographies {

    @JsonProperty("name")
    String name;

    @JsonProperty("handel_name")
    String handel_name;

    @JsonProperty("follower_count")
    String follower_count;

    @JsonProperty("following_count")
    String following_count;
}
