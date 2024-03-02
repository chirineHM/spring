package tn.esprit.courses;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;


@Builder
@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private UUID id;
    private String label;
}
