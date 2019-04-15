# API básica para manipular uma pessoa (Documentação com Swagger)


## Dependência do Maven (Swagger)

	<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger2</artifactId>
		<version>2.7.0</version>
	</dependency>

	<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger-ui</artifactId>
		<version>2.7.0</version>
		<scope>compile</scope>
	</dependency>
	
## Classe de configuração do Swagger (joshua.maia.helloswagger.config.SwaggerConfig)

	@EnableSwagger2
	@Configuration
	public class SwaggerConfig {

	@Bean
	public Docket detalheApi() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("joshua.maia"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());
 
		return docket;
	}
 
	private ApiInfoBuilder informacoesApi() {
 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Api-Person");
		apiInfoBuilder.description("Api to perform a CRUD.");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Term of Use: Should be used for studies.");
		apiInfoBuilder.license("License - Open Source");
		apiInfoBuilder.licenseUrl("https://github.com/joshuamaia");
 
		return apiInfoBuilder;
 
	}
	
	}

		
## Rodar a aplicação
Rodar a classe HelloswaggerApplication para inicializar o projeto. Serão criados 3 pessoas com IDs 1,2 e 3.

Para acessar a documentação do Swagger, após iniciar o projeto, acessar http://localhost:8080/swagger-ui.html.


