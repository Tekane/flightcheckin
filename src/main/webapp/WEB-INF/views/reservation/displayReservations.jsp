<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>
AirLines: ${reservation.flight.operatingAirlines}<br/>
Flight No: ${reservation.flight.flightNumber}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
Arrival City: ${reservation.flight.arrivalCity}<br/>
Date Of Departure: ${reservation.flight.dateOfDeparture}<br/>
Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br/>


<h2>Passenger Detailss</h2>
First Name: ${reservation.passenger.firstName}<br/>
Last name: ${reservation.passenger.lastName}<br/>
Email: ${reservation.passenger.email}<br/>
Phone: ${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">
    Number of bags: <input type="text" name="numberOfBags"/>
    <input type="hidden" name="reservationId" value="${reservation.id}">
    <input type="submit" value="Check In"/>
</form>
</body>
</html>