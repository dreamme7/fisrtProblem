package com.dlk.test;

/**
 * 插入排序
 * 
 * @author duanlunkai@co-mall.com
 *
 *         2016年9月20日
 */
public class InsertionSort {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int[] Sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}

		return array;
	}

	/**
	 * 改进插入排序： 查找插入位置时使用二分查找的方式
	 * 
	 * @param array
	 * @return
	 */
	public static int[] SortBatter(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i], left = 0, right = i - 1;
			while (left <= right) {
				int middle = ((left + right) / 2);
				if (key < array[middle]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				array[j + 1] = array[j];
			}
			array[left] = key;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 51, 48 };
		array = SortBatter(array);
		int len = array.length;
		for (int c = 0; c < len; c++) {
			String abc = null;
			if ((c + 1) != len) {
				abc = ",";
			} else {
				abc = "";
			}
			System.out.print(array[c] + abc);
		}
	}

}
