package com.bookshop.controller;

import com.bookshop.model.Booking;
import com.bookshop.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/{bookingId}")
	Optional<Booking> getBookingById(@PathVariable Long bookingId) {
		return bookingService.getBookingById(bookingId);
	}

	@PostMapping
	Booking createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}

	@PutMapping("/{bookingId}")
	Booking editBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
		return bookingService.editBooking(booking, bookingId);
	}

	@DeleteMapping("/{bookingId}")
	void cancelBooking(@PathVariable Long bookingId) {
		bookingService.cancelBooking(bookingId);
	}


}
