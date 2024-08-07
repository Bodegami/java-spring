package br.com.bodegami.cadastro.entrypoint;

import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.usecase.RemoverProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos")
public class DeletaProdutoController {

    @Autowired
    private RemoverProdutoUseCase removerProdutoUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProdutoPorId(@PathVariable Long id) {

        removerProdutoUseCase.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

}
