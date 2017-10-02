package testing.ingtest;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository <Note, Integer>{

    List<Note> findByCustomerid(int customerid);
    List<Note> findOne(int id);
}
