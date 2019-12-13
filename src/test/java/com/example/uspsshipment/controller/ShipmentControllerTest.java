package com.example.uspsshipment.controller;

import com.example.uspsshipment.model.Shipment;
import com.example.uspsshipment.repository.ShipmentRepository;
import com.example.uspsshipment.service.ShipmentService;
import com.example.uspsshipment.service.ShipmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ShipmentControllerTest {
    @Mock
    ShipmentService shipmentService;

    @InjectMocks
    ShipmentController shipmentController;

    Shipment dummyShipment;

    private MockMvc mockMvc;

    @Before
    public void init() {

        mockMvc = MockMvcBuilders.standaloneSetup(shipmentController).build();
        dummyShipment = new Shipment();
        dummyShipment.setId(1L);
        dummyShipment.setName("Osman");
        dummyShipment.setTrackingNumber(123L);
    }

    @Test
    public void getShipment() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/shipment/123");

        when(shipmentService.getShipment(anyLong())).thenReturn(dummyShipment);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void createShipment() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/shipment/addshipment")
                .content(jsonShipment())
                .contentType(MediaType.APPLICATION_JSON)
                ;

        when(shipmentService.createShipment(any())).thenReturn(dummyShipment);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }

    public String jsonShipment(){
        return "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"xyz\",\n" +
                "    \"trackingNumber\": 123\n" +
                "}";
    }
}