package sorting;

public class ShellSorting {
    public static int get(int N) {
        int h = 1;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        while (h < N / 3) h = 3 * h + 1;
        return h;
    }
    public static void sort(int[] array) {
        int N = array.length;
        System.out.println("N= " + N);
        int h = 1;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            System.out.println("h= " + h);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    Utils.exchange(array, j, j - h);
                }
                /*
                for (int i = 1; i < N; i++) {
                    for (int j = i; j >= 1 && array[j] < array[j - 1]; j -= 1) {
                        Utils.exchange(array, j, j - 1);
                    }
                }
                 */
            }

            h /= 3;
        }
    }

    public static void sort1(int[] array) {
        int N = array.length;
        System.out.println("N= " + N);

        for (int h = N / 2; h >= 1; h /= 2) {
            System.out.println("h= " + h);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    Utils.exchange(array, j, j - h);
                }
                /*
                for (int i = 1; i < N; i++) {
                    for (int j = i; j >= 1 && array[j] < array[j - 1]; j -= 1) {
                        Utils.exchange(array, j, j - 1);
                    }
                }
                 */
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,2,5,4,2,1,7,3,9,3,8,6,10,11,9};
        sort1(array);
        for (int j : array) {
            System.out.print(j + " ");
        }

        /*
        for (int N = 1; N < 100; ++N) {
            System.out.println("N= " + N + ", h= " + get(N));
        }

         */
    }
}
