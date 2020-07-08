package tra.wor.bookreader.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tra.wor.bookreader.pojo.fav_Dao;
import tra.wor.bookreader.pojo.favo_database;
import tra.wor.bookreader.pojo.info_favorite;
import tra.wor.bookreader.pojo.items;
import tra.wor.bookreader.pojo.programming;

public class Repositry extends AndroidViewModel {
    MutableLiveData<List<items>> listMutableLiveData = new MutableLiveData<>();
    LiveData<List<info_favorite>> listMutableLiveData_fav = new MutableLiveData<>();

    private static final String TAG = "Repositry";
    fav_Dao fav_dao;
    favo_database favo_database;

    public Repositry(@NonNull Application application) {
        super(application);
        favo_database = tra.wor.bookreader.pojo.favo_database.getInstance(application);
        fav_dao = favo_database.fav_dao();
        listMutableLiveData_fav = fav_dao.allofrecord();
    }

    public MutableLiveData<List<items>> getitems(String item) {
        Observable<programming> observable = apiclient.getInstance().getbooks(item)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<programming> programmingObserver = new Observer<programming>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(programming programming) {
                List<items> items = programming.getItems();
                listMutableLiveData.setValue(items);
                Log.d(TAG, "onNext: " + items.get(0).getVolumeInfo().getTitle());
                Log.d(TAG, "onNext: " + items.get(0).getVolumeInfo().getAuthors());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(programmingObserver);

        return listMutableLiveData;
    }

    public void insert(info_favorite info_favorite) {
      new InsertAsyntask(fav_dao).execute(info_favorite);
    }

    public void update(info_favorite info_favorite) {

    }

    public void delete(info_favorite info_favorite) {
        new DeleteAsyntask(fav_dao).execute(info_favorite);

    }

    public void deleteallRecord() {
        new deletallrecord(fav_dao).execute();

    }
    public LiveData<List<info_favorite>> getallrecord(){
        return listMutableLiveData_fav;
    }

    public class InsertAsyntask  extends AsyncTask<info_favorite,Void,Void>{
        fav_Dao fav_dao;

        public InsertAsyntask(fav_Dao fav_dao) {
            this.fav_dao = fav_dao;
        }

        @Override
        protected Void doInBackground(info_favorite... info_favorites) {
            fav_dao.insert(info_favorites[0]);
            return null;
        }
    }

    public class DeleteAsyntask  extends AsyncTask<info_favorite,Void,Void>{
        fav_Dao fav_dao;

        public DeleteAsyntask(fav_Dao fav_dao) {
            this.fav_dao = fav_dao;
        }

        @Override
        protected Void doInBackground(info_favorite... info_favorites) {
            fav_dao.delete(info_favorites[0]);
            return null;
        }
    }

    public class deletallrecord  extends AsyncTask<info_favorite,Void,Void>{
        fav_Dao fav_dao;

        public deletallrecord(fav_Dao fav_dao) {
            this.fav_dao = fav_dao;
        }

        @Override
        protected Void doInBackground(info_favorite... info_favorites) {
            fav_dao.deleteallrecord();
            return null;
        }
    }

}
