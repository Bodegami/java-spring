package br.com.bodegami.cadastro.entrypoint;

import br.com.bodegami.cadastro.domain.Usuario;
import br.com.bodegami.cadastro.entrypoint.dto.AtualizaUsuarioRequest;
import br.com.bodegami.cadastro.entrypoint.dto.CadastroUsuarioRequest;
import br.com.bodegami.cadastro.entrypoint.dto.UsuarioResponse;
import br.com.bodegami.cadastro.usecase.AtualizaUsuarioUseCase;
import br.com.bodegami.cadastro.usecase.CadastraUsuarioUseCase;
import br.com.bodegami.cadastro.usecase.ConsultaUsuarioUseCase;
import br.com.bodegami.cadastro.usecase.DeletaUsuarioUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastraUsuarioUseCase cadastraUsuarioUseCase;

    @Autowired
    private AtualizaUsuarioUseCase atualizaUsuarioUseCase;

    @Autowired
    private DeletaUsuarioUseCase deletaUsuarioUseCase;

    @Autowired
    private ConsultaUsuarioUseCase consultaUsuarioUseCase;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioResponse> cadastra(@RequestBody @Valid CadastroUsuarioRequest request) {
        Usuario usuario = request.toDomain(request);

        UsuarioResponse response = cadastraUsuarioUseCase.cadastra(usuario);
        URI uri = UriComponentsBuilder.fromPath("/usuarios/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualiza(@PathVariable Long id,
                                                    @RequestBody @Valid AtualizaUsuarioRequest request) {
        Usuario usuario = request.toDomain(request);

        UsuarioResponse response = atualizaUsuarioUseCase.atualiza(id, usuario);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {

        deletaUsuarioUseCase.deletaPorId(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> consultaPorId(@PathVariable Long id) {

        UsuarioResponse response = consultaUsuarioUseCase.consultaUsuarioPorId(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> consulta() {

        List<UsuarioResponse> response = consultaUsuarioUseCase.consultaUsuarios();

        return ResponseEntity.ok(response);
    }
}
