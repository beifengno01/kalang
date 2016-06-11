
package kalang.core;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class Class {
    
    private Field[] fields;
    
    private MethodDescriptor[] methods;
    
    private String name;
    
    private Class parent;

    public Class(String name, Field[] fields, MethodDescriptor[] methods,Class parent) {
        this.fields = fields;
        this.methods = methods;
        this.name = name;
        this.parent = parent;
    }

    public Field[] getFields() {
        return fields;
    }

    public MethodDescriptor[] getMethods() {
        return methods;
    }

    public String getName() {
        return name;
    }

    public Class getParent() {
        return parent;
    }
    

}
