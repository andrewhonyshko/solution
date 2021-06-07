package solution;

public class SeniorJavaDeveloper extends DeveloverDecorator{
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }
    public String makeCodeReeview()
    {
        return " Make code review.";
    }

    @Override
    public String makeJob() {
        return super.makeJob()+makeCodeReeview();
    }
}
