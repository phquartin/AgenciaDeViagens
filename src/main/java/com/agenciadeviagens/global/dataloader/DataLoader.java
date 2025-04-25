package com.agenciadeviagens.global.dataloader;

import com.agenciadeviagens.local.clientes.model.ClientType;
import com.agenciadeviagens.local.clientes.model.ClienteModel;
import com.agenciadeviagens.local.clientes.repository.ClienteRepository;
import com.agenciadeviagens.local.destinos.model.DestinoModel;
import com.agenciadeviagens.local.destinos.repository.DestinoRepository;
import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import com.agenciadeviagens.local.pacotes.model.PacoteType;
import com.agenciadeviagens.local.pacotes.repository.PacoteRepository;
import com.agenciadeviagens.local.paises.model.Continente;
import com.agenciadeviagens.local.paises.model.PaisModel;
import com.agenciadeviagens.local.paises.repository.PaisRepository;
import com.agenciadeviagens.local.servicos.model.ServicosModel;
import com.agenciadeviagens.local.servicos.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired private PaisRepository paisRepository;
    @Autowired private DestinoRepository destinoRepository;
    @Autowired private PacoteRepository pacoteRepository;
    @Autowired private ServicosRepository servicosRepository;
    @Autowired private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) {

        if (paisRepository.count() == 0) {
            inserirPaises();
        }

        if (destinoRepository.count() == 0) {
            inserirDestinos();
        }

        if (pacoteRepository.count() == 0) {
            inserirPacotes();
        }

        if (servicosRepository.count() == 0) {
            inserirServicos();
        }

        if (clienteRepository.count() == 0) {
            inserirClientes();
        }

    }

    private void inserirPaises() {
        List<PaisModel> paises = List.of(
                new PaisModel("Brasil", Continente.AMERICA_DO_SUL),
                new PaisModel("França", Continente.EUROPA),
                new PaisModel("Alemanha", Continente.EUROPA),
                new PaisModel("Itália", Continente.EUROPA),
                new PaisModel("Japão", Continente.ASIA)
        );
        paisRepository.saveAll(paises);
        System.out.println("🌍 Países inseridos");
    }

    private void inserirDestinos() {
        PaisModel brasil = paisRepository.findById(1L).orElseThrow();
        PaisModel franca = paisRepository.findById(2L).orElseThrow();
        PaisModel alemanha = paisRepository.findById(3L).orElseThrow();
        PaisModel italia = paisRepository.findById(4L).orElseThrow();
        PaisModel japao = paisRepository.findById(5L).orElseThrow();

        List<DestinoModel> destinos = List.of(
                new DestinoModel("Rio de Janeiro", brasil),
                new DestinoModel("Paris", franca),
                new DestinoModel("Berlim", alemanha),
                new DestinoModel("Roma", italia),
                new DestinoModel("Tóquio", japao)
        );
        destinoRepository.saveAll(destinos);
        System.out.println("🗺️ Destinos inseridos");
    }

    private void inserirPacotes() {
        DestinoModel paris = destinoRepository.findById(2L).orElseThrow();
        DestinoModel berlim = destinoRepository.findById(3L).orElseThrow();
        DestinoModel roma = destinoRepository.findById(4L).orElseThrow();

        PacoteModel pacoteEuropa = new PacoteModel();
        pacoteEuropa.setNome("Tour pela Europa");
        pacoteEuropa.setDescricao("Viagem pelas principais capitais europeias");
        pacoteEuropa.setDias(10);
        pacoteEuropa.setPreco(5999.90f);
        pacoteEuropa.setTipo(PacoteType.CULTURAL);
        pacoteEuropa.setDestinos(List.of(paris, berlim, roma));

        pacoteRepository.save(pacoteEuropa);
        System.out.println("✈️ Pacotes inseridos");
    }

    private void inserirServicos(){
        List<ServicosModel> servicos = List.of(
                new ServicosModel("Hotel 5 estrelas", 1500),
                new ServicosModel("Internet", 200),
                new ServicosModel("Transporte aeroporto", 500),
                new ServicosModel("Guia Turistico", 900)
        );
        servicosRepository.saveAll(servicos);
        System.out.println("\uD83D\uDEE0 Servicos inseridos");
    }

    private void inserirClientes(){
        List<ClienteModel> clientes = List.of(
                new ClienteModel("João Silva", "+55 (11) 91234-5678", "joao.silva@email.com", ClientType.NACIONAL, "123.456.789-00"),
                new ClienteModel("Marya Oliveira", "+11 (21) 99876-5432", "marya.oliveira@email.com", ClientType.ESTRANGEIRO, "AB123456"),
                new ClienteModel("Carlos Souza", "+55 (31) 97654-3210", "carlos.souza@email.com", ClientType.NACIONAL, "987.654.321-00"),
                new ClienteModel("Ana Back", "+1 (41) 96543-2109", "ana.back@email.com", ClientType.ESTRANGEIRO, "BC876542"),
                new ClienteModel("Pedro Santos", "+55 (51) 95342-1098", "pedro.santos@email.com", ClientType.NACIONAL, "345.678.901-00")
        );
        clienteRepository.saveAll(clientes);
        System.out.println("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC Clientes inseridos");
    }

}

