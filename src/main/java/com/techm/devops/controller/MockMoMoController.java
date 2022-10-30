package com.techm.devops.controller;

import com.techm.devops.dto.momo.*;
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
    public ResponseEntity viewMobileMoneyBalance(){

        return null;
    }

    @PostMapping(value = "unblock", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity unblockMobileMoneyProfile(){

        return null;
    }

    @PostMapping(value = "payment-completed", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity updatePaymentToECW(){

        return null;
    }
}