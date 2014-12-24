package com.jd.szm;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class GetRandomFromMap {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Map<String, Integer> m = new HashMap<String,Integer>();
		m.put("1", 1);
		m.put("2", 2);
		m.put("3", 3);
		m.put("4", 4);
		m.put("5", 5);
		Random random = new Random();
		for (int i = 0 ; i < 10 ; i++) {
			int pos = Math.abs(random.nextInt()) % m.size();
			System.out.print("pos : " + pos);
			@SuppressWarnings("unchecked")
			Entry<String, Integer> entry = (Entry<String, Integer>)(m.entrySet().toArray()[pos]);
			System.out.print(" , key : " + entry.getKey());
			System.out.println(" , value : " + entry.getValue());
		}
	}

}
