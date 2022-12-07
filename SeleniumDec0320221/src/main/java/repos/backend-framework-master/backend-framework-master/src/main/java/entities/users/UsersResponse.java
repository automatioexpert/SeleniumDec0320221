package entities.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class UsersResponse {
    @JsonProperty("code")
    public Integer code;
    @JsonProperty("type")
    public String type;
    @JsonProperty("message")
    public String message;
}
