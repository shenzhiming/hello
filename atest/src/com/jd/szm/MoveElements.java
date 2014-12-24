package com.jd.szm;

public class MoveElements {
	public static void swap(int[] v, int left, int right) {
		int temp = v[left];
		v[left] = v[right];
		v[right] = temp;
	}
	public static void printVector(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	public static void rotate(int[] v, int first, int n_first, int last) {
		int next = n_first;
		printVector(v);
		while (first != next) {
			swap(v,first++,next++);
			if (next == last) {
				next = n_first;
			} else if (first == n_first) {
				n_first = next;
			}
			printVector(v);
		}
	}
	public static void main(String[] args) {
		int[] vector = {1,2,3,4,5,6,};
		rotate(vector,0,4,6);
	}

}
