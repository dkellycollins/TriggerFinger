package com.dkellycollins.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages class instances.
 */
public abstract class Module {

    private Map<String, Provider> _registry;

    public Module() {
        _registry = new HashMap<String, Provider>();
    }

    public <T> T get(String key) {
        if(_registry.containsKey(key)) {
            return (T) _registry.get(key).getInstance();
        }
        return null;
    }

    protected void init() {}

    protected void register(String key, Provider provider) {
        _registry.put(key, provider);
    }

    protected <T> Provider<T> singleton(Provider<T> provider) {
        return new SingletonProvider<T>(provider);
    }
}