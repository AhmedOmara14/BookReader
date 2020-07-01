package tra.wor.bookreader.data;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tra.wor.bookreader.pojo.items;
import tra.wor.bookreader.pojo.programming;

public class Repositry extends ViewModel {
    MutableLiveData<List<items>> listMutableLiveData=new MutableLiveData<>();
    private static final String TAG = "Repositry";

    public MutableLiveData<List<items>> getitems(String item){
        Observable<programming> observable=apiclient.getInstance().getbooks(item)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;
        Observer<programming> programmingObserver=new Observer<programming>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(programming programming) {
              List<items> items=programming.getItems();
              listMutableLiveData.setValue(items);
                Log.d(TAG, "onNext: "+items.get(0).getVolumeInfo().getTitle());
                Log.d(TAG, "onNext: "+items.get(0).getVolumeInfo().getAuthors());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(programmingObserver);

        return listMutableLiveData;
    }

    public void setitem(HashMap<String, String> hashMap) {

    }
}
