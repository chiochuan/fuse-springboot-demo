package com.chiochuan.demo.fuse.processor;

import javax.ws.rs.core.MediaType;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;

public class ExceptionProcessor implements Processor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {

		Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
		LOGGER.error("Exception caught : {}", cause);

		if (null != cause) {
			if (cause instanceof DuplicateKeyException) {
				exchange.getOut().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON);
				exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
				exchange.getOut().setBody("{message: \" dplicate id\"}");
			} else {
				exchange.getOut().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON);
				exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
				exchange.getOut().setBody("{message: \" unable to process\"}");
			}
		} else {
			exchange.getOut().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON);
			exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
			exchange.getOut().setBody("{message: \" unable to process\"}");
		}
	}

}
