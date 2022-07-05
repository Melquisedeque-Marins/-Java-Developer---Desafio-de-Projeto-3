package com.melck.meetingroommanager.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melck.meetingroommanager.dtos.RoomDTO;
import com.melck.meetingroommanager.entities.Room;
import com.melck.meetingroommanager.exceptions.ResourceNotFoundException;
import com.melck.meetingroommanager.repositories.RoomRepository;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Room findById(Long id){
        Optional<Room> room = roomRepository.findById(id);
        return room.orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
    }

    public List<Room> findAll() {
        List<Room> list = roomRepository.findAll();
        return list;
    }

    public Room create(RoomDTO roomDTO) {
       return roomRepository.save(modelMapper.map(roomDTO, Room.class));
    }

    public Room update(Long id, Room room) {
        Room roomSaved = findById(id); 
        roomSaved.setName(room.getName());
        roomSaved.setDate(room.getDate());
        roomSaved.setStartHour(room.getStartHour());
        roomSaved.setEndHour(room.getEndHour());

        return roomRepository.save(roomSaved);
    }

    public void delete(Long id) {
        Room room = findById(id);
        roomRepository.delete(room);
    }
}
