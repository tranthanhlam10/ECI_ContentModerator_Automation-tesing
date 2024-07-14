package ObjectResponse;

public class ModelResponse {
    private int id;
    private String name;
    private String slug;
    private String displayName;
    private String query;
    private int queryExactly;
    private Integer productId;
    private int productLineId;
    private String createdAt;
    private int createdBy;
    private String updatedAt;
    private int updatedBy;
    private Object deletedAt;
    private ProductLineResponse productLine;
    private UserResponse createdByUser;
    private UserResponse updatedByUser;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getQueryExactly() {
        return queryExactly;
    }

    public void setQueryExactly(int queryExactly) {
        this.queryExactly = queryExactly;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(int productLineId) {
        this.productLineId = productLineId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ProductLineResponse getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLineResponse productLine) {
        this.productLine = productLine;
    }

    public UserResponse getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserResponse createdByUser) {
        this.createdByUser = createdByUser;
    }

    public UserResponse getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(UserResponse updatedByUser) {
        this.updatedByUser = updatedByUser;

}
}
