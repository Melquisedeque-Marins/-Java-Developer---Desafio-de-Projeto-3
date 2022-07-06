package com.melck.meetingroommanager.resources;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
//import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.melck.meetingroommanager.dtos.RoomDTO;
import com.melck.meetingroommanager.entities.Room;
import com.melck.meetingroommanager.services.RoomService;

@ExtendWith(MockitoExtension.class)
public class RoomControlerTest {
    
    private static final String ROOM_API_URL_PATH = "/api/v1";
    //private static final Long VALID_ROOM_ID = 1L;
    //private static final Long INVALID_ROOM_ID = 2L;
   // private static final String ROMM_API_SUBPATH_INCREMENT_URL = "/increment";
   // private static final String ROMM_API_SUBPATH_DECREMENT_URL = "/decrement";

    private MockMvc mockMvc;

    private ModelMapper modelMapper;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(roomController)
        .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
        .setViewResolvers((s, locate) -> new MappingJackson2JsonView())
        .build();
    }

    @Test
        void whenPostIsCalledThenRoonIsCreated(){
            // given
            RoomDTO roomDTO = new RoomDTO( null, "sala01", "12/12/2012", "09:00", "10:00");
            Room room = modelMapper.map(roomDTO, Room.class);

            //when 
            when(roomService.create(roomDTO)).thenReturn(room);

           // when(roomService.create(roomDTO)).thenReturn(roomDTO);

            //then
            /* 
            mockMvc.perform(post(ROOM_API_URL_PATH))
            .contentType(MediaType.APPLICATION_JSON)
            .contentType(asJsonString(roomDTO))
            .andExpect(status().isCreaterd())
            .andExpect(jsonPath("$.name", is(roomDTO.getName())))
            .andExpect(jsonPath("$.date", is(roomDTO.getDate())))
            .andExpect(jsonPath("$.startHour", is(roomDTO.getStartHour())))
            .andExpect(jsonPath("$.endHour", is(roomDTO.getEndHour()))));  
            */ 
        }

}
