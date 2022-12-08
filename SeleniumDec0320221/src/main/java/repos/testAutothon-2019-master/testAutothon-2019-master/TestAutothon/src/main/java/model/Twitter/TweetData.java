package model.Twitter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetData {
    @JsonProperty("statuses")
    List<Statuses> tweetdata;
}
