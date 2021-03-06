package org.eclipse.kura.skeleton4.client.ui;

import java.util.ArrayList;

import org.eclipse.kura.skeleton4.client.GreetingService;
import org.eclipse.kura.skeleton4.client.GreetingServiceAsync;
import org.eclipse.kura.skeleton4.client.ui.Status.StatusPageUi;
import org.eclipse.kura.skeleton4.shared.model.SystemPropertiesModel;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.PanelHeader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Skeleton4Ui extends Composite {

	private final StatusPageUi statusBinder = GWT.create(StatusPageUi.class);

	@UiField
	Panel contentPanel;

	@UiField
	Image header;
	@UiField
	Label footerRight;
	@UiField
	AnchorListItem status, device, network, firewall, packages, setting,
			clockService, cloudService, commandService, webConsole,
			dataService, mqttDataTransport, sslManagerService, watchdogService;

	@UiField
	PanelHeader contentPanelHeader;

	@UiField
	PanelBody contentPanelBody;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static Skeleton4UIUiBinder uiBinder = GWT
			.create(Skeleton4UIUiBinder.class);

	interface Skeleton4UIUiBinder extends UiBinder<Widget, Skeleton4Ui> {
	}

	public Skeleton4Ui() {
		initWidget(uiBinder.createAndBindUi(this));
		contentPanel.setVisible(false);
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

		status.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				status.setIconSpin(true);
				contentPanel.setVisible(true);
				contentPanelHeader.setText("Status");
				contentPanelBody.add(statusBinder);
				status.setIconSpin(false);
			}

		});

	}
}