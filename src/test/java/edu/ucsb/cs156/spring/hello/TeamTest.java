package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    
    @Test
    public void equals_works_as_expected() {
        Team team = new Team("test-team");
        team.addMember("member1");


        Team team1 = new Team("test-team");
        team1.addMember("member1");

        assert(team.equals(team1));
        assert(team.equals(team));
        
        Team team2 = new Team("another-team");
        team2.addMember("member1");
        assert(!team.equals(team2));

        Team team3 = new Team("test-team");
        team3.addMember("member2");
        assert(!team.equals(team3));

        assert(!team.equals(null));

        assert(!team.equals("not a team"));
    }
    

    @Test
    public void hashCode_works_as_expected() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);

    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
