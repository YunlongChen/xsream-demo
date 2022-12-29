package cn.chenyunlong.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XStreamBuilder {

    public static XStream build() {
        //这样写有问题，会有依赖的问题，导致无法创建
        // XStream xStream = new XStream();
        XStream xStream = new XStream(new StaxDriver()) {
            @Override
            protected void setupConverters() {
            }
        };

        xStream.registerConverter(new ReflectionConverter(xStream.getMapper(), xStream.getReflectionProvider()), XStream.PRIORITY_VERY_LOW);
        xStream.registerConverter(new IntConverter(), XStream.PRIORITY_NORMAL);
        xStream.registerConverter(new StringConverter(), XStream.PRIORITY_NORMAL);
        xStream.registerConverter(new CollectionConverter(xStream.getMapper()), XStream.PRIORITY_NORMAL);
        return xStream;
    }
}
