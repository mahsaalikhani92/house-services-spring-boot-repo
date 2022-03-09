package ir.maktab.houseservicesspringboot.service;

/**
 * @author Mahsa Alikhani m-58
 */
public class AddExpertTest {
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    ExpertServiceImpl expertServiceImpl = context.getBean(ExpertServiceImpl.class);

    Expert expert;
    ExpertDto expertDto;
    ExpertMapper expertMapper;

    @Test
    void give_Expert_when_Add_Calls_Then_Exception_Return(){
        expert = new Expert();
        expert.setName("mahsa");
        expert.setLastName("alikhani");
        expert.setEmail("mahsa.alikhani@gmail.com");
        expert.setPassword("123");
        expert.setUserStatus(UserStatus.NEW);
        expert.setRole(Role.EXPERT);
        expert.setImageData(new byte[3000]);
        expertDto = expertMapper.toExpertDto(expert);
        DuplicateException result = assertThrows(DuplicateException.class, ()->
                expertServiceImpl.add(expertDto));
        assertEquals("Duplicate expert!", result.getMessage());
    }

    @Test
    void give_Expert_when_Add_Calls_Then_Image_Size_Exception_Return(){
        expert = new Expert();
        expert.setName("mahsa");
        expert.setLastName("alikhani");
        expert.setEmail("mahsa.alikhani2@gmail.com");
        expert.setPassword("123");
        expert.setUserStatus(UserStatus.NEW);
        expert.setRole(Role.EXPERT);
        expert.setImageData(new byte[4000]);
        expertDto = expertMapper.toExpertDto(expert);
        ImageSizeException result = assertThrows(ImageSizeException.class, ()->
                expertServiceImpl.add(expertDto));
        assertEquals("Maximum image size should be 300 KB", result.getMessage());
    }*/
}
