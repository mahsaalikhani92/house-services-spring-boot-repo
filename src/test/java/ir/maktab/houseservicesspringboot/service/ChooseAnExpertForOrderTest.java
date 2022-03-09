package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class ChooseAnExpertForOrderTest {
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    OrderDao orderDao = context.getBean(OrderDao.class);
    ExpertDao expertDao = context.getBean(ExpertDao.class);
    ClientServiceImpl clientService = context.getBean(ClientServiceImpl.class);
    Order order;
    Expert expert;

    @BeforeEach
    void init(){
        Optional<Order> foundOrder = orderDao.findById(1L);
        order = foundOrder.get();
        Optional<Expert> foundExpert = expertDao.findByEmail("ali.bahari@gmail.com");
        expert = foundExpert.get();
    }

    @Test
    void give_Order_And_Expert_When_ChooseAnExpertForOrder_Calls_Expert_Return(){
        Expert selectedExpert = clientService.chooseAnExpertForOrder(order, expert);

        assertEquals(expert.getEmail(), selectedExpert.getEmail());
    }*/
}
