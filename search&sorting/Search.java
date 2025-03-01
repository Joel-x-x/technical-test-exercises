
public class Search {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println(lineal(array, 5)); // 5
        System.out.println(binary(array, 5)); // 5
    }

    /***
     * Realiza un busqueda lineal de un arreglo
     * 
     * @param int[] arreglo
     * @param int busqueda
     * @return int indice del valor encontrado, si no encuentra nada retorna -1
     */
    public static int lineal(int[] array, int objetivo) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == objetivo) {
                return i;
            }
        }
        
        return -1;
    }
    
    /***
     * Realiza un busqueda binaria de un arreglo ordenado
     * 
     * @param int[] arreglo
     * @param int busqueda
     * @return int indice del valor encontrado, si no encuentra nada retorna -1
     */
    public static int binary(int[] array, int objetivo) {
        int izquierda = 0, derecha = array.length - 1;
        
        while(izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if(array[medio] == objetivo) return medio;
            
            if(array[medio] < objetivo) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        
        return -1;
    }
}