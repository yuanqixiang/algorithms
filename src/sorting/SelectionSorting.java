package sorting;

public class SelectionSorting {
    public static void sort(int[] array) {
        int N = array.length;
        for (int i = 0; i < N; i ++) {
            int min = i;
            for (int j = i + 1; j < N; ++j) {
                if (array[min] > array[j]) min = j;
            }

            Utils.exchange(array, i, min);
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
