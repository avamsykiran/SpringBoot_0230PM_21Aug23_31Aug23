  Lab-Setup

        JDK 1.8
        STS latest 
        Spring Framework 5.x
        Spring Boot 2.x
        MySQl Community Server 8 above


    Pre-Reequisite

        Spring Core, Spring IoC,Spring Bean,Spring Context,Spring SpEL
        JPA and Hibernate
        JUnit 5


Spring Boot
--------------------------------------------------------------------------------------------------------------

    is a spring module used tht providds auto-configuration and by that promotes RAD.

        1. Rapid Application Development.
        2. Serverless Applications

    Spring Boot Application
        1. Spring Boot CLI
        2. Spring Tool Suite 
        3. Spring Starter Portal https://start.spring.io

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}

@SpringBootApplication  =
                            @Configuration
                            @PropertySource("classpath:application.properties")
                            @ComponentScan("current.package.as.base.package")


SpringApplication.run(SpringBootDemoApplication.class, args);

    1. create ApplicationContext
    2. Invoke Spring Boot Runner Classes (if any)
    3. Invoke Spring Embeded Server (if any)
    4. The ApplicationContext is destroyed and Application Terminates

Spring Boot Rumner is any class that implments CommandLineRunner interface or ApplicationRunner interface.
Thee runner classes are sued to do any specific task jsut before the Embeded Server gets started.

Spring Web MVC On Spring Boot
--------------------------------------------------------------------------------------------------------------------

    Single Front Controller MVC Archetecture:

    DB <--> Repo(s) <--> Service(s) <--> Controller(s) <--- FrontController <--------------REQ--- WebClient(Browser)  <--> EndUser
                                            |                    ↑  |                                   ↑
                                            |->viewName(+model)->|  |                                   |
                                                                    |                                   |
                                                                    | (model)                           |
                                                                    ↓                                   |
                                                                    View(s) ----------Resp------------->|
                                                                    (JSP/JSF/Thymeleeaf ...etc.,)


    FrontController

        DispatcherServlet from Spring Framework that plays the Front Controller
            0. Receive any request from the client
            1. invokes an action method from a controller of the request
            2. receive the viewName and model from the action method.
            3. identify the view for the givne viewNAme and attach the model to it.

    Controller

        is any POJO that offers action methods to handle an incoming request.
        and these action methods are expected to return a view name or a model and view name back.

    UrlHandlerMapping
        |
        |<- BeanNameUrlHandlerMapping
        |<- ControllerNameUrlHandlerMapping
        |<- SinpleUrlkHAndlerMapping

            These classes will help the front controller to search and invoke a specific action mehtod from a specific controller for
            a given request.

            Spring Boot configs SimpleUrlHandlerMapping by default.

            http://localhost:8080/home      invokes the below action method.

            @Controller
            public class WelcomeController {
                @RequestMapping(value="/home",method=RequestMethod.GET)
                public String showHoemAction(){
                    return "index";
                }
            }

    ViewResolver
        |
        |<- MessageBundleResourceViewResolver
        |<- XmlResourceViewResolver
        |<- InternalViewResolver

        These view resolver help the fornt controller to pick up a view for a given viewName

        Sprinb Boot by default configures InternalViewResolver.
        InternalViewResolver has two properties prefix and suffix and use the belwo formula to pick up a view for a viewName

            view = prefix + viewName + suffix

            assuming prefix is "/WEB-INf/pages/"
            and         suffix is ".jsp"

            view = "/WEB-INF/pages/index.jsp"

    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    @RequestMapping(value="/home",method=RequestMethod.POST)
    @RequestMapping(value="/home",method=RequestMethod.PUT)
    @RequestMapping(value="/home",method=RequestMethod.DELETE) ...etc.,

        @GetMapping("/home")
        @PostMapping("/home")
        @PutMapping("/home")
        @DeleteMapping("/home")


Spring Data JPA on Spring Boot
------------------------------------------------------------------------------------------------------

    JPa is the java's approach for ORM .

    Spring Data JPA is a sub-moudle of Spring Data Module.

    Spring Data Module provides us with auto-implemented repositories.

    Spring Data JPA provides us with auto-implemented Jpa Repositories.

    Spring Data JDBC provides us with auto-implemented Jdbc Repositories  ....etc.,

    Spring Data JPA

        CrudRepository
            |
            |<- JpaRepository
                    save(entity)            //insertion or updation
                    deleteById(pk)
                    findById(pk)
                    findAll()
                    existsById(pk)
    
        @Entity
        public class Consumer{
            @Id
            private Long consumerId;
            private String fullName;
            private String mobile;
            private String mailId;
            private Double membershipFee;

            //construcotrs,getters,setters ...et.,
        }

        public interface ConsumerRepo  extends JpaRepository<Consumer,Long> {

        }


    Spring Rest On Spring Boot
    ---------------------------------------------------------------------------------------------------

        Instead of @Controller we can use @RestControllerm, and however we do not have VIEWS.

        Model-RestController Archetecture.

           DB <--> Repo(s) <--> Service(s) <--> RestController(s) <--- FrontController <--------------REQ--- Rest Client (Postman/insomnia/Angular App ..etc.,)
                                                    |
                                                    |----------------------------Response (json/xml)-------->

        
       Rest API is an alternate to SOAP Web Servcie. A Web Service is a method that can be invoked
       from a remote appliction.

       A remote application ca send a request (URL) and the application server will execute the web service method
       mapped to the URL and will share the result with the remote application.

       SOAP web services can communicate only using XML as media.

       REST (REpresentational State Trnasfer) is a web service that runs on HTTP SERVERS.
       Http perotocol support a wide variety of media like xml,json,text, pictures, binary ...et.,                                   

       Perform CRUD operations on a resource we need not have multiple end-points (urls).

       For Example, if Consumer is a resource

                                                                                                                        HttpStatus
                                Http Method     End Point       requestBody     responseBody    OnSuccess   OnClientSideError       OnServerSiudeError
                                -------------------------------------------------------------------------------------------------------------------------
       get all consumers        GET             /consumers      none            consumers[]     OK          BAD_REQUEST             INTERNAL_SERVER_ERROR
       get consuemr by id       GET             /consumers/101  none            consuemrObject  OK          NOT_FOUND               INTERNAL_SERVER_ERROR
       add consumer             POST            /consuemrs      consuemr object consuemrObject  CREATED     BAD_REQUEST             INTERNAL_SERVER_ERROR
       update consuemr          PUT             /consuemrs      consuemr object consuemrObject  ACCEPTED    BAD_REQUEST             INTERNAL_SERVER_ERROR
       delete consuemr          DELETE          /consumers/101  none            none            NO_CONTENT  NOT_FOUND               INTERNAL_SERVER_ERROR

       @RestController  =  @Controller + @ResponseBody

       ResponseEntity       = responseBodyContent + httpStatus



    Spring Profiles
    ---------------------------------------------------------------------------------------------------

        Profile?
            an isolated set of configuaratiosna and choice of components for executing our application in specific
            stage of project life cycle and/or environment.

            dev,testing,deployment/production ...etc.,

        @Profile("")
            is apllied on a component or a configuaration class.

        @Component
        publi class DummyComponent{

            @Autowired
            @Qualifier("projectOwner")
            private String projOwner;
        }

        @Configuaration
        @Profile("dev")
        public class Config1 {
            @Bean
            public String projectOwner(){
                return "Vamsy Kiran Aripaka";
            }
        }

        @Configuaration
        @Profile("test")
        public class Config2 {
            @Bean
            public String projectOwner(){
                return "Sagar";
            }
        }

        @Configuaration
        @Profile("prod")
        public class Config3 {
            @Bean
            public String projectOwner(){
                return "Nimal Kumar";
            }
        }

        application.properties
            spring.profiles.active=dev

        application-dev.properties
        application-test.properties
        application-prod.properties

        application.properties
            spring.profiles.active=dev

            spring.jpa.show-sql = false
            spring.jpa.hibernate.ddl-auto = update

            #---
            spring.config.activate.on-profile=dev
            server.port = 8888
            spring.datasource.url = jdbc:h2:mem:db
            spring.datasource.driver-class-name=org.h2.driver
            spring.datasource.username = sa
            spring.datasource.password = sa           
            
            #---
            spring.config.activate.on-profile=prod
            server.port = 9999
            spring.datasource.url = jdbc:mysql://localhost:3306/hrappdb
            spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
            spring.datasource.username = root
            spring.datasource.password = root           
            spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

