package com.company;

public class BruteForce {
    private int lCost = Integer.MAX_VALUE;
    public int vertice=0;

    BruteForce(int[][] matrix, int v) {
        vertice = v;
        int[]lowPath = new int[v];
        int[] n = new int[v];
        int length = 0;
        int radix = v - 1;
        //will add the amount of nodes.
        for (int i = 0; i < v; i++) {
            n[i] = i;
        }
        //will use the permute to understand the lowest path.
        permute(matrix,n,length,radix);

        for(int i = 0; i<v;i++){
            System.out.print(lowPath[i]+" ");
        }

    }
    //this function will calculate the lowest cost for the brute force algorithm.
    public  int calcCost(int[][]matrix, int[]node){

        int cost = 0;
        for(int i =0; i<vertice;i++){
            //if the the current i value is equal to (vertice-1) then the cost will be added to the
            //to the matrix of node[i] and 0
            if(i==vertice-1){
                cost +=matrix[node[i]][node[0]];
            }
            else{
                //otherwise the cost will be at node[i] & i+1;
                cost +=matrix[node[i]][node[i+1]];
            }
        }
        return cost;
    }
            private void permute(int[][]matrix,int[] n, int l, int r)
            {
                //permute will use the existing matrix and the node array.
                int cost = calcCost(matrix,n);
                //if the left and right side of the array are equal to each other; then that is teh lowest cost.
                if (l == r)
                    lCost=cost;
                else
                {
                    //otherwise it will run this for loop, which is swapping the nodes with each other.
                    for (int i = l; i <= r; i++)
                    {
                        n = swap(n,l,i);
                        //after the nodes are swapped the permute will run again.
                        permute(matrix,n, l+1, r);
                        //and then n will equal the swap array.
                        n = swap(n,l,i);
                    }
                }
            }

            public int[] swap(int[] n, int i, int j)
            {
                //swaps the nodes.
                int temp;
                int[] Node = n;
                temp = n[i] ;
                n[i] = n[j];
                n[j] = temp;
                return Node;
            }

        }
