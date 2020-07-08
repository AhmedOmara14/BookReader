package tra.wor.bookreader.pojo;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {info_favorite.class},version = 1)
public abstract class favo_database extends RoomDatabase {
   public abstract fav_Dao fav_dao();

   private static favo_database instance;

    public static favo_database getInstance(Context context) {
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),favo_database.class,"Favorite").build();
        }
        return instance;
    }


}
