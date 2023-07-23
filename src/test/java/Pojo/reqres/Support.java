package Pojo.reqres;

public class Support {
private String url;
private String text;

    public String getUsl() {
        return url;
    }

    public void setUsl(String usl) {
        this.url = usl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support{" +
                "usl='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
