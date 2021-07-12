package vision.integrity.wordwebgame.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "words")
    @ElementCollection
    private List<String> words = new ArrayList<String>();

    @ElementCollection
    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
