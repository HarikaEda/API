package Pojo.reqres;

public class UserRequest {

    private User data;
    private  Support support;
    private String updatedAt;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "data=" + data +
                ", support=" + support +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
