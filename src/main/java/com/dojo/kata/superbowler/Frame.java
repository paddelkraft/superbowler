package com.dojo.kata.superbowler;

public class Frame {

    private int[] knockedDownPins = new int[2];
    private boolean firstRoll = true;
    private boolean frameComplete = false;
    public void roll(int pinsKnockedDown) {
        
       if(firstRoll){
          this.knockedDownPins[0]=pinsKnockedDown;
          if(isStrike()){
              frameComplete  = true;
          }
          firstRoll = false;
       } else{
           this.knockedDownPins[1] =pinsKnockedDown;
           frameComplete = true;
       }
    }

    public String getFrameOutline() {
        
        if(isStrike()){
            return "X";
        }else if (isSpare()){
           return "/"; 
        }
        return (getFirstRoll()+"," 
              + getSecondRoll())
              .replace("0", "-"); 
                
    }

    public boolean isSpare() {
        return (!isStrike()) & (getFirstRoll()+getSecondRoll()==10);
    }

    public boolean isStrike() {
        return getFirstRoll()==10;
    }
    
    
    public int getFirstRoll() {
        return knockedDownPins[0];
    }

    public boolean isFrameComplete(){
        return frameComplete;
    }



    public int getSecondRoll() {
        return knockedDownPins[1];
    }





    
    
    

}
