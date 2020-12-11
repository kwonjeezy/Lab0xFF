package com.company;
import java.util.*;
import java.util.Arrays;
import java.lang.management.*;

public class Main {

    public static void main(String[] args) {
    int vertex =5;
    int s = 0;
	int[][] tsp = {{0, 113, 79, 30, 54, 64, 76},
            {113, 0, 100, 87, 46, 45, 35, 125},
            {79, 100, 0, 47, 11, 70, 21, 71},
            {30, 87, 47, 0, 35, 44, 68, 80},
            {54, 46, 11, 35, 0, 40, 72, 56},
            {64, 45, 70, 44, 40, 0, 62, 71},
            {76, 35, 21, 68, 72, 62, 0, 31},
            {9, 125, 71, 80, 56, 71, 31, 0}
    };

	    new greedy(tsp);
        //new BruteForce(tsp,vertex);
        // dynamic.dynamicAlg(tsp,s,vertex);


    }
    // Get CPU time in nanoseconds since the program(thread) started.
    /** from: http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking#TimingasinglethreadedtaskusingCPUsystemandusertime **/
    public static long getCpuTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadCpuTime( ) : 0L;
    }

}
