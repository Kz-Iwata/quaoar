package org.yumix.quaoar;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

@ApplicationScoped
public class FXMLLoaderProducer {
	@Inject
	private Instance<Object> instance;
	
	@Produces
	public FXMLLoader getFXMLLoader() {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				return instance.select(param).get();
			}
		});
		return loader;
	}
}
