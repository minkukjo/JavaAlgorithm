package main.Array.KthSmallestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
    정렬되지 않은 배열에서 K번째 수를 찾는 알고리즘
    QuickSort를 응용한 QuickSort라고 불린다.
    QuickSort처럼 Pivot보다 작은 값을 왼쪽으로 몰아버린다.
    그렇게 하면 현재 Pivot보다 작은 값들이 왼쪽에 자리 잡게되며 Pivot의 위치는 K번째 작은 위치에 있을 것이다.
    이때 Pivot의 위치를 반환하고 Pivot의 위치가 찾으려는 K번째와 같은지 비교해서 같다면 해당 값을,
    Pivot의 인덱스가 찾으려는 값보다 작다면 PivotIndex +1한 값부터 현재 최대 인덱스까지 찾아본다.
    반대의 경우라면 현재 위치 부터 PivotIndex -1 까지 찾아본다.
    마치 QuickSort의 파티셔닝 재귀처럼 작동한다.
 */

public class KthSmallestNumber {

    public static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int pivotloc = low;

        for(int i=low; i<=high; i++){
            if(arr[i] < pivot){
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }

        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }

    public static int quickSelect(int[] arr, int low,int high, int k){
        int partition = partition(arr,low,high);

        if(partition == k) return arr[partition];
        else if(partition < k) return quickSelect(arr,partition+1,high,k);
        else return quickSelect(arr,low,partition-1,k);
    }
    public static void main(String[] args) {
        int[] arr = {4,7,8,9,1,3,2};

        System.out.println(quickSelect(arr,0,arr.length-1,3));


    }
}
