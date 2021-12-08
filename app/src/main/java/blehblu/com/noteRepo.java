package blehblu.com;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class noteRepo {
    private noteDAO noteDAO;
    private LiveData<List<note>> notes;
    public noteRepo(Application application){
        NoteDatabase database=NoteDatabase.getInstance(application);
        noteDAO= database.noteDAO();
        notes=noteDAO.getAllNotes();
    }

    public void insert(note note){
     new InsertNoteAsync(noteDAO).execute(note);
    }
    public void update(note note){
     new UpdateNoteAsync(noteDAO).execute(note);
    }
    public void delete(note note){
     new DeleteNoteAsync(noteDAO).execute(note);
    }
    public  LiveData<List<note>> getAllNotes(){
        return notes;
    }

    public  static class InsertNoteAsync extends AsyncTask<note,Void,Void> {
        private noteDAO noteDAO;
        private InsertNoteAsync(noteDAO noteDAO){
            this.noteDAO=noteDAO;
        }
        @Override
        protected Void doInBackground(note... notes) {
            noteDAO.insert(notes[0]);
            return null;

        }
    }

    public  static class UpdateNoteAsync extends AsyncTask<note,Void,Void> {
        private noteDAO noteDAO;
        private UpdateNoteAsync(noteDAO noteDAO){
            this.noteDAO=noteDAO;
        }
        @Override
        protected Void doInBackground(note... notes) {
            noteDAO.update(notes[0]);
            return null;

        }
    }

    public  static class DeleteNoteAsync extends AsyncTask<note,Void,Void> {
        private noteDAO noteDAO;
        private DeleteNoteAsync(noteDAO noteDAO){
            this.noteDAO=noteDAO;
        }
        @Override
        protected Void doInBackground(note... notes) {
            noteDAO.delete(notes[0]);
            return null;

        }
    }
}
