import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Contact {


    private int dni;
    private String name;
    private String phone;
    private HashSet<Contact> contacts;


    public Contact() {
        // TODO: 3/16/16
    }
    public Contact(int dni) {
        this.dni=dni;
        contacts = new HashSet<>();
    }
    public Contact(int dni, String name, String phone) {
        this.dni=dni;
        this.name=name;
        this.phone=phone;
        contacts = new HashSet<>();
    }

    public Contact search(int dni) {
        if (contacts.contains(new Contact(dni))) {
            for (Contact c : contacts) {
                if (c.dni == dni) return c;
            }
        }
        return null;
    }


    public boolean add(Contact contact) {
        if (contact.dni != this.dni) {
            return contacts.add(contact);
        }
        return false;
    }

    public boolean remove (Contact contact) {
        return contacts.remove(contact);
    }

    public void removeAll() {
        contacts.clear();
    }

    public void listContacts() {
        System.out.println("--------- Contactes de: "+name+" ---------");
        if(!contacts.isEmpty()) {
            for (Contact c : contacts) {
                System.out.println("DNI:\t" + c.dni + "\tnom:\t" + c.name + "\ttelèfon:\t" + c.phone);
            }
        } else {
            System.out.println("No hi ha cap contacte.");
        }
        System.out.println("------------------------------------------");
    }

    @Override
    public int hashCode() {
        return dni;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return dni == contact.dni;
    }

    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getPhone(){
        return phone;
    }
    @Override
    public String toString() {
        return "DNI:\t"+dni+"\tnom:\t"+name+"\ttelèfon:\t"+phone;
    }

    public static void main(String[] args) {
        Contact c = new Contact(47912783, "Charly", "623845996");
        Contact c1 = new Contact(47348571, "Laura", "697284685");
        Contact c2 = new Contact(46982758, "Carla", "658735945");
        Contact c3 = new Contact(47258465, "Paula", "645978254");

        System.out.println(c.add(c1)); // Be
        System.out.println(c.add(c1)); // Ja existeix
        System.out.println(c.add(c));  // Jo mateix
        System.out.println(c.add(c2)); // Be
        System.out.println(c.add(c3)); // Be
        System.out.println(c.add(c2)); // Ja existeix

        System.out.println(c.search(46982758));     // Carla
        System.out.println(c.search(123));          // No existeix
        System.out.println(c.search(47912783));     // Jo mateix
        System.out.println(c.search(47348571));     // Laura

        System.out.println(c.remove(c2));           // Carla
        System.out.println(c.remove(c));            // Jo mateix

        c.listContacts();   // Mostro els contactes

        c.removeAll();      // Els borro tots

        c.listContacts();   // Comprovo que s'han borrat
    }
}
