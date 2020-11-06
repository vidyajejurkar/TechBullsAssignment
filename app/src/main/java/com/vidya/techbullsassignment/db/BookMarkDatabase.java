package com.vidya.techbullsassignment.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.vidya.techbullsassignment.model.ShowSearchDetails;

@Database(entities = {ShowSearchDetails.class}, version = 1, exportSchema = false)
public abstract class BookMarkDatabase extends RoomDatabase
{
    public abstract BookmarkDao getDao();
}
