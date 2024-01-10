package sorting;

public class InsertionSorting {
    public static void sort(int[] array) {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 1 && array[j] < array[j - 1]; j -= 1) {
                Utils.exchange(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,2,5,4,2,1,7,3,9,3};
        sort(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
