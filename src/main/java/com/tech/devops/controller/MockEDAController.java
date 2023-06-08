package com.tech.devops.controller;

import com.tech.devops.dto.ecw.Identification;
import com.tech.devops.dto.ecw.Identifications;
import com.tech.devops.dto.ecw.UpdateIdentity;
import com.tech.devops.dto.eda.CAIResponse;
import com.tech.devops.dto.eda.EDARequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MockEDAController {

    @PostMapping(value = "eda", consumes = { MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CAIResponse> edaMock(@RequestBody EDARequest caiRequest){
        log.info("--->> EDA Request: {}", caiRequest);

        CAIResponse caiResponse = new CAIResponse();
        caiResponse.setActualResponse(" Enter command: RESP:TRANSID,1234567890987654:0");

        return new ResponseEntity<>(caiResponse, HttpStatus.OK);
    }

    @PutMapping("sample-kt")
    public ResponseEntity<UpdateIdentity> sampleKt(@RequestBody UpdateIdentity updateIdentity){
        log.info("--->> Update Identification Data: {}", updateIdentity);

        updateIdentity.setIdentity("ESF SOA");
        Identification id = new Identification();
        id.setId("123456789");
        id.setIdTp("eu1-ertyu12345-253464");
        Identifications ids = new Identifications();
        ids.setIdentification(id);
        updateIdentity.setIdentifications(ids);
        updateIdentity.setReason("Update successful");

        return new ResponseEntity<>(updateIdentity, HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<Map<String, String>> test(@RequestParam String depth, @RequestParam String sort) {
        log.info("--->> Testing\nDepth: {}\nSort: {}", depth, sort);

        Map<String, String> map = new HashMap<>();
        map.put("provider", "ESF");
        map.put("accessToken", "eywertyuiop[we234567890-sodijhbgcnd.vsjhgrygfh3u54798yhf3wueh");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "vlr", consumes = { MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CAIResponse> edaMockVLR(@RequestBody EDARequest caiRequest){
        log.info("--->> EDA Request: {}", caiRequest);

        CAIResponse caiResponse = new CAIResponse();
        caiResponse.setActualResponse(" Enter command: RESP:TRANSID,00111223:0:RESULT,HLRSN,1:IMSI,645020055427697:ISDN,260765646628:CardType,USIM:NAM,BOTH:CATEGORY,COMMON:SABLOCK:BasicService:Telephony(TS11):EmergencyCall(TS12):ShortMessageMT_PP(TS21):ShortMessageMO_PP(TS22):DefaultCall,Telephony(TS11):SSData:CFU,PROV:CFB,PROV:CFNRY,PROV:CFNRC,PROV:BAOC,PROV:BOIC,PROV:BOICEXHC,PROV:BAIC,PROV:BICROAM,PROV:CLIP,PROV:CW,PROV:HOLD,PROV:MPTY,PROV:CCBSTARGET,PROV:O-CSI:TPLID,31:STATE,TRUE:T-CSI:TPLID,33:STATE,TRUE:U-CSI:TPLID,17:VLR/SGSNRoamingRestrict:SGSNLIST,1:GPRSData:CNTXID,1:APN,internet:CNTXID,2:APN,wap:CNTXID,3:APN,mms:EPSData:CNTXID,1:APNTPLID,3:SMDP,MSC:RROption,ALL_PLMNS:SMSINAPService:SKEY,0");

        return new ResponseEntity<>(caiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "hlr", consumes = { MediaType.APPLICATION_XML_VALUE},
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CAIResponse> edaMockHLR(@RequestBody EDARequest caiRequest){
        log.info("--->> EDA Request: {}", caiRequest);

        CAIResponse caiResponse = new CAIResponse();
        caiResponse.setActualResponse(" Enter command: RESP:TRANSID,00112235:0:RESULT,IMSI,645020055427697:MSISDN,260765646628:STATUS,1:OnHLR,0");

        return new ResponseEntity<>(caiResponse, HttpStatus.OK);
    }
}
