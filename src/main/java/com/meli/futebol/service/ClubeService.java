package com.meli.futebol.service;

import com.meli.futebol.exeption.ExeptionPersonalizada;
import com.meli.futebol.dto.ClubeRequestDTO;
import com.meli.futebol.dto.ClubeResponseDTO;
import com.meli.futebol.enuns.Status;
import com.meli.futebol.model.Clube;
import com.meli.futebol.repository.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClubeService {

    @Autowired
    private ClubeRepository clubeRepository;

    public ClubeResponseDTO cadastrar(ClubeRequestDTO dto) {
        //Para salvar no banco de dados.
        validarInformacoes(dto);
        Clube novoClube = converterClubeRequestDTO(dto);
        novoClube.setStatus(Status.ATIVO);
        novoClube = clubeRepository.save(novoClube);
        return converterClube(novoClube);
    }

    private void validarInformacoes(ClubeRequestDTO dto) {

        if(dto.getNome() == null || dto.getNome().length() < 2) {
            throw new ExeptionPersonalizada("O nome do clube é invalido", 400);
        }

        if (dto.getDataCriacao().isAfter(LocalDate.now())) {
            throw new ExeptionPersonalizada("A data de criação não pode ser maior que a data atual", 400);
        }

        if (clubeRepository.existsByNomeAndSede(dto.getNome(), dto.getSede())) {
            throw new ExeptionPersonalizada("Já existe um clube cadastrado com esse nome para esse estado", 409);
        }
    }

    public ClubeResponseDTO editar(ClubeRequestDTO dto, long id) {
        Clube clube = getClube(id);
        validarInformacoes(dto);

        clube.setSede(dto.getSede());
        clube.setNome(dto.getNome());
        clube.setDataCriacao(dto.getDataCriacao());

        clubeRepository.save(clube);

        return converterClube(clube);
    }

    public String inativarClube(Long id) {
        Clube clube = getClube(id);
        clube.setStatus(Status.INATIVO);
        clubeRepository.save(clube);
        return "Clube inativado com sucesso!";
    }

    public ClubeResponseDTO buscarCluberPorId(Long id) {
        Clube clube = getClube(id);
        return converterClube(clube);
    }

    public boolean clubeAtivo(Long idClube) {
        Status statusClube = clubeRepository.buscarStatusClube(idClube);
        return statusClube == Status.ATIVO;
    }
    public List<ClubeResponseDTO> buscarTodos() {
        List<Clube> clubes = clubeRepository.findAll();
        List<ClubeResponseDTO> responseDTOS = new ArrayList<>();

        if (clubes.isEmpty()) {
            throw new ExeptionPersonalizada("Nenhum clube foi encontrado", 404);
        }

        for (Clube c : clubes) {
            ClubeResponseDTO dto = converterClube(c);
            responseDTOS.add(dto);
        }
        return  responseDTOS;
    }

    public Clube getClube(Long id) {
        return clubeRepository.findById(id)
                .orElseThrow(() -> new ExeptionPersonalizada("Clube não encontrado", 404));
    }

    private  Clube converterClubeRequestDTO(ClubeRequestDTO dto) {
        Clube clube = new Clube();
        clube.setNome(dto.getNome());
        clube.setDataCriacao(dto.getDataCriacao());
        clube.setSede(dto.getSede());
        return  clube;
    }

    private ClubeResponseDTO converterClube(Clube clube) {
        ClubeResponseDTO responseDTO = new ClubeResponseDTO();
        responseDTO.setId(clube.getId());
        responseDTO.setNome(clube.getNome());
        responseDTO.setSede(clube.getSede());
        responseDTO.setDataCriacao(clube.getDataCriacao());
        responseDTO.setStatus(clube.getStatus());
        return responseDTO;
    }


}