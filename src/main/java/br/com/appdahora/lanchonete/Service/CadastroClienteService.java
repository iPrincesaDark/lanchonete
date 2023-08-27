package br.com.appdahora.lanchonete.Service;

import br.com.appdahora.lanchonete.Controller.CidadeController;
import br.com.appdahora.lanchonete.Model.Cliente;
import br.com.appdahora.lanchonete.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void remover (Long clienteId){
        try {
            clienteRepository.deleteById(clienteId);
        }  catch (EmptyResultDataAccessException e) {
            throw new CidadeController.EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro" +
                            "de cliente com código %d", clienteId));
        }
    }
}
