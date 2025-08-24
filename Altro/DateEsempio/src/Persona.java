import java.time.OffsetDateTime;

public record Persona(String nome, OffsetDateTime dataNascita) {

    public Persona{
        if(nome==null)
            throw new IllegalArgumentException();
    }
}