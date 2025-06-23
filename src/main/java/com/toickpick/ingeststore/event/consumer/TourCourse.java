package com.toickpick.ingeststore.event.consumer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tourCourse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourCourse {

    @Id
    @Column(name = "contentId")
    private String contentId;

    @Column(name = "contentTypeId")
    private String contentTypeId;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "addr1", length = 500)
    private String addr1;

    @Column(name = "addr2", length = 500)
    private String addr2;

    @Column(name = "zipcode", length = 20)
    private String zipcode;

    @Column(name = "tel", length = 50)
    private String tel;

    @Column(name = "firstImage", length = 1000)
    private String firstImage;

    @Column(name = "firstImage2", length = 1000)
    private String firstImage2;

    @Column(name = "mapX")
    private Double mapX;

    @Column(name = "mapY")
    private Double mapY;

    @Column(name = "areacode")
    private Integer areaCode;

    @Column(name = "sigungucode")
    private Integer sigunguCode;

    @Column(name = "cat1", length = 50)
    private String cat1;

    @Column(name = "cat2", length = 50)
    private String cat2;

    @Column(name = "cat3", length = 50)
    private String cat3;

    @Column(name = "bookTour", length = 50)
    private String bookTour;

    @Column(name = "cpyrhtDivCd", length = 50)
    private String cpyrhtDivCd;

    @Column(name = "mlevel", length = 50)
    private String mLevel;

    @Column(name = "createdTime")
    private LocalDateTime createdTime;

    @Column(name = "modifiedTime")
    private LocalDateTime modifiedTime;

    public void setCreatedtimeFromString(String createdtimeStr) {
        this.createdTime = parseDateTime(createdtimeStr);
    }

    public void setModifiedtimeFromString(String modifiedtimeStr) {
        this.modifiedTime = parseDateTime(modifiedtimeStr);
    }

    private LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
}