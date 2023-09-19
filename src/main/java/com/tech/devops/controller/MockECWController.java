package com.tech.devops.controller;

import com.tech.devops.dto.ben.PinResetResponse;
import com.tech.devops.dto.ecw.*;
import com.tech.devops.dto.ecw.*;
import com.tech.devops.manualXML.Argument;
import com.tech.devops.manualXML.Body;
import com.tech.devops.manualXML.ErrorResponse;
import com.tech.devops.manualXML.Fault;
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

	@PostMapping(value = "fault", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> fault(@RequestBody Object request) {
		log.info("--->> Error: {}", request);

		return new ResponseEntity<>(Fault.fault(), HttpStatus.OK);
	}

	@PostMapping(value = "getaccountholderaddress", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getaccountholderaddress(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<ns2:getaccountholderaddressresponse xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_0\">\n" +
				"   <addresses>\n" +
				"      <address>\n" +
				"         <AdrTp>HOME</AdrTp>\n" +
				"         <MlngInd>false</MlngInd>\n" +
				"         <RegnAdrInd>false</RegnAdrInd>\n" +
				"         <NmAndAdr>\n" +
				"            <Adr>\n" +
				"               <AdrTp>HOME</AdrTp>\n" +
				"            </Adr>\n" +
				"         </NmAndAdr>\n" +
				"      </address>\n" +
				"\t  <address>\n" +
				"         <AdrTp>HOME</AdrTp>\n" +
				"         <MlngInd>false</MlngInd>\n" +
				"         <RegnAdrInd>false</RegnAdrInd>\n" +
				"         <NmAndAdr>\n" +
				"            <Adr>\n" +
				"               <AdrTp>HOME</AdrTp>\n" +
				"            </Adr>\n" +
				"         </NmAndAdr>\n" +
				"      </address>\n" +
				"\t  <address>\n" +
				"         <AdrTp>HOME</AdrTp>\n" +
				"         <MlngInd>false</MlngInd>\n" +
				"         <RegnAdrInd>false</RegnAdrInd>\n" +
				"         <NmAndAdr>\n" +
				"            <Adr>\n" +
				"               <AdrTp>HOME</AdrTp>\n" +
				"            </Adr>\n" +
				"         </NmAndAdr>\n" +
				"      </address>\n" +
				"   </addresses>\n" +
				"</ns2:getaccountholderaddressresponse>\n" +
				"\n";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "getaccountholdercitizenship", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getaccountholdercitizenship(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
				"<ns2:getaccountholdercitizenshipresponse xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_0\">\n" +
				"<citizenships>\n" +
				"<citizenship>\n" +
				"<MnrInd>false</MnrInd>\n" +
				"<Ntlty>BFR</Ntlty>\n" +
				"</citizenship>\n" +
				"<citizenship>\n" +
				"<MnrInd>false</MnrInd>\n" +
				"<Ntlty>BFR</Ntlty>\n" +
				"</citizenship>\n" +
				"<citizenship>\n" +
				"<MnrInd>false</MnrInd>\n" +
				"<Ntlty>BFR</Ntlty>\n" +
				"</citizenship>\n" +
				"</citizenships>\n" +
				"</ns2:getaccountholdercitizenshipresponse>";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "getaccountholderidentification", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getaccountholderidentification(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<ns2:getaccountholderidentificationresponse xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_0\">\n" +
				"   <identifications>\n" +
				"      <identification>\n" +
				"         <Id>I5747489849</Id>\n" +
				"         <IdTp>NRIN</IdTp>\n" +
				"      </identification>\n" +
				"\t  <identification>\n" +
				"         <Id>I5747489849</Id>\n" +
				"         <IdTp>NRIN</IdTp>\n" +
				"      </identification>\n" +
				"\t  <identification>\n" +
				"         <Id>I5747489849</Id>\n" +
				"         <IdTp>NRIN</IdTp>\n" +
				"      </identification>\n" +
				"   </identifications>\n" +
				"</ns2:getaccountholderidentificationresponse>\n";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "getaccountholderpersonalinformation", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getaccountholderpersonalinformation(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
				"<ns5:getaccountholderpersonalinformationresponse\n" +
				"xmlns:prc=\"http://www.ericsson.com/em/emm/provisioning/v1_0/common\"\n" +
				"xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_1/common\"\n" +
				"xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n" +
				"xmlns:ns5=\"http://www.ericsson.com/em/emm/provisioning/v1_1\">\n" +
				"<information>\n" +
				"<name>\n" +
				"<firstname>Hansen</firstname>\n" +
				"<surname>Duma</surname>\n" +
				"</name>\n" +
				"<language>en</language>\n" +
				"<birth>\n" +
				"<date>2003-06-05</date>\n" +
				"<country>SS</country>\n" +
				"</birth>\n" +
				"<occupation/>\n" +
				"<residentialstatus/>\n" +
				"</information>\n" +
				"</ns5:getaccountholderpersonalinformationresponse>";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "updateaccountholderaddress", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateaccountholderaddress(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ns2:updateaccountholderaddressresponse xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_0\"/>";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "updateaccountholdercitizenship", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateaccountholdercitizenship(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ns2:updateaccountholdercitizenshipresponse xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_0\"/>";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "updateaccountholderidentification", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateaccountholderidentification(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<ns8:updateaccountholderidentificationresponse xmlns:op=\"http://www.ericsson.com/em/emm/v1_0/common\" xmlns:fic=\"http://www.ericsson.com/em/emm/financial/v1_2/common\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:ns4=\"http://www.ericsson.com/em/emm/financial/v1_0/common\" xmlns:ns5=\"http://www.ericsson.com/em/emm/v2_1/common\" xmlns:ns6=\"http://www.ericsson.com/em/emm/financial/v1_1/common\" xmlns:ns8=\"http://www.ericsson.com/em/emm/provisioning/v1_0\" xmlns:ns9=\"http://www.ericsson.com/em/emm/financial/v1_2\" xmlns:ns10=\"http://www.ericsson.com/em/emm/financial/v1_0\" xmlns:ns11=\"http://www.ericsson.com/em/emm/financial/v1_1\"/>";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "updateaccountholderpersonalinformation", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateaccountholderpersonalinformation(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ns5:updateaccountholderpersonalinformationresponse xmlns:prc=\"http://www.ericsson.com/em/emm/provisioning/v1_0/common\" xmlns:ns2=\"http://www.ericsson.com/em/emm/provisioning/v1_1/common\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:ns5=\"http://www.ericsson.com/em/emm/provisioning/v1_1\"/>";

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "error1", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> error1(@RequestBody Object request) {
		log.info("--->> Request: {}", request);

		String response = "<ns0:errorResponse \terrorcode=\"COULD_NOT_PERFORM_OPERATION\" xmlns:ns0=\"http://www.ericsson.com/lwac\">\n" +
				"<arguments \tname=\"message\" value=\"COULD_NOT_PERFORM_OPERATION\"/>\n" +
				"</ns0:errorResponse>";

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}