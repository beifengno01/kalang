package compilier
import jast.ast.AbstractAstVisitor
import jast.ast.AssignExpr;
import jast.ast.BinaryExpr;
import jast.ast.BlockStmt;
import jast.ast.BreakStmt;
import jast.ast.CastExpr;
import jast.ast.ClassExpr;
import jast.ast.ClassNode;
import jast.ast.ConstExpr;
import jast.ast.ContinueStmt;
import jast.ast.ElementExpr;
import jast.ast.ExprNode;
import jast.ast.ExprStmt;
import jast.ast.FieldExpr;
import jast.ast.FieldNode;
import jast.ast.IAstVisitor
import jast.ast.AstVisitor
import jast.ast.IfStmt;
import jast.ast.InvocationExpr;
import jast.ast.LoopStmt;
import jast.ast.MethodNode;
import jast.ast.NewExpr;
import jast.ast.ParameterExpr;
import jast.ast.ParameterNode;
import jast.ast.ReturnStmt;
import jast.ast.Statement;
import jast.ast.UnaryExpr;
import jast.ast.VarDeclStmt;
import jast.ast.VarExpr;

import java.lang.reflect.Modifier
@groovy.transform.TypeChecked
class Ast2Java extends AbstractAstVisitor<String>{

	@Override
	public String visitCastExpr(CastExpr node) {
		"(${node.type}) ${visit(node.expr)}"
	}

	@Override
	public String visitParameterNode(ParameterNode node) {
		return "${node.type} ${node.name}"
	}

	@Override
	public String visitParameterExpr(ParameterExpr node) {
		"${node.parameter.name}"
	}

	@Override
	public String visitNewExpr(NewExpr node) {
		def args = visit(node.arguments).join(",")
		"new ${node.type}(${args})"
	}

	HashMap<Integer,String> varNames = [:]
	
	@Override
	public String visitVarExpr(VarExpr node) {
		def var = node.declStmt.varName
		return var
	}

	@Override
	public String visitClassExpr(ClassExpr node) {
		return node.name
	}

	protected String code = "";
	
	private String stmtDelim = ";"
	
	private String indent = "";
	
	private void incIndent(){
		indent += "  "
	}
	
	private void decIndent(){
		indent = indent.substring(0,indent.length()-2)
	}
	
	public String visitModifier(Integer modifier){
		int m = modifier?:0
		return Modifier.toString(m)
	}
	
	@Override
	public String visitClassNode(ClassNode node) {
		String imports = ""// visit(node.imports).join("\r\n")
		incIndent()
		String fs = visit(node.fields).join("\r\n");
		String mds = visit(node.methods).join("\r\n");
		decIndent()
		String mdf = visitModifier( node.modifier )
		def pkg = ""
		def name = node.name
		def dotIdx = name.lastIndexOf('.');
		if(dotIdx>0){
			pkg = name.substring(0,dotIdx)
			name = name.substring(dotIdx+1)
		}
		String pkgStr = pkg?"package ${pkg};":""
		String parentStr = node.parentName ? " extends ${node.parentName}" :""
		return "${pkgStr}\r\n${imports}\r\n${mdf} class ${name} ${parentStr} {\r\n${fs}\r\n${mds}\r\n}"
	}

	@Override
	public String visitFieldNode(FieldNode node) {
		indent + "${visitModifier(node.modifier)} ${node.type} ${node.name}" +(node.initExpr?"=${visit(node.initExpr)}":"") +";"
	}

	@Override
	public String visitMethodNode(MethodNode node) {
		this.stmtDelim = ""
		String ps = visit(node.parameters).join(",")
		this.stmtDelim = ";"
		incIndent()
		String body = ";";
		if(node.body){
			body = visit(node.body)
		}
		decIndent()
		indent + "${visitModifier(node.modifier)} ${node.type} ${node.name}(${ps}) ${body}"
	}

	@Override
	public String visitBlockStmt(BlockStmt node) {
		incIndent()
		String body = visit(node.statements).join("\r\n")
		decIndent()
		"{\n${body}\n" + indent + "}"
	}

	@Override
	public String visitBreakStmt(BreakStmt node) {
		indent + "break;"
	}

	@Override
	public String visitContinueStmt(ContinueStmt node) {
		indent + "continue;"
	}

	@Override
	public String visitExprStmt(ExprStmt node) {
		return indent + visit(node.expr) +';';
	}

	@Override
	public String visitIfStmt(IfStmt node) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public String visitImportNode(ImportNode node) {
		"import ${node.name};"
	}*/

	@Override
	public String visitLoopStmt(LoopStmt node) {
		def oldIndent = this.indent
		this.indent = ""
		def pre = node.preConditionExpr;
		def post = node.postConditionExpr;
		def init = visit(node.initStmts).join(",");
		this.indent = oldIndent
		def body = visit(node.loopBody)
		this.stmtDelim = ""
		this.stmtDelim = ";"
		if(pre){
			return indent + "for(${init};${visit(pre)};)${body}"
		}else{
			return indent + "do{${body}}while(${visit(post)});"
		}
	}

	@Override
	public String visitReturnStmt(ReturnStmt node) {
		indent + "return ${visit(node.expr)};"
	}

	@Override
	public String visitVarDeclStmt(VarDeclStmt node) {
		varNames.put(node.varId,node.varName)
		String code = "${node.type} ${node.varName}"
		if(node.initExpr){
			code+= "=${visit(node.initExpr)}"
		}
		indent + code + this.stmtDelim;
	}

	@Override
	public String visitAssignExpr(AssignExpr node) {
		"${visit(node.to)}=${visit(node.from)}"
	}

	@Override
	public String visitBinaryExpr(BinaryExpr node) {
		"${visit(node.expr1)}${node.operation}${visit(node.expr2)}"
	}

	@Override
	public String visitConstExpr(ConstExpr node) {
		"${node.value}"
	}

	@Override
	public String visitElementExpr(ElementExpr node) {
		"${visit(node.target)}[${visit(node.key)}]"
	}

	@Override
	public String visitFieldExpr(FieldExpr node) {
		def target = "" 
		if(node.target){
			target = visit(node.target) + "."
		}
		"${target}${node.fieldName}"
	}

	@Override
	public String visitInvocationExpr(InvocationExpr node) {
		def target = node.target ? "${visit(node.target)}." : ""
		def args = visit(node.arguments).join(",");
		"${target}${node.methodName}($args)"
	}

	@Override
	public String visitUnaryExpr(UnaryExpr node) {
		"${node.preOperation?:''}${visit(node.expr)}${node.postOperation?:''}"
	}

}