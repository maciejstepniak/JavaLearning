package pl.stepniak.maciej.javaeducation.trywithresources;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class Operation1 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Operation 1: close");
    }
}
