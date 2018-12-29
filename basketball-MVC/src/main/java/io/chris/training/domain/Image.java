package io.chris.training.domain;//package io.chris.training.domain;
//
//import org.postgresql.jdbc.UUIDArrayAssistant;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.UUID;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@Entity
//@Table(name="images")
//public class Image {
//
//    @Id
//    @GeneratedValue(strategy = SEQUENCE, generator= "images_id_seq")
//    @SequenceGenerator(name = "images_id_seq",sequenceName = "images_id_seq",allocationSize = 1)
//    private Long id;
//
//    @Column(name ="UUID")
//    private String uuid;
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
//
//    public String getUuid() {
//        return uuid;
//    }
//}
