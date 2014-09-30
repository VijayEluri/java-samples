package jp.canetrash.sample.activeobjects;

import net.java.ao.EntityManager;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        EntityManager em = new EntityManager("jdbc:hsqldb:db/test", "sa", "");
        em.migrate(Person.class, Family.class, PersonToPerson.class);
        
        Family family = em.create(Family.class);
        family.setName("Spiewak");
                
        Person me = em.create(Person.class);
        me.setName("Daniel Spiewak");
        me.setAge(27);
        me.setComment("I love databasing");
        me.setFamily(family);

        Person you = em.create(Person.class);
        you.setName("Joe Blow");
        you.setAge(23);
        you.setComment("Guess who?");
        you.setFamily(family);

        PersonToPerson relation = em.create(PersonToPerson.class);
        relation.setPersonA(me);
        relation.setPersonB(you);

        family.getPeople();     // ...returns new Person[] {you, me}
        you.getPeople();        // ...returns new Person[] {me}

        // notice, this is the first use of SQL in the whole example
        Family[] families = em.findWithSQL(Family.class, "familyID", "SELECT familyID FROM person");
        System.out.println(families.length);

        // returns any person with age >= 18
        Person[] overAge = em.find(Person.class, "age >= ?", 18);
        System.out.println(overAge.length);

        /*
         * notice the varargs parameters, as well as the direct use of an
         * entity instance without worrying about the ID value
         */
        Person[] inFamilyOver21 = em.find(Person.class, "age >= ? AND familyID = ?", 21, family);
        System.out.println(inFamilyOver21.length);
    }

}
