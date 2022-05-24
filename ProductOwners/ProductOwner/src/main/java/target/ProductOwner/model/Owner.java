package target.ProductOwner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ownerId;

    @Column(name = "ownerName")
    private String ownerName;
    @Column(name = "productId")
    private long productId;
    @Column(name = "productName")
    private String productName;
}


/*spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
        spring.datasource.username=postgres
        spring.datasource.password=admin
        spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
        spring.jpa.hibernate.ddl-auto=create
        server.port = 8090
        spring.jpa.generate-ddl = true*/
