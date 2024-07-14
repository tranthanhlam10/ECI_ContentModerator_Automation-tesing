package ObjectResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ManufacturerResponse {
    private int id;
    private String name;

    // Getters and Setters

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
}
