package br.com.appdahora.lanchonete.Service;

import br.com.appdahora.lanchonete.Controller.ClienteController;
import br.com.appdahora.lanchonete.Controller.EstadoController;
import br.com.appdahora.lanchonete.Model.Estado;
import br.com.appdahora.lanchonete.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service

public class CadastroEstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }
    public void remover(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);
        } catch (EmptyResultDataAccessException e) {
            throw new EstadoController.EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro" +
                            "de estado com código %d", estadoId));
        } catch (DataIntegrityViolationException e){
          throw new  EstadoController.EntidadeOcupada(
                  String.format("O estado %d, está em uso", estadoId));

        }



    }
}
