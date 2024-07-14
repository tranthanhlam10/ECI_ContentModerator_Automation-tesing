package ObjectResponse;

public class ProductLineResponse {
    private int id;
    private String name;
    private String slug;
    private int brandId;
    private int industryId;
    private String createdAt;
    private Object createdBy;
    private String updatedAt;
    private int updatedBy;
    private BrandResponse brand;
    private IndustryResponse industry;

    public int getId() {
        return id;
    }

}
