package com.vidya.techbullsassignment.view.list;

import java.util.List;
import java.util.concurrent.Executor;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.vidya.techbullsassignment.model.ShowSearchDetails;
import com.vidya.techbullsassignment.repo.ShowDataSourceFactory;
import com.vidya.techbullsassignment.repo.ShowRepository;

public class ShowViewModel extends AndroidViewModel
{
    private ShowRepository mShowRepository;
    private ShowDataSourceFactory mShowDataSourceFactory;
    private LiveData<List<ShowSearchDetails>> mBookmarkList;
    private LiveData<PagedList<ShowSearchDetails>> mShowSearchLiveData;

    public ShowViewModel(@NonNull Application application)
    {
        super(application);
        mShowRepository = ShowRepository.getInstance(application);
        mShowDataSourceFactory = new ShowDataSourceFactory(mShowRepository, application);
        initializePaging();
        mBookmarkList = mShowRepository.getAllBookMark();
    }

    public LiveData<List<ShowSearchDetails>> getBookmarkList()
    {
        return mBookmarkList;
    }

    public void insert(ShowSearchDetails showSearchDetails)
    {
        mShowRepository.insertBookMark(showSearchDetails);
    }

    public void delete(ShowSearchDetails showSearchDetails)
    {
        mShowRepository.deleteBookMark(showSearchDetails);
    }



    private void initializePaging() {

        PagedList.Config pagedListConfig =
            new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();

        mShowSearchLiveData = new LivePagedListBuilder<>(mShowDataSourceFactory, pagedListConfig)
            .build();

    }


    public void searchShow(String mSearchKey, Executor executor)
    {
        PagedList.Config pagedListConfig =
            new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();
        mShowDataSourceFactory.setSearchKey(mSearchKey);

        mShowSearchLiveData = new LivePagedListBuilder<>(mShowDataSourceFactory, pagedListConfig)
            .build();
        // Build PagedList
    }

    public LiveData<PagedList<ShowSearchDetails>> getmShowSearchLiveData()
    {
        return mShowSearchLiveData;
    }

}
