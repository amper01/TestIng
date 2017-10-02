package testing.ingtest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@RestController

@RequestMapping(value = "/note")
public class NoteController {

    private NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteController() {}

    @RequestMapping(value = "/findall/{customerid}", method = RequestMethod.GET)
    public List<Note> findBy(@PathVariable int customerid) {

        return noteRepository.findByCustomerid(customerid);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Note> getAll() {
        return noteRepository.findAll();
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Note> create(@RequestBody Note note) {

        System.out.println("to jest ten sout" + note);
        noteRepository.save(note);

        return noteRepository.findAll();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public List<Note> remove(@PathVariable int id) {

        noteRepository.delete(id);

        return noteRepository.findAll();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public List<Note> edit(@PathVariable int id) {

        return noteRepository.findOne(id);
    }


    @RequestMapping(value = "/note/edit", method = RequestMethod.POST)
    public List<Note> edit(@RequestBody Note note) {

        Note noteToUpdate = noteRepository.getOne(note.getId());
        noteToUpdate.setNote(note.getNote());
        noteToUpdate.setDate(note.getDate());
        noteRepository.save(noteToUpdate);

        return noteRepository.findAll();
    }
}
