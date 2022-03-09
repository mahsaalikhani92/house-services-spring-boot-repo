package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class AddSubCategoryTest {
   /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    SubCategoryServiceImpl subCategoryServiceImpl = context.getBean(SubCategoryServiceImpl.class);
    Category category;
    SubCategory subCategory;

    @Test
    void give_Service_And_SubService_when_Add_Calls_Then_NotFoundException_Return(){
        category = Category.builder().title("house facilities").build();
        subCategory = SubCategory.builder()
                        .title("water")
                                .basePrice(100d)
                                        .description("using newest equipment").build();

        NotFoundException result = assertThrows(NotFoundException.class, ()->
                subCategoryServiceImpl.add(category, subCategory));
        assertEquals("Category not found!", result.getMessage());
    }

    @Test
    void give_Service_And_SubService_when_Add_Calls_Then_DuplicateException_Return(){
        category = Category.builder().title("cleaning").build();
        subCategory = SubCategory.builder()
                .title("spraying")
                .basePrice(50d)
                .description("Comes with washing").build();

        DuplicateException result = assertThrows(DuplicateException.class, ()->
                subCategoryServiceImpl.add(category, subCategory));
        assertEquals("Duplicate sub service!", result.getMessage());
    }*/
}
