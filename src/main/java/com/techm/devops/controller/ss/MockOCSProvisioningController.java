package com.techm.devops.controller.ss;

import com.techm.devops.dto.ss.ocs.changesubpaymentmode.ChangeSubPaymentModeResultMsg;
import com.techm.devops.dto.ss.ocs.changesubscriberinfo.ChangeSubInfoResultMsg;
import com.techm.devops.dto.ss.ocs.changesubstatus.ChangeSubStatusResultMsg;
import com.techm.devops.dto.ss.ocs.createsubscriber.CreateSubscriberResultMsg;
import com.techm.devops.dto.ss.ocs.creditlimitchange.ChangeAcctCreditLimitResultMsg;
import com.techm.devops.dto.ss.ocs.cugsubscription.AddGroupMemberResultMsg;
import com.techm.devops.dto.ss.ocs.cugsubscription.DelGroupMemberResultMsg;
import com.techm.devops.dto.ss.ocs.querybalance.QueryBalanceResultMsg;
import com.techm.devops.dto.ss.ocs.querycustomerinfo.QueryCustomerInfoResultMsg;
import com.techm.devops.dto.ss.ocs.queryfreelimit.QueryFreeUnitResultMsg;
import com.techm.devops.dto.ss.ocs.subdeactivation.SubDeactivationResultMsg;
import com.techm.devops.dto.ss.ocs.suboffering.ChangeSubOfferingResultMsg;
import com.techm.devops.dto.ss.ocs.subscriberidentifier.ChangeSubIdentityResultMsg;
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

    @PostMapping(value = "addCUG", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> addCUG(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new AddGroupMemberResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "delCUG", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> delCUG(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new DelGroupMemberResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "suboffering", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> suboffering(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new ChangeSubOfferingResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "changestatus", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changestatus(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new ChangeSubStatusResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "change-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> changeInfo(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new ChangeSubInfoResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "balance", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> balance(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new QueryBalanceResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "freelimit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> freelimit(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new QueryFreeUnitResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "customer-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> customerInfo(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new QueryCustomerInfoResultMsg(), HttpStatus.OK);
    }

    @PostMapping(value = "primary-offering", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> primaryOffering(@RequestBody Object object){
        log.info("--->> Request: {}", object);

        return new ResponseEntity<>(new com.techm.devops.dto.ss.ocs.primaryoffering.ChangeSubOfferingResultMsg(), HttpStatus.OK);
    }

//    Change Subscriber Identifier
@PostMapping(value = "subscriber-identifier", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<Object> subscriberIdentifier(@RequestBody Object object){
    log.info("--->> Request: {}", object);

    return new ResponseEntity<>(new ChangeSubIdentityResultMsg(), HttpStatus.OK);
}
}