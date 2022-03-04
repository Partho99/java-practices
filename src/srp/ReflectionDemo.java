package srp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionDemo {
    private String s;

    // creating a public constructor
    public ReflectionDemo() {
        s = "Geeks for Geeks";
    }

    // Creating a public method with no arguments
    public void method1() {
        System.out.println("The string is " + s);
    }

    // Creating a public method with int as argument
    public void method2(int n) {
        System.out.println("The number is " + n);
    }

    // creating a private method
    private void method3() {
        System.out.println("Private method invoked");
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, NoSuchFieldException, InstantiationException {
        ReflectionDemo obj = new ReflectionDemo();

        // Creating class object from the object using
        // getclass method
        Class<? extends ReflectionDemo> cls = obj.getClass();
        System.out.println("The name of class is " +
                cls.getPackageName());

        // Getting the constructor of the class through the
        // object of the class
        Constructor<? extends ReflectionDemo> constructor = cls.getConstructor();
        System.out.println("The name of constructor is " +
                constructor.getName());

        System.out.println("The public methods of class are : ");

        // Getting methods of the class through the object
        // of the class by using getMethods
        Method[] methods = cls.getMethods();

        // Printing method names
        System.out.println("-------------------");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("-------------------");

        // creates object of desired method by providing the
        // method name and parameter class as arguments to
        // the getDeclaredMethod
        Method methodcall1 = cls.getDeclaredMethod("method2",
                int.class);

        // invokes the method at runtime
        methodcall1.invoke(obj, 19);

        // creates object of the desired field by providing
        // the name of field as argument to the 
        // getDeclaredField method
        Field field = cls.getDeclaredField("s");

        // allows the object to access the field irrespective
        // of the access specifier used with the field
        field.setAccessible(true);

        // takes object and the new value to be assigned
        // to the field as arguments
        field.set(obj, "JAVA");

        // Creates object of desired method by providing the
        // method name as argument to the getDeclaredMethod
        Method methodcall2 = cls.getDeclaredMethod("method1");

        // invokes the method at runtime
        methodcall2.invoke(obj);

        // Creates object of the desired method by providing
        // the name of method as argument to the 
        // getDeclaredMethod method
        Method methodcall3 = cls.getDeclaredMethod("method3");

        // allows the object to access the method irrespective 
        // of the access specifier used with the method
        methodcall3.setAccessible(true);

        // invokes the method at runtime
        methodcall3.invoke(obj);
    }
}


class DateDemo {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = sdformat.parse("06-11-2022");
        Date d2 = new Date();
        Instant i1 = d1.toInstant();
        Instant i2 = d2.toInstant();

        ZoneId zoneId = ZoneId.of("Asia/Dhaka");

        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(i1, zoneId);
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(i2, zoneId);

        YearMonth ym1 = YearMonth.from(zdt1);
        YearMonth ym2 = YearMonth.from(zdt2);

        Boolean same = ym1.isAfter(ym2);

        System.out.println(same);

//        System.out.println("The date 1 is: " + sdformat.format(d1));
//        System.out.println("The date 2 is: " + sdformat.format(d2));
//        if (d1.compareTo(new Date()) > 0) {
//            System.out.println(d1.compareTo(new Date()) > 0);
//            System.out.println("Date 1 occurs after Date 2");
//        }
//        if (d1.compareTo(d2) < 0) {
//            System.out.println(d1.compareTo(d2) < 0);
//            System.out.println("Date 1 occurs before Date 2");
//        }
//        if (d1.compareTo(d2) == 0) {
//            System.out.println("Both dates are equal");
//        }
//        if (true) {
//            System.out.println("hello");
//        }
    }
}

class SwitchDemo {
    public static void main(String[] args) {
        System.out.println("LOCAL DATE :: " + LocalDateTime.now());
        System.out.println("DATE :: " + new Date().toInstant());
        System.out.println("ZONED DATE :: " + ZonedDateTime.now());
        System.out.println("MONTH DATE :: " + MonthDay.now());
        System.out.println("MONTH DATE :: " + OffsetDateTime.now());
        System.out.println("MONTH DATE :: " + OffsetTime.now());
        System.out.println("MONTH DATE :: " + DayOfWeek.FRIDAY);
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("Canada/Ontario"));
        System.out.println("MONTH DATE :: " + currentDate);
    }
}


class ArrayDemo {
    public static void main(String[] args) {
        ArrayList<String> sList = new ArrayList<>();
        sList.add("Dragos");
        sList.add("Dhundarba");
        sList.add("Luis");
        sList.add("Solaiman");
        UpdatedArr((ArrayList<String>) sList.clone());
        System.out.println(sList);


        int a [] = new int[5];
        System.out.println(a.length);

    }

    public static void UpdatedArr(ArrayList<String> s){
        s.set(0, "update");
    }
}


class ContiguousBinArray{
    public static void main(String[] args) {
        byte[] binArr = {0,1,0};
        int inc = 0;
        for (int i = 0; i < binArr.length - 1; i++){
            System.out.println(binArr[i]);
            inc++;
        }
        System.out.println(inc);
    }
}