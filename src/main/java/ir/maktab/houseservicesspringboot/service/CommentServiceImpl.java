package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.CommentDao;
import ir.maktab.houseservicesspringboot.dao.OrderDao;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.CommentDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Comment;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.service.mapper.ClientMapper;
import ir.maktab.houseservicesspringboot.service.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentDao commentDao;
    private final CommentMapper commentMapper;
    private final ClientMapper clientMapper;
    private final OrderDao orderDao;

    public void addComment(ClientDto clientDto, CommentDto commentDto, String code){
        Client client = clientMapper.toClient(clientDto);
        Order order = orderDao.findOrdersByTrackingCode(code);
        Expert expert = order.getExpert();
        Comment comment = commentMapper.toComment(commentDto);
        comment.setClient(client);
        comment.setExpert(expert);
        commentDao.save(comment);
    }

    public void removeComment(CommentDto commentDto){
        Comment comment = commentMapper.toComment(commentDto);
        Optional<Comment> foundComment = commentDao.findById(comment.getId());
        if(foundComment.isEmpty())
            throw new NotFoundException("comment not found!");
        commentDao.delete(comment);
    }

    public void update(CommentDto commentDto){
        Comment comment = commentMapper.toComment(commentDto);
        Optional<Comment> foundComment = commentDao.findById(comment.getId());
        if(foundComment.isEmpty())
            throw new NotFoundException("comment not found!");
        commentDao.save(comment);
    }

    public List<CommentDto> getAllComments(Expert expert){
        List<Comment> comments = commentDao.findAllByExpert_IdOrderByRate(expert.getId());
        if(comments.isEmpty())
            throw new NotFoundException("there is no comment!");
        return comments.stream().map(commentMapper::toCommentDto).collect(Collectors.toList());
    }
}
