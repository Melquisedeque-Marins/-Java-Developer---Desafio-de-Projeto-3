package com.melck.meetingroommanager.services;

import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.melck.meetingroommanager.dtos.RoomDTO;
import com.melck.meetingroommanager.entities.Room;
import com.melck.meetingroommanager.repositories.RoomRepository;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {
    
    @Mock
    private RoomRepository roomRepository;

    private ModelMapper modelMapper;

    @InjectMocks
    private RoomService roomService;

    @Test
    void whenInformedThenItShukdBeCreated(){
        // given
        RoomDTO roomDTO = new RoomDTO( null, "sala01", "12/12/2012", "09:00", "10:00");
       
       Room expectedSavedRoom = modelMapper.map(roomDTO, Room.class);
        
        // when
        when(roomRepository.save(expectedSavedRoom)).thenReturn(expectedSavedRoom);
    
        // then
        Room createdRoom = roomService.create(roomDTO);

        MatcherAssert.assertThat(createdRoom.getId(), Matchers.is(Matchers.equalTo(roomDTO.getId())));
        MatcherAssert.assertThat(createdRoom.getName(), Matchers.is(Matchers.equalTo(roomDTO.getName())));
        MatcherAssert.assertThat(createdRoom.getDate(), Matchers.is(Matchers.equalTo(roomDTO.getDate())));
        MatcherAssert.assertThat(createdRoom.getStartHour(), Matchers.is(Matchers.equalTo(roomDTO.getStartHour())));
        MatcherAssert.assertThat(createdRoom.getEndHour(), Matchers.is(Matchers.equalTo(roomDTO.getEndHour())));


       // assertThat(createdRoom.getId(), is(equalTo(expectedSavedRoom.getId())));
       // assertThat(createdRoom.getName(), is(equalTo(expectedSavedRoom.getName())));
       // assertThat(createdRoom.getDate(), is(equalTo(expectedSavedRoom.getDate())));
       // assertThat(createdRoom.getStartHour(), is(equalTo(expectedSavedRoom.getStartHour())));
       // assertThat(createdRoom.getEndHour(), is(equalTo(expectedSavedRoom.getEndHour())));

        /*
        assertEquals(roomDTO.getId(), createdRoom.getId());
        assertEquals(roomDTO.getName(), createdRoom.getName());
        assertEquals(roomDTO.getDate(), createdRoom.getDate());
        assertEquals(roomDTO.getStartHour(), createdRoom.getStartHour());
        assertEquals(roomDTO.getEndHour(), createdRoom.getEndHour());
         */
    }
  
}
