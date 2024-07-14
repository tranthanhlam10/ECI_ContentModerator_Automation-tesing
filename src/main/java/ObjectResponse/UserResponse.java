package ObjectResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserResponse {

        private int id;
        private String email;
        private String fullname;

        // Getters and Setters

        @JsonProperty("id")
        public int getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(int id) {
            this.id = id;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("fullname")
        public String getFullname() {
            return fullname;
        }

        @JsonProperty("fullname")
        public void setFullname(String fullname) {
            this.fullname = fullname;
        }
    }


