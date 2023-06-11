package Utils;
import java.util.ArrayList;

public abstract class LeitorArquivo<T> {
    protected final String filename;

    public LeitorArquivo(String filename) {
        this.filename = filename;
    }

    public abstract ArrayList<T> read();
    public abstract ArrayList<T> read(String value);

}