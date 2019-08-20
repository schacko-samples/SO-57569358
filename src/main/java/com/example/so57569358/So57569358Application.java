package com.example.so57569358;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class So57569358Application {

	private static final Log logger = LogFactory.getLog(So57569358Application.class);

	public static void main(String[] args) {
		SpringApplication.run(So57569358Application.class, args);
	}

	@Bean
	public java.util.function.Consumer<KStream<Object, String>> so57569358(ExternalCommunication externalCommunication) {
		return input ->input.foreach((key, value) -> {
			logger.info("Sending data: " + value);
			externalCommunication.sendData((value));
		});
	}

	@Bean
	public ExternalCommunication externalCommunication() {
		return new ExternalCommunication();
	}
}

class ExternalCommunication {

	public void sendData(String data) {
		//logic to send data...
	}
}