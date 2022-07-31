package day0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        List<List<Integer>> inputArray = arr;
        int i=0; int j= 0;
        List<List<Integer>> listOfSumList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        for(i=0; i<=3; i++){
            for (j=0; j<=3; j++){
                int a = arr.get(i).get(j);
                int b = arr.get(i).get(j+1);
                int c = arr.get(i).get(j+2);
                int d = arr.get(i+1).get(j+1);
                int e = arr.get(i+2).get(j);
                int f = arr.get(i+2).get(j+1);
                int g = arr.get(i+2).get(j+2);
                int sum = a+b+c+d+e+f+g;
                sumList.add(sum);
                System.out.println("each time sum : " + sum);
            }
            listOfSumList.add(sumList);
            System.out.println("sumList" + sumList);
            sumList = new ArrayList<>();

        }
        System.out.println("listOfSumList : " + listOfSumList);
        List<Integer> listOfMax = new ArrayList<>();
        listOfSumList.forEach(x -> {
             int max = x.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
             listOfMax.add(max);
        });
        int OutPut = listOfMax.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

        return OutPut;
    }

}

public class HourGlassProblem {
    public static void main(String[] args) throws IOException {

        List<List<Integer>> arr = new ArrayList<>();
                arr.add(List.of(1, 1, 1, 0, 0, 0));
                arr.add(List.of(0, 1, 0, 0, 0, 0));
                arr.add(List.of(1, 1, 1, 0, 0, 0));
                arr.add(List.of(0, 0, 2, 4, 4, 0));
                arr.add(List.of(0, 0, 0, 2, 0, 0));
                arr.add(List.of(0, 0, 1, 2, 4, 0));


        System.out.println("Input \n"+ arr);
        int result = Result.hourglassSum(arr);
        System.out.println("ARResult : \n"+result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

