package abstract_factory;

public class TruckEngine implements Engine{
    @Override
    public void create() {
        System.out.println("Creating truck engine");
    }
}
