package bean;

public class Person {
    private int id;
    private String name;
    private String sex;
    private String phone;
    private String address;
    public Person() {
    };
    public Person(Integer id, String name, String sex, String phone, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
