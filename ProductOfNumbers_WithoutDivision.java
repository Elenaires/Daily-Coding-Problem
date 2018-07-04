// without division

public class ProductOfNumbers_WithoutDivision {
    public static void main(String[] args)
    {
        int[] array = new int[]{3,2,1};
        int[] newArray = productOfNumbers(array);

        for(int i = 0; i < newArray.length; i++)
        {
            System.out.print(newArray[i] + " ");
        }

    }

    public static int[] productOfNumbers(int[] inputArray)
    {
        int length = inputArray.length;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        int[] result = new int[length];

        // prefix multiplication of inputArray from left to right
        for(int i = 0; i < length; i++)
        {
            if(i != 0)
            {
                arr1[i] = inputArray[i] * arr1[i-1];
            }
            else
            {
                arr1[i] = inputArray[i];
            }
        }

        // prefix multiplication of inputArray from right to left
        for(int i = length-1; i >= 0; i--)
        {
            if(i != length-1)
            {
                arr2[i] = inputArray[i] * arr2[i+1];
            }
            else
            {
                arr2[i] = inputArray[i];
            }
        }

        // populate result based on arr2[i+1] * arr1[i-1] provided they are within bounds
        for(int i = 0; i < length; i++)
        {
            if(i-1 < 0) // out of bounds for arr1 - substitute with 1
            {
                result[i] = arr2[i+1] * 1;
            }
            else if(i+1 >= length) // out of bounds for arr2 - substitute with 1
            {
                result[i] = 1 * arr1[i-1];
            }
            else
            {
                result[i] = arr2[i+1] * arr1[i-1];
            }
        }

        return result;

    }
}



