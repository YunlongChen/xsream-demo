package cn.chenyunlong.xstream;

import com.thoughtworks.xstream.XStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        XStream xstream = XStreamBuilder.build();

//        xstream.alias("person", Person.class);
//        xstream.alias("fsdfsd", PhoneNumber.class);


        Person joe = new Person("Joe", "Walnes");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));


        String xml = xstream.toXML(joe);

        System.out.println("xml = " + xml);

    }
}
