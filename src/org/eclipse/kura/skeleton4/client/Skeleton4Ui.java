package org.eclipse.kura.skeleton4.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Skeleton4Ui extends Composite {

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static Skeleton4UIUiBinder uiBinder = GWT
			.create(Skeleton4UIUiBinder.class);

	// GWT.create(SystemPropertyService.class);

	interface Skeleton4UIUiBinder extends UiBinder<Widget, Skeleton4Ui> {
	}

	public Skeleton4Ui() {
		initWidget(uiBinder.createAndBindUi(this));

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogBox.setWidget(dialogVPanel);

		greetingService.greetServer(new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				dialogBox.setText("Remote Procedure Call - Failure");
				serverResponseLabel.addStyleName("serverResponseLabelError");
				serverResponseLabel.setHTML("ERROR");
				dialogBox.center();
				closeButton.setFocus(true);
			}

			@Override
			public void onSuccess(String result) {
				dialogBox.setText("Remote Procedure Call");
				serverResponseLabel.removeStyleName("serverResponseLabelError");
				serverResponseLabel.setHTML(result);
				dialogBox.center();
				closeButton.setFocus(true);
			}
		});

	}
}
