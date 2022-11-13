package com.techm.devops.controller.ss;

import com.techm.devops.dto.ecw.UpdateCitizenship;
import com.techm.devops.dto.ecw.UpdateCitizenshipResponse;
import com.techm.devops.dto.ss.provisioning.SendSyncReqResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/huawei")
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

}