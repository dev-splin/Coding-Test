package Kakao.Blind;

import java.io.*;
import java.util.*;

public class kb2021_5 {

	class Solution {
	    
	    public int timeToSecond(String time) {
	        int result[] = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
	                
	        return result[0] * 3600 + result[1] * 60 + result[2];
	    }
	        
	    public String solution(String play_time, String adv_time, String[] logs) {
	        int playTime = timeToSecond(play_time);
	        int advTime = timeToSecond(adv_time);
	        
	        long timeLine[] = new long[playTime+1];
	        
	        for(String log : logs) {
	            String[] times = log.split("-");
	            ++timeLine[timeToSecond(times[0])];
	            --timeLine[timeToSecond(times[1])];
	        }
	        
	        for(int i = 1 ; i < timeLine.length; ++i)
	            timeLine[i] += timeLine[i-1];
	        
	        for(int i = 1 ; i < timeLine.length; ++i)
	            timeLine[i] += timeLine[i-1];
	        
	        long max = timeLine[advTime-1];
	        int startTime = 0;
	        for(int i = 0 ; i + advTime <= playTime; ++i) {
	            long tmp = timeLine[i + advTime] - timeLine[i];
	            
	            if(tmp > max) {
	                max = tmp;
	                startTime = i+1;
	            }        
	        }
	        
	        return String.format("%02d:%02d:%02d", startTime / 3600, (startTime / 60) % 60, startTime % 60);
	    }
	}
}
