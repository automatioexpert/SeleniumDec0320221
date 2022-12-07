
package entities.pet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
