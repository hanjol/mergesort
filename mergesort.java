public class mergesort {
    public static int[] mergesort(int[] unsorted)
    {
        int[] sorted = unsorted;

        if(unsorted.length == 1)
        {
            return sorted;
        }

        int end = unsorted.length;

        int mid = unsorted.length/2;

        int[] array1 = new int[mid];

        System.arraycopy(unsorted, 0, array1, 0, mid);

        int[] array2 = new int[end-mid];

        System.arraycopy(unsorted, mid, array2, 0, end-mid);

        sorted = mergesort(array1,array2);

        return sorted;
    }
    public static int[] mergesort(int[] array1, int[] array2)
    {
        if((array1.length == 1) && (array2.length == 1))
        {
            if(array1[0] < array2[0])
            {
                return concat(array1, array2);
            }
            else
            {
                return concat(array2, array1);
            }
        }

        if((array1.length == 1) && (array2.length > 1))
        {
            int end = array2.length;

            int mid = array2.length/2;

            int[] array21 = new int[mid];

            System.arraycopy(array2, 0, array21, 0, mid);

            int[] array22 = new int[end-mid];

            System.arraycopy(array2, mid, array22, 0, end-mid);

            array2 = mergesort(array21,array22);

            if(array1[0] < array2[0]) {
                return concat(array1, array2);
            }
            else{
                int temp = array2[0];
                array2[0] = array1[0];
                array2 = mergesort(array2);
                return concat(temp, array2);
            }
        }

        if((array1.length > 1) && (array2.length == 1))
        {
            int end = array1.length;

            int mid = array1.length/2;

            int[] array11 = new int[mid];
            System.arraycopy(array1, 0, array11, 0, mid);

            int[] array12 = new int[end-mid];
            System.arraycopy(array1, mid, array12, 0, end-mid);

            array1 = mergesort(array11,array12);

            if(array2[0] < array1[0]) {
                return concat(array2, array1);
            }
            else{
                int temp = array1[0];
                array1[0] = array2[0];
                array1 = mergesort(array1);
                return concat(temp, array1);
            }
        }

        if((array1.length > 1) && (array2.length > 1))
        {
            int end1 = array1.length;

            int mid1 = array1.length/2;

            int[] array11 = new int[mid1];
            System.arraycopy(array1, 0, array11, 0, mid1);

            int[] array12 = new int[end1-mid1];
            System.arraycopy(array1, mid1, array12, 0, end1-mid1);

            array1 = mergesort(array11,array12);

            int end2 = array2.length;

            int mid2 = array2.length/2;

            int[] array21 = new int[mid2];
            System.arraycopy(array2, 0, array21, 0, mid2);

            int[] array22 = new int[end2-mid2];
            System.arraycopy(array2, mid2, array22, 0, end2-mid2);

            array2 = mergesort(array21,array22);

            int total_length = array1.length+array2.length;

            int[] sorted = new int[total_length];

            int last1 = array1.length-1;

            int last2 = array2.length-1;

            int current = 0;

            int a1index = 0;

            int a2index = 0;

            int i;

            for(i = 0; i < sorted.length; i++) {

                if (a1index > last1) {
                    current = 1;
                    break;
                }
                if (a2index > last2) {
                    current = 2;
                    break;
                }

                if (array1[a1index] <= array2[a2index]) {
                    sorted[i] = array1[a1index];
                    a1index++;
                } else {
                    sorted[i] = array2[a2index];
                    a2index++;
                }
            }

            if(current == 1) {
                System.arraycopy(array2, a2index, sorted, i, end2-a2index);
            }
            if(current == 2) {
                System.arraycopy(array1, a1index, sorted, i, end1-a1index);
            }

            return sorted;
        }

        System.out.println("Error");
        return array1;
    }

    public static int[] concat(int[] array1, int[] array2)
    {
        int[] array = new int[array1.length+array2.length];
        System.arraycopy(array1,0,array,0,array1.length);
        System.arraycopy(array2,0,array,array1.length,array2.length);
        return array;
    }
    public static int[] concat(int integer, int[] array1)
    {
        int[] array = new int[array1.length+1];
        array[0] = integer;
        System.arraycopy(array1,0,array,1,array1.length);
        return array;
    }

    /***
     * these methods are unused and are meant for development purposes only
     ***

    public static int[] concat(int[] array1, int integer)
    {
        int[] array = new int[array1.length+1];
        System.arraycopy(array1,0,array,0,array1.length);
        array[array1.length] = integer;
        return array;
    }

    public static void print(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    ***/
}
