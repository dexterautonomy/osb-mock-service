package com.techm.devops.controller;

import com.techm.devops.dto.ecw.UpdateIMSI;
import com.techm.devops.dto.ecw.UpdateIMSIResponse;
import com.techm.devops.dto.momo.*;
import com.techm.devops.manualXML.Argument;
import com.techm.devops.manualXML.Body;
import com.techm.devops.manualXML.ErrorResponse;
import com.techm.devops.manualXML.XMLToPOJO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/momo")
public class MockMoMoController {

    @PostMapping(value = "transaction-history", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
    produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<TransactionHistoryResponseDTO> viewMobileMoneyTransactions(@RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        log.info("--->> {}", transactionHistoryDTO);

        TransactionHistoryResponseDTO transactionHistoryResponseDTO = new TransactionHistoryResponseDTO();
        List<Transactionhistoryentry> transactionhistoryentries = new ArrayList<>();
        Transactionhistoryentry transactionhistoryentry = new Transactionhistoryentry();
        transactionhistoryentries.add(transactionhistoryentry);
        transactionhistoryentries.add(transactionhistoryentry);
        transactionhistoryentries.add(transactionhistoryentry);

        transactionHistoryResponseDTO.setTransactionhistoryentries(transactionhistoryentries);
        return new ResponseEntity<>(transactionHistoryResponseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MobileMoneyRegistrationInfoResponseDTO> viewMobileMoneyRegistrationInfo(
            @RequestBody MobileMoneyRegistrationInfoRequestDTO mobileMoneyRegistrationInfoRequestDTO) {
        log.info("--->> {}", mobileMoneyRegistrationInfoRequestDTO);

        return ResponseEntity.ok(new MobileMoneyRegistrationInfoResponseDTO());
    }

    @PostMapping(value = "balance", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MobileMoneyBalanceResponseDTO> viewMobileMoneyBalance(
            @RequestBody MobileMoneyBalanceRequestDTO mobileMoneyBalanceRequestDTO){
        log.info("--->> {}", mobileMoneyBalanceRequestDTO);

        return ResponseEntity.ok(new MobileMoneyBalanceResponseDTO());
    }

    @PostMapping(value = "unblock", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UnblockMoMoProfileResponseDTO> unblockMobileMoneyProfile(
            @RequestBody UnblockMoMoProfileRequestDTO unblockMoMoProfileRequestDTO){
        log.info("--->> {}", unblockMoMoProfileRequestDTO);

        return ResponseEntity.ok(new UnblockMoMoProfileResponseDTO());
    }

    @PostMapping(value = "payment-completed", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<PaymentCompletedResponseDTO> updatePaymentToECW(
            @RequestBody PaymentCompletedRequestDTO paymentCompletedRequestDTO){
        log.info("--->> {}", paymentCompletedRequestDTO);

        return ResponseEntity.ok(new PaymentCompletedResponseDTO());
    }

    @PostMapping(value = "set-imsi", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> setIMSI(@RequestBody Object request){
        log.info("--->> Set IMSI Request: {}", request);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "get-imsi", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<GetIMSIResponse> getIMSI(@RequestBody Object request){
        log.info("--->> Get IMSI Request: {}", request);

        return new ResponseEntity<>(new GetIMSIResponse(), HttpStatus.OK);
    }

    @PostMapping(value = "debit", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<DebitResponse> debitRequest(@RequestBody Object request) {
        log.info("--->> Debit Request: {}", request);

        return new ResponseEntity<>(new DebitResponse(), HttpStatus.OK);
    }

    @PostMapping(value = "registration", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RegistrationResponse> registrationRequest(@RequestBody Object request) {
        log.info("--->> Registration Request: {}", request);

        return new ResponseEntity<>(new RegistrationResponse(), HttpStatus.OK);
    }

    @PostMapping(value = "error", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> error(@RequestBody Object request) {
        log.info("--->> Error: {}", request);

        Body body = new Body();
        ErrorResponse errorResponse = new ErrorResponse();

        for(int count = 0; count < 2; count++) {
            Argument argument = new Argument();
            if(count == 0) {
                argument.setName("fri");
                argument.setValue("invalid fri");
            } else {
                argument.setName("message");
                argument.setValue("Request: GetBalanceRequest violates constraints!");
            }
            errorResponse.getArguments().add(argument);
        }

        return new ResponseEntity<>(errorResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}