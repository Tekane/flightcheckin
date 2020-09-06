package com.tekane.flightcheck.controllers;

import com.tekane.flightcheck.dto.Reservation;
import com.tekane.flightcheck.dto.ReservationUpdateRequest;
import com.tekane.flightcheck.intergration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    private ReservationRestClient reservationRestClient;

    @GetMapping("/showStartCheckIn")
    public String showStartCheckIn() {
        return "checkin/startCheckIn";
    }

    @PostMapping("/startCheckIn")
    public String showStartCheckIn(@RequestParam("reservationId") long reservationId, ModelMap modelMap) {
        Reservation reservation = reservationRestClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);
        return "reservation/displayReservations";
    }

    @PostMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId, @RequestParam("numberOfBags") int numberOfBags) {
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        reservationRestClient.updateReservation(reservationUpdateRequest);
        return "checkin/checkInConfirmation";
    }
}
