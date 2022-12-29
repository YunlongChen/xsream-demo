package cn.chenyunlong;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        XStream xstream = new XStream(new StaxDriver()) {
            @Override
            protected void setupConverters() {
            }
        };

        xstream.registerConverter(new ReflectionConverter(xstream.getMapper(), xstream.getReflectionProvider()), XStream.PRIORITY_VERY_LOW);
        xstream.registerConverter(new IntConverter(), XStream.PRIORITY_NORMAL);
        xstream.registerConverter(new StringConverter(), XStream.PRIORITY_NORMAL);
        xstream.registerConverter(new CollectionConverter(xstream.getMapper()), XStream.PRIORITY_NORMAL);

//        xstream.alias("person", Person.class);
//        xstream.alias("fsdfsd", PhoneNumber.class);


        Person joe = new Person("Joe", "Walnes");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));


        String xml = xstream.toXML(joe);

        System.out.println("xml = " + xml);

    }
}
