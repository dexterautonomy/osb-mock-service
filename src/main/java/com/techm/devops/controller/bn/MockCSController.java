package com.techm.devops.controller.bn;

import com.techm.devops.dto.ben.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MockCSController {
	@PostMapping(value = "change-language", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MethodResponse> resetPin(@RequestBody Object object){
		log.info("--->> Benin use case: Change Language: {}", object);

		Value_2 val2 = new Value_2();
		val2.setString("20125630");
		Member_2 m2 = new Member_2();
		m2.setName("originTransactionID");
		m2.setVal(val2);

		Value_1 val1 = new Value_1();
		val1.setI4("7");
		Member_1 m1 = new Member_1();
		m1.setName("serviceClassCurrent");
		m1.setVal(val1);

		Value_1 val1_ = new Value_1();
		val1_.setI4("0");
		Member_1 m1_ = new Member_1();
		m1_.setName("responseCode");
		m1_.setVal(val1_);

		Value_3 val3 = new Value_3();
		val3.setBoolean_("0");
		Member_3[] member3a = new Member_3[6];

		member3a[0] = new Member_3();
		member3a[0].setName("activationStatusFlag");
		member3a[0].setVal(val3);

		member3a[1] = new Member_3();
		member3a[1].setName("negativeBarringStatusFlag");
		member3a[1].setVal(val3);

		member3a[2] = new Member_3();
		member3a[2].setName("serviceFeePeriodExpiryFlag");
		member3a[2].setVal(val3);

		member3a[3] = new Member_3();
		member3a[3].setName("serviceFeePeriodWarningActiveFlag");
		member3a[3].setVal(val3);

		member3a[4] = new Member_3();
		member3a[4].setName("supervisionPeriodExpiryFlag");
		member3a[4].setVal(val3);

		member3a[5] = new Member_3();
		member3a[5].setName("supervisionPeriodWarningActiveFlag");
		member3a[5].setVal(val3);

		Struct_1 struct_1 = new Struct_1();
		struct_1.setMem3(member3a[0]);
//		struct_1.getMem3().add(member3a[1]);
//		struct_1.getMem3().add(member3a[2]);
//		struct_1.getMem3().add(member3a[3]);
//		struct_1.getMem3().add(member3a[4]);
//		struct_1.getMem3().add(member3a[5]);

		Value_4 val4 = new Value_4();
		val4.setStruct(struct_1);
		Member_4 m4 = new Member_4();
		m4.setName("accountFlagsBefore");
		m4.setVal(val4);

		Struct_2 struct2 = new Struct_2();
		struct2.setMem4(m4);
		struct2.setMem2(m2);
		struct2.setMem1(m1_);

		Value_5 val5 = new Value_5();
		val5.setStruct(struct2);

		Param param = new Param();
		param.setValue(val5);

		Params params = new Params();
		params.setParam(param);

		MethodResponse methodResponse = new MethodResponse();
		methodResponse.setParams(params);

		return new ResponseEntity<>(methodResponse, HttpStatus.OK);
	}
}