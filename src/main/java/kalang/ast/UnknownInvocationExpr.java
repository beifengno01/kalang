
package kalang.ast;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.core.Type;
import kalang.core.Types;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class UnknownInvocationExpr extends ExprNode{
    
    private ExprNode target;
    
    private String methodName;
    
    private ExprNode[] arguments;

    public UnknownInvocationExpr(ExprNode target, String methodName, ExprNode[] arguments) {
        this.target = target;
        this.methodName = methodName;
        this.arguments = arguments;
    }

    public ExprNode getTarget() {
        return target;
    }

    public String getMethodName() {
        return methodName;
    }

    public ExprNode[] getArguments() {
        return arguments;
    }

    @Override
    public Type getType() {
        return Types.ROOT_TYPE;
    }

}