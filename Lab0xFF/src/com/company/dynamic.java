package com.company;
import java.util.*;
import java.util.Arrays;
import java.lang.management.*;
   public class dynamic {
      public static int dynamicAlg(int[][] graph, int s, int v) {

         ArrayList<Integer> vertex = new ArrayList<Integer>();

         //creates a for loop that will add a new node to the vertex array list for the amount of vertices given.
         for (int i = 0; i < v; i++)
            if (i != s) vertex.add(i);

         int min_path = Integer.MAX_VALUE;

         //this segment of code will run for as long as the find next function is true.
         //so for all values in the data group.
         do {

            int cPath= 0;

            int k = s;
            //for loop that will run for the entire vertex size
            for (int i = 0;i < vertex.size(); i++) {
               //will add to the current path, the graph @ k and vertex[i]
               cPath += graph[k][vertex.get(i)];
               k = vertex.get(i);
            }
            //will add to the current path graph @ k,s
            cPath += graph[k][s];

            //will locate the minimum path.
            min_path = Math.min(min_path, cPath);

         } while (findNext(vertex));
         //return the min path available.
         return min_path;
      }

      //creates a function to swap the list out.
      public static ArrayList<Integer> swap(ArrayList<Integer> data, int l, int r) {
         //creates an integer for temporary data.
         int temporaryData = data.get(l);
         //set the data to the right and left side of the arrayList
         data.set(l, data.get(r));
         data.set(r, temporaryData);
         //return the data which will be used in the dynamic algorithm.
         return data;
      }
      //similar to the swap function the reverse function will reverse the array list.
      public static ArrayList<Integer> reverse(ArrayList<Integer> data, int left, int right)
      {
         //creates while loop which will look at the left side and if it smaller than the right then the data will set
         //the left++ and the right--.
         while (left < right)
         {
            int temp = data.get(left);
            data.set(left++, data.get(right));
            //a temporary data point as too not lose the data point.
            data.set(right--, temp);
         }

         return data;
      }
      int dynamic(int[][] graph, int s, int v) {

         ArrayList<Integer> vertex = new ArrayList<Integer>();

         //creates a for loop that will add a new node to the vertex array list for the amount of vertices given.
         for (int i = 0; i < v; i++)
            if (i != s) vertex.add(i);

         int min_path = Integer.MAX_VALUE;

         //this segment of code will run for as long as the find next function is true.
         //so for all values in the data group.
        do {

            int cPath= 0;

            int k = s;
            //for loop that will run for the entire vertex size
            for (int i = 0;i < vertex.size(); i++) {
               //will add to the current path, the graph @ k and vertex[i]
               cPath += graph[k][vertex.get(i)];
               k = vertex.get(i);
            }
            //will add to the current path graph @ k,s
            cPath += graph[k][s];

            //will locate the minimum path.
            min_path = Math.min(min_path, cPath);

         } while (findNext(vertex));
      //return the min path available.
         return min_path;
      }

   public static boolean findNext(ArrayList<Integer> data) {
      //so if the data has less than or equal to one node then the program will finish
      if (data.size() <= 1)
         return false;

      int last = data.size() - 2;

      //creates a while loop so that to create a break if the last is less then the last +1.
      while (last >= 0) {
         if (data.get(last) < data.get(last + 1)) {
            break;
         }
         last--;
      }

      if (last < 0)
         return false;

      int nextGreater = data.size() - 1;
      //creates a for loop for 5o check the data size
      for (int i = data.size() - 1; i > last; i--) {
         if (data.get(i) > data.get(last)) {
            //and will get the next greater.
            nextGreater = i;
            break;
         }
      }

      data = swap(data, nextGreater, last);

      data = reverse(data, last + 1, data.size() - 1);

      return true;
   }

}
