package micronaut.reproduce;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import reactor.core.publisher.Flux;

@R2dbcRepository(dialect = Dialect.H2)
public interface BookRepository extends ReactiveStreamsCrudRepository<Book, Integer> {
    @Query("""
            SELECT 1 AS id, NULL AS title
            """)
    Flux<Book> getBooks();
}
