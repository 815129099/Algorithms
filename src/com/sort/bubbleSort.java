package com.sort;

public class bubbleSort {

    /**原始冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static int[] sort(int[] arr){
        SortUtil.showStartTime("bubbleSort.sort");
        int temp;
        int num = arr.length;
        for (int i=0;i<num-1;i++){
            for(int j=0;j<num-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        SortUtil.showEndTime();
        return arr;
    }


    /**
     * 改进-：
     * 针对【5,4,6,7,8,9,10】这样的数组，一次冒泡就排好序了，按照原始的冒泡排序，程序会继续遍历，直到遍历完才会结束
     * 这无疑是极大的时间浪费
     * 改进方法：
     * 如果一次冒泡排序中，没有进行交换，说明数组已经有序了，则跳出循环
     * 设定一个标准位，在交换时进行赋值，一次冒泡后进行判断，如果数值有变则无序，否则有序
     */
    public static int[] wellSort(int[] arr){
        //显示程序开始执行时的时间戳
        SortUtil.showStartTime("bubbleSort.wellSort");
        int temp;
        int num = arr.length;

        //标志位
        boolean isSort;

        for (int i=0;i<num-1;i++){
            //默认有序
            isSort = true;
            for(int j=0;j<num-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //如果交换，则改成无序
                    isSort = false;
                }
            }

            //一次冒泡之后，进行判断,如果isSort=true，则没有进行交换，跳出循环
            if(isSort){
                break;
            }
        }
        //显示程序执行需要的时间
        SortUtil.showEndTime();
        return arr;
    }

    /**
     * 改进二：
     * 针对【2,5,4,1,7,8,9,10】这样的数组，后面7,8,9,10已经有序了，按照前面两个算法会重复遍历这四个数的一部分，造成资源浪费
     *
     * 改进方法：
     * 设置一个下标，在每次遍历中，用于记录最后一次交换的数组下标
     * 下一次冒泡。遍历到该下标即可
     *
     */
    public static int[] betterSort(int[] arr){
        //显示程序开始执行时的时间戳
        SortUtil.showStartTime("bubbleSort.betterSort");
        int temp;
        int num = arr.length;
        //标志位
        boolean isSort;
        //下标,用户代替内循环的结束条件，j<index
        int endIndex = num-1;
        int endPos = 0;//用于记录下标，一次冒泡后赋值给Index

        for (int i=0;i<num-1;i++){
            //默认有序
            isSort = true;
            for(int j=0;j<endIndex;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //如果交换，则改成无序
                    isSort = false;
                    endPos = j;
                }
            }

            //一次冒泡之后，进行判断,如果isSort=true，则没有进行交换，跳出循环
            if(isSort){
                break;
            }
            //更新下标，下标之后的没有进行交换，已经有序，下次遍历该下标之前的即可
            endIndex = endPos;
        }
        //显示程序执行需要的时间
        SortUtil.showEndTime();
        return arr;
    }


    /**
     * 改进三：
     * 针对【1,2,3,6,5,4,1,7,8,9,10】这样的数组，后面7,8,9,10有序前面已经改进过了，那么前面的1,2,3也已经有序了，是不是也可以改进一下？
     *
     * 改进方法：
     * 设置一个下标，在外循环里面进行两次遍历，
     * 第一次是从前往后，选出最大的值，并记录后面有序的下标
     * 第二次是从后往前，选出最小的值，并记录前面有序的下标
     * 下一次冒泡。遍历两个下标之间的即可
     *
     */
    public static int[] bestSort(int[] arr){
        //显示程序开始执行时的时间戳
        SortUtil.showStartTime("bubbleSort.bestSort");
        int temp;
        int num = arr.length;
        //标志位
        boolean isSort;
        //下标,用户代替内循环的结束条件，j<index
        int endIndex = num-1;
        int endPos = 0;//用于记录下标，一次冒泡后赋值给Index

        int startIndex =1;
        int startPos =0;
        for (int i=0;i<num-1;i++){
            //默认有序
            isSort = true;
            for(int j=0;j<endIndex;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //如果交换，则改成无序
                    isSort = false;
                    endPos = j;
                }
            }

            //一次冒泡之后，进行判断,如果isSort=true，则没有进行交换，跳出循环
            if(isSort){
                break;
            }
            //更新下标，下标之后的没有进行交换，已经有序，下次遍历该下标之前的即可
            endIndex = endPos;

            isSort = true;
            for(int k=endIndex;k>=startIndex;k--){
                if(arr[k]<arr[k-1]){
                    temp = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = temp;
                    startPos = k;
                    isSort = false;
                }
            }

            //一次冒泡之后，进行判断,如果isSort=true，则没有进行交换，跳出循环
            if(isSort){
                break;
            }
            startIndex = startPos;

        }
        //显示程序执行需要的时间
        SortUtil.showEndTime();
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------"+10000+"----------------------------------");
        SortUtil.show(sort(SortUtil.getArray(50000)));
        System.out.println("-------------------------"+50000+"----------------------------------");
        SortUtil.show(wellSort(SortUtil.getArray(50000)));
        System.out.println("-------------------------"+50000+"----------------------------------");
        SortUtil.show(betterSort(SortUtil.getArray(50000)));
        System.out.println("-------------------------"+50000+"----------------------------------");
        SortUtil.show(bestSort(SortUtil.getArray(50000)));

        // System.out.println("-------------------------"+100000+"----------------------------------");
        //  SortUtil.show(sort(SortUtil.getArray(100000)));
        //  System.out.println("-------------------------"+100000+"----------------------------------");
        //  SortUtil.show(betterSort(SortUtil.getArray(100000)));
    }
}
