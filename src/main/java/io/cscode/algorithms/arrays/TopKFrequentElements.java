package io.cscode.algorithms.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequentElements {


    /**
     *  First, store the mapping of number -> number of times it appeared into a HashMap
     *  Second, sort the entries of HashMap using the values (number of times a number is appeared)
     *  Then, take last K elements
     */
    static int[] usingSorting(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.of(nums).forEach(num->map.merge(num, 1, Integer::sum));
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        for(int i=0; i<k; i++) {
            ans[i] = list.get(list.size()-1-i).getKey();
        }
        return ans;
    }

    /**
     *
     * First, store the mapping of number -> number of times it appeared into a HashMap
     * Next, Crate a Min Heap (default Java Priority Queue is Min heap, i.e. at top it keeps min element and children are greater than parent)
     * Then, loop through entries of HashMap and add it to PriorityQueue, if it is reaches size 'k' then poll, by the end will  have top k elements
     */
    static int[] usingHeap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.of(nums).forEach(num->map.merge(num, 1, Integer::sum));
        final PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        map.entrySet().forEach(entry->{
            minHeap.offer(entry);
            if(minHeap.size() >k) {
                minHeap.poll();
            }
        });
        int[] result = new int[k];
        for(int i=0;i<k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }


    /**
     * Using QuickSelect algorithm
     */
    static int[] usingQuickSelect(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.of(nums).forEach(num->map.merge(num, 1, Integer::sum));
        Map.Entry<Integer, Integer>[] entries= map.entrySet().toArray(new Map.Entry[0]);
        // we are passing k as entries.length - k, because we need last k elements
        selectTopKFrequent(entries, 0, entries.length-1, entries.length-k); //entries wil be updated by reference
        int[] result = new int[k];
        for(int i=0; i<k; i++) { // take last k elements from array
            result[i] = entries[entries.length-1-i].getKey();
        }
        return result;
    }

    static void selectTopKFrequent(Map.Entry<Integer, Integer>[] entries, int left, int right, int k) {
        if(left == right) {
            return;
        }

        int storeIndex = partition(entries, left, right);

        if(storeIndex == k) {
            //k is positioned at the right place
            return;
        } else if (k< storeIndex) { // if K is smaller than current pivot, move to the left
            selectTopKFrequent(entries, left, storeIndex -1, k);
        } else {
            selectTopKFrequent(entries, storeIndex+1, right, k);
        }
    }

    static int partition(Map.Entry<Integer, Integer>[] entries, int left, int right) {

        Map.Entry<Integer, Integer> pivotIndexElement = entries[right]; //we are choosing right index to be pivot index, but we can select any random one
        int storeIndex = left;
        for(int i=left;i<right; i++) {
            if(entries[i].getValue() < pivotIndexElement.getValue()) {
                // swap these entries
                swap(entries, i, storeIndex);
                storeIndex++;
            }
        }
        swap(entries, right, storeIndex); // move pivot to its final place, meaning that,
                                            // left side elements are now smaller than pivot and right elements
                                            // are greater than pivot
        return storeIndex;
    }

    // utility to swap i, j indexed elements
    static void swap(Map.Entry<Integer, Integer>[] entries, int i, int j) {
        Map.Entry<Integer, Integer> temp = entries[i];
        entries[i] = entries[j];
        entries[j] = temp;
    }


    /**
     *
     * Using a temporary array to store elements into respective indexes based the number of times they have appeared.
     */
    static int[] usingBucketSortingTechnique(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.of(nums).forEach(num->map.merge(num, 1, Integer::sum));

        // Now, we will create n buckets to store count of number of times an element appeared
        // index of array is the number of times an element appeared, within that bucket we will store elements
        // that have appeared same number of times

        List<Integer>[] buckets = new List[nums.length+1];// added +1 to keep n times appeared element into n(th) index
        map.forEach((key, value) -> {
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        });

        int[] result = new int[k];
        for(int i= buckets.length-1; i>=0 && k>0 ; i--) {
            if(buckets[i] != null) {
                List<Integer> elements = buckets[i];
                for(int j=0; j<elements.size() && k>0; j++) {
                    result[k-1] = elements.get(j);
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("############### Using sorting ######################");
        System.out.println(Arrays.toString(usingSorting(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 3)));
        System.out.println(Arrays.toString(usingSorting(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 2)));
        System.out.println(Arrays.toString(usingSorting(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 1)));

        System.out.println("############### Using min heap ######################");
        System.out.println(Arrays.toString(usingHeap(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 3)));
        System.out.println(Arrays.toString(usingHeap(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 2)));
        System.out.println(Arrays.toString(usingHeap(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 1)));

        System.out.println("############### Using QuickSelect algorithm ######################");
        System.out.println(Arrays.toString(usingQuickSelect(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 3)));
        System.out.println(Arrays.toString(usingQuickSelect(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 2)));
        System.out.println(Arrays.toString(usingQuickSelect(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 1)));

        System.out.println("############### Using Technique from BucketSort algorithm ######################");
        System.out.println(Arrays.toString(usingBucketSortingTechnique(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 3)));
        System.out.println(Arrays.toString(usingBucketSortingTechnique(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 2)));
        System.out.println(Arrays.toString(usingBucketSortingTechnique(new int[]{1, 1, 1, 1, 2, 3, 2, 2, 3, 1}, 1)));

    }

}
