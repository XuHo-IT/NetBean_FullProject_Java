import controller.VaccineManager;
import model.Vaccine;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        VaccineManager a = new VaccineManager();
        a.addVaccine();

    }
}