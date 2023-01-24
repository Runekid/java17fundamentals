package exercise06_03;

import javax.persistence.Embeddable;

@Embeddable
public class Email {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Email() {
    }
    public Email(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }
}
