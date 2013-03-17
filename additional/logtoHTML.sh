#!/bin/bash 
# 
# This filter is transform logcat data to HTML
# 
echo "<head><link rel="stylesheet" type="text/css" href="style.css" /></head><table>"
COLOR1=#F8F7F6
    COLOR2=#FFFFFF
    bg=$COLOR1
while read a ; 
  do
    first_symbol=${a:19:1};
    
    case $first_symbol in
     "E" )
          Col="#ff0000" #red
           ;;
     "V" )
           Col="#000033" # black
           ;;
     "I" )
           Col="#509E06" #green 
           ;;
     "W" )
           Col="#ff8100" #orange 
           ;;
     "D" )
           Col="#0e53a7" # blue
           ;;
      *	 ) 
	   Col="#000033" # black
           ;;
    esac 
      echo "<tr style=\"color:"$Col"\" bgcolor=\""$bg"\"><td ID=time>" 
	a0=${a:0:18}
      echo $a0"</td><td>"
	a01=${a#$a0}
     	X='(*'
	a1=${a01%%$X}
      echo $a1"</td><td>"
	a2=${a01#$a1"("}
	X1='):*'
	a3=${a2%%$X1}
      echo $a3"</td><td>"
     	a4=${a2#$a3"):"}
      echo $a4"</td></tr>"
      if [ $bg = $COLOR1 ]; then	
	bg=$COLOR2
      else
	bg=$COLOR1
      fi
  done 
echo "</table>"
