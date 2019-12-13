package com.example.uspsshipment.service;

import com.example.uspsshipment.model.Shipment;
import com.example.uspsshipment.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;


    @Override
    public Shipment getShipment(Long trackingNumber) {
        return shipmentRepository.getShipmentByTrackingNumber(trackingNumber);
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
