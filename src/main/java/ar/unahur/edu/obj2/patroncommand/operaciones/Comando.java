package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public abstract class Comando implements Operable{

    @Override
    public void execute(Programable micro) {
        this.doExecute(micro);
        micro.incProgramCounter();
    }

    protected abstract void doExecute(Programable micro);
}
