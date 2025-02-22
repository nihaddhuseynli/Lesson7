import java.util.*;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(){}

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getYear() {
        return year;
    }
    public int getIq() {
        return iq;
    }
    public String[][] getSchedule() {
        return schedule;
    }
    public Family getFamily() {
        return family;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setIq(int iq) {
        this.iq = iq;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
    public void setFamily(Family family) {
        this.family = family;
    }
    public void greetPet() {
        System.out.println("Hello, " + family.getPet().getNickname());
    }

    public void describePet() {
        String slyness = family.getPet().getTrickLevel() > 50 ? "very sly" : "almost not sly";
        System.out.println("I have a " + family.getPet().getSpecies() + ", age " + family.getPet().getAge() + ", he is " + slyness);
    }

    public boolean feedPet(boolean isTime) {
        if (isTime) {
            System.out.println("Hm... I will feed " + name + "'s " + family.getPet().getSpecies());
            return true;
        } else {
            Random random = new Random();
            int randomNum = random.nextInt(101);
            if (family.getPet().getTrickLevel() > randomNum) {
                System.out.println("Hm... I will feed " + name + "'s " + family.getPet().getSpecies());
                return true;
            } else {
                System.out.println("I think " + name + "'s " + family.getPet().getSpecies() + " is not hungry.");
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Human{name='"+name+"', surname='"+surname+"', year="+year+", iq="+iq+ ", schedule="+Arrays.deepToString(schedule)+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Arrays.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, iq);
        result = 31 * result + Arrays.deepHashCode(schedule);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is removed.");
    }

}