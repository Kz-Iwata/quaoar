package org.yumix.quaoar.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import javafx.fxml.FXMLLoader;

@ApplicationScoped
public class FXMLLoaderProducer {
	@Inject
	private Instance<Object> instance;
	
	@Produces
	public FXMLLoader getFXMLLoader() {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(param -> instance.select(param).get());
		return loader;
	}
}
