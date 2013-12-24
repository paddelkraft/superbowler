package com.dojo.kata.superbowler;

import junit.framework.Assert;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class SuperBowlerSteps {
    
    SuperBowlerGame game = null;
    
    @Given("^a fresh game$")
    public void a_fresh_game() throws Throwable {
        game = new SuperBowlerGame();
    }

    @When("^i roll (\\d+) strikes?$")
    public void i_roll_strike(int strikes) throws Throwable {
        for(int i = 0;i<strikes;i++){
            game.roll(10);
        }
    }
    
    @When("^i roll (\\d+) gutter balls?$")
    public void i_roll_gutter_balls(int gutterBalls) throws Throwable {
        for(int i = 0;i<gutterBalls;i++){
            game.roll(0);
        }
        
    }
    
    @When("^i roll (\\d+) spare$")
    public void i_roll_spare(int spares) throws Throwable {
        for(int i = 0;i<spares;i++){
            game.roll(5);
            game.roll(5);
        }
    }
    
    @When("^i knock down (\\d+) pins?$")
    public void i_knock_down_pins(int pins) throws Throwable {
        game.roll(pins);
    }
    
    @Then("^game outline should be (.*)$")
    public void game_outline_should_be_X(String expectedThrows) throws Throwable {
        Assert.assertEquals(expectedThrows, game.getGameOutline());
    }

    @Then("^total score should be (.*)$")
    public void total_score_should_be(String expectedScore) throws Throwable {
        Assert.assertEquals(expectedScore,game.getTotalScore());
    }
    
    @Then("^i should be able to roll a ball$")
    public void i_should_be_able_to_roll_a_ball() throws Throwable {
        Assert.assertFalse(game.completedGame());
    }
    //Junk
    
    @Then("^i should not be able to roll a ball$")
    public void i_should_not_be_able_to_roll_a_ball() throws Throwable {
        Assert.assertTrue(game.completedGame());
    }

    

    @Then("^frame score for frame (\\d+) should be (.*)$")
    public void frame_score_for_frame_should_be(int frame,String expectedFrameScore) throws Throwable {
        
        Assert.assertEquals(expectedFrameScore, game.getScoreForFrame(frame));
    }


}
