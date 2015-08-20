package com.dkellycollins.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages class instances.
 */
public abstract class Module {

    private Map<String, IProvider> _registry;

    public Module() {
        _registry = new HashMap<String, IProvider>();
    }

    public <T> T get(String key) {
        if(_registry.containsKey(key)) {
            return (T) _registry.get(key).getInstance();
        }
        return null;
    }

    protected void init() {}

    protected void register(String key, IProvider provider) {
        _registry.put(key, provider);
    }

    protected <T> IProvider<T> singleton(IProvider<T> provider) {
        return new SingletonProvider<T>(provider);
    }
}