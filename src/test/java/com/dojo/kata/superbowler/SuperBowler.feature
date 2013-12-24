Feature: Interactive Bowling
 
  Background:
  Given a fresh game
  
  Scenario: First Strike
  
  When i roll 1 strike
  Then total score should be 0
  And game outline should be X
  And frame score for frame 1 should be X
  
 
  