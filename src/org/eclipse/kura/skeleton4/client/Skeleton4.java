package org.eclipse.kura.skeleton4.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Skeleton4 implements EntryPoint {

	private final Skeleton4Ui binder = GWT.create(Skeleton4Ui.class);

	@Override
	public void onModuleLoad() {

		RootPanel.get().add(binder);

	}
}
