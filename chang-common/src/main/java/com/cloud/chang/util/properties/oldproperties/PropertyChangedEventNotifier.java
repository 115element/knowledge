package com.cloud.chang.util.properties.oldproperties;


public interface PropertyChangedEventNotifier {

	void post(PropertyModifiedEvent propertyChangedEvent);

	void unregister(ReloadablePropertyPostProcessor reloadablePropertyProcessor);

	void register(ReloadablePropertyPostProcessor reloadablePropertyProcessor);

}
