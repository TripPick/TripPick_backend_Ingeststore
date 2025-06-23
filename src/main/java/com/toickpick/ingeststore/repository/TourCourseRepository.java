package com.toickpick.ingeststore.repository;

import com.toickpick.ingeststore.event.consumer.TourCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourCourseRepository extends JpaRepository<TourCourse, String> {
}