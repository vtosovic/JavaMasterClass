package dev.lpa;

interface Player{
    String name();
}

record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position) implements Player{}
record VollebayPlayer(String name, String position) implements Player{}


public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city",
                "Philadelphia, PA", "US");
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);
        //Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2, 3, astros2, 5);
        //Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)

        Team<BaseballPlayer, Affiliation> phillies =
                new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);
        //Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();
        //Philadelphia Phillies Roster: AFFILIATION: city (Philadelphia, PA in US)
        //B Harper
        //B Marsh
        //D Guthrie

        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows",
                "City of Adelaide, South Australia, in AU");

        var tex = new FootballPlayer("Tex Walker", "Center half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        //this will not work, after adding generic:
//        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
//        afc.addTeamMember(guthrie);

        Team<VollebayPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VollebayPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VollebayPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VollebayPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);
        //B Harper
        //B Marsh
        //D Guthrie
        //Adelaide Crows Roster: AFFILIATION: City of Adelaide, South Australia, in AU
        //Tex Walker
        //Rory Laird
        //Adelaide Storm Roster:
        //N Roberts
        //Canberra Heat Roster:
        //B Black
        //Canberra Heat (Ranked 3) lost to Adelaide Storm (Ranked 1)

    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
