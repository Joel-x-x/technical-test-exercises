/**
 * Bubble Sorting
 * 
 * @param int[] array
 * @return void
 */
class Sorting {
    public static void main(String[] args) {
    int[] numeros = {5,3,6,2,3,6};

    Sorting.bubbleSort(numeros);

        for(int i = 0; i <= numeros.length - 1; i++) {
            System.out.println(numeros[i]);
        }
    }

    /**
     * Bubble Sorting
     * 
     * @param int[] array
     * @return void
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean intercambiado;
        
        for(int i = 0; i < n - 1; i++) {
            intercambiado = false;
            
            for(int j = 0; j < n - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    intercambiado = true;
                }
            }
            
            if(!intercambiado) break;
        }
    }

    /**
     * Selection Sorting
     * 
     * @param int[] array
     * @return void
     */
    public static void selectionSort(int[] array) {
        int n = array.length;

        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Quick Sorting
     * 
     * @param int[] array
     * @param int start
     * @param int end
     * @return void
     */
    public static void orderQuick(int[] array, int inicio, int fin) {
        if(inicio < fin) {
            int pivoteIndex = partitionQuick(array, inicio, fin);
            orderQuick(array,inicio, pivoteIndex - 1);
            orderQuick(array, pivoteIndex + 1, fin);
        }
    }

    public static int partitionQuick(int[] array, int inicio, int fin) {
        int pivote = array[fin];
        int i = inicio - 1;

        for(int j = inicio; j < fin; j++) {
            if(array[j] <= pivote) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;

        return i + 1;
    }

    /**
     * Merge Sorting
     * 
     * @param int[] array
     * @return void
     */
    public static void orderMerge(int[] array) {
        if(array.length <= 1) return;

        int mitad = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mitad);
        int[] right = Arrays.copyOfRange(array, mitad, array.length);

        orderMerge(left);
        orderMerge(right);

        mixedMerge(array, left, right);
    }

    public static void mixedMerge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while(i < left.length) array[k++] = left[i++];
        while(j < right.length) array[k++] = right[j++];
    }
}