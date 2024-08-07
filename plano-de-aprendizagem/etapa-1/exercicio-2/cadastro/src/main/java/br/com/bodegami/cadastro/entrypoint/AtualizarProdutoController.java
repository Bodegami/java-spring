package br.com.bodegami.cadastro.entrypoint;

import br.com.bodegami.cadastro.domain.Produto;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoRequest;
import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.entrypoint.mapper.ProdutoRequestMapper;
import br.com.bodegami.cadastro.usecase.AtualizarProdutoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class AtualizarProdutoController {

    @Autowired
    private AtualizarProdutoUseCase atualizarProdutoUseCase;

    @Autowired
    private ProdutoRequestMapper mapper;

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizaProdutoPorId(@PathVariable Long id, @RequestBody @Valid ProdutoRequest request) {

        var produto = mapper.toDomain(request);

        var response = atualizarProdutoUseCase.atualizaProduto(id, produto);

        return ResponseEntity.ok(response);
    }


}
