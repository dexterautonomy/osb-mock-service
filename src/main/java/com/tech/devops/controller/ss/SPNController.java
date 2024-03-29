package com.tech.devops.controller.ss;

import com.tech.devops.dto.spn.Envelope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/spn")
@CrossOrigin(maxAge = 3600, origins = "*")
public class SPNController {

    @PostMapping(value = "offer", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> subscriptionOffer(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "offer-removal", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> removeOffer(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }
}