package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.CommentDto;
import ir.maktab.houseservicesspringboot.model.entity.Expert;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface CommentService {

    void addComment(ClientDto clientDto, CommentDto commentDto, String code);

    void removeComment(CommentDto commentDto);

    void update(CommentDto commentDto);

    List<CommentDto> getAllComments(Expert expert);
}
