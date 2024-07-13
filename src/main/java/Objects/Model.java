package Objects;
// This class is known as POJO oject()

import lombok.Data;

@Data
public class Model {
    private String display_name;
    private int product_line_id;
    private int query_exactly;
    private String query;
}
