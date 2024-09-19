/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author zedan.net
 */
public class LibrarianUser  extends item {

    private String librarianId, name, email, address, phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public LibrarianUser() {
    }

    @Override
    public String lineRepresentation() {
        return "" + librarianId + "," + name + "," + email + "," + address + "," + phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return this.librarianId;
    }

    /* public String getLibrarianId() {
        return librarianId;
    }*/
    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
