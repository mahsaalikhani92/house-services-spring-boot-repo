package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class AddOrderTest {
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
    SubCategoryServiceImpl subCategoryService = context.getBean(SubCategoryServiceImpl.class);
    SubCategoryDao subCategoryDao = context.getBean(SubCategoryDao.class);
    ClientDao clientDao = context.getBean(ClientDao.class);

    Order order;
    Client client;

    @BeforeEach
    void init(){
        Optional<Client> foundClient = clientDao.findByEmail("mahsa.alikhani@gmail.com");
        client = foundClient.get();
    }

    @Test
    void give_Order_When_AddOrder_calls_Then_OrderTitle_Return() throws ParseException {
        List<SubCategoryDto> subCategories = subCategoryService.getAllSubCategories();
        System.out.println(subCategories);
        Optional<SubCategory> subCategory = subCategoryDao.findByTitle("painting");
        order = Order.builder()
                .subCategory(subCategory.get())
                .proposedDateToDo(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-20 15:30"))
                .address("tehran")
                .client(client)
                .description("four room")
                .proposedPrice(700d)
                .orderStatus(OrderStatus.WAITING_FOR_EXPERT_OFFER)
                .build();
        String registeredOrder = orderService.addOrder(order);
        assertEquals("painting", registeredOrder);
    }

    @Test
    void give_Order_When_AddOrder_calls_Then_Exception_Return() throws ParseException {
        List<SubCategoryDto> subCategories = subCategoryService.getAllSubCategories();
        System.out.println(subCategories);
        Optional<SubCategory> subCategory = subCategoryDao.findByTitle("painting");
        order = Order.builder()
                .subCategory(subCategory.get())
                .proposedDateToDo(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-20 15:30"))
                .address("tehran")
                .client(client)
                .description("four room")
                .proposedPrice(500d)
                .orderStatus(OrderStatus.WAITING_FOR_EXPERT_OFFER)
                .build();
        ProposedPriceException result = assertThrows(ProposedPriceException.class, ()->
                orderService.addOrder(order));
        assertEquals("the proposed price is less than base price!", result.getMessage());
    }*/
}
