package com.dlk.test;
/**
 * ð������
 * 
 * @author duanlunkai@co-mall.com
 *
 *         2016��9��20��
 */
public class BubbleSort {

	/**
	 * ԭʼ����forѭ��ð������
	 * 
	 * @param array
	 *            ������Ҫ��������
	 * @return
	 */
	public static int[] Sort(int[] array) {
		
		int len = array.length;
		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len - 1 - a; b++) {
				if (array[b] > array[b + 1]) {	//����Ԫ�������Ա�
					int temp = array[b + 1];	//Ԫ�ؽ���
					array[b + 1] = array[b];
					array[b] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * �Ľ�ð������1�� 
	 * ����һ��־�Ա���pos,���ڼ�¼ÿ�����������һ�ν��н�����λ�á�
	 * ����posλ��֮��ļ�¼���ѽ�����λ,���ڽ�����һ������ʱֻҪɨ�赽posλ�ü��ɡ�
	 * 
	 * @param array
	 * 		������Ҫ��������
	 * @return
	 */
	public static int[] SortBatter(int[] array) {
		
		int i = array.length - 1;	//��ʼʱ,���λ�ñ��ֲ���
		while (i > 0) {
			int pos = 0;	//ÿ�˿�ʼʱ,�޼�¼����
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					pos = j;	//��¼������λ��
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			i = pos;	//Ϊ��һ��������׼��
		}
		return array;
	}

	/**
	 * �Ľ���ð������2��
	 * 	��ͳð��������ÿһ���������ֻ���ҵ�һ�����ֵ����Сֵ,���ǿ���������ÿ�������н���
	 * ����ͷ�������ð�ݵķ���һ�ο��Եõ���������ֵ(����ߺ���С��) , �Ӷ�ʹ������������������һ�롣
	 * 
	 * @param array
	 * 		������Ҫ��������
	 * @return
	 */
	public static int[] SortThanBatter(int[] array) {

		int low = 0;
		int high = array.length - 1;	//���ñ����ĳ�ʼֵ
		int tmp, j;

		while (low < high) {
			for (j = low; j < high; ++j) {	//����ð��,�ҵ������
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			--high;		//�޸�highֵ, ǰ��һλ
			for (j = high; j > low; --j) {	//����ð��,�ҵ���С��
				if (array[j] < array[j - 1]) {
					tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
			++low;		//�޸�lowֵ,����һλ
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
