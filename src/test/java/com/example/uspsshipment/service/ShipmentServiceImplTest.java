package com.example.uspsshipment.service;

import com.example.uspsshipment.model.Shipment;
import com.example.uspsshipment.repository.ShipmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ShipmentServiceImplTest {

    @Mock
    ShipmentRepository shipmentRepository;

    @InjectMocks
    ShipmentServiceImpl shipmentService;

    Shipment dummyShipment;

    @Before
    public void init() {
        dummyShipment = new Shipment();
        dummyShipment.setId(1L);
        dummyShipment.setName("Osman");
        dummyShipment.setTrackingNumber(123L);
    }

    @Test
    public void getShipment() {
        when(shipmentRepository.getShipmentByTrackingNumber(anyLong())).thenReturn(dummyShipment);

        Shipment actual = shipmentService.getShipment(123L);

        assertNotNull(actual);
        assertEquals(dummyShipment.getName(), actual.getName());
    }

    @Test
    public void createShipment() {
        when(shipmentRepository.save(any())).thenReturn(dummyShipment);

        Shipment actual = shipmentService.createShipment(dummyShipment);

        assertNotNull(actual);
        assertEquals(dummyShipment.getName(), actual.getName());
    }
}