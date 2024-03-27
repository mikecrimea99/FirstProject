package Package.algorithm;

import java.util.Arrays;

public class BobleSort {
    public static void main(String[] args) {
        int[] testData = {10, 4, 43, 5, 4, 67, 12, 0, 99, 19};
        System.out.println(Arrays.toString(bubbleSort(testData)));
    }

    public static int[] bubbleSort(int[] array) {
        boolean sorted = false;                              //флаг что все отсортировано
        int temp;                                            //внутреняя переменная
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {    //проход по всему массиву
                if (array[i] > array[i+1]) {                //провряем что предыдущий больше следующего
                    temp = array[i];                        //если больше то присваиваем пред.эл. временной переменной
                    array[i] = array[i+1];                  //меняем текущую переменную на следующую
                    array[i+1] = temp;                      // меняем следующую переменную на временную
                    sorted = false;                         //повторяем
                }
            }
        }
        return array;
    }
}