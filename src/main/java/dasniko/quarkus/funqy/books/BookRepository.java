package dasniko.quarkus.funqy.books;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class BookRepository {

    public static final String DDB_TABLE_NAME = "dasniko-funqy-books";

    @Inject
    DynamoDbClient dynamoDb;

    public List<Book> getBooks() {
        return dynamoDb.scanPaginator(builder ->
                builder.tableName(DDB_TABLE_NAME).projectionExpression("id,title,author"))
                .items().stream()
                .map(Book::fromItem)
                .collect(Collectors.toList());
    }

    public void addBook(Book book) {
        dynamoDb.putItem(builder -> builder.tableName(DDB_TABLE_NAME).item(book.toItem()));
    }

}
