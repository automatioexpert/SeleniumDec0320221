package model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Tweet {

    @JsonProperty("top_retweet_count")
    int top_retweet_count;

    @JsonProperty("top_like_count")
    int top_like_count;

    @JsonProperty("top_10_hashtag")
    List<String> top_10_hashtag;

    @JsonProperty("biographies")
    List<Biographies> biographies;

}
