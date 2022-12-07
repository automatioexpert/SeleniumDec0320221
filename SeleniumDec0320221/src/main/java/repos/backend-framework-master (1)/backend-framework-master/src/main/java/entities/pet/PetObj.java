
package entities.pet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetObj {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("category")
    public Category category;
    @JsonProperty("name")
    public String name;
    @JsonProperty("photoUrls")
    public List<String> photoUrls =null;
    @JsonProperty("tags")
    public List<Tag> tags= null;
    @JsonProperty("status")
    public String status;

    public PetObj(Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}
