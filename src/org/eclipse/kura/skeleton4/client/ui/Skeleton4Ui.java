package org.eclipse.kura.skeleton4.client.ui;

import java.util.ArrayList;

import org.eclipse.kura.skeleton4.client.GreetingService;
import org.eclipse.kura.skeleton4.client.GreetingServiceAsync;
import org.eclipse.kura.skeleton4.shared.model.SystemPropertiesModel;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Skeleton4Ui extends Composite {

	@UiField
	Image header;
	@UiField
	Label footerRight;
	@UiField
	AnchorListItem status, device, network, firewall, packages, setting,
			clockService, cloudService, commandService, webConsole,
			dataService, mqttDataTransport, sslManagerService, watchdogService;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static Skeleton4UIUiBinder uiBinder = GWT
			.create(Skeleton4UIUiBinder.class);

	interface Skeleton4UIUiBinder extends UiBinder<Widget, Skeleton4Ui> {
	}

	public Skeleton4Ui() {
		initWidget(uiBinder.createAndBindUi(this));

		// TODO : ADD IE specific code if needed
		// System.out.println("USER AGENT: " + Navigator.getUserAgent());
		header.addStyleName("header-logo");
		header.setUrl("images/kura_logo_small.png");

		greetingService
				.greetServer(new AsyncCallback<ArrayList<SystemPropertiesModel>>() {

					@Override
					public void onFailure(Throwable caught) {
						DialogBox box = new DialogBox();
						box.add(new Label("FAILURE"));
					}

					@Override
					public void onSuccess(
							ArrayList<SystemPropertiesModel> result) {
						for (SystemPropertiesModel sysProp : result) {
							if (sysProp.getName().contains("KuraVersion")) {
								footerRight.setText(sysProp.getValue());
							}
						}
					}
				});

	}
}