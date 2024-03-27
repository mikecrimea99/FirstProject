package Package.algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array1 = {8, 0, -3, 5, 6, 9, 8, -4, 2, -99, 43};
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }
//    Основана на парадигме «разделяй и властвуй».
//    Будем делись массив пополам, пока не получим множество массивов из одного элемента.
//    После чего выполним процедуру слияния:
//    поддерживаем два указателя, один на текущий элемент первой части,
//    второй – на текущий элемент второй части.
//    Из этих двух элементов выбираем минимальный,
//    вставляем в ответ и сдвигаем указатель, соответствующий минимуму.
//    Так сделаем слияния массивов из 1го элемента в массивы по 2 элемента, затем из 2х в 4 и т.д.
//
//    Слияние работает за O(n), уровней всего log(n), поэтому асимптотика O(n*log(n)).


    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);     //создаем копию массива
        int[] buffer2 = new int[array1.length];                   //создаем пустой массив такой же длины
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    /**
     * @param buffer1    Массив для сортировки.
     * @param buffer2    Буфер. Размер должен быть равен размеру buffer1.
     * @param startIndex Начальный индекс в buffer1 для сортировки.
     * @param endIndex   Конечный индекс в buffer1 для сортировки.
     * @return
     */
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {                                 //если стартовый индекс больше или равен конечному -1
            return buffer1;                                                         // уже отсортирован.
        }

        int middle = startIndex + (endIndex - startIndex) / 2;                  //находим середину
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);
                                                                                // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}

