package org.eclipse.kura.skeleton4.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Skeleton4Ui extends Composite {

	@UiField
	Label footerRight;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static Skeleton4UIUiBinder uiBinder = GWT
			.create(Skeleton4UIUiBinder.class);

	interface Skeleton4UIUiBinder extends UiBinder<Widget, Skeleton4Ui> {
	}

	public Skeleton4Ui() {
		initWidget(uiBinder.createAndBindUi(this));

		greetingService.greetServer(new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
			}

			@Override
			public void onSuccess(String result) {
				footerRight.setText(result);
			}
		});

	}
}