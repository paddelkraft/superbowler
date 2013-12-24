Feature: Interactive Bowling
 
  Background:
  Given a fresh game
  
  Scenario: First Strike
  
  When i roll 1 strike
  And i roll 1 gutter ball
  Then total score should be 0
  And game outline should be X
  And frame score for frame 1 should be X
  
 
  Scenario: 4rd Strike
  
  When i roll 4 strikes
  Then game outline should be X,X,X,X
  And frame score for frame 2 should be 30
  And total score should be 60
  
  Scenario: Perfect game
  
  When i roll 12 strikes
  Then total score should be 300
  
  Scenario: Gutter frame
  
  When i roll 2 gutter balls
  Then total score should be 0
  And game outline should be -,-
  And frame score for frame 1 should be 0

  Scenario: Spare
  
  When i roll 1 spare
  And i roll 1 strike
  Then frame score for frame 1 should be 20
  And game outline should be /,X
  And total score should be 20
  
  

  Scenario: regular frame

  When i knock down 4 pins
  And i knock down 1 pin
  Then total score should be 5
  And game outline should be 4,1
  And frame score for frame 1 should be 5

  Scenario: last frame strike

  When i roll 10 strikes
  And i knock down 5 pins
  Then i should be able to roll a ball 
  
  Scenario: last frame spare

  When i roll 9 strikes
  And i roll 1 spare
  Then i should be able to roll a ball 


  Scenario: last frame regular

  When i roll 9 strikes
  And i knock down 5 pins
  And i knock down 4 pins
  Then i should not be able to roll a ball 


  