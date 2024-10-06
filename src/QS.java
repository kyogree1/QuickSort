import java.util.Arrays;

public class QS {

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];  // Choosing the last element as the pivot
        int i = left - 1;  // i marks the "split" point for the smaller elements

        System.out.println("Partitioning array: " + Arrays.toString(arr));
        System.out.println("Pivot: " + pivot);
        System.out.println("Left range: " + Arrays.toString(Arrays.copyOfRange(arr, left, right)));
        System.out.println("");

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("Swap: " + arr[j] + " with " + arr[i]);
                System.out.println("Array after swap: " + Arrays.toString(arr));
                System.out.println("Smaller than pivot: " + Arrays.toString(Arrays.copyOfRange(arr, left, i + 1)));
                System.out.println("Larger or unsorted part: " + Arrays.toString(Arrays.copyOfRange(arr, i + 1, right)));
                System.out.println("");
            }
        }

        // Final swap of pivot to its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        System.out.println("Placing pivot in position: Swapped " + arr[i + 1] + " with " + arr[right]);
        System.out.println("Array after placing pivot: " + Arrays.toString(arr));
        System.out.println("");

        return i + 1;  // Return the partition index
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {
            System.out.println("Sorting array: " + Arrays.toString(array));
            System.out.println("Range: " + low + " to " + high);
            System.out.println("");

            int pi = partition(array, low, high);  // Get partition index

            quickSort(array, low, pi - 1);  // Recursively sort elements before partition
            quickSort(array, pi + 1, high); // Recursively sort elements after partition
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 2, 8, 9, 5, 0, 3, 7};
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("");


        long awal = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);  // Start the quicksort process
        long akhir = System.currentTimeMillis();
        long waktu = akhir - awal;
        System.out.println("");
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("waktu ;" + waktu);
    }
}