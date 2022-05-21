/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author User
 */
public class Manager {
    private String id;
    private String name;
    
    public Manager(String id, String name) {
            this.id = id;
            this.name = name;
        }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    

}
