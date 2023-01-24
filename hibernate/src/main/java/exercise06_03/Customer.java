package exercise06_03;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection
    @Column(name = "PHONE_NUMBER")
    @MapKeyColumn(name = "PHONE_TYPE")
    @CollectionTable(name = "Phones")
    private Map<String,String> phones = new HashMap<>();

    @ElementCollection
    @MapKeyColumn(name = "EMAILT_TYPE")
    @MapKeyEnumerated(EnumType.STRING)
    @CollectionTable(name = "Emails")
    private Map<EmailType, Email> emails = new HashMap<>();

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<EmailType, Email> getEmails() {
        return emails;
    }

    public void setEmails(Map<EmailType, Email> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", emails=" + emails +
                '}';
    }
}
