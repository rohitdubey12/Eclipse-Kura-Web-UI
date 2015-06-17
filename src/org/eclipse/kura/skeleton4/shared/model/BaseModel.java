package org.eclipse.kura.skeleton4.shared.model;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.IsSerializable;

public class BaseModel implements IsSerializable {

	HashMap<String, String> data;

	public BaseModel() {
		data = new HashMap<String, String>();
	}

	public void set(String name, String value) {
		data.put(name, value);
	}

	public String get(String name) {
		return data.get(name);
	}
}
