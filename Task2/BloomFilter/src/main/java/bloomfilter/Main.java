package bloomfilter;

import java.util.Arrays;

import static com.sangupta.murmur.Murmur3.hash_x86_32;

public class Main {
    //Source link: https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/
    public static void main(String[] args) {
        String[] arr = {
                "Test", "Haha", "Juhu", "Morten", "Tabel", "Bloom", "Filter", "Hest"
        };
        String[] arrToFind = {
                "No", "Haha", "Jubiii", "Morten", "Test", "Hurra", "Fodbold"
        };
        final int numberElements = arr.length;
        final double falsePositivePercent = 0.05;
        final int size = getSize(numberElements, falsePositivePercent);
        final int numberOfHashFunctions = getHashFunctions(size, numberElements);
        boolean[] bitArray = new boolean[size];

        for (String s : arr) {
            long[] addArr = add(bitArray, s, numberOfHashFunctions, size);
            Arrays.sort(addArr);
            System.out.println("Indexes for string: " + s);
            for (int i = 0; i < addArr.length; i++) {
                System.out.println(addArr[i]);
            }
            System.out.println("********************");
        }

        for (String s2 : arrToFind) {
            System.out.print("Status for string: " + s2 + " - ");
            boolean status = check(bitArray, s2, numberOfHashFunctions, size);
            if(status)
            {
                System.out.println("Probably there.");
            } else
            {
                System.out.println("Definitely not there!");
            }
        }
    }

    public static int getSize(int elements, double falsePositive)
    {
        return (int) Math.floor(
                -(elements * Math.log(falsePositive))
                        / (Math.pow(Math.log(2), 2)));
    }

    //Source Link: https://en.wikipedia.org/wiki/Bloom_filter
    public static int getHashFunctions(int sizeBitArray, int numberOfElements)
    {
        return (int) ((sizeBitArray/numberOfElements) * Math.log(2));
    }

    public static long[] add(boolean[] bitArray, String element, int numberOfHashFunctions, int size)
    {
        long[] indexes = new long[numberOfHashFunctions];
        for (int i = 0; i < numberOfHashFunctions; i++) {
            long elementIndex = hash_x86_32(element.getBytes(), element.length(), i) % size;
            indexes[i] = elementIndex;
            bitArray[(int) elementIndex] = true;
        }
        return indexes;
    }

    public static boolean check(boolean[] bitArray, String element, int numberOfHashFunctions, int size)
    {
        for (int i = 0; i < numberOfHashFunctions; i++) {
            long elementIndex = hash_x86_32(element.getBytes(), element.length(), i) % size;
            if(bitArray[(int) elementIndex] != true)
            {
                return false;
            }
        }
        return true;
    }
}
