package com.dkellycollins.ioc;

/**
 * Manages a single instance of a class.
 * @param <T> The type of the class.
 */
class SingletonProvider<T> implements IProvider<T> {

    private final IProvider<T> _inner;

    private T _instance;

    public SingletonProvider(IProvider<T> inner) {
        _inner = inner;
    }

    @Override
    public T getInstance() {
        if(_instance == null) {
            _instance = _inner.getInstance();
        }
        return _instance;
    }
}