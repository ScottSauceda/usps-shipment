package com.example.uspsshipment.service;

import com.example.uspsshipment.model.Shipment;
import com.example.uspsshipment.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ShipmentService {

    public Shipment getShipment(Long trackingNumber);

    public Shipment createShipment(Shipment shipment);

}
