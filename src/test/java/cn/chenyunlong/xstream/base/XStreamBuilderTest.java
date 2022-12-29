package cn.chenyunlong.xstream.base;

import cn.chenyunlong.xstream.City;
import cn.chenyunlong.xstream.Province;
import cn.chenyunlong.xstream.XStreamBuilder;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class XStreamBuilderTest {

    @Test
    void build() {

        XStream xstream = XStreamBuilder.build();

    }

    @Test
    public void function1() {
        List<Province> proList = getProvinceList();
        /*
         * 创建XStream对象，调用toXML把集合转换成xml字符串
         */
        XStream xStream = XStreamBuilder.build();
        xStream.aliasType("province", Province.class);
        String string = xStream.toXML(proList);
        System.out.println(string);
    }

    public List<Province> getProvinceList() {
        Province p1 = new Province();
        p1.setName("北京");
        p1.addCity(new City("东城区", "dongchengqu"));
        p1.addCity(new City("昌平区", "changpingqu"));

        Province p2 = new Province();
        p1.setName("山东省");
        p1.addCity(new City("济南", "jinan"));
        p1.addCity(new City("青岛", "qingdao"));

        ArrayList<Province> provinceList = new ArrayList<>();
        provinceList.add(p1);
        provinceList.add(p2);

        return provinceList;
    }

    @Test
    public void function2() {
        List<Province> proList = getProvinceList();
        /*
         * 创建XStream对象，调用toXML把集合转换成xml字符串
         */
        XStream xStream = XStreamBuilder.build();
        xStream.alias("china", List.class);
        xStream.alias("province", Province.class);
        xStream.alias("city", City.class);

        xStream.useAttributeFor(Province.class, "name");
        xStream.addImplicitCollection(Province.class, "cities");

        String string = xStream.toXML(proList);
        System.out.println(string);
    }


    /**
     * 去除不想要的属性
     */
    @Test
    public void omitField() {
        List<Province> proList = getProvinceList();
        /*
         * 创建XStream对象，调用toXML把集合转换成xml字符串
         */
        XStream xStream = XStreamBuilder.build();

        xStream.alias("china", List.class);
        xStream.alias("province", Province.class);
        xStream.alias("city", City.class);

        xStream.useAttributeFor(Province.class, "name");
        xStream.addImplicitCollection(Province.class, "cities");

        // 让city类，名为description的属性不生成对应的xml属性
        xStream.omitField(City.class, "description");

        String string = xStream.toXML(proList);
        System.out.println(string);
    }


}
