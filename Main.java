public class Main {
    public static void main(String[] args) {

        String[][] motherSchedule = {{DayOfWeek.MONDAY.name(), "Work"}, {DayOfWeek.TUESDAY.name(), "Shopping"}};
        String[][] fatherSchedule = {{DayOfWeek.MONDAY.name(), "Work"}, {DayOfWeek.WEDNESDAY.name(), "Gym"}};
        String[][] child1Schedule = {{DayOfWeek.MONDAY.name(), "School"}, {DayOfWeek.FRIDAY.name(), "Play"}};
        String[][] child2Schedule = {{DayOfWeek.THURSDAY.name(), "School"}, {DayOfWeek.SATURDAY.name(), "Play"}};

        Human mother = new Human("Alice", "Smith", 1985, 120, motherSchedule);
        Human father = new Human("John", "Smith", 1980, 130, fatherSchedule);

        Family family = new Family(mother, father);

        Human child1 = new Human("Emma", "Smith", 2010, 110, child1Schedule);
        Human child2 = new Human("Liam", "Smith", 2012, 100, child2Schedule);

        family.addChild(child1);
        family.addChild(child2);

        Pet pet = new Pet(Species.DOG, "Buddy", 5, 60, new String[]{"Play", "Sleep"});
        family.setPet(pet);

        System.out.println("Family Information:");
        System.out.println(family);

        System.out.println("Deleting a child from the family:");
        boolean deleted = family.deleteChild(child1);
        System.out.println("Child deleted: " + deleted);
        for (int i = 0; i < 10000000; i++) {
            if (family.deleteChild(child1)) {
                System.gc();
            }
        }
        System.out.println("Updated Family Information:");
        System.out.println(family);

        System.out.println("Number of family members: " + family.countFamily());
        family.getPet().foul();
        family.getPet().eat();
        family.getPet().respond();
        mother.greetPet();
        mother.describePet();
        mother.feedPet(true);
    }
}
