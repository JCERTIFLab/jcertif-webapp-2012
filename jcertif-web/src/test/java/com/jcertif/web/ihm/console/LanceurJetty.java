package com.jcertif.web.ihm.console;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.plus.jaas.JAASUserRealm;
import org.mortbay.jetty.webapp.WebAppContext;

public class LanceurJetty {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Server server = new Server();

		Connector connector = new SelectChannelConnector();
		connector.setPort(8080);
		server.addConnector(connector);

		createRealms(server);

		WebAppContext wac = new WebAppContext();
		wac.setContextPath("/jcertif-web");
		wac.setWar("./src/main/webapp");
		wac.setDefaultsDescriptor("src/test/resources/jetty-webdefault.xml");
		server.addHandler(wac);

		server.setStopAtShutdown(true);
		server.start();

	}

	private static void createRealms(Server server) {
		JAASUserRealm realm = new JAASUserRealm();
		realm.setName("JaasRealm"); 
		realm.setLoginModuleName("file");
		server.addUserRealm(realm);
	}

}
