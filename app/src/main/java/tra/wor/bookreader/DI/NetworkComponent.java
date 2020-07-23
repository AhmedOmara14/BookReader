package tra.wor.bookreader.DI;


import javax.inject.Singleton;

import dagger.Component;
import tra.wor.bookreader.ui.fragment.homefragment;
import tra.wor.bookreader.ui.fragment.searchFragment;
import tra.wor.bookreader.ui.main.showsports;

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    public void inject(homefragment homefragment);
    public void inject_show(showsports showsports);

    public void inject_sea(searchFragment searchFragment);

}
