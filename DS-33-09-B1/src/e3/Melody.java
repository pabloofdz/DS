package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melody {
    private List<Notes> NotesList;
    private List<Accidentals> AccidentalsList;
    private List<Float> TimesList;
    enum Notes{
        DO,
        RE,
        MI,
        FA,
        SOL,
        LA,
        SI
    }
    enum Accidentals{
        NATURAL(""),
        SHARP("#"),
        FLAT("b");

        private final String valor;

        public String getValor() {
            return valor;
        }

        Accidentals(String valor) {
            this.valor = valor;
        }
    }

    public Melody () {
        NotesList = new ArrayList<>();
        AccidentalsList = new ArrayList<>();
        TimesList = new ArrayList<>();
    }

    public void addNote ( Notes note , Accidentals accidental , float time ) {
        if((note == Notes.DO || note == Notes.RE || note == Notes.MI || note == Notes.FA || note == Notes.SOL || note == Notes.LA || note == Notes.SI)
        && (accidental == Accidentals.FLAT || accidental == Accidentals.SHARP || accidental == Accidentals.NATURAL) && time != 0f){
            NotesList.add(note);
            AccidentalsList.add(accidental);
            TimesList.add(time);
        }else
            throw new IllegalArgumentException("Uno de los parámetros no es válido");
    }

    public Notes getNote ( int index ) {
        if (!NotesList.isEmpty() && index > NotesList.size()-1)
            throw new IllegalArgumentException("El índice no es válido");
        else
            return NotesList.get(index);
    }

    public Accidentals getAccidental (int index ) {
        return AccidentalsList.get(index);
    }

    public float getTime ( int index ) {
        return TimesList.get(index);
    }

    public int size () {
        return NotesList.size();
    }

    public float getDuration () {
        float duration = 0;
        for (Float aFloat : TimesList) {
            duration = duration + aFloat;
        }
        return duration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null) { return false; }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Melody m1 = (Melody) o;
        boolean notasIguales = false, tiemposIguales = true;
        if (this.NotesList.isEmpty() && m1.NotesList.isEmpty()){
            return true;
        }
        else if (this.size() == m1.size()){
            for (int i = 0; i < NotesList.size(); i++) {
                Notes n1 = this.NotesList.get(i), n2 = m1.NotesList.get(i);
                Accidentals a1 = this.AccidentalsList.get(i), a2 = m1.AccidentalsList.get(i);

                if (n1 == n2 && a1 == m1.AccidentalsList.get(i) ||
                        n1 == Notes.DO && n2 == Notes.RE && a1 == Accidentals.SHARP && a2 == Accidentals.FLAT ||
                        n1 == Notes.RE && n2 == Notes.MI && a1 == Accidentals.SHARP && a2 == Accidentals.FLAT ||
                        n1 == Notes.MI && n2 == Notes.FA && a1 == Accidentals.NATURAL && a2 == Accidentals.FLAT ||
                        n1 == Notes.MI && n2 == Notes.FA && a1 == Accidentals.SHARP && a2 == Accidentals.NATURAL ||
                        n1 == Notes.FA && n2 == Notes.SOL && a1 == Accidentals.SHARP && a2 == Accidentals.FLAT ||
                        n1 == Notes.SOL && n2 == Notes.LA && a1 == Accidentals.SHARP && a2 == Accidentals.FLAT ||
                        n1 == Notes.LA && n2 == Notes.SI && a1 == Accidentals.SHARP && a2 == Accidentals.FLAT ||
                        n1 == Notes.SI && n2 == Notes.DO && a1 == Accidentals.NATURAL && a2 == Accidentals.FLAT ||
                        n1 == Notes.SI && n2 == Notes.DO && a1 == Accidentals.SHARP && a2 == Accidentals.NATURAL ||
                        n2 == Notes.DO && n1 == Notes.RE && a2 == Accidentals.SHARP && a1 == Accidentals.FLAT ||
                        n2 == Notes.RE && n1 == Notes.MI && a2 == Accidentals.SHARP && a1 == Accidentals.FLAT ||
                        n2 == Notes.MI && n1 == Notes.FA && a2 == Accidentals.NATURAL && a1 == Accidentals.FLAT ||
                        n2 == Notes.MI && n1 == Notes.FA && a2 == Accidentals.SHARP && a1 == Accidentals.NATURAL ||
                        n2 == Notes.FA && n1 == Notes.SOL && a2 == Accidentals.SHARP && a1 == Accidentals.FLAT ||
                        n2 == Notes.SOL && n1 == Notes.LA && a2 == Accidentals.SHARP && a1 == Accidentals.FLAT ||
                        n2 == Notes.LA && n1 == Notes.SI && a2 == Accidentals.SHARP && a1 == Accidentals.FLAT ||
                        n2 == Notes.SI && n1 == Notes.DO && a2 == Accidentals.NATURAL && a1 == Accidentals.FLAT ||
                        n2 == Notes.SI && n1 == Notes.DO && a2 == Accidentals.SHARP && a1 == Accidentals.NATURAL)
                    notasIguales = true;
                else {
                    notasIguales = false;
                    break;
                }
            }

            for (int i = 0; i < TimesList.size(); i++) {
                if (!Objects.equals(this.TimesList.get(i), m1.TimesList.get(i))) {
                    tiemposIguales = false;
                    break;
                }
            }

            return notasIguales && tiemposIguales;

        }else { return false; }
    }

    public int hashCode() {
        int hash = 0;
        Notes n;
        Accidentals a;
        if (NotesList.isEmpty())
            return hash;
        for (int i = 0; i < NotesList.size(); i++) {
            n = this.NotesList.get(i);
            a = this.AccidentalsList.get(i);
            if (n == Notes.DO && a == Accidentals.FLAT)
                hash = hash + 13;
            else if (n == Notes.DO)
                hash = hash + 2;
            else if (n == Notes.RE)
                hash = hash + 4;
            else if (n == Notes.MI)
                hash = hash + 6;
            else if (n == Notes.FA)
                hash = hash + 7;
            else if (n == Notes.SOL)
                hash = hash + 9;
            else if (n == Notes.LA)
                hash = hash +11;
            else if (n == Notes.SI && a == Accidentals.SHARP)
                hash = hash + 2;
            else if (n == Notes.SI)
                hash = hash + 13;

            if (a == Accidentals.FLAT && n != Notes.DO)
                hash = hash - 1;
            else if (a == Accidentals.SHARP && n != Notes.SI)
                hash = hash + 1;

            hash = hash *(i + 1);
        }
        hash = hash + (int)getDuration() * 2 + NotesList.size() * 3;
        return hash;
    }

    public String toString() {
        StringBuilder melody = new StringBuilder();
        for (int i = 0; i < NotesList.size(); i++){
            if(i != NotesList.size()-1)
                melody.append(NotesList.get(i).toString()).append(AccidentalsList.get(i).valor).append("(").append(TimesList.get(i).toString()).append(") ");
            else
                melody.append(NotesList.get(i).toString()).append(AccidentalsList.get(i).valor).append("(").append(TimesList.get(i).toString()).append(")");
        }
        return melody.toString();
    }
}