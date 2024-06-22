/*
 * Created on 21.03.2014
 */
package ch.fhnw.algd.sortalgs;

import ch.fhnw.algd.sortdemo.framework.SortAlg;
import ch.fhnw.algd.sortdemo.framework.SortData;

public class HeapSort implements SortAlg {
	@Override
	public void run(SortData data) { // [9, 1, 4, 5, 10, 6, 7, 19, 2, 3, 8, 13]
		createFloydMaxHeap(data);
		heapSort(data);
	}

	private void createFloydMaxHeap(SortData data) {
		int size = data.size();
		for (int i = size / 2 - 1; i >= 0; i--) { // i-- -> 1
			siftDown(data, i, size); // 1, 6
		}
	}

	private void heapSort(SortData data) {
		int size = data.size();
		for (int i = size - 1; i > 0; i--) {
			data.swap(0, i);
			siftDown(data,0, i);
		}
	}

	private void siftDown(SortData data, int parent, int size) {
		int child = indexOfLargerChild(data, parent, size); // 1, 6 -> 6, -> 5
		while (child < size && data.less(parent, child)) { // 5 < 6 && 1 < 5
			data.swap(parent, child);
			parent = child; // 5
			child = indexOfLargerChild(data, child, size); // 5, 6
		}
	}

	private int indexOfLargerChild(SortData data, int parent, int size) {
		int child = 2 * parent + 1; // 11
		if (child + 1 < size && data.less(child, child + 1)) { // 4 < 6 && 4 < 5 true -> child = 5
			++child;
		}
		return child;
	}
}
