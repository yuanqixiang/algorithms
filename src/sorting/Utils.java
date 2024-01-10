package sorting;

public class Utils {
    public static void exchange(int[] array, int i, int j) {
        int N = array.length;
        assert i >= 0 && i < N && j >= 0 && j < N && i != j;
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
