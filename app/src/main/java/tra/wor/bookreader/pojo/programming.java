package tra.wor.bookreader.pojo;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class programming {
   @SerializedName("items")
   @Expose
   ArrayList<items> items;

   public ArrayList<tra.wor.bookreader.pojo.items> getItems() {
      return items;
   }

   public void setItems(ArrayList<tra.wor.bookreader.pojo.items> items) {
      this.items = items;
   }
}
