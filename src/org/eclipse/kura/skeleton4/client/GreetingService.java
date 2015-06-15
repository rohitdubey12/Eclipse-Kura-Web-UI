package org.eclipse.kura.skeleton4.client;

import java.util.ArrayList;

import org.eclipse.kura.skeleton4.shared.model.SystemPropertiesModel;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	ArrayList<SystemPropertiesModel> greetServer();
}
