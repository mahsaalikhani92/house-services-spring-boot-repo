package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class AddOfferTest {
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    ExpertDao expertDao = context.getBean(ExpertDao.class);
    ClientDao clientDao = context.getBean(ClientDao.class);
    OrderDao orderDao = context.getBean(OrderDao.class);
    OfferMapper offerMapper = context.getBean(OfferMapper.class);
    OfferServiceImpl offerService = context.getBean(OfferServiceImpl.class);

    Order order;
    Expert expert;
    Client client;
    Offer offer;
    OfferDto offerDto;

    @BeforeEach
    void init() throws ParseException {
        Optional<Client> foundClient = clientDao.findByEmail("mahsa.alikhani@gmail.com");
        client = foundClient.get();

        Optional<Order> foundOrder = orderDao.findById(1L);
        order = foundOrder.get();

        Optional<Expert> foundExpert = expertDao.findByEmail("ali.bahari@gmail.com");
        expert = foundExpert.get();
    }

    @Test
    void give_Offer_When_AddOffer_calls_Then_Offer_Return() throws ParseException {
        offer = Offer.builder()
                .order(order)
                .expert(expert)
                .proposedPrice(750d)
                .startTime(new SimpleDateFormat("hh:mm").parse("17:00"))
                .workDuration("8 hour")
                .build();

        offerDto = offerMapper.toOfferDto(offer);
        assertEquals(offer.getOrder().getOrderStatus(), OrderStatus.WAITING_TO_CHOOSE_AN_EXPERT);
    }

    @Test
    void give_Offer_When_AddOffer_calls_Then_Exception_Return() throws ParseException {
        offer = Offer.builder()
                .order(order)
                .expert(expert)
                .proposedPrice(400d)
                .startTime(new SimpleDateFormat("hh:mm").parse("17:00"))
                .workDuration("8 hour")
                .build();

        offerDto = offerMapper.toOfferDto(offer);
        ProposedPriceException result = assertThrows(ProposedPriceException.class, ()->
                offerService.addOffer(offerDto));
        assertEquals("the proposed price is less than base price!", result.getMessage());
    }

    @Test
    void give_Offer_When_AddOffer_calls_Then_OfferException_Return() throws ParseException {
        order.setOrderStatus(OrderStatus.DONE);
        orderDao.save(order);
        offer = Offer.builder()
                .order(order)
                .expert(expert)
                .proposedPrice(400d)
                .startTime(new SimpleDateFormat("hh:mm").parse("17:00"))
                .workDuration("8 hour")
                .build();

        offerDto = offerMapper.toOfferDto(offer);
        OfferException result = assertThrows(OfferException.class, ()->
                offerService.addOffer(offerDto));
        assertEquals("the order status is not match!", result.getMessage());
    }
*/
}
