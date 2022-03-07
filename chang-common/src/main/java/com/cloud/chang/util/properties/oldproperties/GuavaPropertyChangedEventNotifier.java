package com.cloud.chang.util.properties.oldproperties;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.eventbus.EventBus;

public class GuavaPropertyChangedEventNotifier implements PropertyChangedEventNotifier {

	private final EventBus eventBus;

	@Autowired
	public GuavaPropertyChangedEventNotifier() {
		this.eventBus = new EventBus();
	}

	@Override
	public void post(final PropertyModifiedEvent propertyChangedEvent) {
		this.eventBus.post(propertyChangedEvent);
	}

	@Override
	public void unregister(final ReloadablePropertyPostProcessor ReloadablePropertyPostProcessor) {
		this.eventBus.unregister(ReloadablePropertyPostProcessor);
	}

	@Override
	public void register(final ReloadablePropertyPostProcessor ReloadablePropertyPostProcessor) {
		this.eventBus.register(ReloadablePropertyPostProcessor);
	}

}
