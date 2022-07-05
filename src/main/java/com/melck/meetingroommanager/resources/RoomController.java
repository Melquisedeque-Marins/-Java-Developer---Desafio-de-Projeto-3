package com.melck.meetingroommanager.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.melck.meetingroommanager.dtos.RoomDTO;
import com.melck.meetingroommanager.entities.Room;
import com.melck.meetingroommanager.services.RoomService;

@RestController
@CrossOrigin(origins = "http://localhost:4288")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAll(){
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable Long id){
        Room room = roomService.findById(id);
        return ResponseEntity.ok().body(room);
    }

    @PostMapping
    public ResponseEntity<Room> create(@Valid @RequestBody RoomDTO roomDTO){
        Room newRoon = roomService.create(roomDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRoon.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id, @Valid @RequestBody Room room){
        Room roomUpdate = roomService.update(id, room);
       
        return ResponseEntity.ok().body(roomUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> delete(@PathVariable Long id){
        roomService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
