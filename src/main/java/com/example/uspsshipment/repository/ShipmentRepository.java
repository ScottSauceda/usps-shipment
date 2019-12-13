package com.example.uspsshipment.repository;

import com.example.uspsshipment.model.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentRepository extends CrudRepository<Shipment, Long>{

    @Query("FROM Shipment s where s.trackingNumber = ?1")
    public Shipment getShipmentByTrackingNumber(Long trackingNumber);

}
