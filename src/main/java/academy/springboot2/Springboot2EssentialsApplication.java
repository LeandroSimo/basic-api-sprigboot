package academy.springboot2;

import academy.springboot2.domain.Usuario;
import academy.springboot2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Springboot2EssentialsApplication implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(Springboot2EssentialsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario(null, "Leandro", "teste1", "123");
        Usuario usuario2 = new Usuario(null, "Maria", "teste2", "123");
        Usuario usuario3 = new Usuario(null, "Joao", "teste3", "123");

//		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
    }
}
