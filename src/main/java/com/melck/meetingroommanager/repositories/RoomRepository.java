package com.melck.meetingroommanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.meetingroommanager.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    
}
