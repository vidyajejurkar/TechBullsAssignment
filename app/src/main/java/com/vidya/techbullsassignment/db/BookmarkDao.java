package com.vidya.techbullsassignment.db;

import java.util.List;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.vidya.techbullsassignment.model.ShowSearchDetails;

@Dao
public interface BookmarkDao
{
    @Insert
    void insertBookmark(ShowSearchDetails bookMark);

    @Query("SELECT * FROM bookmarkdata order by _id desc")
    LiveData<List<ShowSearchDetails>> getAllBookMarks();

    @Delete
    void deleteBookmark(ShowSearchDetails bookMark);
}
