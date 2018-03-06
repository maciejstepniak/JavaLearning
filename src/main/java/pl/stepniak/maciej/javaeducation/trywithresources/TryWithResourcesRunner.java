package pl.stepniak.maciej.javaeducation.trywithresources;

/**
 *
 * @author Maciej Stępniak &lt;maciek.stepniak@gmail.com&gt;
 */
public class TryWithResourcesRunner {

    public static void main(String[] args) {
        try (Operation1 op1 = new Operation1()) {
            System.out.println("Operation 1 running");
        } catch (Exception ex) {
            System.err.println("Exception occured.");
        }
        System.out.println("---------------------------");
        Operation2 op2 = new Operation2();
        try (AutoCloseable closer = () -> op2.close()) {
            System.out.println("Operation 2 running");
        } catch (Exception ex) {
            System.err.println("Exception occured.");
        }
        System.out.println("---------------------------");
        Operation3 op3 = new Operation3();
        try (AutoCloseable closer = op3::close) {
            System.out.println("Operation 3 running");
        } catch (Exception ex) {
            System.err.println("Exception occured.");
        }
        System.out.println("---------------------------");
    }
}
