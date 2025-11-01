package ar.unahur.edu.obj2.patroncommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Invoker.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;

public class ProgramaTest {
    private Programa p = new Programa();
    private Microcontrolador m = new Microcontrolador();

    @BeforeEach
    void setup(){
        p.vaciarLista();
        p.reiniciarMicro(m);
    }

    @Test
    void avanzar3PosicionesElProgramCounter(){
        p.addOperacion(new Nop());
        p.addOperacion(new Nop());
        p.addOperacion(new Nop());

        p.ejecutar(m);

        assertEquals(3, m.getProgramCounter());
    }
}
