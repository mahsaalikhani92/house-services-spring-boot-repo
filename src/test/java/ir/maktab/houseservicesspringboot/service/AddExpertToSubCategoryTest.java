package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class AddExpertToSubCategoryTest {
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    SubCategoryServiceImpl subCategoryServiceImpl = context.getBean(SubCategoryServiceImpl.class);
    Category service;
    SubCategory subCategory;
    Expert expert;

    @Test
    void give_Service_And_SubService_And_Expert_when_AddExpertToSubService_Calls_Then_Service_NotFoundException_Return(){
        service = new Category();
        service.setTitle("house facilities");
        subCategory = new SubCategory();
        subCategory.setTitle("water");
        subCategory.setBasePrice(100d);
        subCategory.setDescription("using newest equipment");
        expert = new Expert();
        expert.setName("ladan");
        expert.setLastName("kiani");
        expert.setEmail("la.kiani@gmail.com");
        expert.setPassword("123");
        expert.setUserStatus(UserStatus.CONFIRMED);
        expert.setRole(Role.EXPERT);
        expert.setImageData(new byte[3000]);

        NotFoundException result = assertThrows(NotFoundException.class, ()->
                subCategoryServiceImpl.addExpertToSubCategory(service, subCategory, expert));
        assertEquals("Service not found!", result.getMessage());
    }

    @Test
    void give_Service_And_SubService_And_Expert_when_AddExpertToSubService_Calls_Then_SubService_NotFoundException_Return(){
        service = new Category();
        service.setTitle("cleaning");
        subCategory = new SubCategory();
        subCategory.setTitle("floor washing");
        subCategory.setBasePrice(50d);
        subCategory.setDescription("extra drying");
        expert = new Expert();
        expert.setName("ladan");
        expert.setLastName("kiani");
        expert.setEmail("la.kiani@gmail.com");
        expert.setPassword("123");
        expert.setUserStatus(UserStatus.CONFIRMED);
        expert.setRole(Role.EXPERT);
        expert.setImageData(new byte[3000]);

        NotFoundException result = assertThrows(NotFoundException.class, ()->
                subCategoryServiceImpl.addExpertToSubCategory(service, subCategory, expert));
        assertEquals("sub service not found!", result.getMessage());
    }*/
}
