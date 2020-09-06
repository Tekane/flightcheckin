package com.tekane.flightcheck.intergration;

import com.tekane.flightcheck.dto.Reservation;
import com.tekane.flightcheck.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {
    private static final String RESERVATION_URL = "http://localhost:8080/flightreservation/reservation/";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_URL + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(RESERVATION_URL, request, Reservation.class);
        return reservation;
    }
}
