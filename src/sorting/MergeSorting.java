package sorting;

public class MergeSorting {
    private static int[] aux;

    public void sort(int[] array) {
        int length = array.length;
        aux = new int[length];
        sortTopDown(array, 0, length - 1);
        //sortDownTop(array);
    }

    public void sortDownTop(int[] array) {
        int length = array.length;
        for (int sz = 1; sz < length; sz *= 2) {
            for (int lo = 0; lo < length - sz; lo += 2 * sz) {
                merge(array, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, length - 1));
            }
        }
    }


    public void sortTopDown(int[] array, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sortTopDown(array, lo, mid);
        sortTopDown(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private static void merge(int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; ++k) {
            aux[k] = array[k];
        }

        for (int k = lo; k <= hi; ++k) {
            if (i > mid)                array[k] = aux[j++];
            else if (j > hi)            array[k] = aux[i++];
            else if (aux[j] < aux[i])   array[k] = aux[j++];
            else                        array[k] = aux[i++];
        }

    }
}
