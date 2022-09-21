package ma.insea.comptecqrses.commands.aggregates;

import java.util.*;

class TestQuiz
{

    static int[] countFreq(int arr[], int n)
    {
        Arrays.sort(arr);
        Map<Integer, Integer> mp = new HashMap<>();
        List res = new ArrayList();
        // Traverse through array elements and
        // count frequencies
        for (int i = 0; i < n; i++)
        {
            if (mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else
            {
                mp.put(arr[i], 1);
            }
        }
        // Traverse through map and print frequencies
        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
            res.add(entry.getValue());
        }
         return res.stream().mapToInt(i->(int)i).toArray();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        System.out.println(Arrays.toString(countFreq(arr, n)));
    }
}

// This code contributed by Rajput-Ji