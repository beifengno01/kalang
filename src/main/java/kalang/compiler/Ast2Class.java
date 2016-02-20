
package kalang.compiler;
import kalang.ast.AbstractAstVisitor;
import kalang.ast.AssignExpr;
import kalang.ast.AstVisitor;
import kalang.ast.BinaryExpr;
import kalang.ast.BlockStmt;
import kalang.ast.BreakStmt;
import kalang.ast.CastExpr;
import kalang.ast.CatchStmt;
import kalang.ast.ClassExpr;
import kalang.ast.ClassNode;
import kalang.ast.ConstExpr;
import kalang.ast.ContinueStmt;
import kalang.ast.ElementExpr;
import kalang.ast.ExprStmt;
import kalang.ast.FieldExpr;
import kalang.ast.IfStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.KeyExpr;
import kalang.ast.LoopStmt;
import kalang.ast.MethodNode;
import kalang.ast.MultiStmtExpr;
import kalang.ast.NewArrayExpr;
import kalang.ast.ParameterExpr;
import kalang.ast.ReturnStmt;
import kalang.ast.ThrowStmt;
import kalang.ast.TryStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.VarExpr;
import kalang.ast.VarObject;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.ast.AssignableExpr;
import kalang.ast.ExprNode;
import kalang.core.ArrayType;
import kalang.core.Type;
import kalang.core.Types;
import static kalang.core.Types.*;
import kalang.util.AstUtil;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.*;
/**
 *The class generate the java class binary data for ast
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class Ast2Class extends AstVisitor<Object>{

    private ClassWriter classWriter;
    private MethodVisitor md;
    
    private final static int 
            T_I = 0,
            T_L = 1,
            T_F = 2,
            T_D = 3,
            T_A = 4;
    
    private int getT(Type type){
        int t;
            if(
                    type.equals(INT_TYPE)
                    ||type.equals(BOOLEAN_TYPE)
                    || type.equals(CHAR_TYPE)
                    || type.equals(BYTE_TYPE)
                    || type.equals(SHORT_TYPE)
                    ){
                t = T_I;
            }else if(type.equals(LONG_TYPE)){
                t = T_L;
            }else if(type.equals(FLOAT_TYPE)){
                t = T_F;
            }else if(type.equals(DOUBLE_TYPE)){
                t = T_D;
            }else{
                t = T_A;
            }
            return t;
    }

    private String interClassName(String name){
        return name.replace(".", "/");
    }
    
    private String[] interClassName(String[] names){
        String[] inames = new String[names.length];
        for(int i=0;i<names.length;i++){
            inames[i] = interClassName(names[i]);
        }
        return inames;
    }
    
    @Override
    public Object visitClassNode(ClassNode node) {        
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        //TODO modifier -> access
        int access = node.modifier;
        String sign = null;
        classWriter.visit(V1_5, access,interClassName(node.name), sign, node.parent.name,interClassName(node.interfaces.toArray(new String[0])));
        return super.visit(node);
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        //TODO mdf => access
        int access = node.modifier;
        md = classWriter.visitMethod(access, interClassName(node.name),getMethodDescriptor(node), null,internalName(node.exceptionTypes.toArray(new Type[0])) );
        super.visit(node);
        md.visitEnd();
        return null;
    }

    @Override
    public Object visitBlockStmt(BlockStmt node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Object visitBreakStmt(BreakStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitContinueStmt(ContinueStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitExprStmt(ExprStmt node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Object visitIfStmt(IfStmt node) {
        Label stopLabel = new Label();
        Label falseLabel = new Label();
        visit(node.conditionExpr);
        md.visitJumpInsn(IFEQ, falseLabel);
        if(node.trueBody!=null){
            visit(node.trueBody);
        }
        md.visitJumpInsn(GOTO, stopLabel);
        md.visitLabel(falseLabel);
        if(node.falseBody!=null){
            visit(node.falseBody);
        }
        md.visitLabel(stopLabel);
        return null;
    }

    @Override
    public Object visitLoopStmt(LoopStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitReturnStmt(ReturnStmt node) {
        int lnsn = RETURN;
        if(node.expr!=null){
            visit(node.expr);
            Type type = node.expr.type;
            lnsn = asmType(type).getOpcode(IRETURN);
        }
        md.visitInsn(lnsn);
        return null;
    }

    @Override
    public Object visitTryStmt(TryStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitCatchStmt(CatchStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitThrowStmt(ThrowStmt node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        AssignableExpr to = node.to;
        org.objectweb.asm.Type type = asmType(node.from.type);
        if(to instanceof FieldExpr){
            FieldExpr toField = (FieldExpr) to;
            int opc = PUTFIELD;
            if(toField.target instanceof ClassExpr){
                opc = PUTSTATIC;
            }else{
                visit(toField.target);
            }
            visit(node.from);
            md.visitFieldInsn(
                    opc, 
                    asmType(toField.target.type).getInternalName()
                    , toField.fieldName
                    , getTypeDescriptor(toField.target.type)
            );
        }else if(to instanceof VarExpr){
            visit(node.from);
            VarExpr toVarExpr = (VarExpr) to;
            int vid = getVarId(toVarExpr.var);
            md.visitVarInsn(type.getOpcode(ISTORE), vid);
        }else{
            throw new UnknownError("unknown expression:" + to);
        }
        return null;
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        visit(node.expr1);
        visit(node.expr2);
        int op = 0;
        org.objectweb.asm.Type at = asmType(node.expr1.type);
        switch(node.operation){
            case "+": op = IADD;break;
            case "-" : op = ISUB;break;
            case "*" : op = IMUL;break;
            case "/" : op = IDIV;break;
            case "%":op = IREM;break;
            default:throw new IllegalArgumentException("unknown op:" + node.operation);
        }
        md.visitInsn(at.getOpcode(op));
        return null;
    }

    @Override
    public Object visitConstExpr(ConstExpr node) {
        md.visitLdcInsn(node.value);
        return null;
    }

    @Override
    public Object visitElementExpr(ElementExpr node) {
        visit(node.arrayExpr);
        visit(node.index);
        org.objectweb.asm.Type t = asmType(((ArrayType)node.type).getComponentType());
        md.visitInsn(t.getOpcode(IALOAD));
        return null;
    }

    @Override
    public Object visitFieldExpr(FieldExpr node) {
        int opc = GETFIELD;
        if(node.target instanceof ClassExpr){
            opc = GETSTATIC;
        }else{
            visit(node.target);
        }
        md.visitFieldInsn(
                opc
                ,asmType(node.target.type).getInternalName()
                ,node.fieldName
                , getTypeDescriptor(node.type));
        return null;
    }

    @Override
    public Object visitInvocationExpr(InvocationExpr node) {
        int opc = INVOKEVIRTUAL;
        if(node.target instanceof ClassExpr){
            opc = INVOKESTATIC;
        }else{
            visit(node.target);
        }
        visitAll(node.arguments);
        md.visitMethodInsn(
                opc
                , internalName(node.target.type)
                , node.methodName
                , getTypeDescriptor(
                        AstUtil.getExprTypes(node.arguments.toArray(new ExprNode[0])) )
                , false);
        return null;
    }

    @Override
    public Object visitUnaryExpr(UnaryExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitVarExpr(VarExpr node) {
        visitVarObject(node.var);
        return null;
    }

    @Override
    public Object visitClassExpr(ClassExpr node) {
        return null;
    }

    @Override
    public Object visitParameterExpr(ParameterExpr node) {
        visitVarObject(node.parameter);
        return null;
    }

    @Override
    public Object visitCastExpr(CastExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitNewArrayExpr(NewArrayExpr node) {
        visit(node.size);
        //org.objectweb.asm.Type t = asmType(node.type);
        Type t = node.type;
        int opr = -1;
        int op = NEWARRAY;
        if(t.equals(BOOLEAN_TYPE)){
            opr = T_BOOLEAN;
        }else if(t.equals(CHAR_TYPE)){
            opr = T_CHAR;
        }else if(t.equals(SHORT_TYPE)){
            opr = T_SHORT;
        }else if(t.equals(INT_TYPE)){
            opr = T_INT;
        }else if(t.equals(LONG_TYPE)){
            opr = T_LONG;
        }else if(t.equals(FLOAT_TYPE)){
            opr = T_FLOAT;
        }else if(t.equals(DOUBLE_TYPE)){
            opr = T_DOUBLE;
        }else if(t.equals(BYTE_TYPE)){
            opr = T_BYTE;
        }else{
            op = ANEWARRAY;
        }
        if(op==NEWARRAY){
            md.visitIntInsn(op, opr);
        }else{
            md.visitTypeInsn(ANEWARRAY, internalName(t));
        }
        return null;
    }

    @Override
    public Object visitKeyExpr(KeyExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object visitMultiStmtExpr(MultiStmtExpr node) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private String getTypeDescriptor(Type[] types){
        String ts = "";
        for(Type t:types){
            ts += getTypeDescriptor(t);
        }
        return ts;
    }
    
    private String getTypeDescriptor(Type t){
        if(t instanceof ArrayType){
            return "[" + getTypeDescriptor(t);
        }else{
            if(t.equals(BOOLEAN_TYPE)){
                return "Z";
            }
            switch(getT(t)){
                case T_I:return "I";
                case T_L:return "L";
                case T_F:return "F";
                case T_D:return "D";
                case T_A:return "L" + interClassName(t.getName()) + ";";
                default:throw new IllegalArgumentException("unknown type:" + t.getName());
            }
        }
    }
    private String getSingleTypeDescriptor(String type){
        switch(type){
            case "int":return "I";
            case "long":return "L";
            case "float":return "F";
            case "double":return "D";
            case "boolean":return "Z";
            default:return "L" + interClassName(type) + ";";
        }
    }
        
    private String getMethodDescriptor(MethodNode node) {
//        String desc = "";
//        String retTyp = getTypeDescriptor(node.type);
//        for(VarObject p:node.parameters){
//            desc += getTypeDescriptor(p.type);
//        }
//        return "(" + desc + ")" + retTyp;
        return null;
    }
    
    private org.objectweb.asm.Type asmType(Type type){
        return org.objectweb.asm.Type.getType(getTypeDescriptor(type));
    }

    private int getVarId(VarObject var) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void visitVarObject(VarObject vo){
        org.objectweb.asm.Type type = asmType(vo.type);
        int vid = getVarId(vo);
        md.visitVarInsn(type.getOpcode(ILOAD),vid);
    }

    private String internalName(Type t) {
        return asmType(t).getInternalName();
    }
    
    private String[] internalName(Type[] types){
        String[] ts = new String[types.length];
        for(int i=0;i<types.length;i++){
            ts[i] = internalName(types[i]);
        }
        return ts;
    }

}