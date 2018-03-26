package model.Customer;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String gender;
    private String phone;
    private Boolean access;
    private String image;

    public Customer() { }

    public Customer(Long id, String firstName, String lastName, String userName, String password, String email,
                    String gender, String phone, Boolean access, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.access = access;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String  getGender() {
        return gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAccess() {
        return access;
    }

    void setAccess(Boolean access) {
        this.access = access;
    }

    public String getImage() {
        return image;
    }

    void setImage(String image) {
        this.image = image;
    }

    public Boolean toCompare(String str) {
        String customerHeader = "id,firstname,lastname,username,password,email,gender,phone,access,image";
        return customerHeader.equals(str);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", access=" + access +
                ", image='" + image + '\'' +
                '}';
    }
}
