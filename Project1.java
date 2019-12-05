
import java.util.*;

public class Project1 {

    public static void main(String[] args) {

        System.out.println("The Egg-drop program by Michael Merabi is now starting");
        Scanner input = new Scanner (System.in);
        int floors, eggs;

        System.out.println("Please enter in the number of floors");
        floors = input.nextInt();
        System.out.println("Please enter in the number of eggs");
        eggs = input.nextInt();

        System.out.println("The minimum number of trials in a worst case scenario is "+ eggDrop(eggs,floors));



    }
    //n eggs     k floors
    static int eggDrop (int eggs, int floors){
        int eggFloor[][] = new int[eggs+1][floors+1]; //2D array to hold the minimum # of trials
        int i, j, x;
        int res;

        for (i = 1; i <= eggs; i++){ //If only 1 or 0 floors, doesn't matter how many eggs
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (j = 1; j <= floors; j++){ //If only one egg, minimum = floors
            eggFloor[1][j] =  j;
        }

        for (i = 2; i <= eggs; i++){ //Start creating the 2D array

            for (j = 2; j <= floors; j++){
                eggFloor[i][j] = Integer.MAX_VALUE;

                for (x = 1; x <= j; x++){
                    res = 1+ max(eggFloor[i-1][x-1], eggFloor[i][j-x]);

                    if (res < eggFloor [i][j]){
                        eggFloor[i][j] = res;
                    }

                }
            }
        }


        return eggFloor[eggs][floors];
    }

    static int max(int a, int b){ //function to return the max of two ints
        if (a > b){
            return a;
        } else {
            return b;
        }
    }


}
