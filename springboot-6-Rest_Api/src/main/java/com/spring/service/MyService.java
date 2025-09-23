package com.spring.service;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	public Map<Integer,Integer> get(){
		Map<Integer,Integer>map=new HashMap<>();
		map.put(1996,10000);
		map.put(2000,1000);
		map.put(2001,15000);
		map.put(2002,11000);
		map.put(2003,14000);
		map.put(2004,1000);
		return map;
	}
}
