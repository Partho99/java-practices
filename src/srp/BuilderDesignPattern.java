package srp;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class BuilderDesignPattern {

    private String name;
    private String modelName;
    private String ram;
    private String processor;
    private String color;

    public BuilderDesignPattern(String name) {
        System.out.println("creating laptop name");
        this.name = name;
    }

    public BuilderDesignPattern(String name, String color) {
        this(name);
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Main {
    public static void main(String[] args) {

        List<AddUser> addUserList = Arrays.asList(
                new AddUser("partho das", "partho99@gmail.com", 1L, true),
                new AddUser("fahim", "fahim@gmail.com", 2L, true),
                new AddUser("shagoto", "shagoto@gmail.com", 3L, true),
                new AddUser("sourav", "sourav@gmail.com", 4L, true),
                new AddUser("rafi", "rafi@gmail.com", 5L, true),
                new AddUser("tapu", "tapu@gmail.com", 6L, false)
        );


        List<User> users = addUserList.stream().map(user -> new User
                        .UserBuilder(user.fullName, user.id)
                        .activeStatus(user.activeStatus)
                        .fullName(user.fullName)
                        .build())
                .collect(Collectors.toList());
    }

    private static final class AddUser {
        String fullName;
        String email;
        Long id;
        Boolean activeStatus;

        public AddUser(String fullName, String email, Long id, Boolean activeStatus) {
            this.fullName = fullName;
            this.email = email;
            this.id = id;
            this.activeStatus = activeStatus;
        }
    }

    private static final class AddRole {
        Integer id;
        String role;

        public AddRole(Integer id, String role) {
            this.id = id;
            this.role = role;
        }
    }
}

final class User {
    private final String email;
    private final String fullName;
    private final Boolean activeStatus;
    private final Long id;
    private List<RoleBuilder> roles;

    public static class UserBuilder {

        //Required Parameters
        private final String email;
        private final Long id;

        //Optional Parameters
        private String fullName;
        private Boolean activeStatus;


        public UserBuilder(String email, Long id) {
            this.email = email;
            this.id = id;
        }


        public UserBuilder fullName(String value) {
            fullName = value;
            return this;
        }

        public UserBuilder activeStatus(Boolean value) {
            activeStatus = value;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    private static class RoleBuilder {
        private String role;
        private Long id;


        public RoleBuilder(String role, Long id) {
            this.role = role;
            this.id = id;
        }

        public RoleBuilder(RoleBuilder roleBuilder) {

        }

        public RoleBuilder role(String value) {
            this.role = value;
            return this;
        }

        public RoleBuilder id(Long value) {
            this.id = value;
            return this;
        }

        public RoleBuilder build() {
            return new RoleBuilder(this);
        }
    }

    public User(UserBuilder builder) {
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.activeStatus = builder.activeStatus;
        this.id = builder.id;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", activeStatus=" + activeStatus +
                ", id=" + id +
                '}';
    }
}


class ThreadExample {
    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName);

        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.setName("Extended Thread");
        extendedThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExtendedThread extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }

    private void sleepOneSecond() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class RevString {

    public static String revStr(String str) {
        char[] ch = str.toCharArray();
        StringBuilder rev = new StringBuilder();
        for (int i = ch.length - 1; i >= 0; i--) {
            rev.append(ch[i]);
        }
        return rev.toString();
    }

    public static void main(String[] args) {
        System.out.println(RevString.revStr("HELLO"));
    }
}


class JavaFunctionalExercise {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> result = numbers
                .stream()
                .reduce((subtotal, element) -> subtotal + element);

        String string = "Item1 10 Item2 25 Item3 30 Item4 45";

        Integer sum = Arrays.stream(string.split(" "))
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.println(result);
    }
}


class HigherOrderFunction12 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filter;
        filter = (list, predicate) -> {
            List<Integer> result = new ArrayList<>();
            for (Integer l : list)
                if (predicate.test(l)) result.add(l);
            return result;
        };

        System.out.println(filter.apply(numbers, x -> x % 2 == 0));
    }
}

class DistinctEx {
    public static void main(String[] args) {
        List<AssignBrand> list = Arrays.asList(
                new AssignBrand("Rally", "Racer", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Bolt", 2, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally2", "Bolt", 2, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Ice", 3, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally3", "Ice", 3, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon", "Racer", 4, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon2", "Racer", 4, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon", "Ice", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Marise", "Bolt", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Marise", "Ice", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Verve", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Verve2", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Bidi", "Special Abul", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rexon", "Kings", 5, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rexon2", "Kings", 5, List.of(new ProductCategory(1, "cigarette")))
        );

        list.sort(new SortByProductName());
        System.out.println("SORTED BY NAME ::  ");
        list.forEach(System.out::println);

        System.out.println("SORTED BY NAME END ::  ");
        list.stream()
                .sorted(Comparator.comparing(AssignBrand::getProductType))
                .filter(distinctBy(AssignBrand::getId))
                .forEach(System.out::println);


        list.stream()
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(AssignBrand::getId))
                )).forEach(System.out::println);

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
        System.out.println("Number of threads " + Thread.activeCount() * Runtime.getRuntime().availableProcessors());

        list.stream()
                .collect(Collectors
                        .groupingBy(AssignBrand::getId, mapping(AssignBrand::getProductName, toList())))
                .entrySet()
                .forEach(System.out::println);

//        list.stream().map(AssignBrand::getProductType).forEach(System.out::println);
    }

    public static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        Set<Integer> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add((Integer) keyExtractor.apply(t));
    }

    public static <AssignBrand> Predicate<AssignBrand> distinctById(Function<? super AssignBrand, ?> keyExtractor) {
        Set<Integer> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add((Integer) keyExtractor.apply(t));
    }
}

class AssignBrand {
    private String productName;
    private String productType;
    private int id;

    private List<ProductCategory> productCategories;

    public AssignBrand(String productName, String productType, int id, List<ProductCategory> productCategories) {
        this.productName = productName;
        this.productType = productType;
        this.id = id;
        this.productCategories = productCategories;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return "AssignBrand{" +
                "productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", id=" + id +
                ", productCategories=" + productCategories +
                '}';
    }
}


class SortByProductName implements Comparator<AssignBrand> {

    @Override
    public int compare(AssignBrand assignBrand, AssignBrand t1) {
        return assignBrand.getProductName().compareTo(t1.getProductName());
    }

    @Override
    public Comparator<AssignBrand> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<AssignBrand> thenComparing(Comparator<? super AssignBrand> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<AssignBrand> thenComparing(Function<? super AssignBrand, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<AssignBrand> thenComparing(Function<? super AssignBrand, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<AssignBrand> thenComparingInt(ToIntFunction<? super AssignBrand> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<AssignBrand> thenComparingLong(ToLongFunction<? super AssignBrand> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<AssignBrand> thenComparingDouble(ToDoubleFunction<? super AssignBrand> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}

class SortByProductType implements Comparable<AssignBrand> {

    @Override
    public int compareTo(AssignBrand assignBrand) {

        return 0;
    }
}

@FunctionalInterface
interface I {
    int m1();
}

@FunctionalInterface
interface J {
    int m2();
}

@FunctionalInterface
interface K {
    A m3(I obj1, I obj2);
}

@FunctionalInterface
interface A {
    void m4();
}

class HigherOrderFunction {
    public static void main(String[] args) {
        I obj1 = () -> 111;
        I obj2 = () -> 222;
        K obj3 = (x, y) -> {
            System.out.println(x.m1() + y.m1());
            return () -> System.out.println("m4 method");
        };
        obj3.m3(obj1, obj2);
    }
}


class JavaHiddenTreasure {

    public static void printTest(Long number, Predicate<Long> predicate, String msg) {
        System.out.println(number + " " + msg + " : " + predicate.test(number));
    }

    public static void main(String[] args) {
        Predicate<Long> isEven = e -> e % 2 == 0;
        Predicate<Long> isGreater = e -> e > 299;
        Predicate<Long> isLess = e -> e < 599;
        Predicate<Long> isEqual = e -> e == 499;

        printTest(5L, isEven, "is even ?");
        printTest(4L, isEven, "is even ?");
        printTest(989898984124124129L, isEven.and(isGreater).or(isLess), "is even ?");
    }
}

class NullPointerException {
    public static void main(String[] args) {
        List<String> name = null;
        assert false;
        System.out.println(name.isEmpty());
    }
}

class FlatMapExercise {
    public static void main(String[] args) {

        List<AssignBrand> list = Arrays.asList(
                new AssignBrand("Rally", "Racer", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Bolt", 2, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally2", "Bolt", 2, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Ice", 3, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally3", "Ice", 3, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon", "Racer", 4, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon2", "Racer", 4, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon", "Ice", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Marise", "Bolt", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Marise", "Ice", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Verve", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Verve2", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Bidi", "Special Abul", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rexon", "Kings", 5, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rexon2", "Kings", 5, List.of(new ProductCategory(1, "cigarette")))
        );
//        List<AssignBrand> collect = list.stream().flatMap(l -> l.getProductCategories().stream()).collect(toList());

        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(new ArrayList<>(new ArrayList<>(people.entrySet())));
    }
}

class ProductCategory {
    private Integer id;
    private String categoryName;

    public ProductCategory(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}


class StringPolExercise {
    public static void main(String[] args) {
//        String s1 = new String("Apple");
        String s2 = new String("Apple");
//        s1.intern();

        char data[] = {'a', 'b', 'c'};
        String str = new String(data);

        System.out.println(str.toUpperCase());

//        System.out.println(s1 == s2);

        String s1 = "ABC";
        byte[] b = s1.getBytes();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}


class ThreadPoolExercise {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        PrintJob[] jobs = {new PrintJob("sohel"),
                new PrintJob("partho"),
                new PrintJob("bappy"),
                new PrintJob("mahfuz"),
                new PrintJob("pk"),
                new PrintJob("anil")};

        for (PrintJob job : jobs) {
            executorService.submit(job);
        }
        executorService.shutdown();
    }
}

class PrintJob implements Runnable {

    String name;

    public PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Job started by Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
        }
        System.out.println(name + " Job completed by Thread " + Thread.currentThread().getName());
    }
}

class CallablePrintJob implements Callable {

    int num;

    public CallablePrintJob(int num) {
        this.num = num;
    }

    @Override
    public Object call() {
        System.out.println(Thread.currentThread().getName() + " is ... responsible to find sum of first " + num + " numbers");
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}

class CallableExercise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CallablePrintJob[] jobs = {new CallablePrintJob(10),
                new CallablePrintJob(20),
                new CallablePrintJob(30),
                new CallablePrintJob(40),
                new CallablePrintJob(50),
                new CallablePrintJob(60)
        };

        for (CallablePrintJob job : jobs) {
            Future f = executorService.submit(job);
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
}

class ReactiveDemo {
    public static void main(String[] args) {
        System.out.println("Number of threads " + Thread.activeCount());
    }
}

class Test_ {
    public static void main(String[] args) {
        Test_ test = new Test_();
        Long start_time = System.currentTimeMillis();
        double re = test.testFun(10, 16666611, 1000000000);
        Long end_time = System.currentTimeMillis();

        System.out.println(re);
        System.out.println("time taken " + (end_time - start_time));
    }

    private double testFun(double first, double second, long times) {
        int i = 0;
        double result = 0;
        double dx = (second - first) / times;
        for (; i < times; i++) {
            result += fun(first + i * dx);
        }
        return result * dx;
    }

    private double fun(double v) {
        return Math.pow(v, 2) - v;
    }
}

class KKK {

    public static void main(String[] args) {
        int[] x1 = {1, 2, 3, 5, 6, 7, 4};

//         Arrays.stream(x1).takeWhile(x -> x < 6).forEach(System.out::println);
//        System.out.println(g);
    }
}

class Contiguous {
    public static void main(String[] args) {
        int[] binArr = {0, 1, 0};
        for (int x = 0; x < binArr.length; x++) {
            if (binArr.length > x) {
                if (binArr[x] == 0) {

                }
            }
        }
    }
}

class ArrayEx {
    public static void main(String[] args) {
        List<Integer> l = new CopyOnWriteArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);

        int i = 0;
        try {
            for (Integer x : l) {
                l.remove(x);
                //i++;
            }
        } catch (Exception e) {

        }

        System.out.println(l.size());

    }
}

class ContArray {
    public static void main(String[] args) {
        byte[] cArray = {0, 1, 0};

        int[] arr = {0, 1, 0};
        int beg = 1, end = arr.length - 1;

        int counter = 0;

        int[] subarray = new int[end - beg + 1];
//        System.arraycopy(arr, beg + 0, subarray, 0, subarray.length);
        for (int i = 0; i < subarray.length; i++) {
            subarray[i] = arr[beg + i];
            System.out.println(arr[i]);
        }
        //System.out.println(counter);
        System.out.println(Arrays.toString(subarray));
    }

}


class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map5 = Stream.of(
                new AbstractMap.SimpleEntry<>("Sakshi", "java"),
                new AbstractMap.SimpleEntry<>("fine", "python")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map5.get("Sakshi"));
        map5.put("Shiva", "Javascript");
        System.out.println(map5.get("Shiva"));
        System.out.println(map5);
    }
}

class BiFunctionDemo {
    public static void main(String[] args) {
        String result = powToString(2, 4,
                Math::pow,
                (r) -> "Result : " + String.valueOf(r));

        System.out.println(result); // Result : 16.0
    }

    public static <R> R powToString(Integer a1, Integer a2,
                                    BiFunction<Integer, Integer, Double> func,
                                    Function<Double, R> func2) {

        return func.andThen(func2).apply(a1, a2);

    }
}

class Java8BiFunction3 {

    public static void main(String[] args) {

        GPS obj = factory("40.741895", "-73.989308", GPS::new);
        System.out.println(obj);

    }

    public static <R extends GPS> R factory(String Latitude, String Longitude,
                                            BiFunction<String, String, R> func) {
        return func.apply(Latitude, Longitude);
    }

}

class GPS {

    String Latitude;
    String Longitude;

    public GPS(String latitude, String longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public GPS(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "Latitude='" + Latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                '}';
    }
}

interface Notifying {
    void notifyMe(int data);
}

class GetNotified {
    public static void main(String[] args) {
        SetNotifier setNotifier = new SetNotifier();
        setNotifier.setNotifying(data -> System.out.println(data));

        setNotifier.processData(5656);

        CreateNotify createNotify = new CreateNotify();
        createNotify.setNotifying(data -> System.out.println(data));
        createNotify.getData();
    }
}

class SetNotifier {
    Notifying notifying;

    void setNotifying(Notifying notifying) {
        this.notifying = notifying;
    }

    void processData(int x) {
        notifying.notifyMe(x);
    }
}

class CreateNotify {
    SetNotifier setNotifier = new SetNotifier();

    Notifying notifying;

    void setNotifying(Notifying notifying) {
        this.notifying = notifying;
    }

    void getData() {
        setNotifier.processData(12);
    }
}


class IntStreamExample {
    public static void main(String[] args) {
        List<AssignBrand> list = Arrays.asList(
                new AssignBrand("Rally", "Racer", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Bolt", 2, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally2", "Bolt", 2, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Ice", 3, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally3", "Ice", 3, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon", "Racer", 4, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon2", "Racer", 4, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Sunmoon", "Ice", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Marise", "Bolt", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Marise", "Ice", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Verve", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rally", "Verve2", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Bidi", "Special Abul", 1, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rexon", "Kings", 5, List.of(new ProductCategory(1, "cigarette"))),
                new AssignBrand("Rexon2", "Kings", 5, List.of(new ProductCategory(1, "cigarette")))
        );

        batches(list, 3).forEach(System.out::println);


    }

    public static <T> Stream<List<T>> batches(List<T> source, int length) {
        if (length <= 0)
            throw new IllegalArgumentException("length = " + length);
        int size = source.size();
        if (size <= 0)
            return Stream.empty();
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1).mapToObj(
                n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
    }
}