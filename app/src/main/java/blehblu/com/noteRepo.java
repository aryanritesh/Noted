package blehblu.com;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class noteRepo {
    private noteDAO noteDAO;
    private LiveData<List<note>> notes;
    public noteRepo(Application application){
        NoteDatabase database=NoteDatabase.getInstance(application);
        noteDAO= database.noteDAO();
    }

}
