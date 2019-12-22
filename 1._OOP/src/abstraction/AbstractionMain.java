package abstraction;

import java.util.Arrays;

public class AbstractionMain {

    public static void main(String[] args) {

        int[] array={ 7, 4, 1, 93, 17, 41, 37};

        Sort sort = new Sort();

        sort.sort(array);

        Arrays.stream(array).forEach((n)->{
            System.out.print(n+" ");
        });
    }

}
