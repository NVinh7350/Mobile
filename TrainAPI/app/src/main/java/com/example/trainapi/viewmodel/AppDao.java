package com.example.trainapi.viewmodel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.trainapi.model.Dog;

import java.util.List;

@Dao
public interface AppDao {
    @Query("SELECT * FROM Dog")
    public List<Dog> getAllContact();

    @Insert
    public void insertAll(Dog... dog);

    @Delete
    void delete(Dog dog);
}
