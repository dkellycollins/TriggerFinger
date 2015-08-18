package com.dkellycollins.ioc;

/**
 * Manages a single instance of a class.
 * @param <T> The type of the class.
 */
class SingletonProvider<T> implements Provider<T> {

    private final Provider<T> _inner;

    private T _instance;

    public SingletonProvider(Provider<T> inner) {
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
