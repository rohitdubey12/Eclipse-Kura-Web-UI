package org.eclipse.kura.skeleton4.server;

import java.util.ArrayList;

import org.eclipse.kura.skeleton4.client.GreetingService;
import org.eclipse.kura.skeleton4.shared.model.SystemPropertiesModel;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	ArrayList<SystemPropertiesModel> sysProp = new ArrayList<SystemPropertiesModel>();

	@Override
	public ArrayList<SystemPropertiesModel> greetServer() {
		addKuraVersion(sysProp);
		// TODO add other System Properties here

		return sysProp;
	}

	public void addKuraVersion(ArrayList<SystemPropertiesModel> sysProp) {
		// TODO replace with logic to fetch version
		String version = "2.3";

		SystemPropertiesModel prop = new SystemPropertiesModel();
		prop.setId("1");
		prop.setName("KuraVersion");
		prop.setValue(version);

		sysProp.add(prop);
	}
}
