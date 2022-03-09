package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class GetClientOrderOffersOrderByProposedPriceAndExpertRateTest {
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    ClientServiceImpl clientService = context.getBean(ClientServiceImpl.class);
    OrderDao orderDao = context.getBean(OrderDao.class);
    OfferDao offerDao = context.getBean(OfferDao.class);
    Offer offer1;
    Offer offer2;
    List<Offer> expectedOffers = new ArrayList<>();
    Order order;

    @BeforeEach
    void init(){
        Optional<Offer> foundOffer1 = offerDao.findById(1L);
        offer1 = foundOffer1.get();
        expectedOffers.add(offer1);
        Optional<Offer> foundOffer2 = offerDao.findById(2L);
        offer2 = foundOffer2.get();
        expectedOffers.add(offer2);

        Optional<Order> foundOrder = orderDao.findById(1L);
        order = foundOrder.get();
    }

    @Test
    void give_Order_When_GetClientOrderOffers_Calls_OrderedOffers_Return(){
        List<Offer> offers = clientService.getClientOrderOffersOrderByProposedPriceAndExpertRate(order);
        for(int i = 0; i < offers.size() ;i++){
            assertEquals(expectedOffers.get(i).getId(), offers.get(i).getId());
        }
    }

    @Test
    void give_Client_When_GetClientOrderOffers_Calls_Exception_Return(){
        NotFoundException result = assertThrows(NotFoundException.class, ()->
                clientService.getClientOrderOffersOrderByProposedPriceAndExpertRate(order));
        assertEquals("there is no offers!!", result.getMessage());
    }*/
}
