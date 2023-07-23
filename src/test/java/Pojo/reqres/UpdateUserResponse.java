package Pojo.reqres;

public class UpdateUserResponse {
private User data;
private Support support;
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
        return "UpdateUserResponse{" +
                "data=" + data +
                ", support=" + support +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
