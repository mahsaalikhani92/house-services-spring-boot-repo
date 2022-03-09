package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class ExpertMapper {

    private ExpertDto expertDto;
    private Expert expert;

    public Expert toExpert(ExpertDto expertDto){
        expert = new Expert();
        expert.setName(expertDto.getName());
        expert.setLastName(expertDto.getLastName());
        expert.setEmail(expertDto.getEmail());
        expert.setPassword(expertDto.getPassword());
        expert.setImageData(expertDto.getImageData());
        return expert;
    }

    public ExpertDto toExpertDto(Expert expert){
        expertDto = new ExpertDto();
        expertDto.setName(expert.getName());
        expertDto.setLastName(expert.getLastName());
        expertDto.setEmail(expert.getEmail());
        expertDto.setImageData(expert.getImageData());
        expertDto.setMeanRate(expert.getMeanRate());
        return expertDto;
    }
}
