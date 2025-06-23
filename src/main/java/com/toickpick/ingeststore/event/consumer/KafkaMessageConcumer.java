package com.toickpick.ingeststore.event.consumer;

import com.toickpick.ingeststore.event.consumer.message.tour.TourEvent;
import com.toickpick.ingeststore.repository.TourCourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageConcumer {

    private final TourCourseRepository tourCourseRepository;

    @KafkaListener(
            topics = TourEvent.Topic,
            properties = {
                    JsonDeserializer.VALUE_DEFAULT_TYPE
                            + ":com.toickpick.ingeststore.event.consumer.message.tour.TourEvent"
            }
    )
    void handleTourinfoEvent(TourEvent event, Acknowledgment ack) {
        log.info("TourEvent 처리. userId={}",event.getTourCourse());
        tourCourseRepository.save(event.getTourCourse());
    }
}
