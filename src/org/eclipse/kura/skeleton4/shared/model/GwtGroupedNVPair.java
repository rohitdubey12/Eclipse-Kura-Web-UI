package org.eclipse.kura.skeleton4.shared.model;

public class GwtGroupedNVPair extends BaseModel {

	public GwtGroupedNVPair() {
	}

	public GwtGroupedNVPair(String group, String name, String value) {
		setGroup(group);
		setName(name);
		setValue(value);
	}

	public void setGroup(String group) {
		set("group", group);
	}

	public String getGroup() {
		return get("group");
	}

	public String getGroupLoc() {
		return get("groupLoc");
	}

	public void setId(String id) {
		set("id", id);
	}

	public String getId() {
		return get("id");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return get("name");
	}

	public String getNameLoc() {
		return get("nameLoc");
	}

	public void setValue(String value) {
		set("value", value);
	}

	public String getValue() {
		return get("value");
	}

	public void setStatus(String status) {
		set("status", status);
	}

	public String getStatus() {
		return get("status");
	}

	public String getStatusLoc() {
		return get("statusLoc");
	}

	public void setVersion(String version) {
		set("version", version);
	}

	public String getVersion() {
		return get("version");
	}

}
