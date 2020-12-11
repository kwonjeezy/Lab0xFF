package com.company;
import java.util.*;
import java.util.Arrays;
import java.lang.management.*;
import java.util.Stack;
import java.util.Collections;

public class greedy {
//using https://medium.com/ivymobility-developers/algorithm-a168afcd3611 as reference

    greedy(int[][] greedyTsp){
        int sum =0;
        int i = 0;
        int j =0;
        int counter =0;
        int min = Integer.MAX_VALUE;
        //creating a list to create the correct list of min variable.
        List<Integer> RouteList = new ArrayList<>();
        //adds the initial route start.
        RouteList.add(0);
        //an array to get hold the nodes that have been accessed.
        int[] route = new int[greedyTsp.length];
        while (counter<(greedyTsp.length-1)){

            //if the program gets to a corner of the matrix then it will break
            if(counter >= greedyTsp[i].length){
                break;
            }
            //next the program will check if the path is visited or not.
            if(j!=i && !RouteList.contains(j)){
                //after it will check to see if it is cheaper than the surrounding nodes.
                // if it does cost less then it will be added to the array, and the cost will be added as well
                if(greedyTsp[i][j]<min){
                    min = greedyTsp[i][j];
                    route[counter] = j+1;
                }
            }
            j++;
            //next it will check all paths for the city that is currently indexed.
            if(j==greedyTsp[i].length){
                sum +=min;
                min = Integer.MAX_VALUE;
                RouteList.add(route[counter]-1);
                j= 0;
                i = route[counter]-1;
                counter++;

            }
        }


        for(j = 0;j<greedyTsp.length;j++){
            if((i!=j) && greedyTsp[i][j]<min){
                min = greedyTsp[i][j];
                route[counter] =j+1;
            }

        }
/*
        for(int p = 0;p<greedyTsp.length;p++){
            System.out.print(route[p] + " ");
        }

 */
        sum +=min;
        System.out.println("Min cost: " +sum);
    }
}
