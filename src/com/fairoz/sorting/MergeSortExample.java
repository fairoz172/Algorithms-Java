package com.fairoz.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortExample {

    public static void main(String[] args) {
        List<Integer> inputArray = new ArrayList<Integer>();
        MergeSort mergeSort = new MergeSort();
        inputArray.add(8);
        inputArray.add(1);
        inputArray.add(4);
        inputArray.add(3);
        inputArray.add(6);
        inputArray.add(2);
        inputArray.add(5);
        List<Integer> sortedArray = mergeSort.sort(inputArray);
        System.out.println("Sorted Array : " + sortedArray);
    }

}

class MergeSort {

    public List<Integer> sort(List<Integer> inputArray) {
        List<Integer> mergedArray = new ArrayList<>();
        List<Integer> leftArray = null;
        List<Integer> rightArray = null;
        if (inputArray.size() <= 1) {
            return inputArray;
        } else if (inputArray.size() == 2) {
            if (inputArray.get(0) > inputArray.get(1)) {
                Integer temp = inputArray.get(0);
                inputArray.set(0, inputArray.get(1));
                inputArray.set(1, temp);
            }
            return inputArray;
        } else if (inputArray.size() % 2 == 0) {
            leftArray = inputArray.subList(0, inputArray.size() / 2);
            rightArray = inputArray.subList(inputArray.size() / 2, inputArray.size());
        } else {
            leftArray = inputArray.subList(0, (inputArray.size() + 1) / 2);
            rightArray = inputArray.subList(((inputArray.size() + 1) / 2), inputArray.size());

        }
        List<Integer> leftSortedArray = sort(leftArray);
        List<Integer> rightSortedArray = sort(rightArray);
        int i = 0;
        int j = 0;
        for (int k = 0; k < inputArray.size(); k++) {
            if (i == leftSortedArray.size()) {
                mergedArray.addAll(rightSortedArray.subList(j, rightSortedArray.size()));
                break;
            } else if (j == rightSortedArray.size()) {
                mergedArray.addAll(leftSortedArray.subList(i, leftSortedArray.size()));
                break;
            }
            if (leftSortedArray.get(i) <= rightSortedArray.get(j)) {
                mergedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                mergedArray.add(rightSortedArray.get(j));
                j++;
            }
        }
        return mergedArray;
    }
}
