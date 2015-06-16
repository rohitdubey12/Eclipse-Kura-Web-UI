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
		sysProp.clear();

		sysProp.add(new SystemPropertiesModel("1", "KuraVersion", "2.3"));

		// TODO add other System Properties here

		return sysProp;
	}
}
