package org.eclipse.kura.skeleton4.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SystemPropertiesModel implements IsSerializable {

	private String id;
	private String name;
	private String value;

	public SystemPropertiesModel() {
	}

	public SystemPropertiesModel(String id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
