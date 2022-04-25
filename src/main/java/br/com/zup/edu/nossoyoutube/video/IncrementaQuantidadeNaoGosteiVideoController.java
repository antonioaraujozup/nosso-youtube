package br.com.zup.edu.nossoyoutube.video;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class IncrementaQuantidadeNaoGosteiVideoController {

    private final VideoRepository repository;

    public IncrementaQuantidadeNaoGosteiVideoController(VideoRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/videos/{id}/nao-gostei")
    @Transactional
    public ResponseEntity<?> incrementa(@PathVariable Long id) {
        Video video = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vídeo não encontrado"));

        video.incrementaNaoGostei();

        repository.save(video);

        return ResponseEntity.noContent().build();
    }
}
