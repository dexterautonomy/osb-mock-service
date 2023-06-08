package com.tech.devops.controller;

import com.tech.devops.dto.ben.PinResetResponse;
import com.tech.devops.dto.ecw.*;
import com.tech.devops.dto.ecw.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MockECWController {

	@PostMapping(value = "update-citizen", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UpdateCitizenshipResponse> updateCitizenship(@RequestBody UpdateCitizenship updateCitizenship){
		log.info("--->> Update Citizen Data: {}", updateCitizenship);

		return new ResponseEntity<>(new UpdateCitizenshipResponse(), HttpStatus.OK);
	}

	@PostMapping(value = "update-id", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UpdateIdentityResponse> updateId(@RequestBody UpdateIdentity updateIdentity){
		log.info("--->> Update Identification Data: {}", updateIdentity);

		return new ResponseEntity<>(new UpdateIdentityResponse(), HttpStatus.OK);
	}

	@PostMapping(value = "update-info", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UpdatePersonalInfoResponse> updatePersonalInfo(@RequestBody UpdatePersonalInfo updatePersonalInfo){
		log.info("--->> Update Personal Info: {}", updatePersonalInfo);

		return new ResponseEntity<>(new UpdatePersonalInfoResponse(), HttpStatus.OK);
	}

	@PostMapping(value = "id", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AccountHolderInfoResponse> getInfo(@RequestBody AccountHolderInfo accountHolderInfo){
		log.info("--->> Account Holder Info: {}", accountHolderInfo);
		AccountHolderBasicInfo accountHolderBasicInfo = AccountHolderBasicInfo.builder()
				.language(Language.builder().code("0123").build())
				.acceptedTermsAndConditions("True")
				.accountHolderStatus("Valid")
				.bankDomainName("Zenith")
				.firstname("Enterprise Service")
				.surname("Framework")
				.hasParent("True")
				.profileName("ESF")
				.msisdn("+23375847589")
				.loyaltyPointsAccountFRI("1000 points")
				.internalIdentity("123AA8892")
				.financialResourceInformations(FinancialResourceInformations.builder()
						.financialResource(FinancialResource.builder()
								.currency(Currency.builder()
										.code("USD")
										.build())
								.financialResourceInfo("No FRI")
								.build())
						.build())
				.build();

		AccountHolderInfoResponse accountHolderInfoResponse = AccountHolderInfoResponse.builder()
				.accountHolderBasicInfo(accountHolderBasicInfo)
				.build();

		return new ResponseEntity<>(accountHolderInfoResponse, HttpStatus.OK);
	}

	@PostMapping(value = "update-imsi", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UpdateIMSIResponse> updateIMSI(@RequestBody UpdateIMSI updateIMSI){
		log.info("--->> Update IMSI Data: {}", updateIMSI);

		return new ResponseEntity<>(new UpdateIMSIResponse(), HttpStatus.OK);
	}

	@PostMapping("token")
	public ResponseEntity<Map<String, String>> token(@RequestParam String client_id, @RequestParam String client_secret,
		@RequestParam String grant_type, @RequestParam String username, @RequestParam String password,
		@RequestParam String scope) {
		log.info("--->> Requesting token");

		Map<String, String> map = new HashMap<>();
		map.put("access_token", "eywertyuiopwe234567890.sodijhbgcnd.vsjhgrygfh3u54798yhf3wuehygiwedbhbcuygwyesgywe7378284bhvbr44i7ydhyub3w478hdwhebvdybybvc9u987r37fb3y83yf83y483.ew");
		map.put("refresh_token", "eywertyuiopwe234567890-sodijhbgcnd.vsjhgrygfh3u54798yhf3wueh");
		map.put("scope", "Generic");
		map.put("id_token", "qwertyui123456789gfdsdfghjk");
		map.put("token_type", "Super");
		map.put("expires_in", "1000000000");

		log.info("--->> Gotten token: {}", map);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping(value = "reset-pin", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> resetPin(@RequestBody Object object){
		log.info("--->> Benin use case: Reset Pin: {}", object);

		return new ResponseEntity<>(new PinResetResponse(), HttpStatus.OK);
	}
}