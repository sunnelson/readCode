
/**
 * 这篇内容是介绍排序算法的实现代码
 * 包括冒泡排序、插入排序、选择排序、归并排序、快速排序、大根堆排序
 * 冒泡、插入、选择时间复杂度O(n)；归并、堆排时间复杂度O(nlogn)；快排平均是O(logn)
 * 冒泡、插入式稳定性算法，其他非稳定
 * @author sunnelson
 *
 */

public class Code_time_0408_sort {

	//冒泡排序
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) return ;
		for (int i = arr.length - 1; i > 0; i--) {
			boolean change = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					change = true;
				}
			}
			if (!change) return ;
		}
	}
	
	//插入排序
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) return ;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j++);
			}
		}
	}
	
	//选择排序
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) return ;
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = 0;
			for(int j = minIndex + 1; j < arr.length; j++) {
				minIndex = arr[minIndex] < arr[j] ? minIndex : j;
			}
			swap(arr, i, minIndex);
		}
	}
	
	/**
	 * 归并排序
	 * @param arr
	 * @param i
	 * @param j
	 */
	//归并算法
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) return ;
		mergeSort(arr, 0, arr.length - 1);
	}
	
	//归并算法
	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) return ;
		int mid = l + (r - l) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
		
	}
	
	//归并过程
	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < arr.length; i++) {
			arr[l + i] = help[i];
		}
	}
	
	/**
	 * 快速排序
	 * @param arr
	 * @param i
	 * @param j
	 */
	//快排算法
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) return ;
		quickSort(arr, 0, arr.length - 1);
	}
	
	//快排算法
	public static void quickSort(int[] arr, int l, int r) {
		if (l >= r) return ;
		swap(arr, r, (int) (Math.random() * (r - l + 1)));
		int[] p = partition(arr, l, r);
		quickSort(arr, l, p[0] - 1);
		quickSort(arr, p[0] + 1, r);
	}
	
	//快排划分过程
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, l++, --more);
			} else {
				l++;
			}
		}
		swap (arr, more, r);
		return new int[] {less + 1, more};
	}
	
	/**
	 * 大根堆排序
	 * @param arr
	 * @param i
	 * @param j
	 */
	//大根堆排序
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) return;
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		for (int i = arr.length - 1; i != 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}
	
	//插入到大根堆一个元素
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	//调整大根堆的一次过程
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) return;
			swap (arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}
	
	//交换函数
	public static void swap(int[] arr, int i, int j) {
		if (i == j) return ; 
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
