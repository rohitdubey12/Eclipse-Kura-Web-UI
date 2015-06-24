package org.eclipse.kura.skeleton4.client.ui.Status;

import org.gwtbootstrap3.client.ui.AnchorListItem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class StatusPageUi extends Composite {

	private static StatusPageUiUiBinder uiBinder = GWT
			.create(StatusPageUiUiBinder.class);

	interface StatusPageUiUiBinder extends UiBinder<Widget, StatusPageUi> {
	}

	@UiField
	AnchorListItem statusRefresh;

	public StatusPageUi() {
		initWidget(uiBinder.createAndBindUi(this));

	}

}
