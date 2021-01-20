import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Person> people = Person.getTestList();
        Streams<Person> streams = Streams.of(people);
        streams.filter(p->p.getAge()>30);
        streams.transform(p->new Person(p.getName(), p.getAge()+100));
        Map m = streams.toMap(p->p.getName(), p->p);
        m.forEach((k,v)-> System.out.println(k + " -> " + v));


       /* Stream <Person> m = people.stream();
       m.filter(p->p.getAge()>20).map(p->new Person(p.getName(), p.getAge()+30)).forEach(System.out::println);;*/
      //m.trasform(p->n)
      //people.stream().forEach(System.out::println);
      //people.stream().filter(p -> { return p.getAge() >50;}).forEach(System.out::println);
      //System.out.println("s");

    }
}
