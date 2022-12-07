package entities.pet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class PetRequestBuilder {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    @JsonProperty("id")
    public PetRequestBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("category")
    public PetRequestBuilder category(Category category) {
        this.category = category;
        return this;
    }

    @JsonProperty("name")
    public PetRequestBuilder name(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("photoUrls")
    public PetRequestBuilder photoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    @JsonProperty("tags")
    public PetRequestBuilder tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    @JsonProperty("status")
    public PetRequestBuilder status(String status) {
        this.status = status;
        return this;
    }

    public PetObj build() {
        return new PetObj(this.id, this.category, this.name, this.photoUrls, this.tags, this.status);
    }

    public String toString() {
        return "PetRequestBuilder(id=" + this.id + ", category=" + this.category + ", name=" + this.name + ", photoUrls=" + this.photoUrls + ", tags=" + this.tags + ", status=" + this.status + ")";
    }
}

