package org.eclipse.kura.skeleton4.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Skeleton4 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */

	private final Skeleton4Ui binder = GWT.create(Skeleton4Ui.class);

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

		RootPanel.get().add(binder);

	}
}
