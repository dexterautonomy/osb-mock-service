package com.techm.devops.controller.ss;

import com.techm.devops.dto.ss.provisioning.Envelope;
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
    public ResponseEntity<Object> addSub(@RequestBody Object object){
        log.info("--->> Huawei: AddSub");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "rmvsub", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> rmvSub(@RequestBody Object object){
        log.info("--->> Huawei: RmvSub");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "modproduct", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> modProd(@RequestBody Object object){
        log.info("--->> Huawei: ModProduct");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "modvas", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> modvas(@RequestBody Object object){
        log.info("--->> Huawei: ModVAS");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "suspend", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> suspend(@RequestBody Object object){
        log.info("--->> Huawei: Suspension");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "revoke", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> revoke(@RequestBody Object object){
        log.info("--->> Huawei: RevokeSuspension");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "reactivate", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> reactivate(@RequestBody Object object){
        log.info("--->> Huawei: ManualReactivation");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    /*For MODIMSI, MODMSISDN, QUERYUSER, BAR/UNBAR*/
    @PostMapping(value = "generic", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> generic(@RequestBody Object object){
        log.info("--->> Huawei: ModIMSI | ModMSISDN | QueryUser");

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }
}