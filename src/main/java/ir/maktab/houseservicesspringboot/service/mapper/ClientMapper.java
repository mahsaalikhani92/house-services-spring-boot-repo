package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class ClientMapper {
    private ClientDto clientDto;
    private Client client;

    public Client toClient(ClientDto clientDto){
        client = new Client();
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        return client;
    }

    public ClientDto toClientDto(Client client){
        clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setEmail(client.getEmail());
        clientDto.setPassword(client.getPassword());
        return clientDto;
    }
}
