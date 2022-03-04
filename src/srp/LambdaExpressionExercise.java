package srp;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.*;

import static java.util.Comparator.comparing;

public class LambdaExpressionExercise {

    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>();
        L.add(20);
        L.add(10);
        L.add(25);
        L.add(5);
        L.add(30);
        L.add(0);
        L.add(15);

        System.out.println(L);
        Collections.sort(L, new MyComparator());
        System.out.println(L);
    }
}

@FunctionalInterface
interface FPInterface {
    void xyz();
}

@FunctionalInterface
interface XPInterface extends FPInterface {
    void xyz();

    default void helloPrint() {
        System.out.println("HELLO FP");
    }
}

class Demo implements XPInterface {

    @Override
    public void xyz() {
        System.out.println("hello ...");
    }

    @Override
    public void helloPrint() {
        XPInterface.super.helloPrint();
    }
}

interface MultipleAbsInterface {
    void add(int x, int y);
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer I1, Integer I2) {
        if (I1 < I2) return 1;
        else if (I1 > I2) return -1;
        else return 0;
    }
}

class TreeAndHashSetEx {
    public static void main(String[] args) {
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(11290);
        integerTreeSet.add(909);
        integerTreeSet.add(9009);
        integerTreeSet.add(903);
        integerTreeSet.add(900);

        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(312);
        integerHashSet.add(1332);
        integerHashSet.add(122);
        integerHashSet.add(1232);
        integerHashSet.add(132);

        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "afif");
        integerStringMap.put(2, "dumba");
        integerStringMap.put(3, "archer");
        integerStringMap.put(1, "sohel");
        integerStringMap.put(5, "soloman");

        integerStringMap.entrySet().forEach(System.out::println);
//        integerTreeSet.stream().forEach(System.out::println);

//        integerHashSet.stream().forEach(System.out::println);
    }
}


class method1 {
    public static void main(String args[]) throws ClassNotFoundException {
        givenObject_whenGetsFieldNamesAtRuntime_thenCorrect();
    }

    public static void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() throws ClassNotFoundException {
        Class c = Class.forName("Person");
        System.out.println(c.getName());

    }
}

class Person {
    private String name;
    private int age;
}

class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> f = i -> i * i;
        Predicate<Integer> p = i -> i % 2 == 0;
        System.out.println(f.apply(4));
        if (p.test(78)) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

        ArrayList<Integer> l = new ArrayList<>();
        l.add(20);
        l.add(10);
        l.add(25);
        l.add(5);
        System.out.println(l);
        Comparator<Integer> c = (I1, I2) -> (I1 < I2) ? 1 : (I1 > I2) ? -1 : 0;
        Collections.sort(l, c);
        l.stream().forEach(System.out::println);
        List<Integer> l2 = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(l2);
    }
}

class Employee {
    String name;
    int eno;

    public Employee(String name, int eno) {
        this.name = name;
        this.eno = eno;
    }

    @Override
    public String toString() {
        return "{" + "name='" + name + '\'' + ", eno=" + eno + '}';
    }
}

class EmployeeMain {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("partho", 1));
        employees.add(new Employee("masud", 4));
        employees.add(new Employee("sohel", 5));
        employees.add(new Employee("rahat", 2));
        employees.add(new Employee("naim", 3));

    /*  System.out.println(employees);
        Collections.sort(employees, (e1, e2) -> e1.eno > e2.eno ? -1 : e1.eno < e1.eno ? 1 : 0);
        Collections.sort(employees, (e1, e2) -> e2.name.compareTo(e1.name));
        System.out.println(employees);
    */


        List<String> collect = employees.stream().map(e -> e.name + " : " + e.eno).collect(Collectors.toList());

//        System.out.println(collect);

        Predicate<Integer> integerPredicate = i -> i % 2 == 0;

        System.out.println(integerPredicate.test(80));
    }
}


class AnonymousVsLambda {
    public static void main(String[] args) {
        prepareTemperature().stream().map(City::getName).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);

        Set<Integer> treeSet = Stream.of(1, 3, 5, 7, 9).collect(Collectors.toCollection(TreeSet::new));
    }

    private static List<City> prepareTemperature() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("New Delhi", 33.5));
        cities.add(new City("Mexico", 14));
        cities.add(new City("New York", 13));
        cities.add(new City("Dubai", 43));
        cities.add(new City("London", 15));
        cities.add(new City("Alaska", 1));
        cities.add(new City("Kolkata", 30));
        cities.add(new City("Sydney", 11));
        cities.add(new City("Mexico", 14));
        cities.add(new City("Dubai", 43));
        return cities;
    }
}

class City {

    // Initializing the properties
    // of the city class
    private String name;
    private double temperature;

    // Parameterized constructor to
    // initialize the city class
    public City(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    // Getters to get the name and
    // temperature
    public String getName() {
        return name;
    }

    public Double getTemperature() {
        return temperature;
    }

    // Overriding the toString method
    // to return the name and temperature
    @Override
    public String toString() {
        return name + " --> " + temperature;
    }
}

class DateTimeExercise {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}

interface StaticExercise {
    static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("partho", 1));
        employees.add(new Employee("masud", 4));
        employees.add(new Employee("sohel", 5));
        employees.add(new Employee("rahat", 2));
        employees.add(new Employee("naim", 3));

        Employee employee = new Employee("partho", 1);
        Predicate<Employee> e = e1 -> e1.eno == 1;

        List integerArrayList = List.of(1, 2, 3, 4);

        System.out.println(integerArrayList.get(2));


        String[] emp = {"masud", "naimur", "raqib", "shakil", "partho", "mahfuz", "bappy", "touhid"};
        Predicate<String> empPredicate = empS -> (empS.length() % 2) == 0;
        Predicate<String> empPredicate2 = empS -> empS.length() >= 5;

        Arrays.stream(emp).filter(em -> empPredicate.and(empPredicate2).test(em)).forEach(System.out::println);

    }
}

interface FunctionalExercise {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("partho", 1));
        employees.add(new Employee("masud", 4));
        employees.add(new Employee("sohel", 5));
        employees.add(new Employee("rahat", 2));
        employees.add(new Employee("naim", 3));

        Function<Employee, String> p = i -> i.name;
        System.out.println(p.apply(new Employee("parth", 9)));
    }
}


class Sample {
    public static boolean isGreaterThan3(int number) {
        return number > 3;
    }

    public static void main(String[] args) {
        List<Integer> i = Arrays.asList(1, 2, 2, 4, 5, 4, 5, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = 0;
        for (int e : i) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }

//        curry function
        Function<Integer, Predicate<Integer>> greaterThan = x -> num -> num > x;
        System.out.println(
                i.stream()
                        .filter(greaterThan.apply(5))
                        .filter(Sample::isEven)
                        .map(e -> e * 2)
                        .findFirst()
                        .get()
        );
    }

    private static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    boolean isPrime(Long number) {
        return number > 1 && LongStream.range(2, number).noneMatch(index -> number % index == 0);
    }
}

class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed... ");
        notify();
    }
}

class Test {
    public static void main(String args[]) {
        final Customer c = new Customer();
        new Thread(() -> c.withdraw(15000)).start();
        new Thread(() -> c.deposit(10000)).start();

    }
}


class Sample2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(System.out::print);
    }

    static <T> T t(T t) {
        return t;
    }

    static Integer someThing() {
        Integer tx = 0;
        return t(tx);
    }
}


class WaitSleepExample {

    //create an instance of the Object
    private static Object object = new Object();

    //main() method starts with handling InterruptedException
    public static void main(String[] args) throws InterruptedException {
        //pause process for five second
        Thread.sleep(5000);

        //print custom statement
        System.out.println(Thread.currentThread().getName() +
                " Thread is woken after five second");

        //create synchronized context from which we call Wait() method
        synchronized (object) {
            //use wait() method to set obj in waiting state for five seconds
            object.wait(5000);

            System.out.println(object + " Object is in waiting state and woken after 5 seconds");
        }
    }
}

class MapExample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Java Programming", "Java", "Spring Boot", "Java 8", "Hibernate", "Oracle");

        List<Integer> collect = stringList.stream()
                .map(String::length)// :: means method references
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}

class FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> number = new ArrayList<>();
        number.add(Arrays.asList(8, 4));
        number.add(Arrays.asList(43, 23));
        number.add(Arrays.asList(50, 26));
        number.add(Arrays.asList(73, 83));

        System.out.println("List of list or (Arrays of Array) - " + number);

        List<Integer> flatList
                = number.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

//        List<List<Integer>> mapList = number.stream().map((x,y) -> flatList).collect(Collectors.toList());
        System.out.println("List generate by flatMap - "
                + flatList);
    }
}

interface DefaultMethodExample {
    default void showSomething() {
        System.out.println("Showing something...");
    }
}

interface StaticMethodExample {
    static void staticMethod() {
        System.out.println("I am static method from interface...");
    }
}

interface DefaultMethod extends DefaultMethodExample {
    @Override
    default void showSomething() {
        System.out.println("Showing something is overridden...");
    }
}

class StaticVsDefaultMethods implements DefaultMethod, DefaultMethodExample {
    public static void main(String[] args) {
//        recursionEx(1);
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");

        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
        list.stream().flatMapToDouble(s -> DoubleStream.of(Integer.parseInt(s)))
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);
    }

    public static void recursionEx(int i) {
        int n = 5;
        if (i > n) return;
        System.out.printf("%d ", i);
        recursionEx(i + 1);
        System.out.printf("%d ", i);
    }
}

class LambdaDesignEx {
    private static int compute(int x) {
        System.out.println("called ... ");
        return x * 2;
    }

    public static void main(String[] args) {
        int x = 14;
        var temp = new Lazy<Integer>(() -> compute(x));

        if (x > 5 && temp.get() > 7)
            System.out.println("path 1 " + " value " + temp.get());
        else System.out.println("path 2");
    }
}

class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> theSupplier) {
        supplier = theSupplier;
    }

    public T get() {
        if (instance == null) {
            instance = supplier.get();
            supplier = null;
        }
        return instance;
    }

}

class SuperClassOther extends SuperClass {
    @Override
    public void result() {
        super.x = 90;
        System.out.println(x);
    }
}


class SuperClass {
    public int x = 88;

    public void result() {
        System.out.println("print something");
    }
}

class SetDemo {
    public static void main(String[] args) {
        Set<String> names = newHashSet("Tom", "Jane", "Karen");
        Set<Integer> mutableSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6));
        Iterator<String> namesIterator = names.iterator();

        System.out.println(mutableSet);
//        String firstName = namesIterator.next();
//        System.out.println(" ::::::::::::::::: -> "+firstName);

        namesIterator.forEachRemaining(System.out::println);


        Stream.of("a", "b", "c", "d", "e", "a", "b", "c")
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }

    public static final <T> Set<T> newHashSet(T... objs) {
        Set<T> set = new HashSet<T>();
        Collections.addAll(set, objs);
        return set;
    }
}

class HashTableDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Math", "John", "Smith", "Miami", 19),
                new Student("Programming", "Mike", "Miles", "New York", 21),
                new Student("Math", "Michael", "Peterson", "New York", 20),
                new Student("Math", "James", "Robertson", "Miami", 20),
                new Student("Programming", "Kyle", "Miller", "Miami", 20)
        );

        Student s = new Student();

        Map<String, List<Student>> studentsBySubject = students
                .stream()
                .collect(
                        Collectors.groupingBy(Student::getSurname)
                );

//        studentsBySubject.entrySet().stream().forEach(System.out::println);

        Map<String, List<String>> namesByCity = students.stream().collect(Collectors.groupingBy(
                        Student::getCity,
                        Collectors.mapping(Student::getName, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(comparing(e -> e.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

//        namesByCity.entrySet().stream().forEach(System.out::println);

        Map<String, List<String>> namesByCity2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCity,
                        TreeMap::new,
                        Collectors.mapping(Student::getSubject, Collectors.toList())));

//        namesByCity2.entrySet().stream().forEach(System.out::println);

        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getAge,
                        Collectors.counting()))
                .entrySet();
//                .forEach(System.out::println);

        int[] values = new int[]{11, 22, 33, 44, 55};

        IntStream stream = Arrays.stream(values);
        int sum = stream.reduce(0, (left, right) -> left + right);

//         students
//                .stream()
//                .collect(Collectors.mapping(Student::getName, Collectors.toSet())).forEach(System.out::println);
    }
}


class Student {
    private String subject;
    private String name;
    private String surname;
    private String city;
    private int age;

    public Student() {
    }

    public Student(String subject, String name, String surname, String city, int age) {
        this.subject = subject;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }

    // Constructors, Getters, Setters, toString()
}


class Duck {
    private IDisplayBehavior iDisplayBehavior;
    private IQuackBehavior iQuackBehavior;
    private IFLyBehavior ifLyBehavior;

    public Duck(IDisplayBehavior iDisplayBehavior, IQuackBehavior iQuackBehavior, IFLyBehavior ifLyBehavior) {
        this.iDisplayBehavior = iDisplayBehavior;
        this.iQuackBehavior = iQuackBehavior;
        this.ifLyBehavior = ifLyBehavior;
    }

    public void fly() {
        this.ifLyBehavior.fly();
    }

    public void display() {
        this.iDisplayBehavior.display();
    }

    public void quack() {
        this.iQuackBehavior.quack();
    }


}

interface IFLyBehavior {
    void fly();
}

interface IQuackBehavior {
    void quack();
}

interface IDisplayBehavior {
    void display();
}

class DisplayAsGraphics implements IDisplayBehavior {
    @Override
    public void display() {
        System.out.println("displaying graphically....");
    }
}

class DisplayAsText implements IDisplayBehavior {

    @Override
    public void display() {
        System.out.println("displaying text.....");
    }
}

class SimpleQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("simple quack behavior.....");
    }
}

class NoQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("no quack behavior.....");
    }
}

class SimpleFLy implements IFLyBehavior {
    @Override
    public void fly() {
        System.out.println("simple flying behavior.....");
    }
}

class JetFly implements IFLyBehavior {

    @Override
    public void fly() {
        System.out.println("jet flying behavior.....");
    }
}


class DuckMain {
    public static void main(String[] args) {
        Duck duck = new Duck(new DisplayAsGraphics(), new NoQuack(), new JetFly());
        Duck duck2 = new Duck(new DisplayAsText(), new SimpleQuack(), new SimpleFLy());

        duck.fly();
        duck.display();
        duck.quack();

        System.out.println("------------------------------------------------");

        duck2.quack();
        duck2.fly();
        duck2.display();
    }
}


//Observer Design Pattern

interface IObservable {

}



// Observer Design Pattern

class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}

class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}

interface EventListener {
    void update(String eventType, File file);
}
class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}

class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}

class Demo2 {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/home/partho/Desktop/xyz/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}