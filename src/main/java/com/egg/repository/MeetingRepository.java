package com.egg.repository;

import com.egg.model.Meeting;
import java.util.List;
import java.util.Optional;

/**Data access operations for meeting documents in the meeting collection. */
public interface MeetingRepository {

    Meeting save(Meeting meeting);

    Optional<Meeting> findById(String id);

    List<Meeting> findAll();

    void deleteById(String id);
}
