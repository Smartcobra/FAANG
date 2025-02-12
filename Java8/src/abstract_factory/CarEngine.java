package abstract_factory;

public class CarEngine implements Engine{
    @Override
    public void create() {
        System.out.println("Creating car seats");
    }
}
