package srp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayExample {
    // The actual code for creating an Array to hold DVD's.


    public static int[] sortedSquares(int[] nums) {
        int[] x = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
            x[i] = nums[i];
        }
        Arrays.sort(x);
        return x;
    }

    public static void main(String[] args) {
        DVD[] dvdCollection = new DVD[15];
        DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon");
        DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
        DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
        DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");

        dvdCollection[0] = avengersDVD;
        dvdCollection[4] = incrediblesDVD;
        dvdCollection[7] = findingDoryDVD;
        dvdCollection[9] = lionKingDVD;

        int[] squareNumbers = new int[10];

// Go through each of the Array indexes, from 0 to 9.
        for (int i = 0; i < 10; i++) {
            // We need to be careful with the 0-indexing. The next square number
            // is given by (i + 1) * (i + 1).
            // Calculate it and insert it into the Array at index i.
            int square = (i + 1) * (i + 1);
            squareNumbers[i] = square;
        }

        int[] value = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(sortedSquares(value)));

    }
}


// A simple definition for a DVD.
class DVD {
    public String name;
    public int releaseYear;
    public String director;

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", director='" + director + '\'' +
                '}';
    }
}