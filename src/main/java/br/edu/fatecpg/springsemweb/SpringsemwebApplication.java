package br.edu.fatecpg.springsemweb;

import br.edu.fatecpg.springsemweb.service.ConsomeApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

@SpringBootApplication
public class SpringsemwebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringsemwebApplication.class, args);
	}

	Scanner scan = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		String fipeJson = ConsomeApi.obterDados("https://parallelum.com.br/fipe/api/v1/carros/marcas");

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			String jsonFormatado = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(objectMapper.readTree(fipeJson));
			System.out.println("----- MARCAS DISPONÍVEIS -----");
			System.out.println(jsonFormatado);

			System.out.print("\nDigite o Código da Marca desejada: ");
			String codMarca = scan.nextLine();

			String urlModelos = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codMarca + "/modelos";
			String modelosJson = ConsomeApi.obterDados(urlModelos);
			String modelosFormatados = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(objectMapper.readTree(modelosJson));
			System.out.println("\n----- MODELOS DISPONÍVEIS -----");
			System.out.println(modelosFormatados);

			System.out.print("\nDigite o Código do Modelo desejado: ");
			String codModelo = scan.nextLine();

			String urlAnos = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codMarca + "/modelos/" + codModelo + "/anos";
			String anosJson = ConsomeApi.obterDados(urlAnos);
			String anosFormatados = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(objectMapper.readTree(anosJson));
			System.out.println("\n----- ANOS DISPONÍVEIS -----");
			System.out.println(anosFormatados);

			System.out.print("\nDigite o Código do Ano desejado (ex: 2020-1): ");
			String codAno = scan.nextLine();

			String urlPreco = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/" + codAno;
			String precoJson = ConsomeApi.obterDados(urlPreco);
			String precoFormatado = objectMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(objectMapper.readTree(precoJson));

			System.out.println("\n----- INFORMAÇÕES DO VEÍCULO -----");
			System.out.println(precoFormatado);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
