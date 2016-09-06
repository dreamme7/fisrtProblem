package com.dlk.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

public class Book implements Comparable<Object> {

	public int id;
	public String name;
	public double price;
	private String author;
	public GregorianCalendar calendar;
	
	public Book(){
		this(0,"x",0.0,"",new GregorianCalendar());
	}
	
	public Book(int id, String name, double price, String author, GregorianCalendar calendar) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.calendar = calendar;
	}

	@Override
	public String toString() {
		String showStr = id + "\t" + name; // ������ʾ����Ϣ���ַ���  
        DecimalFormat formatPrice = new DecimalFormat("0.00");// ��ʽ���۸�С�������λ  
        showStr += "\t" + formatPrice.format(price);// ��ʽ���۸�  
        showStr += "\t" + author;  
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy��MM��dd��");  
        showStr += "\t" + formatDate.format(calendar.getTime()); // ��ʽ��ʱ��  
        return showStr; // ��������Ϣ�ַ���  
	}

//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", calendar="
//				+ calendar + "]";
//	}

	@Override
	public int compareTo(Object obj){
		Book b = (Book)obj;
		return this.id - b.id;
		
	}
	public static void main(String[] args) {
		Book b1 = new Book(10000, "��¥��", 150.86, "��ѩ�ۡ��߶�", new GregorianCalendar(2009,  
                01, 25));  
        Book b2 = new Book(10001, "��������", 99.68, "�޹��� ", new GregorianCalendar(2008, 7,  
                8));  
        Book b3 = new Book(10002, "ˮ䰴�", 100.8, "ʩ���� ", new GregorianCalendar(2009, 6,  
                28));  
        Book b4 = new Book(10003, "���μ�", 120.8, "��ж�", new GregorianCalendar(2011, 6,  
                8));  
        Book b5 = new Book(10004, "�����˲�", 10.4, "�Ѻ�", new GregorianCalendar(2011, 9,  
                23));  
        TreeMap<Book, Integer> tm = new TreeMap<Book, Integer>();  
        tm.put(b1, new Integer(255));  
        tm.put(b2, new Integer(122));  
        tm.put(b3, new Integer(688));  
        tm.put(b4, new Integer(453));  
        tm.put(b5, new Integer(40));  
        Iterator<Book> it = tm.keySet().iterator();  
        Object key = null, value = null;  
        Book bb = null;  
        while (it.hasNext()) {  
            key = it.next();  
            bb = (Book) key;  
            value = tm.get(key);  
            System.out.println(bb.toString() + "\t��棺" + tm.get(key));  
        }  
	}

}
