package micronaut.reproduce;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNull;

@MicronautTest(transactional = false)
class BookRepositoryTest {
    @Inject
    private BookRepository bookRepository;

    @Test
    void testGetBooks() {
        StepVerifier.create(bookRepository.getBooks())
                .assertNext(book -> assertNull(book.getTitle()))
                .verifyComplete();
    }
}
