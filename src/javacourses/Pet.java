package javacourses;

import java.time.LocalDate;

public class Pet extends RecordWithBirthday {
    private String name;
    private String species;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    @Override
    public void askUserData() {
        String name = Main.askString("Pet's name: ");
        String species = Main.askString("Pet's species: ");
        LocalDate birthday = super.askBirthday();


        setName(name);
        setSpecies(species);
        super.setBirthday(birthday);
    }

    @Override
    public boolean contains(String part) {
        String strDate = Main.DATE_FORMATTER.format(super.getBirthday());
        return strDate.contains(part)
                || name.contains(part)
                || species.contains(part);

    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", birthday='" + super.getBirthday() + '\'' +
                '}';
    }


}

