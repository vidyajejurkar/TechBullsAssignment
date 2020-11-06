package com.vidya.techbullsassignment.adapter;


import com.vidya.techbullsassignment.model.ShowSearchDetails;

public interface IShowClickListner
{
    void onShowClick(ShowSearchDetails showDetails);
    void onSaveBookMark(ShowSearchDetails showDetails);
    void onDeleteBookMark(ShowSearchDetails showDetails);
}
