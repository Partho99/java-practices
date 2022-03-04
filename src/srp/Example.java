package srp;

import java.util.List;
import java.util.Random;

public class Example {
}

interface Pet {
    public void test();
}

class Dog implements Pet {
    public void test() {
        System.out.println("Dog is a pet (Dog class implement pet interface)");
    }

    public static void main(String args[]) {
        Pet p = new Dog();
        p.test();
    }
}

abstract class Shape {
    int b = 20;

    abstract public void calculateArea();
}

class Rectangle extends Shape {
    public static void main(String args[]) {
        Rectangle obj = new Rectangle();
        obj.b = 200;
        obj.calculateArea();
    }

    public void calculateArea() {
        System.out.println("Area is " + (b * b));
    }
}


class RandomClassExample {
    public static void main(String args[]) {
        int min = 1;
        int max = 10;

        Random random = new Random();
        System.out.println(random.ints(min, max)
            .findFirst()
            .getAsInt());

    }
}

class Player implements java.io.Serializable {

    /** Properties **/
    private boolean deceased = false;

    private List list;

    /** Property "name", readable/writable. */
    private String name = null;

    /** No-arg constructor (takes no arguments). */
    public Player() {
    }

    public List getList() {
        return list;
    }

    public void setList(final List list) {
        this.list = list;
    }

    /**
     * Getter for property "name".
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property "name".
     *
     * @param value
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Getter for property "deceased"
     * Different syntax for a boolean field (is v.s. get)
     */
    public boolean isDeceased() {
        return deceased;
    }

    /**
     * Setter for property "deceased".
     * @param value
     */
    public void setDeceased(boolean value) {
        deceased = value;
    }
}
