package pl.stepniak.maciej.javaeducation.trywithresources;

public class TryWithResourcesRunner {

    public static void main(final String[] args) {
        try (final Operation1 op1 = new Operation1()) {
            System.out.println("Operation 1 running");
        } catch (final Exception ex) {
            System.err.println("Exception occured.");
        }
        System.out.println("---------------------------");
        final Operation2 op2 = new Operation2();
        try (final AutoCloseable closer = () -> op2.close()) {
            System.out.println("Operation 2 running");
        } catch (final Exception ex) {
            System.err.println("Exception occured.");
        }
        System.out.println("---------------------------");
        final Operation3 op3 = new Operation3();
        try (final AutoCloseable closer = op3::close) {
            System.out.println("Operation 3 running");
        } catch (final Exception ex) {
            System.err.println("Exception occured.");
        }
        System.out.println("---------------------------");
    }
}
