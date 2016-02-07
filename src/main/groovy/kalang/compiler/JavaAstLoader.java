package kalang.compiler;

import jast.ast.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@groovy.transform.TypeChecked
public class JavaAstLoader extends AstLoader {

    static String ROOT_CLASS = "java.lang.Object";
    
    private ClassLoader javaClassLoader;

    public static ClassNode buildFromClass(Class clz) {
        ClassNode cn = ClassNode.create();
        cn.name = clz.getName();
        Class superClass = clz.getSuperclass();
        if (superClass != null) {
            cn.parentName = superClass.getName();
        } else if (!cn.name.equals(ROOT_CLASS)) {
            cn.parentName = ROOT_CLASS;
        }
        List<Executable> methods = new LinkedList();
        methods.addAll(Arrays.asList(clz.getMethods()));
        methods.addAll(Arrays.asList(clz.getConstructors()));
        for (Executable m : methods) {
            MethodNode methodNode = MethodNode.create();
            for (Parameter p : m.getParameters()) {
                VarObject param = new VarObject();
                param.name = p.getName();
                param.type = p.getType().getTypeName();
                methodNode.parameters.add(param);
            }
            if (m instanceof Method) {
                methodNode.type = ((Method) m).getReturnType().getName();
                methodNode.name = m.getName();
                methodNode.modifier = m.getModifiers();
            } else if (m instanceof Constructor) {
                methodNode.name = "<init>";
                methodNode.type = clz.getName();
                methodNode.modifier = m.getModifiers() | Modifier.STATIC;
            }
            cn.methods.add(methodNode);
            methodNode.body = null;
            for (Class e : m.getExceptionTypes()) {
                methodNode.exceptionTypes.add(e.getName());
            }
        }
        for (Field f : clz.getFields()) {
            VarObject fn = new VarObject();
            fn.name = f.getName();
            fn.type = f.getType().getName();
            fn.modifier = f.getModifiers();
            cn.fields.add(fn);
        }
        return cn;
    }

    public JavaAstLoader(ClassLoader javaClassLoader) {
        this.javaClassLoader = javaClassLoader;
    }

    public JavaAstLoader() {
        javaClassLoader = this.getClass().getClassLoader();
    }
    
    

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if(className==null){
            System.err.println("warning:trying to null class");
            throw new AstNotFoundException("null");
        }
        try {
            return super.findAst(className);
        } catch (AstNotFoundException e) {
            try {
                Class clz = javaClassLoader.loadClass(className);
                return buildFromClass(clz);
            } catch (ClassNotFoundException ex) {
                throw e;
            }
        }
    }

}
