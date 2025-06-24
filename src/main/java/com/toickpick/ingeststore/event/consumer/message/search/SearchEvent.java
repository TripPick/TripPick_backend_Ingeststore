package com.toickpick.ingeststore.event.consumer.message.search;


import com.toickpick.ingeststore.event.consumer.dto.Search;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchEvent {
    public static  final String Topic = "searchinfo";

    private String action;

    private Search search;

    public static SearchEvent fromEntity(String action, Search search) {
        SearchEvent message = new SearchEvent();

        message.action = action;
        message.search = search;
        return message;
    }


}
