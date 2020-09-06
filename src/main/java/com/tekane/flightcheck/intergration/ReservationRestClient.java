package com.tekane.flightcheck.intergration;

import com.tekane.flightcheck.dto.Reservation;
import com.tekane.flightcheck.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
     Reservation findReservation(Long id);
     Reservation updateReservation(ReservationUpdateRequest request);
}
