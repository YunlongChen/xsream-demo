package cn.chenyunlong.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@XStreamAlias("province")
public class Province {
    private String name;// 省名
    private List<City> cities = new ArrayList<City>();

    public void addCity(City city) {
        this.cities.add(city);
    }
}
