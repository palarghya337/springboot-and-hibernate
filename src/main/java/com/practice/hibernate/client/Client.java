package com.practice.hibernate.client;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.practice.hibernate.beans.Salesman;

public class Client {

	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
	private static final String URL = "http://localhost:8081/";
	static WebClient webClient = WebClient.builder()
			.baseUrl(URL).build();
	public static void main(String[] args) {
		
		LOGGER.info("\n1. Get All\n2. Add\n3. Update"
				+ "\n4. Get By ID\n5. Delete By ID\n6. Delete All");
		try (Scanner scan = new Scanner(System.in)) {
			
			int input = Integer.parseInt(scan.nextLine());
			switch(input) {

			case 1: {
				List<Salesman> salesmen = getAllSalesman();
				salesmen.stream()
				.forEach(salesman -> LOGGER.info(salesman.toString()));
				break;
			}
			case 2: {

				LOGGER.info("Name: ");
				String name = scan.nextLine();
				LOGGER.info("City");
				String city = scan.nextLine();
				LOGGER.info("Commission");
				double commission = scan.nextDouble();
				
				Salesman salesman = new Salesman();
				salesman.setId(101);
//				salesman.setCity(city);
				salesman.setCommission(commission);
				
				webClient.post().uri("salesmen/addNew")
				.syncBody(salesman)
				.retrieve()
				.bodyToMono(Void.class)
				.block();
				break;
			}
			case 3: {

				Salesman salesman = getSalesman(1);
//				salesman.setCity("West Bengal");
				webClient.put().uri("salesmen/updateSalesman")
				.syncBody(salesman)
				.retrieve()
				.bodyToMono(Void.class)
				.block();
				break;
			}
			case 4: {
				Salesman salesman = getSalesman(101);
				LOGGER.info(salesman.toString());
			}
			case 5: {
				boolean isDeleted = webClient.delete()
					.uri("salesmen/delete/{id}", 1)
					.retrieve()
					.bodyToMono(Boolean.class)
					.block();
				LOGGER.info("isDeleted: " + isDeleted);
				break;
			}
			case 6: {
				boolean isDeleted = webClient.delete()
						.uri("salesmen/delete")
						.retrieve()
						.bodyToMono(Boolean.class)
						.block();
				LOGGER.info("isDeleted: " + isDeleted);
				break;
			}
			}
		}
	}
	private static List<Salesman> getAllSalesman() {
		List<Salesman> salesmen = webClient.get()
				.uri("salesmen/all")
				.retrieve()
				.bodyToFlux(Salesman.class)
				.collectList()
				.block();
		return salesmen;
	}
	private static Salesman getSalesman(int id) {
		return webClient.get()
				.uri("salesmen/{id}", id)
				.retrieve()
				.bodyToMono(Salesman.class)
				.block();
	}
}
