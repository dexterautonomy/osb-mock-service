package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transactionhistoryentry {
    @JsonProperty("financialtransactionid")
    public String financialtransactionid = "ABCD0983834";
    @JsonProperty("transactionstatus")
    public String transactionstatus = "STATUS";
    @JsonProperty("transfertype")
    public String transfertype = "TYPE";
    @JsonProperty("startdate")
    public LocalDateTime startdate = LocalDateTime.now();
    @JsonProperty("commitdate")
    public LocalDateTime commitdate = LocalDateTime.now();
    @JsonProperty("fxrate")
    public String fxrate = "FIXED";
    @JsonProperty("initiatinguser")
    public String initiatinguser = "ESF-USER";
    @JsonProperty("realuser")
    public String realuser = "OSB-USER";
    @JsonProperty("initiatingaccountholder")
    public String initiatingaccountholder = "MTN Account Holder";
    @JsonProperty("realaccountholder")
    public String realaccountholder = "World Account Holder";
    @JsonProperty("from")
    public String from = "South-Sudan";
    @JsonProperty("fromaccount")
    public String fromaccount = "1234567890";
    @JsonProperty("fromamount")
    public Fromamount fromamount = new Fromamount();
    @JsonProperty("fromavailablebalance")
    public Fromavailablebalance fromavailablebalance = new Fromavailablebalance();
    @JsonProperty("fromtotalbalance")
    public Fromtotalbalance fromtotalbalance = new Fromtotalbalance();
    @JsonProperty("fromcommittedbalance")
    public Fromcommittedbalance fromcommittedbalance = new Fromcommittedbalance();
    @JsonProperty("fromaccountholder")
    public String fromaccountholder = "987654345678";
    @JsonProperty("originalamount")
    public Originalamount originalamount = new Originalamount();
    @JsonProperty("amount")
    public Amount amount = new Amount();
    @JsonProperty("to")
    public String to = "COE Team";
    @JsonProperty("toaccount")
    public String toaccount = "56789065432432";
    @JsonProperty("toamount")
    public Toamount toamount = new Toamount();
    @JsonProperty("maininstructionid")
    public String maininstructionid = "23456ertyuio0987654567";
    @JsonProperty("instructionid")
    public String instructionid = "123456789098765hgtfrds3456";
    @JsonProperty("externaltransactionid")
    public String externaltransactionid = "1234567890dfghjkvbnm,uytre";
    @JsonProperty("toaccountholder")
    public String toaccountholder = "123423456123456";
    @JsonProperty("fromfirstname")
    public String fromfirstname = "Chinedu";
    @JsonProperty("fromlastname")
    public String fromlastname = "Ezeigbo";
    @JsonProperty("fromhandlerfirstname")
    public String fromhandlerfirstname = "How many times Oga!";
    @JsonProperty("fromhandlerlastname")
    public String fromhandlerlastname = "Na wa o!";
    @JsonProperty("communicationchannel")
    public String communicationchannel = "JustPayTheMoney";
    @JsonProperty("fitype")
    public String fitype = "NotFixed";
}
