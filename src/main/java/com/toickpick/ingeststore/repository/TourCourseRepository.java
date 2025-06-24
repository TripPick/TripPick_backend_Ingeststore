package com.toickpick.ingeststore.repository;

import com.toickpick.ingeststore.event.consumer.dto.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourCourseRepository extends JpaRepository<Search, String> {
}