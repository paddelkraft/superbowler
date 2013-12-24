package com.dojo.kata.superbowler;

import java.util.ArrayList;
import java.util.List;

public class SuperBowlerGame {
    
    private List<Frame> frames = new ArrayList<Frame>();
    boolean firstRoll = true;
    Frame currentFrame = null;
    boolean fullGame = false;
    
    public void roll(int pinsKnockedDown) {
        if(firstRoll){
            currentFrame = new Frame() ;
            frames.add(currentFrame);
        }
        currentFrame.roll(pinsKnockedDown);
        if(pinsKnockedDown<10 & firstRoll ){
            firstRoll = false;
        } else {
            firstRoll = true;
        }
    }

    public String getTotalScore() {
        return ""+calculateTotalScore(getGameOutline());
    }

    public String getGameOutline() {
        String gameOutline = "";
        for(Frame frame : frames){
           gameOutline += ","+frame.getFrameOutline();  
        }
        return gameOutline.substring(1);
    }

    public String getScoreForFrame(int frame) {
        frame--;
        int score = calculateFrameScore(frame); 
        if ( (score == 0) & "X/".contains(frames.get(frame).getFrameOutline())){
            return frames.get(frame).getFrameOutline();
        }
        return "" +score;
    }
    
   public boolean completedGame()  {
       boolean full = false; 
       if(frames.size()>=9 & !"X/".contains(getScoreForFrame(10))){
            full = true;
        }
       return full;
   }

   private int calculateFrameScore(int frame) {
        if(isSpare(frame)){
            return sparePointsCalculation(frame);
        }else if(isStrike(frame)){
            return strikePointsCalculation(frame);
        } else{
            return getFirstRoll(frame) + getSecondRoll(frame);
        }
    }



    private int sparePointsCalculation(int frame) {
        int nextFrame = frame +1;
        if(!lastPlayedFrame(frame)){
            return 10 + getFirstRoll(nextFrame);
        }
        return 0;
    }



    private int strikePointsCalculation(int frame) {
        int nextFrame = frame+1;
        if(!lastPlayedFrame(frame)){
            if(isStrike(nextFrame)){
                    if(!lastPlayedFrame(nextFrame) ){
                        return 20 + getFirstRoll(nextFrame+1);
                    }
                    
            }else if(frames.get(nextFrame).isFrameComplete()){
                return 10 + getFirstRoll(nextFrame) + getSecondRoll(nextFrame);
            }
            
        }
        return 0;
    }

    private boolean isStrike(int frame) {
        return frames.get(frame).isStrike();
    }

    private boolean isSpare(int frame) {
        return frames.get(frame).isSpare();
    }

    private int getSecondRoll(int frame) {
        int pins = 0; 
        if(getFirstRoll(frame)==10  & !lastPlayedFrame(frame)){
            pins = frames.get(frame + 1).getFirstRoll();
        } else{
            pins = frames.get(frame).getSecondRoll();
        }
        return pins;
    }
    

    private int getFirstRoll(int frame) {
        return frames.get(frame).getFirstRoll();
    }
    
    private int calculateTotalScore(String allThrows) {
        int score = 0;
        for(int i = 0; i<frames.size();i++){
           score += calculateFrameScore(i) ;
        }
        return score;
    }
    
    private boolean lastPlayedFrame(int frame) {
        return frames.size() == frame+1;
    }


}
