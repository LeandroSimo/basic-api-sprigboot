package academy.springboot2.services;

import academy.springboot2.domain.Usuario;
import academy.springboot2.repositories.UsuarioRepository;
import academy.springboot2.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + "; Tipo: " + Usuario.class.getName()));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Integer id, Usuario obj) {
        Usuario newUser = findById(id);
        newUser.setNome(obj.getNome());
        newUser.setLogin(obj.getLogin());
        newUser.setSenha(obj.getSenha());
        return usuarioRepository.save(newUser);
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return usuarioRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
