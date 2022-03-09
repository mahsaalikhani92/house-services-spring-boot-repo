package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.CommentDto;
import ir.maktab.houseservicesspringboot.model.entity.Comment;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class CommentMapper {

    public Comment toComment(CommentDto commentDto){
        return Comment.builder()
                .comment(commentDto.getComment())
                .rate(commentDto.getRate())
                .client(commentDto.getClient())
                .expert(commentDto.getExpert())
                .build();
    }

    public CommentDto toCommentDto(Comment comment){
        return CommentDto.builder()
                .comment(comment.getComment())
                .rate(comment.getRate())
                .client(comment.getClient())
                .expert(comment.getExpert())
                .build();
    }
}
