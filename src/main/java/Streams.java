import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.stream.*;

public class Streams <T>{

    Stream <T> mStream;

    public static Streams of(List list){
        return new Streams(list);
    }

    public Streams(List<? extends T> list) {
        mStream = (Stream <T>) list.stream();
    }

    public void filter(Predicate <? super T> predicate){
        mStream = mStream.filter(predicate);
    }

    public void transform(Function <? super T, ? extends T> mapper){
        mStream = mStream.map(mapper);
    }

    public Map<Object, T> toMap(Function <? super T, Object> from, Function <? super T, ? extends T> to){
        Map<Object, Object> map = mStream.collect(Collectors.toMap(from, to));
        return (Map <Object, T>) map;
    }

    public void show(){
        mStream.forEach(System.out::println);
    }

}
