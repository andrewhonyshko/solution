package solution;

public class DeveloverDecorator implements Developer{
    Developer developer;

    public DeveloverDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
