import java.util.*;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.pet=new Pet();
        mother.setFamily(this);
        father.setFamily(this);
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public Human[] getChildren() {
        return children;
    }
    public Pet getPet() {
        return pet;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(Human[] children) {
        this.children = children;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void addChild(Human child) {
        children= Arrays.copyOf(children, children.length+1);
        children[children.length-1]=child;
        child.setFamily(this);
    }
    public boolean deleteChild(Human child) {
        for(int i=0;i<children.length;i++) {
            if(children[i]==child) {
                for(int j=i;j<children.length-1;j++) {
                    children[j]=children[j+1];
                }
                children=Arrays.copyOf(children, children.length-1);
                child.setFamily(null);
                return true;
            }
        }
        return false;
    }
    public boolean deleteChild(int index) {
        index=index-1;
        if(index<0 || index>=children.length) {
            return false;
        }
        for(int i =index;i<children.length;i++) {
            children[i]=children[i+1];
        }
        children=Arrays.copyOf(children, children.length-1);
        children[index]=null;
        return false;
    }
    public int countFamily(){
        return children.length+2;
    }

    @Override
    public String toString() {
        return "Family{mother=" + mother + ", father=" + father + ", children=" + Arrays.toString(children) + ", pet=" + pet + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        throw new UnsupportedOperationException("finalize() method is not supported in Family");
    }


}
