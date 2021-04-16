package com.bootcamp.avengers.model.service;

import com.bootcamp.avengers.model.entity.Activity;
import io.reactivex.Completable;
import io.reactivex.Observable;

import java.util.List;

public interface IApiService {

    Observable<List<Activity>> getAllActivities();

    Completable saveActivity(Activity activity);

    Observable<List<Activity>> getAllActivitiesByCategory(Long idCategory);
}
