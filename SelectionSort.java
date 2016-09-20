package com.dlk.test;

/**
 * ѡ������
 * 
 * @author duanlunkai@co-mall.com
 *
 *         2016��9��20��
 */
public class SelectionSort {

	/**
	 * ѡ������
	 * 
	 * @param array
	 *            ��������
	 * @return
	 */
	public static int[] Sort(int[] array) {
		int len = array.length;
		int minIndex, temp;
		for (int i = 0; i < len - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 51, 48 };
		array = Sort(array);
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
