package com.techere.project.domain.room.repository;

import com.techere.project.domain.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
