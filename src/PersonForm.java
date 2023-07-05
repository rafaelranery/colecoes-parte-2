import java.util.Scanner;
import java.util.Set;

public class PersonForm {
    /**
     * Receives a string user input in format "Full Name, Gender"
     * @return [person name, person gender]
     */
    public static String[] receiveNameGenderInput() {
        Scanner s = new Scanner(System.in);
        String name;
        String gender;

        System.out.println(
                "Insira o nome completo e o gênero de de uma pessoa, no seguinte formato\n'Nome Completo, M / F':"
        );
        String unparsedInput = s.nextLine();
        String[] parsedInput = unparsedInput.split(",");

        Boolean isValid = validateInput(parsedInput);
        if(isValid) {
            return parsedInput;
        } else {
            return null;
        }

    }

    /**
     * Checks for empty inputs or wrongly submitted options.
     * @param fields of [Person name, person gender].
     * @return field validity of provided input.
     */
    public static Boolean validateInput(String[] fields) {
        for (String input : fields) {
            if(input.isEmpty()) {
                return false;
            }
        }
        if(!(fields[1].trim().toLowerCase().contains("m") || fields[1].trim().toLowerCase().contains("f"))) {
            return false;
        }

        return true;
    }

    /**
     * Checks necessity of a new user input.
     * @return Boolean representation of users choice to continue form.
     */
    public static Boolean persistForm() {
        Scanner s = new Scanner(System.in);

        System.out.println("Você deseja adicionar mais um nome? [S/N]");
        String option = s.nextLine();

        if(option.equalsIgnoreCase("s")) {
            return true;
        } else if(option.equalsIgnoreCase("n")) {
            return false;
        } else {
            return null;
        }

    }

    /**
     * Filter a person according to its gender, inserting it in its corresponding Set.
     * @param name
     * @param gender
     * @param filterMasculine String Set for persons of masculine gender.
     * @param filterFeminine String Set for persons of feminine gender.
     */
    public static void filterInput(String name, String gender, Set<String> filterMasculine, Set<String> filterFeminine) {
        if(gender.toLowerCase().contains("f")) {
            filterFeminine.add(name);
        } else if (gender.toLowerCase().contains("m")) {
            filterMasculine.add(name);
        }
    }
}
