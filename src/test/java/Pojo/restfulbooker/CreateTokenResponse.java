package Pojo.restfulbooker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTokenResponse {
@JsonProperty
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CreateTokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
