package org.eclipse.kura.skeleton4.client;

import java.util.ArrayList;

import org.eclipse.kura.skeleton4.shared.model.SystemPropertiesModel;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(AsyncCallback<ArrayList<SystemPropertiesModel>> callback);
}
