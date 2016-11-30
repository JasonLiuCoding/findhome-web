package com.liu.model;

import org.springframework.util.StringUtils;

public enum AutoNumberType {
	User("UserNumber")

	;
	public final String name;

	private AutoNumberType(String name) {
		this.name = name;
	}

	public AutoNumberType parseType(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		for (AutoNumberType type : values()) {
			if (type.name.equals(name)) {
				return type;
			}
		}
		return null;
	}
}
