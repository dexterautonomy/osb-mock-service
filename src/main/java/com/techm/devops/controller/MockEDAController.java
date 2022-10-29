package com.techm.devops.controller;

import com.techm.devops.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MockEDAController {

    @PostMapping(value = "eda", consumes = { MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CAIResponse> edaMock(@RequestBody EDARequest caiRequest){
        log.info("--->> EDA Request: {}", caiRequest);

        CAIResponse caiResponse = new CAIResponse();
        caiResponse.setActualResponse("Enter command: RESP:0");

        return new ResponseEntity<>(caiResponse, HttpStatus.OK);
    }

    @PutMapping("sample-kt")
    public ResponseEntity<UpdateIdentity> sampleKt(@RequestBody UpdateIdentity updateIdentity){
        log.info("--->> Update Identification Data: {}", updateIdentity);

        updateIdentity.setIdentity("ESF SOA");
        Identification id = new Identification();
        id.setId("123456789");
        id.setIdTp("eu1-ertyu12345-253464");
        Identifications ids = new Identifications();
        ids.setIdentification(id);
        updateIdentity.setIdentifications(ids);
        updateIdentity.setReason("Update successful");

        return new ResponseEntity<>(updateIdentity, HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<Map<String, String>> test(@RequestParam String depth, @RequestParam String sort) {
        log.info("--->> Testing\nDepth: {}\nSort: {}", depth, sort);

        Map<String, String> map = new HashMap<>();
        map.put("provider", "ESF");
        map.put("accessToken", "eywertyuiop[we234567890-sodijhbgcnd.vsjhgrygfh3u54798yhf3wueh");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
