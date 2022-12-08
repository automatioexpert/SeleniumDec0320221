package model.Twitter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Entities {

    @JsonProperty("hashtags")
    public List<Hashtag> hashtags;
    @JsonProperty("symbols")
    public List<Object> symbols;
    @JsonProperty("urls")
    public List<Object> urls;


}