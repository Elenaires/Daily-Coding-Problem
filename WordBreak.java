import java.util.*;

public class WordBreak {
    public static void main(String[] args)
    {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("bed");
        arrayList.add("bath");
        arrayList.add("bedbath");
        arrayList.add("and");
        arrayList.add("beyond");

        String input = "bedbathandbeyond";

        List<String> output = wordBreak(input, arrayList);

        if(output != null) {
            for (String word : output) {
                System.out.println(word);
            }
        }
        else
        {
            System.out.println("There is no possible reconstruction");
        }

    }

    public static List<String> wordBreak(String input, List<String> words)
    {
        List<String> wordList = new ArrayList<>();

        Set<String> hashSet = new HashSet<>();

        for (String word : words)
        {
            hashSet.add(word);
        }

        int i = 0, j = 1;

        while(j <= input.length()) // with the assumption that input is never null
        {
            String substring = input.substring(i,j);
            if(hashSet.contains(substring))
            {
                wordList.add(substring);
                i = j;
            }

            j++;

        }

        if(wordList.isEmpty())
        {
            wordList = null;
        }

        return wordList;
    }
}
