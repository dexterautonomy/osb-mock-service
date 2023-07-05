package com.tech.devops.controller.ss;

import com.tech.devops.dto.ss.ocs.subdeactivation.Envelope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ocs")
@CrossOrigin(maxAge = 3600, origins = "*")
public class MockOCSProvisioningController {

    @PostMapping(value = "subdeactivation", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> subdeactivation(@RequestBody Object object){
        log.info("--->> OCS: SubDeactivation");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "createsubscriber", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> createsubscriber(@RequestBody Object object){
        log.info("--->> OCS: CreateSubscriber");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.createsubscriber.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "changepayment-hybrid-postpaid", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changePaymentHybridToPostpaid(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubPaymentMode-Hybrid-Postpaid");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.changesubpaymentmode.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "changepayment-postpaid-hybrid", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changePaymentPostpaidToHybrid(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubPaymentMode-Postpaid-Hybrid");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.changesubpaymentmode.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "creditlimit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> creditlimit(@RequestBody Object object){
        log.info("--->> OCS: ChangeAccountCreditLimit");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.creditlimitchange.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "addCUG", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> addCUG(@RequestBody Object object){
        log.info("--->> OCS: AddCUG");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.cugsubscription.addcug.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "delCUG", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> delCUG(@RequestBody Object object){
        log.info("--->> OCS: RmvCUG");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.cugsubscription.removecug.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "change-primary-offering", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> suboffering(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubOffering");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.suboffering.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "changestatus", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changestatus(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubStatus");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.changesubstatus.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "change-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changeInfo(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubInfo -- ChangeLanguage");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.changesubscriberinfo.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "balance", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> balance(@RequestBody Object object){
        log.info("--->> OCS: QueryBalance");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.querybalance.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "freelimit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> freelimit(@RequestBody Object object){
        log.info("--->> OCS: QueryFreeLimit");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.queryfreelimit.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "customer-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> customerInfo(@RequestBody Object object) throws InterruptedException {
        Thread.sleep(5000);
        log.info("--->> OCS: QueryCustomerInformation");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.querycustomerinfo.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "add-supplemetary-offering", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> addSupplementaryOffering(@RequestBody Object object){
        log.info("--->> OCS: AddPrimaryOffering");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.primaryoffering.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "subscriber-identifier", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> subscriberIdentifier(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubIdentity");
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.tech.devops.dto.ss.ocs.subscriberidentifier.Envelope(), HttpStatus.OK);
    }
}