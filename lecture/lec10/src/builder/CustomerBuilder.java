package builder;

public class CustomerBuilder {
    private String firstName;
    private String lastName;
    private int age;

    public CustomerBuilder(String firstName) {
        this.firstName = firstName;
    }

    public void setFirstName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) { this.age = age; }

    public Customer build() {

        return new Customer(firstName, lastName, age);
    }

    public static void main(String[] args) {
        CustomerBuilder cb = new CustomerBuilder("Tom");
        cb.setAge(32);
        Customer tom = cb.build();

        cb.setLastName("Cheng");
        cb.setFirstName("Jack");
    }
}
