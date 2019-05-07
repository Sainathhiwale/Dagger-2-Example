package com.examen.myapplication;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
/* Component and associate modules should have the same scope. In this example the
 scope was defined via @Singleton annotation.

 For modules with different scopes we can create sub components and dependent components.


 We should list all the modules associated with the component as a list before the component name
declaration with the @Component annotation.@Component(modules = MemberDataModule.class)

 We need to declare abstract methods including corresponding views (activities and fragments) as parameters.
          void inject(MainActivity mainActivity) */
@Singleton
@Component(modules = MemberDataModule.class)
public interface MemberAppComponent {

    void inject(MainActivity mainActivity);
}
