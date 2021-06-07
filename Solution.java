package solution;



/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception
    {
        Developer developer=new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}
