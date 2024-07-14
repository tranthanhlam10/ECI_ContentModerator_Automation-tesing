package ObjectResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class BrandResponse {

        private int id;
        private String name;
        private String slug;
        private int manufacturerId;
        private Date createdAt;
        private int createdBy;
        private Date updatedAt;
        private int updatedBy;
        private Object deletedAt; // Sử dụng Object vì giá trị có thể là null
        private int isActive;
        private String nameExactly;
        private int notArchived;
        private String title;
        private ManufacturerResponse manufacturer;
        private UserResponse createdByUser; // Đặt tên khác để tránh xung đột với `createdBy`
        private UserResponse updatedByUser; // Đặt tên khác để tránh xung đột với `updatedBy`

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

        @JsonProperty("slug")
        public String getSlug() {
            return slug;
        }

        @JsonProperty("slug")
        public void setSlug(String slug) {
            this.slug = slug;
        }

        @JsonProperty("manufacturer_id")
        public int getManufacturerId() {
            return manufacturerId;
        }

        @JsonProperty("manufacturer_id")
        public void setManufacturerId(int manufacturerId) {
            this.manufacturerId = manufacturerId;
        }

        @JsonProperty("created_at")
        public Date getCreatedAt() {
            return createdAt;
        }

        @JsonProperty("created_at")
        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        @JsonProperty("created_by")
        public int getCreatedBy() {
            return createdBy;
        }

        @JsonProperty("created_by")
        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        @JsonProperty("updated_at")
        public Date getUpdatedAt() {
            return updatedAt;
        }

        @JsonProperty("updated_at")
        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }

        @JsonProperty("updated_by")
        public int getUpdatedBy() {
            return updatedBy;
        }

        @JsonProperty("updated_by")
        public void setUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
        }

        @JsonProperty("deleted_at")
        public Object getDeletedAt() {
            return deletedAt;
        }

        @JsonProperty("deleted_at")
        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        @JsonProperty("is_active")
        public int getIsActive() {
            return isActive;
        }

        @JsonProperty("is_active")
        public void setIsActive(int isActive) {
            this.isActive = isActive;
        }

        @JsonProperty("name_exactly")
        public String getNameExactly() {
            return nameExactly;
        }

        @JsonProperty("name_exactly")
        public void setNameExactly(String nameExactly) {
            this.nameExactly = nameExactly;
        }

        @JsonProperty("not_archived")
        public int getNotArchived() {
            return notArchived;
        }

        @JsonProperty("not_archived")
        public void setNotArchived(int notArchived) {
            this.notArchived = notArchived;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("manufacturer")
        public ManufacturerResponse getManufacturer() {
            return manufacturer;
        }

        @JsonProperty("manufacturer")
        public void setManufacturer(ManufacturerResponse manufacturer) {
            this.manufacturer = manufacturer;
        }

        @JsonProperty("createdBy")
        public UserResponse getCreatedByUser() {
            return createdByUser;
        }

        @JsonProperty("createdBy")
        public void setCreatedByUser(UserResponse createdByUser) {
            this.createdByUser = createdByUser;
        }

        @JsonProperty("updatedBy")
        public UserResponse getUpdatedByUser() {
            return updatedByUser;
        }

        @JsonProperty("updatedBy")
        public void setUpdatedByUser(UserResponse updatedByUser) {
            this.updatedByUser = updatedByUser;
        }
    }


