package main.Sorting.Practice;

public class Practice {

    static void quick(int[] arr, int l, int r){
        int left = l;
        int right = r;
        int pivot = arr[(l+r)/2];
        do{
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }while(left<=right);
        if(l < right) quick(arr,l,right);
        if(r > left) quick(arr,left,r);
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,1,2,3,4,5,7,6,4,3,9,5,7,9,1};

        quick(arr,0,arr.length-1);

        for(int a : arr){
            System.out.println(a);
        }

    }
}
