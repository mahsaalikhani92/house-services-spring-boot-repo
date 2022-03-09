package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */

public class AddClientTest {
   /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    ClientServiceImpl clientServiceImpl = context.getBean(ClientServiceImpl.class);
    Client client;
    ClientMapper clientMapper;
    ClientDto clientDto;
    @BeforeEach
    void init(){
        clientMapper = new ClientMapper();
        client = new Client();
        client.setName("mahsa");
        client.setLastName("alikhani");
        client.setEmail("mahsa.alikhani@gmail.com");
        client.setPassword("123");
        client.setUserStatus(UserStatus.NEW);
        client.setRole(Role.CLIENT);
        clientDto = clientMapper.toClientDto(client);
    }

    @Test
    void give_Client_when_Add_Calls_Then_Exception_Return(){
        DuplicateException result = assertThrows(DuplicateException.class, ()->
                clientServiceImpl.add(clientDto));
        assertEquals("Duplicate client!", result.getMessage());
    }*/
}
