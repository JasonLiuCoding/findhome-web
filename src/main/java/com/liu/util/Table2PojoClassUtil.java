package com.liu.util;

import java.util.Scanner;

public class Table2PojoClassUtil {

	private static String PrintFormat = "public final %s %s;";
	public static final Table2PojoClassUtil instance = new Table2PojoClassUtil();

	private Table2PojoClassUtil() {
	}
	
	public static String trans(String sql){
		String field_name = "";
		String field_type = "";
		int nameStartIndex = sql.indexOf("`");
		int nameEndIndex = sql.indexOf("`",nameStartIndex+1);
		field_name = sql.substring(nameStartIndex+1, nameEndIndex);
		char firstChar = field_name.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			field_name = field_name.replaceFirst(String.valueOf(firstChar), String.valueOf((char)(firstChar + 32)));
		}
		int typeIndex1 = sql.indexOf("(", nameEndIndex+2);
		int typeIndex2 = sql.indexOf(" ", nameEndIndex+2);
		if(typeIndex1 == -1){
			typeIndex1 = 99999;
		}
		if(typeIndex2 == -1){
			typeIndex2 = 99999;
		}
		int typeEndIndex = Math.min(typeIndex1, typeIndex2);
		field_type = sql.substring(nameEndIndex+2, typeEndIndex).trim();
		if(field_type.equalsIgnoreCase("TINYINT")){
			System.out.println(String.format(PrintFormat, "byte", field_name));
		}else if(field_type.equalsIgnoreCase("INT")){
			System.out.println(String.format(PrintFormat, "int", field_name));
		}else if(field_type.equalsIgnoreCase("BIGINT")){
			System.out.println(String.format(PrintFormat, "long", field_name));
		}else if(field_type.equalsIgnoreCase("VARCHAR")){
			System.out.println(String.format(PrintFormat, "String", field_name));
		}else if(field_type.equalsIgnoreCase("TIMESTAMP")){
			System.out.println(String.format(PrintFormat, "long", field_name));
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("ÇëÊäÈë£º");
		  Scanner sc = new Scanner(System.in); 
		  while(sc.hasNext()){
			  String next = sc.nextLine();
			  trans(next);
		  }
	}
}
