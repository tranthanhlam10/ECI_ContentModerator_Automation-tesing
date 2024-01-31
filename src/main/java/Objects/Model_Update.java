package Objects;

import lombok.Data;

@Data
public class Model_Update {
    private String display_name;
    private String name;
    private int product_line_id;
    private String query;
    private int query_exactly;
}
