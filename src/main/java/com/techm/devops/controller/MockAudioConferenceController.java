package com.techm.devops.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.techm.devops.dto.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/audioconference")
public class MockAudioConferenceController {

	@PostMapping
	public ResponseEntity<Map<String, String>> createBridge(@RequestBody CreateBridge createBridge,
		@RequestHeader("Authorization") String authorization) {
		log.info("--->> Create bridge: {}\nAuthorization: {}", createBridge, authorization);

		if(authorization == null)
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

		Map<String, String> map = new HashMap<>();
		map.put("phoneNumber", "234567890");
		map.put("conferenceId", "zz454");
		map.put("moderatorPincode", "54666");
		map.put("participantPincode", "100");

		log.info("--->> Create bridge response: {}", map);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("{serviceAccountId}/resend_details")
	public ResponseEntity<Map<String, String>> resendBridge(@PathVariable String serviceAccountId,
		@RequestHeader("Authorization") String authorization) {
		log.info("--->> Resend bridge: {}\nAuthorization Header: {}", serviceAccountId, authorization);

		if(authorization == null)
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

		Map<String, String> map = new HashMap<>();
		map.put("message", "Message sent");

		log.info("--->> Resend bridge response: {}", map);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping("{serviceAccountId}")
	public ResponseEntity<Map<String, Object>> updateBridge(@PathVariable String serviceAccountId,
                                                            @RequestBody UpdateBridge updateBridge, @RequestHeader("Authorization") String authorization) {
		log.info("--->> Update bridge: {}\n ServiceAccountId: {}\nAuthorization: {}", updateBridge, serviceAccountId, authorization);

		if(authorization == null)
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

		Map<String, Object> map = new HashMap<>();
		Map<String, Object> conferenceSchedule = new HashMap<>();
		Map<String, Object> scheduleReservationless = new HashMap<>();

		map.put("title", "234567890");
		map.put("restrictParticipants", false);
		map.put("muteAllAttendeesOnEntry", false);
		map.put("endConferenceOnModeratorExit", false);
		map.put("moderatorRequired", false);
		map.put("requireSecurityPin", true);
		map.put("securityPin", "54666");
		map.put("allowUniqueIdentifier", false);
		map.put("attendeeNotification", "Play recorded name");

		scheduleReservationless.put("startTime", LocalDateTime.now());
		conferenceSchedule.put("scheduleReservationless", scheduleReservationless);
		map.put("conferenceSchedule", conferenceSchedule);
		map.put("moderatorPin", "54666");
		map.put("hostTimeZone", "Africa/Kampala");

		log.info("--->> Update bridge response: {}", map);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping("{serviceAccountId}")
	public ResponseEntity<Map<String, Object>> deleteBridge(@PathVariable String serviceAccountId,
		@RequestHeader("Authorization") String authorization) {
		log.info("--->> Terminate bridge: {}\nAuthorization Header: {}", serviceAccountId, authorization);

		if(authorization == null)
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}