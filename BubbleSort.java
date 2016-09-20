package com.dlk.test;
/**
 * 冒泡排序
 * 
 * @author duanlunkai
 *
 *         2016年9月20日
 */
public class BubbleSort {

	/**
	 * 原始两层for循环冒泡排序
	 * 
	 * @param array
	 *            传入需要排序数组
	 * @return
	 */
	public static int[] Sort(int[] array) {
		
		int len = array.length;
		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len - 1 - a; b++) {
				if (array[b] > array[b + 1]) {	//相邻元素两两对比
					int temp = array[b + 1];	//元素交换
					array[b + 1] = array[b];
					array[b] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * 改进冒泡排序1： 
	 * 设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
	 * 由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
	 * 
	 * @param array
	 * 		传入需要排序数组
	 * @return
	 */
	public static int[] SortBatter(int[] array) {
		
		int i = array.length - 1;	//初始时,最后位置保持不变
		while (i > 0) {
			int pos = 0;	//每趟开始时,无记录交换
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					pos = j;	//记录交换的位置
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			i = pos;	//为下一趟排序作准备
		}
		return array;
	}

	/**
	 * 改进版冒泡排序2：
	 * 	传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,我们考虑利用在每趟排序中进行
	 * 正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) , 从而使排序趟数几乎减少了一半。
	 * 
	 * @param array
	 * 		传入需要排序数组
	 * @return
	 */
	public static int[] SortThanBatter(int[] array) {

		int low = 0;
		int high = array.length - 1;	//设置变量的初始值
		int tmp, j;

		while (low < high) {
			for (j = low; j < high; ++j) {	//正向冒泡,找到最大者
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			--high;		//修改high值, 前移一位
			for (j = high; j > low; --j) {	//反向冒泡,找到最小者
				if (array[j] < array[j - 1]) {
					tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
			++low;		//修改low值,后移一位
		}
		return array;
	}
	
	public static void main(String[] args) {

		int[] array = new int[] {3,44,38,5,47,15,36,26,27,2,46,4,19,51,48};
		array = SortThanBatter(array);
		int len = array.length;
		for (int c = 0; c < len; c++) {
			String abc = ",";
			if ((c + 1) != len) {
				System.out.print(array[c] + ",");
			} else {
				System.out.print(array[c]);
			}
		}
	}

}
