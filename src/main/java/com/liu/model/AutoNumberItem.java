package com.liu.model;

public class AutoNumberItem {
	private int start;
	private int step;
	private int max;
	private int now;

	public AutoNumberItem() {
	}
	
	//������ǣ�mybites��ѯ��������Ĭ�Ϲ��캯��
	public AutoNumberItem(int start, int step) {
		this.start = start;
		this.step = step;
		this.max = this.start + this.step;
		this.now = start;
	}

	public synchronized int getNext() {
		now += 1;
		return now;
	}

	public int getMax() {
		return this.max;
	}

	public int getStart() {
		return start;
	}

	public int getStep() {
		return step;
	}
}
