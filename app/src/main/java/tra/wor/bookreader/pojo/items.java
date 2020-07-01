package tra.wor.bookreader.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class items {
    @SerializedName("volumeInfo")
    @Expose
     volumeInfo volumeInfo;

    public tra.wor.bookreader.pojo.volumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(tra.wor.bookreader.pojo.volumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
