package Pojo.Exercises;

import java.util.ArrayList;

public class TextPojo {


        private String status;
        private int code;
        private int total;
        private ArrayList<TextPojoData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<TextPojoData> getData() {
        return data;
    }

    public void setData(ArrayList<TextPojoData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TextPojo{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
