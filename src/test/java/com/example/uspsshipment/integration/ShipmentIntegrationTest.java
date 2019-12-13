package com.example.uspsshipment.integration;

import com.example.uspsshipment.model.Shipment;
import com.example.uspsshipment.repository.ShipmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("qa")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentIntegrationTest {
    @Autowired
    ShipmentRepository shipmentRepository;

    @Test
    public void createShipment(){
        Shipment dummyShipment = new Shipment();
        dummyShipment = new Shipment();
        dummyShipment.setId(1L);
        dummyShipment.setName("Osman");
        dummyShipment.setTrackingNumber(123L);

        Shipment savedShipment = shipmentRepository.save(dummyShipment);

        assertEquals(dummyShipment.getName(), savedShipment.getName());
    }

    @Test
    public void getShipment(){
        Shipment dummyShipment = new Shipment();
        dummyShipment = new Shipment();
        dummyShipment.setId(2L);
        dummyShipment.setName("isha");
        dummyShipment.setTrackingNumber(456L);

        shipmentRepository.save(dummyShipment);

        Shipment savedShipment = shipmentRepository.getShipmentByTrackingNumber(456L);

        assertEquals(dummyShipment.getName(), savedShipment.getName());

    }
}
