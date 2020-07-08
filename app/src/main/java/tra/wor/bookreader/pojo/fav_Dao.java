package tra.wor.bookreader.pojo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface fav_Dao {

    @Insert
    void insert(info_favorite info_favorite);

    @Update
    void update(info_favorite info_favorite);

    @Delete
    void delete(info_favorite info_favorite);

    @Query("Delete from favorite")
    void deleteallrecord();

    @Query("SELECT * FROM favorite")
    LiveData<List<info_favorite>> allofrecord();


}
