# Sorting Algorithms Comparison

## Overview

This document explains and compares four common sorting algorithms: Bubble Sort, Insertion Sort, Quick Sort, and Merge Sort. The provided Java code implements these sorting algorithms to sort an array of `Purchase` objects based on their `amount`.

## Sorting Algorithms

### Bubble Sort

**Description:**  
A simple comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

**Time Complexity:**
- Worst Case: O(n²)
- Average Case: O(n²)
- Best Case: O(n) (when the list is already sorted)

---

### Insertion Sort

**Description:**  
Builds the final sorted list one item at a time, inserting each new item into its proper position within the already sorted section.

**Time Complexity:**
- Worst Case: O(n²)
- Average Case: O(n²)
- Best Case: O(n) (when the list is already sorted)

---

### Quick Sort

**Description:**  
A divide-and-conquer algorithm that picks an element as a pivot and partitions the array around the pivot such that elements less than the pivot are on the left and elements greater than the pivot are on the right.

**Time Complexity:**
- Worst Case: O(n²) (rare and depends on pivot selection)
- Average Case: O(n log n)
- Best Case: O(n log n)

---

### Merge Sort

**Description:**  
A divide-and-conquer algorithm that divides the array into two halves, recursively sorts them, and then merges the sorted halves back together.

**Time Complexity:**
- All Cases: O(n log n)

---

## Analysis

### Time Complexity Comparison

**Bubble Sort:**
- Worst Case: O(n²)
- Average Case: O(n²)
- Best Case: O(n)

**Quick Sort:**
- Worst Case: O(n²) (depends on pivot selection)
- Average Case: O(n log n)
- Best Case: O(n log n)

### Why Quick Sort is Generally Preferred Over Bubble Sort
1. **Efficiency:** Quick Sort generally has better average-case performance (O(n log n)) compared to Bubble Sort's O(n²) average-case performance.
2. **Scalability:** Quick Sort scales better with larger datasets due to its more efficient time complexity.
3. **Real-World Performance:** Quick Sort performs well in practice because it is cache-friendly and has low overhead, making it faster than other O(n log n) algorithms like Merge Sort for many types of data.

---

## Code Implementation

The Java code provided demonstrates the sorting algorithms implemented for sorting `Purchase` objects based on their `amount`. The code includes:

- `sortByBubble` for Bubble Sort
- `sortByQuick` for Quick Sort
- `partition` as a helper function for Quick Sort

To run the code, compile and execute the `PurchaseSorter` class. The program prompts for user input to create and sort a list of purchases, displaying results before and after sorting with both Bubble Sort and Quick Sort.

Feel free to modify and expand the code to include additional sorting algorithms or adjust the logic for different types of objects.