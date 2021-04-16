package com.bootcamp.avengers.controllers;

import com.bootcamp.avengers.model.entity.Activity;
import com.bootcamp.avengers.model.service.IApiService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity/v1")
public class ApiController {
    @Autowired
    private IApiService apiService;

    @GetMapping("/")
    public String get() {
        return "bootcamp-avengers-activity api rest";
    }

    @GetMapping("/all")
    public Observable<List<Activity>> getAllActivities() {
        return apiService.getAllActivities()
                .subscribeOn(Schedulers.io());
    }

    @PostMapping("/save")
    public Completable saveActivity(@RequestBody Activity activity) {
        return apiService.saveActivity(activity)
                .subscribeOn(Schedulers.io());
    }

    @GetMapping("/allByCategory")
    public Observable<List<Activity>> getAllActivitiesByCategory(Long idCategory) {
        return apiService.getAllActivitiesByCategory(idCategory)
                .subscribeOn(Schedulers.io());
    }
}