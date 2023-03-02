package com.techm.devops.controller.ss;

import com.techm.devops.dto.ss.ocs.subdeactivation.Envelope;
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

        return new ResponseEntity<>(new Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "createsubscriber", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> createsubscriber(@RequestBody Object object){
        log.info("--->> OCS: CreateSubscriber");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.createsubscriber.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "changepayment", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changepayment(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubPaymentMode");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.changesubpaymentmode.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "creditlimit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> creditlimit(@RequestBody Object object){
        log.info("--->> OCS: ChangeAccountCreditLimit");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.creditlimitchange.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "addCUG", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> addCUG(@RequestBody Object object){
        log.info("--->> OCS: AddCUG");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.cugsubscription.addcug.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "delCUG", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> delCUG(@RequestBody Object object){
        log.info("--->> OCS: RmvCUG");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.cugsubscription.removecug.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "suboffering", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> suboffering(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubOffering");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.suboffering.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "changestatus", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changestatus(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubStatus");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.changesubstatus.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "change-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changeInfo(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubInfo -- ChangeLanguage");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.changesubscriberinfo.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "balance", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> balance(@RequestBody Object object){
        log.info("--->> OCS: QueryBalance");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.querybalance.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "freelimit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> freelimit(@RequestBody Object object){
        log.info("--->> OCS: QueryFreeLimit");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.queryfreelimit.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "customer-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> customerInfo(@RequestBody Object object){
        log.info("--->> OCS: QueryCustomerInformation");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.querycustomerinfo.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "primary-offering", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> primaryOffering(@RequestBody Object object){
        log.info("--->> OCS: AddPrimaryOffering");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.primaryoffering.Envelope(), HttpStatus.OK);
    }

    @PostMapping(value = "subscriber-identifier", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> subscriberIdentifier(@RequestBody Object object){
        log.info("--->> OCS: ChangeSubIdentity");

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.subscriberidentifier.Envelope(), HttpStatus.OK);
    }
}