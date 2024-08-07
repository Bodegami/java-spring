package br.com.bodegami.cadastro.entrypoint;

import br.com.bodegami.cadastro.entrypoint.dto.ProdutoRequest;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.entrypoint.mapper.ProdutoRequestMapper;
import br.com.bodegami.cadastro.usecase.CadastrarProdutoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class CadastraProdutoController {

    @Autowired
    private CadastrarProdutoUseCase cadastrarProdutoUseCase;

    @Autowired
    private ProdutoRequestMapper produtoRequestMapper;

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(@RequestBody @Valid ProdutoRequest request) {

        var produto = produtoRequestMapper.toDomain(request);
        var response = cadastrarProdutoUseCase.cadastrar(produto);

        URI uri = UriComponentsBuilder
                .fromPath("/propostas/{id}")
                .buildAndExpand("id", response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

}
