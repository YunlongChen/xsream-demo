package cn.chenyunlong.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstname;
    private String lastname;
    private PhoneNumber phone;
    @XStreamAlias("testFax")
    private PhoneNumber fax;


    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
