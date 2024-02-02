# Yatzy Refactoring Kata

There is a [top code kata video](https://youtu.be/SvcJKNF_nRQ) explaining why you might want to try this refactoring kata. The original exercise was designed by Jon Jagger and is available in his Cyber-Dojo. See [his blog post](http://jonjagger.blogspot.co.uk/2012/05/yahtzee-cyber-dojo-refactoring-in-java.html). I have changed it a little, so that the rules more closely match what I'm used to.

If you like this Kata, you may be interested in [my books](https://leanpub.com/u/emilybache) and website [SammanCoaching.org](https://sammancoaching.org)

## Kata Description

The problem that this code is designed to solve is explained here: [Yatzy](https://sammancoaching.org/kata_descriptions/yatzy.html)

## Refactoring srategy 

The current refactoring is guided by these following principles: 

-   Make the code readable : this is done by decomposing the code into multiple self explanatory modules.
-   Make the code easily extensible : this is done by decoupling the scoring logic from the scoring engine. To add a new scoring strategy we just have to implement the GameScorer interface and update the Enum that contains all scoring strategies. We can finish the work by writing a single unit test specific to the added scoring strategy which has zero impact on existing unit tests. 
-   At this stage I did not include some of repetitive scoring strategies like twos, threes, etc. I have just implemented two examples ones and sixes that enherit from a generic N of kind scoring strategy. 


