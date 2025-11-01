package ar.unahur.edu.obj2.patroncommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Invoker.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;

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

    @Test
    void sumar20Mas17YObtener37AcumuladorA(){
        p.addOperacion(new Lodv(20));
        p.addOperacion(new Swap());
        p.addOperacion(new Lodv(17));
        p.addOperacion(new Add());

        p.ejecutar(m);

        assertEquals(37, m.getAcumuladorA());
        assertEquals(4, m.getProgramCounter());
    }

    @Test
    void sumar2Mas8Mas5EnAcumuladorA(){
        p.addOperacion(new Lodv(2));
        p.addOperacion(new Str(0));
        p.addOperacion(new Lodv(8));
        p.addOperacion(new Swap());
        p.addOperacion(new Lodv(5));
        p.addOperacion(new Add());
        p.addOperacion(new Swap());
        p.addOperacion(new Lod(0));
        p.addOperacion(new Add());
    }
}
