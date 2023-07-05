import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> masculineSet = new HashSet<String>();
        Set<String> feminineSet = new HashSet<String>();
        Boolean persist = false;

        do {
            String[] personInput = PersonForm.receiveNameGenderInput();
            PersonForm.filterInput(personInput[0], personInput[1], masculineSet, feminineSet);
            persist = PersonForm.persistForm();
        } while (persist == true);

        System.out.println(
                "Lista de pessoas do gênero masculino: " + masculineSet
                + "\n" +
                "Lista de pessoas do gênero feminino: " + feminineSet
        );
    }

}
