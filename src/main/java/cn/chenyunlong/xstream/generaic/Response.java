package cn.chenyunlong.xstream.generaic;


import com.thoughtworks.xstream.XStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Response<T extends Response.Foo> {
    private int id;
    private T field;


    public static void main(String[] args) {
        Response<B> responseB = new Response<B>(5, new B("1"));
        String xml = new XStream().toXML(responseB);
        System.out.println("marshalled:\n" + xml);
        Response<B> resultB = (Response<B>) new XStream().fromXML(xml);
        System.out.println("unmarshalled: " + resultB);

        Response<C> responseC = new Response<C>(10, new C());
        xml = new XStream().toXML(responseC);
        System.out.println("marshalled:\n" + xml);
        Response<C> resultC = (Response<C>) new XStream().fromXML(xml);
        System.out.println("unmarshalled: " + resultC);
    }


    @Data
    static class Foo {

        private String name;
    }

    @Data
    @AllArgsConstructor
    static class B extends Foo {
        private String a;
    }

    @Data
    @NoArgsConstructor
    static class C extends Foo {
        private String c;
    }
}

