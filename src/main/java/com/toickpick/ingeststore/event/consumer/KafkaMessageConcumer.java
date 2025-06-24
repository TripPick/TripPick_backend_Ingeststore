package com.toickpick.ingeststore.event.consumer;

import com.toickpick.ingeststore.event.consumer.message.search.SearchEvent;
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
            topics = SearchEvent.Topic,
            properties = {
                    JsonDeserializer.VALUE_DEFAULT_TYPE
                            + ":com.toickpick.ingeststore.event.consumer.message.search.SearchEvent"
            }
    )
    void handleTourinfoEvent(SearchEvent event, Acknowledgment ack) {
        log.info("SearchEvent 처리. contentId={}",event.getSearch());
        tourCourseRepository.save(event.getSearch());
    }
}
