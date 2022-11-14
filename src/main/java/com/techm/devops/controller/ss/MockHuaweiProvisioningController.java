package com.techm.devops.controller.ss;

import com.techm.devops.dto.ss.provisioning.SendSyncReqResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/huawei")
@CrossOrigin(maxAge = 3600, origins = "*")
public class MockHuaweiProvisioningController {

    @PostMapping(value = "addsub", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<SendSyncReqResponse> addSub(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new SendSyncReqResponse(), HttpStatus.OK);
    }

    @PostMapping(value = "rmvsub", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<SendSyncReqResponse> rmvSub(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new SendSyncReqResponse(), HttpStatus.OK);
    }

    @PostMapping(value = "modproduct", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<SendSyncReqResponse> modProd(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new SendSyncReqResponse(), HttpStatus.OK);
    }

    @PostMapping(value = "modvas", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<SendSyncReqResponse> modvas(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new SendSyncReqResponse(), HttpStatus.OK);
    }
}