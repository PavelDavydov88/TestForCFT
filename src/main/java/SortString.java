public class SortString  {

    public static String[] doSortA(String[] array) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }

        String[] arrayB = new String[array.length / 2];
        System.arraycopy(array, 0, arrayB, 0, array.length / 2);

        String[] arrayC = new String[array.length - arrayB.length];
        System.arraycopy(array, arrayB.length, arrayC, 0, array.length - arrayB.length);

        doSortA(arrayB);
        doSortA(arrayC);

        mergeArray(array, arrayB, arrayC);

        return array;
    }

    private static void mergeArray(String[] array, String[] arrayB, String[] arrayC) {

        int positionB = 0;
        int positionC = 0;

        for (int c = 0; c < array.length; c++) {
            if (positionB == arrayB.length) {
                array[c] = arrayC[positionC];
                positionC++;
            } else if (positionC == arrayC.length) {
                array[c] = arrayB[positionB];
                positionB++;
            } else if (arrayB[positionB].compareTo(arrayC[positionC]) < 0) {
                array[c] = arrayB[positionB];
                positionB++;
            } else {
                array[c] = arrayC[positionC];
                positionC++;
            }
        }
    }

    public static String[]  doSortD(String[] array) {
        String[]  arraysortD =  new String [array.length];
        String [] arraysortA = doSortA(array);
        int j = 0;
        for (int i = arraysortA.length-1; i >= 0; i--) {
            arraysortD[j] = arraysortA[i];
            j++;
        }
        return arraysortD;
    }

}
