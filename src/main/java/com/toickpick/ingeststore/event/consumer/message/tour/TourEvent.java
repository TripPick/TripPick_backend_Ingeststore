package com.toickpick.ingeststore.event.consumer.message.tour;


import com.toickpick.ingeststore.event.consumer.TourCourse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourEvent {
    public static  final String Topic = "tourinfo";

    private String action;

    private com.toickpick.ingeststore.event.consumer.TourCourse tourCourse;

    public static TourEvent fromEntity(String action, TourCourse tourCourse) {
        TourEvent message = new TourEvent();

        message.action = action;
        message.tourCourse = tourCourse;
        return message;
    }


}
