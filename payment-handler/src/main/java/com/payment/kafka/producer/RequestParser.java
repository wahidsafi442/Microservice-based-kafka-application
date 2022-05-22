package com.payment.kafka.producer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RequestParser {

    public static final Logger LOG = LoggerFactory.getLogger(RequestParser.class);

    @SuppressWarnings("unchecked")
    public PaymentFactory parseRequest(String file)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        PaymentFactory paymentObject = new PaymentFactory();

        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray paymentRequestObj = (JSONArray) obj;
            LOG.info(paymentRequestObj.toString());

            //Iterate over employee array
            paymentObject = parsePaymentObject((JSONObject) paymentRequestObj.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paymentObject;
    }

    private PaymentFactory parsePaymentObject(JSONObject request)
    {
        JSONObject paymentRequest = (JSONObject) request.get("payment");

        String paymentType = (String) paymentRequest.get("paymentType");
        String amount = (String) paymentRequest.get("amount");

        PaymentFactory paymentObj = new PaymentFactory();
        paymentObj.setPaymentType(paymentType);
        paymentObj.setAmount(amount);

        return paymentObj;
    }
}
