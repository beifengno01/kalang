package kalang.test;

import java.io.File;
import java.io.IOException;
import kalang.tool.ClassWriter;
import kalang.tool.FileSystemOutputManager;
import org.junit.Test;

/**
 *
 * @author Kason Yang 
 */
public class ExamplesTest extends JointCompilerTestCase{
    
    public ExamplesTest() {
    }

    @Test
    public void testExamples() throws IOException {
        addSourceDir(new File("examples"));
        addSourceDir(new File("TestScript/source"));
        FileSystemOutputManager fom = new FileSystemOutputManager(new File("build/examples"),"class");
        setJavaOutputManager(fom);
        setCodeGenerator(new ClassWriter(fom));
        compile();
    }
    
}
