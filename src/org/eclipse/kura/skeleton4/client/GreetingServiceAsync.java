package org.eclipse.kura.skeleton4.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(AsyncCallback<String> callback);
	// throws IllegalArgumentException;
}
