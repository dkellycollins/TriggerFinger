package com.dkellycollins.triggerfinger;

import com.dkellycollins.ioc.Module;
import com.dkellycollins.ioc.Provider;
import com.dkellycollins.triggerfinger.factories.impl.EntityFactory;

public class AppModule extends Module {


    @Override
    protected void init() {
        super.init();

        register("IEntityFactory", singleton(new Provider() {
            @Override
            public Object getInstance() {
                return new EntityFactory();
            }
        }));
    }
}
