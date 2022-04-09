package com.example.trainapi.viewmodel;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.trainapi.model.Dog;

@Database(entities = {Dog.class}, version=3,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao contactDao();
    private static  AppDatabase instance;

    static Migration migration = new Migration(1,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'Contact' ADD COLUMN 'uri' TEXT DEFAULT ''");
        }
    };
    public static AppDatabase getInstance(Context context)
    {
        if (instance == null){
            synchronized (AppDatabase.class){
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "AppDog")
                        .addMigrations(migration)
                        .build();

            }
        }
        return instance;
    }

}
