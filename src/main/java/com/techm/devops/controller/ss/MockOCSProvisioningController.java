package com.techm.devops.controller.ss;

import com.techm.devops.dto.ss.ocs.changesubpaymentmode.ChangeSubPaymentModeResultMsg;
import com.techm.devops.dto.ss.ocs.createsubscriber.CreateSubscriberResultMsg;
import com.techm.devops.dto.ss.ocs.creditlimitchange.ChangeAcctCreditLimitResultMsg;
import com.techm.devops.dto.ss.ocs.subdeactivation.SubDeactivationResultMsg;
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
@RequestMapping("api/v1/ocs")
public class MockOCSProvisioningController {

    @PostMapping(value = "subdeactivation", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> subdeactivation(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new SubDeactivationResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "createsubscriber", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> createsubscriber(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new CreateSubscriberResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "changepayment", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changepayment(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new ChangeSubPaymentModeResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "creditlimit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> creditlimit(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new ChangeAcctCreditLimitResultMsg(), HttpStatus.OK);
    }
}