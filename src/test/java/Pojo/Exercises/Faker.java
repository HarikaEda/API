package Pojo.Exercises;

public class Faker {
private String name;
private String phoneNumber;
private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Faker{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
