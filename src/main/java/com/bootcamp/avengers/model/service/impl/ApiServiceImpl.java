package com.bootcamp.avengers.model.service.impl;

import com.bootcamp.avengers.model.entity.Activity;
import com.bootcamp.avengers.model.repository.ActivityRepository;
import com.bootcamp.avengers.model.service.IApiService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements IApiService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Observable<List<Activity>> getAllActivities() {
        return Observable.fromArray(activityRepository.findAll());
    }

    @Override
    public Completable saveActivity(Activity activity) {
        return Completable.create(subscriber -> {
            activityRepository.save(activity);
            subscriber.onComplete();
        });
    }

    @Override
    public Observable<List<Activity>> getAllActivitiesByCategory(Long idCategory) {
        return Observable.fromArray(activityRepository.findAllByCategory(idCategory));
    }
}