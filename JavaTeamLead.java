package solution;

public class JavaTeamLead extends DeveloverDecorator{
    public JavaTeamLead(Developer developer) {
        super(developer);
    }
    public String sendWeerReport()
    {
        return " Send week report.";
    }

    @Override
    public String makeJob() {
        return super.makeJob()+sendWeerReport();
    }
}
