package br.com.sisarq.util;

public class Util {
 
	 public static String right(String strValor,int intTam)
	 {
		int pos=strValor.length()-intTam;
	    return strValor.substring(pos, strValor.length());
			
		 
	 }
	
}
