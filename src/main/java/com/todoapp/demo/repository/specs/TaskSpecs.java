package com.todoapp.demo.repository.specs;

import com.todoapp.demo.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskSpecs {
    public static Specification<Task> nameLike(String name){
        return((root, query, cb) ->
                cb.like(root.get("name"),"%"+name+"%")
        );
    }

    public static Specification<Task> startDateEqual(LocalDate startDate){
        return((root, query, cb) ->
                cb.equal(root.get("startDate"), startDate)
        );
    }

    public static Specification<Task> finishDateEqual(LocalDate finishDate){
        return((root, query, cb) ->
                cb.equal(root.get("finishDate"), finishDate)
        );
    }

    public static Specification<Task> datePeriod(LocalDate startDate, LocalDate finishDate){
        return((root, query, cb) ->
                 cb.between(root.get("startDate"), startDate, finishDate)
        );
    }

    public static Specification<Task> startTimeEqual(LocalTime startTime){
        return((root, query, cb) ->
            cb.equal(root.get("startTime"), startTime)

        );
    }

    public static Specification<Task> finishTimeEqual(LocalTime finishTime){
        return((root, query, cb) ->
                cb.equal(root.get("finishTime"), finishTime)

        );
    }

    public static Specification<Task> timePeriod(LocalTime startTime, LocalTime finishTime){
        return((root, query, cb) ->
                cb.between(root.get("startTime"), startTime, finishTime)
        );
    }
}
