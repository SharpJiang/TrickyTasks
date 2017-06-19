import java.util.Collections;
import java.util.List;

/**
 * Created by Victor on 19.06.2017.
 */
public class Arrays {

    /*Delete duplicates from a sorted array*/
    public static int deleteDuplicates(List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }
        int writelndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            if (!A.get(writelndex - 1).equals(A.get(i))) {
                A.set(writelndex++, A.get(i));
            }
        }
        for (int symb : A) {
            System.out.print(symb + " ");
        }
        // Returns the number of valid entries after deletion
        return writelndex;
    }

    /*Permute the elementa of an array*/
    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        for (int i = 0; i < A.size(); ++i) {
        // Check if the element at index i has not been moved by checking if
        // perm.get(i) is nonnegative
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
        // Subtracts perm.sizeO from an entry in perm to make it negative,
        // which indicates the corresponding move has been performed
                perm.set(next, perm.get(next) - perm.size());
            }
        }
        // Restore perm.
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());

        }
    }

}
