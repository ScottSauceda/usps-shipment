package com.example.uspsshipment.controller;

import com.example.uspsshipment.model.Shipment;
import com.example.uspsshipment.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;


    @GetMapping("/{trackingNumber}")
    public Shipment getShipment(@PathVariable Long trackingNumber){
        return shipmentService.getShipment(trackingNumber);
    }

    @PostMapping("/addshipment")
    public Shipment createShipment(@RequestBody Shipment shipment){
        return shipmentService.createShipment(shipment);
    }

}
