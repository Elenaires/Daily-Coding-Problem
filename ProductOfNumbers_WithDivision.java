public class ProductOfNumbers_WithDivision {
    public static void main(String[] args)
    {
        int[] array = new int[]{3,2,1};

        int[] result = productOfNumbers(array);

        for(int i = 0; i < array.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] productOfNumbers(int[] inputArray)
    {
        int product = 1;
        int[] result = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++)
        {
            product *= inputArray[i];
        }

        for(int i = 0; i < inputArray.length; i++)
        {
            result[i] = product / inputArray[i];
        }

        return result;

    }
}
