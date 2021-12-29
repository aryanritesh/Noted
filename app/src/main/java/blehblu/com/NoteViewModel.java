package blehblu.com;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private noteRepo repo;
    private LiveData<List<note>> notes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repo = new noteRepo(application);
        notes = repo.getAllNotes();
    }

    public void insert(note note) {
        repo.insert(note);
    }

    public void update(note note) {
        repo.update(note);
    }

    public void delete(note note) {
        repo.delete(note);
    }

    public LiveData<List<note>> getAllNotes(){
    return notes;
    }
}
