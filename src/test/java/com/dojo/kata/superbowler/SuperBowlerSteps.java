package com.dojo.kata.superbowler;

import org.junit.Assert;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class SuperBowlerSteps {
    
    SuperBowlerGame game = null;
    
    @Given("^a fresh game$")
    public void a_fresh_game() throws Throwable {
        game = new SuperBowlerGame();
    }

    @When("^i roll (\\d+) strikes?$")
    public void i_roll_strike(int strikes) throws Throwable {
            game.roll(10);
    }
    
    @Then("^game outline should be (.*)$")
    public void game_outline_should_be_X(String expectedThrows) throws Throwable {
        Assert.assertEquals(expectedThrows, game.getGameOutline());
    }

    @Then("^total score should be (.*)$")
    public void total_score_should_be(String expectedScore) throws Throwable {
        Assert.assertEquals(expectedScore,game.getTotalScore());
    }
    
    
   
    @Then("^frame score for frame (\\d+) should be (.*)$")
    public void frame_score_for_frame_should_be(int frame,String expectedFrameScore) throws Throwable {
        Assert.assertEquals(expectedFrameScore, game.getScoreForFrame(frame));
    }
}
